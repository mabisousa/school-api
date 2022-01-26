package br.com.senai.api.assembler;

import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.input.AlunoInputDTO;
import br.com.senai.domain.model.Aluno;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AlunoAssembler {

    private ModelMapper modelMapper;

    public AlunoDTO toModel(Aluno aluno) {
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    public List<AlunoDTO> toCollectionModel(List<Aluno> alunos) {
        return alunos.stream().map(this::toModel).collect(Collectors.toList());
    }
    public Aluno toEntity(AlunoInputDTO alunoInputDTO) {
        return modelMapper.map(alunoInputDTO, Aluno.class);
    }

    public Aluno toEntityFromModel(AlunoDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, Aluno.class);
    }

}
