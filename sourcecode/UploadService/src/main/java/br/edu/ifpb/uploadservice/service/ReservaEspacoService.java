package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.config.UploadServiceConfig;
import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco.ReservaEspacoStatus;
import br.edu.ifpb.uploadservice.job.RemocaoReservaExpirada;
import br.edu.ifpb.uploadservice.repository.LocalArmazenamentoRepository;
import br.edu.ifpb.uploadservice.repository.ReservaEspacoRepository;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import br.edu.ifpb.uploadservice.service.erros.StatusDeReservaInvalido;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;

@Service
public class ReservaEspacoService {

    private final ReservaEspacoRepository reservaEspacoRepository;

    private final LocalArmazenamentoRepository localArmazenamentoRepository;

    private final UploadServiceConfig uploadServiceConfig;

    private final TaskScheduler taskScheduler;

    public ReservaEspacoService(ReservaEspacoRepository reservaEspacoRepository, LocalArmazenamentoRepository localArmazenamentoRepository, UploadServiceConfig uploadServiceConfig, TaskScheduler taskScheduler) {
        this.reservaEspacoRepository = reservaEspacoRepository;
        this.localArmazenamentoRepository = localArmazenamentoRepository;
        this.uploadServiceConfig = uploadServiceConfig;
        this.taskScheduler = taskScheduler;
    }

    public ReservaEspaco efetuarReservaDeEspaco(Long tamanhoDoArquivo) throws NenhumaUnidadeComEspacoDisponivelException {
        ReservaEspaco reservaEspaco = new ReservaEspaco();
        reservaEspaco.setBytesReservados(tamanhoDoArquivo);
        reservaEspaco.setCriacao(ZonedDateTime.now());
        reservaEspaco.setCodigoReserva(this.gerarCodigoReserva());
        reservaEspaco.setExpiracao(calcularDataExpiracao(reservaEspaco.getCriacao()));
        LocalArmazenamento localArmazenamento = definirLocalArmazenamento(tamanhoDoArquivo).
                orElseThrow(() -> new NenhumaUnidadeComEspacoDisponivelException(String.format("Não há nenhuma unidade disponível para reservar %d bytes", tamanhoDoArquivo)));
        reservaEspacoRepository.save(reservaEspaco);

        taskScheduler.schedule(new RemocaoReservaExpirada(reservaEspaco, this), Date.from(reservaEspaco.getExpiracao().toInstant()));

        return reservaEspaco;

    }

    public List<ReservaEspaco> listarReservasEspaco(String status) throws StatusDeReservaInvalido {
        List<ReservaEspaco> reservasEspaco = new ArrayList<>();
        if (status != null) {
            try {
                ReservaEspacoStatus reservaEspacoStatus = ReservaEspacoStatus.valueOf(status);
                reservasEspaco = reservaEspacoRepository.findAllByStatus(reservaEspacoStatus);
            } catch(IllegalArgumentException e) {
                throw new StatusDeReservaInvalido("Status de reserva invalido");
            }
        } else {
            reservasEspaco = reservaEspacoRepository.findAll();
        }
        return reservasEspaco;
    }

    public void removerReserva(ReservaEspaco reservaEspaco){
        reservaEspacoRepository.delete(reservaEspaco);
    }

    private String gerarCodigoReserva() {
        return UUID.randomUUID().toString();
    }

    private ZonedDateTime calcularDataExpiracao(ZonedDateTime dataCriacao) {
        return dataCriacao.plusMinutes(uploadServiceConfig.getReservaEspaco().getTempoExpiracaoEmMinutos());
    }

    private Optional<LocalArmazenamento> definirLocalArmazenamento(Long tamanhoDoArquivo) {
        return localArmazenamentoRepository.findPrimeiroLocalArmazenamentoDisponivel(tamanhoDoArquivo);
    }


}
