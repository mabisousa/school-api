package br.com.senai.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Presenca {

    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    Aluno aluno;

    private boolean presenca;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate data;

}