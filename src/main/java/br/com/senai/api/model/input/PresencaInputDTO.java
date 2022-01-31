package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PresencaInputDTO {

    @NotNull
    private boolean presenca;

    @NotNull
    private long aluno_id;

}
