package br.edu.ifpb.uploadservice.config;

import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.repository.LocalArmazenamentoRepository;
import br.edu.ifpb.uploadservice.service.LocalArmazenamentoService;
import br.edu.ifpb.uploadservice.service.erros.LocalArmazenamentoInexistente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UploadServiceInit implements ApplicationListener<ContextRefreshedEvent> {

    private final LocalArmazenamentoService localArmazenamentoService;

    private final LocalArmazenamentoRepository localArmazenamentoRepository;

    private Logger log = LoggerFactory.getLogger(UploadServiceInit.class);

    public UploadServiceInit(LocalArmazenamentoService localArmazenamentoService, LocalArmazenamentoRepository localArmazenamentoRepository) {
        this.localArmazenamentoService = localArmazenamentoService;
        this.localArmazenamentoRepository = localArmazenamentoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (localArmazenamentoRepository.count() == 0) {
            LocalArmazenamento localArmazenamento = new LocalArmazenamento();
            localArmazenamento.setNome("Unidade temporaria");
            localArmazenamento.setCaminho("/tmp");
            try {
                localArmazenamentoService.criarLocalDeArmazenamento(localArmazenamento);
            } catch (LocalArmazenamentoInexistente localArmazenamentoInexistente) {
                log.error("Não foi possível criar a unidade padrao");
            }
        }

    }
}
