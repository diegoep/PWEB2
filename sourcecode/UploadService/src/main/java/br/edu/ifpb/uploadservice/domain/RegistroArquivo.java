package br.edu.ifpb.uploadservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class RegistroArquivo {

    public enum EnvioArquivoStatus {
        NAO_INICIADO,
        EM_ANDAMENTO,
        PAUSADO,
        CANCELADO,
        FALHO,
        FINALIZADO,
        CHECANDO_INTEGRIDADE
    }

    @Id
    @GeneratedValue
    private Long id;

    private ZonedDateTime inicio;

    private ZonedDateTime ultimaModificacao;

    @Enumerated(EnumType.STRING)
    private EnvioArquivoStatus status;

    private Integer totalFatiasEsperadas;
    private Integer fatiasEnviadas;
    private Integer progresso;
    private Long totalBytesEnviados;

    @OneToOne
    private Arquivo arquivo;

    @OneToOne
    private ReservaEspaco reservaEspaco;

}
