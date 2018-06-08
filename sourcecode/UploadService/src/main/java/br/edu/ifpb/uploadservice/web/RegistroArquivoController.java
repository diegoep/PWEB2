package br.edu.ifpb.uploadservice.web;

import br.edu.ifpb.uploadservice.domain.RegistroArquivo;
import br.edu.ifpb.uploadservice.service.RegistroArquivoService;
import br.edu.ifpb.uploadservice.service.erros.CaminhoInexistente;
import br.edu.ifpb.uploadservice.service.erros.FalhaAoEscreverArquivo;
import br.edu.ifpb.uploadservice.service.erros.ReservaTokenInvalido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/registro-arquivo")
public class RegistroArquivoController {
    private final RegistroArquivoService registroArquivoService;

    public RegistroArquivoController(RegistroArquivoService registroArquivoService) {
        this.registroArquivoService = registroArquivoService;
    }


    public ResponseEntity<RegistroArquivo> enviarArquivo(@RequestParam("token") String token, @RequestBody MultipartFile file){
        RegistroArquivo registro = null;
        try {
            registro = registroArquivoService.efetuarUpload(file.getName(), token, file.getSize(), file.getBytes());
        } catch (CaminhoInexistente | FalhaAoEscreverArquivo | ReservaTokenInvalido  e) {
            return ResponseEntity.badRequest().header("errorMessage", e.getMessage()).body(null);
        } catch(IOException e){
          return ResponseEntity.badRequest().header("errorMessage", "Não foi possível ler o arquivo enviado!").body(null);
        }
        return ResponseEntity.ok(registro);
    }

}
