package br.edu.ifpb.uploadservice.web;


import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import br.edu.ifpb.uploadservice.service.erros.StatusDeReservaInvalido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reserva-espaco")
public class ReservaEspacoController {

    private Logger log = LoggerFactory.getLogger(ReservaEspacoController.class);

    private final ReservaEspacoService reservaEspacoService;

    public ReservaEspacoController(ReservaEspacoService reservaEspacoService) {
        this.reservaEspacoService = reservaEspacoService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaEspaco>> listarReservas(@RequestParam(value = "status", required = false) String status) {
        List<ReservaEspaco> reservas = new ArrayList<>();
        try {
            reservas = reservaEspacoService.listarReservasEspaco(status);
        } catch (StatusDeReservaInvalido statusDeReservaInvalido) {
            log.error("Status de reserva inválido");
            return ResponseEntity.badRequest().
                    header("errorMessage", statusDeReservaInvalido.getMessage()).
                    body(null);
        }
        return ResponseEntity.ok().body(reservas);
    }

    @PostMapping
    public ResponseEntity<ReservaEspaco> criarReserva(@RequestParam("total") Long tamanhoArquivo) {
        log.info("Requisição para criação de uma reserva de espaço para um arquivo de tamanho {}", tamanhoArquivo);
        ReservaEspaco reservaEspaco = null;
        try {
            reservaEspaco = reservaEspacoService.efetuarReservaDeEspaco(tamanhoArquivo);
        } catch (NenhumaUnidadeComEspacoDisponivelException e) {
            log.error("Nenhuma unidade com espaço disponível", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("errorMessage", "Não há espaço suficiente para a sua reserva").body(null);
        }

        return ResponseEntity.ok().body(reservaEspaco);
    }

}
