package br.edu.ifpb.uploadservice.web;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.domain.LocalArmazenamento;
import br.edu.ifpb.uploadservice.service.ArquivoServico;
import br.edu.ifpb.uploadservice.service.erros.LocalArmazenamentoInexistente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {

    private final ArquivoServico arquivoServico;

    private Logger log = LoggerFactory.getLogger(ArquivoController.class);

    public ArquivoController(ArquivoServico arquivoServico) {
        this.arquivoServico = arquivoServico;
    }

    @GetMapping
    public ResponseEntity<List<Arquivo>> listarArquivos() {
        return ResponseEntity.ok().body(arquivoServico.listarArquivos());
    }

    @PostMapping
    public ResponseEntity<Arquivo> salvarArquivo(@RequestBody @Valid  Arquivo arquivo){
        return ResponseEntity.ok().body(arquivoServico.salvarArquivo(arquivo));
    }

    @DeleteMapping
    public ResponseEntity<?> deletarArquivo(@RequestParam("id") long id){
        arquivoServico.deletarArquivo(id);
        return  ResponseEntity.ok().body(null);
    }

}
