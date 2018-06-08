package br.edu.ifpb.uploadservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Arquivo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nome;

    @NotNull
    private String formato;

    private Long tamanho;

    @ManyToOne
    @NotNull
    private LocalArmazenamento localArmazenamento;

}
