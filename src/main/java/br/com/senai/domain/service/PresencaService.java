package br.com.senai.domain.service;

import br.com.senai.api.assembler.PresencaAssembler;
import br.com.senai.api.input.PresencaInputDTO;
import br.com.senai.api.model.PresencaDTO;
import br.com.senai.domain.model.Aluno;
import br.com.senai.domain.model.Presenca;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.repository.PresencaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PresencaService {

    private PresencaRepository presencaRepository;
    private PresencaAssembler presencaAssembler;
    private AlunoRepository alunoRepository;

    @Transactional
    public Presenca cadastrar(Presenca presenca) {
        presencaRepository.save(presenca);
        return presenca;
    }

    @Transactional
    public void excluir(Long presencaId) {
        presencaRepository.deleteById(presencaId);
    }

    public List<PresencaDTO> listar() {
        return presencaAssembler.toCollectionModel(presencaRepository.findAll());
    }

    public ResponseEntity<PresencaDTO> buscar(Long presencaId) {
        return presencaRepository.findById(presencaId).map
                (presenca -> {
                    return ResponseEntity.ok(presencaAssembler.toModel(presenca));
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PresencaDTO> editar(Long presencaId, PresencaInputDTO presencaInputDTO) {

        if(!presencaRepository.existsById(presencaId)){
            return ResponseEntity.notFound().build();
        }


        Presenca presenca = presencaAssembler.toEntity(presencaInputDTO);
        presenca.setId(presencaId);
        presencaRepository.save(presenca);
        PresencaDTO presencaDTO = presencaAssembler.toModel(presenca);

        return ResponseEntity.ok(presencaDTO);
    }
}
