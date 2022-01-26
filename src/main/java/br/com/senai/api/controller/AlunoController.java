package br.com.senai.api.controller;

import br.com.senai.api.assembler.AlunoAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.input.AlunoInputDTO;
import br.com.senai.domain.model.Aluno;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class AlunoController {

    private AlunoRepository pessoaRepository;
    private AlunoService alunoService;
    private AlunoAssembler alunoAssembler;

    @GetMapping
    public List<AlunoDTO> listar(){ return alunoService.listar();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<AlunoDTO> listarPorNome(@PathVariable String pessoaNome){
        return alunoService.listarPorNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<AlunoDTO> listarNomeContaining(@PathVariable String nomeContaining){
        return alunoService.listarNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<AlunoDTO> buscar(@PathVariable Long pessoaId){
        return alunoService.buscar(pessoaId);
    }

    @PostMapping
    public AlunoDTO cadastrar(@Valid @RequestBody AlunoInputDTO alunoInputDTO) {
        Aluno newAluno = alunoAssembler.toEntity(alunoInputDTO);
        Aluno aluno = alunoService.cadastrar(newAluno);
        return alunoAssembler.toModel(aluno);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<AlunoDTO> editar(@Valid @PathVariable Long pessoaId,
                                           @RequestBody AlunoInputDTO alunoInputDTO){
        return alunoService.editar(pessoaId, alunoInputDTO);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Aluno> remover(@PathVariable Long pessoaId){
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        alunoService.excluir(pessoaId);

        return ResponseEntity.noContent().build();
    }
}
