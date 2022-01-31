package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PresencaDTO {
    private long id;
    private boolean presenca;
    private LocalDateTime data;
    private AlunoDTO aluno;
}
