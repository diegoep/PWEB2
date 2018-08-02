package br.edu.ifpb.producer.commandproducer.web;

import br.edu.ifpb.producer.domain.Conteudo;
import br.edu.ifpb.producer.service.ConteudoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/conteudos")
public class ConteudoResource {

    private final ConteudoService conteudoService;

    public ConteudoResource(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }


    @GetMapping
    public ResponseEntity<List<Conteudo>> listarConteudos() {
        return ResponseEntity.ok(conteudoService.listarConteudos());
    }

    @PostMapping
    public ResponseEntity<Conteudo> salvarConteudo(@RequestBody Conteudo conteudo) {
        return ResponseEntity.ok(conteudoService.criarConteudo(conteudo));
    }

}
