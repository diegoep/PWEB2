package br.edu.ifpb.producer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Conteudo {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    private Long tamanho;

    private String codigoReserva;

}
