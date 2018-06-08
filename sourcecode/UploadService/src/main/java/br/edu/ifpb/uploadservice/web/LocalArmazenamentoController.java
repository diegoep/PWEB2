package br.edu.ifpb.uploadservice.web;

import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.service.LocalArmazenamentoService;
import br.edu.ifpb.uploadservice.service.erros.LocalArmazenamentoInexistente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/local-armazenamento")
public class LocalArmazenamentoController {

    private final LocalArmazenamentoService localArmazenamentoService;

    private Logger log = LoggerFactory.getLogger(LocalArmazenamentoController.class);

    public LocalArmazenamentoController(LocalArmazenamentoService localArmazenamentoService) {
        this.localArmazenamentoService = localArmazenamentoService;
    }

    @GetMapping
    public ResponseEntity<List<LocalArmazenamento>> listarLocaisArmazenamento() {
        return ResponseEntity.ok().body(localArmazenamentoService.listarLocaisArmazenamento());
    }

    @PostMapping
    public ResponseEntity<LocalArmazenamento> criarLocalArmazenamento(@RequestBody @Valid LocalArmazenamento localArmazenamento){
        try {
            localArmazenamento = localArmazenamentoService.criarLocalDeArmazenamento(localArmazenamento);
        } catch (LocalArmazenamentoInexistente e) {
            log.error("Local de armazenamento {} inexistente", localArmazenamento.getCaminho());
            return ResponseEntity.badRequest().header("errorMessage", e.getMessage()).body(null);
        }

        return ResponseEntity.ok().body(localArmazenamento);

    }

}
