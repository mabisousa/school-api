package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PresencaDTO {
    private long id;
    private boolean presenca;
    private String data;
    private Long aluno_id;
}
