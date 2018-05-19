package br.edu.ifpb.uploadservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Arquivo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nome;

    private String formato;

    private Long tamanho;

    @ManyToOne
    private LocalArmazenamento localArmazenamento;

}
