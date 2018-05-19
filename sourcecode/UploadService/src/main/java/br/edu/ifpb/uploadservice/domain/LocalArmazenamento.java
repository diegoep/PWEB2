package br.edu.ifpb.uploadservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class LocalArmazenamento {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @Column(unique = true)
    private String caminho;

    private Long espacoReservado;

    private Long espacoTotal;

    private Long espacoDisponivel;

}
