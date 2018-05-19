package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.config.UploadServiceConfig;
import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.repository.LocalArmazenamentoRepository;
import br.edu.ifpb.uploadservice.repository.ReservaEspacoRepository;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaEspacoService {

    private final ReservaEspacoRepository reservaEspacoRepository;

    private final LocalArmazenamentoRepository localArmazenamentoRepository;

    private final UploadServiceConfig uploadServiceConfig;

    public ReservaEspacoService(ReservaEspacoRepository reservaEspacoRepository, LocalArmazenamentoRepository localArmazenamentoRepository, UploadServiceConfig uploadServiceConfig) {
        this.reservaEspacoRepository = reservaEspacoRepository;
        this.localArmazenamentoRepository = localArmazenamentoRepository;
        this.uploadServiceConfig = uploadServiceConfig;
    }

    public ReservaEspaco efetuarReservaDeEspaco(Long tamanhoDoArquivo) throws NenhumaUnidadeComEspacoDisponivelException {

        ReservaEspaco reservaEspaco = new ReservaEspaco();
        reservaEspaco.setBytesReservados(tamanhoDoArquivo);
        reservaEspaco.setCriacao(ZonedDateTime.now());
        reservaEspaco.setCodigoReserva(this.gerarCodigoReserva());
        reservaEspaco.setExpiracao(reservaEspaco.getCriacao());
        LocalArmazenamento localArmazenamento = definirLocalArmazenamento(tamanhoDoArquivo).
                orElseThrow(() -> new NenhumaUnidadeComEspacoDisponivelException(String.format("Não há nenhuma unidade disponível para reservar %d bytes", tamanhoDoArquivo)));
//        Optional<LocalArmazenamento> localArmazenamento = definirLocalArmazenamento(tamanhoDoArquivo);
//        if (localArmazenamento.isPresent()) {
//            reservaEspaco.setLocalArmazenamento(localArmazenamento.get());
//        } else {
//            throw new NenhumaUnidadeComEspacoDisponivelException(String.format("Não há nenhuma unidade disponível para reservar %d bytes", tamanhoDoArquivo));
//        }
        reservaEspacoRepository.save(reservaEspaco);

        return reservaEspaco;

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
