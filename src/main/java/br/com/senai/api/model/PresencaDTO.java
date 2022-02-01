package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PresencaDTO {
    private long id;
    private boolean presenca;
    private LocalDate data;
    private AlunoDTO aluno;
}
