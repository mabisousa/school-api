package br.com.senai.api.assembler;

import br.com.senai.api.input.PresencaInputDTO;
import br.com.senai.api.model.PresencaDTO;
import br.com.senai.domain.model.Presenca;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PresencaAssembler {

    private ModelMapper modelMapper;

    public PresencaDTO toModel(Presenca presenca) {
        return modelMapper.map(presenca, PresencaDTO.class);
    }

    public List<PresencaDTO> toCollectionModel(List<Presenca> presencas) {
        return presencas.stream().map(this::toModel).collect(Collectors.toList());
    }
    public Presenca toEntity(PresencaInputDTO presencaInputDTO) {
        return modelMapper.map(presencaInputDTO, Presenca.class);
    }

    public Presenca toEntityFromModel(PresencaDTO presencaDTO) {
        return modelMapper.map(presencaDTO, Presenca.class);
    }

}
