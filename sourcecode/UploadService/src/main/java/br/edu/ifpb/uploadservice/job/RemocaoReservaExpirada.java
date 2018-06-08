package br.edu.ifpb.uploadservice.job;


import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.LocalArmazenamentoService;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemocaoReservaExpirada implements Runnable {

    private final Logger log = LoggerFactory.getLogger(RemocaoReservaExpirada.class);

    private final ReservaEspaco reservaEspaco;

    private final LocalArmazenamento localArmazenamento;

    private final ReservaEspacoService reservaEspacoService;

    private final LocalArmazenamentoService localArmazenamentoService;

    public RemocaoReservaExpirada(ReservaEspaco reservaEspaco, LocalArmazenamento localArmazenamento, ReservaEspacoService reservaEspacoService, LocalArmazenamentoService localArmazenamentoService) {
        this.reservaEspaco = reservaEspaco;
        this.reservaEspacoService = reservaEspacoService;
        this.localArmazenamentoService = localArmazenamentoService;
        this.localArmazenamento = localArmazenamento;
    }

    @Override
    public void run() {
        localArmazenamento.setEspacoDisponivel(localArmazenamento.getEspacoDisponivel() + reservaEspaco.getBytesReservados());
        localArmazenamento.setEspacoReservado(localArmazenamento.getEspacoReservado() - reservaEspaco.getBytesReservados());
        localArmazenamentoService.atualizarLocalArmazenamento(localArmazenamento);
        reservaEspaco.setStatus(ReservaEspaco.ReservaEspacoStatus.EXPIRADA);
        reservaEspacoService.atualizarReserva(reservaEspaco);
        log.info("Reserva do token {} expirada! ", reservaEspaco.getCodigoReserva());
    }
}
