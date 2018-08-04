package br.edu.ifpb.producer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Conteudo {

    public enum ConteudoStatus {
        PENDENTE,
        APROVADO,
        NEGADO
    }

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    private Long tamanho;

    private String codigoReserva;

    @Enumerated(value = EnumType.STRING)
    private ConteudoStatus status;

}
