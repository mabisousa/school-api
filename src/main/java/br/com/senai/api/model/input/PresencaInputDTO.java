package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PresencaInputDTO {

    @NotNull
    private boolean presenca;

    @NotNull
    private AlunoInputDTO aluno;

    @NotNull
    private LocalDate data;

}
