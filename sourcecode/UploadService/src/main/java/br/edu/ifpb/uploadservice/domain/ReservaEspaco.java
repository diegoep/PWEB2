package br.edu.ifpb.uploadservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class ReservaEspaco {

    public enum ReservaEspacoStatus {
        ATIVA,
        PENDENTE,
        EXPIRADA,
        INVALIDA
    }

    @Id
    private String codigoReserva;

    private Long bytesReservados;

    @Enumerated(EnumType.STRING)
    private ReservaEspacoStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime criacao;

    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime expiracao;

    @OneToOne
    private LocalArmazenamento localArmazenamento;

}
