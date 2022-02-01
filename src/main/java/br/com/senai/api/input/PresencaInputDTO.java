package br.com.senai.api.input;

import br.com.senai.api.model.input.AlunoInputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
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
