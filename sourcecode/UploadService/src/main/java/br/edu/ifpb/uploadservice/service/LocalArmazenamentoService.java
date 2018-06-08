package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.repository.LocalArmazenamentoRepository;
import br.edu.ifpb.uploadservice.service.erros.LocalArmazenamentoInexistente;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class LocalArmazenamentoService {

    private final LocalArmazenamentoRepository localArmazenamentoRepository;

    public LocalArmazenamentoService(LocalArmazenamentoRepository localArmazenamentoRepository) {
        this.localArmazenamentoRepository = localArmazenamentoRepository;
    }

    public void atualizarLocalArmazenamento(LocalArmazenamento localArmazenamento) {
        localArmazenamentoRepository.save(localArmazenamento);
    }

    public List<LocalArmazenamento> listarLocaisArmazenamento() {
        return localArmazenamentoRepository.findAll();
    }

    public LocalArmazenamento criarLocalDeArmazenamento(LocalArmazenamento localArmazenamento) throws LocalArmazenamentoInexistente {
        File file = new File(localArmazenamento.getCaminho());
        if (!file.exists()) {
            throw new LocalArmazenamentoInexistente("Local de armazenamento inexistente");
        }
        localArmazenamento.setEspacoTotal(file.getTotalSpace());
        localArmazenamento.setEspacoReservado(0L);
        localArmazenamento.setEspacoDisponivel(file.getUsableSpace());
        localArmazenamentoRepository.save(localArmazenamento);
        return localArmazenamento;
    }

}
