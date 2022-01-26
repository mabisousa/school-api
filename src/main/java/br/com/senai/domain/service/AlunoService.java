package br.com.senai.domain.service;

import br.com.senai.api.assembler.AlunoAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.input.AlunoInputDTO;
import br.com.senai.domain.model.Aluno;
import br.com.senai.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private AlunoAssembler alunoAssembler;

    @Transactional
    public Aluno cadastrar(Aluno aluno) {
        alunoRepository.save(aluno);
        return aluno;
    }

    @Transactional
    public void excluir(Long pessoaId) {
        alunoRepository.deleteById(pessoaId);
    }

    public List<AlunoDTO> listar() {
        return alunoAssembler.toCollectionModel(alunoRepository.findAll());
    }

    public ResponseEntity<AlunoDTO> buscar(Long pessoaId) {
        return alunoRepository.findById(pessoaId).map
                (aluno -> {
                    return ResponseEntity.ok(alunoAssembler.toModel(aluno));
                }).orElse(ResponseEntity.notFound().build());
    }

    public List<AlunoDTO> listarPorNome(String pessoaNome) {
        return alunoAssembler.toCollectionModel(alunoRepository.findByNome(pessoaNome));
    }

    public List<AlunoDTO> listarNomeContaining(String nomeContaining) {
        return alunoAssembler.toCollectionModel(alunoRepository.findByNomeContaining(nomeContaining));
    }

    public ResponseEntity<AlunoDTO> editar(Long pessoaId, AlunoInputDTO alunoInputDTO) {

        if(!alunoRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        Aluno aluno = alunoAssembler.toEntity(alunoInputDTO);
        aluno.setId(pessoaId);
        alunoRepository.save(aluno);
        AlunoDTO pessoaDTO = alunoAssembler.toModel(aluno);

        return ResponseEntity.ok(pessoaDTO);
    }
}
