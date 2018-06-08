package br.edu.ifpb.uploadservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class LocalArmazenamento {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min=3, max = 50)
    private String nome;

    @NotNull
    @Column(unique = true)
    private String caminho;

    private Long espacoReservado;

    private Long espacoTotal;

    private Long espacoDisponivel;

}
