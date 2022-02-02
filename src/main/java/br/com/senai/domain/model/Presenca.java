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
    private Long id;

    private Long aluno_id;

    private boolean presenca;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String data;

}