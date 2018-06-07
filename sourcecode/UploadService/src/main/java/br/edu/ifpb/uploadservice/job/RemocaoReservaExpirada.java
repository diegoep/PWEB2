package br.edu.ifpb.uploadservice.job;


import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;

public class RemocaoReservaExpirada implements Runnable {

    private final ReservaEspaco reservaEspaco;

    private final ReservaEspacoService reservaEspacoService;

    public RemocaoReservaExpirada(ReservaEspaco reservaEspaco, ReservaEspacoService reservaEspacoService) {
        this.reservaEspaco = reservaEspaco;
        this.reservaEspacoService = reservaEspacoService;
    }

    @Override
    public void run() {
        reservaEspacoService.removerReserva(reservaEspaco);
    }
}
