package br.com.senai.api.controller;

import br.com.senai.api.assembler.PresencaAssembler;
import br.com.senai.api.input.PresencaInputDTO;
import br.com.senai.api.model.PresencaDTO;
import br.com.senai.domain.model.Presenca;
import br.com.senai.domain.repository.PresencaRepository;
import br.com.senai.domain.service.PresencaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/presenca")
public class PresencaController {

    private PresencaRepository presencaRepository;
    private PresencaService presencaService;
    private PresencaAssembler presencaAssembler;

    @GetMapping
    public List<PresencaDTO> listar(){ return presencaService.listar();
    }

    @GetMapping("/{presencaId}")
    public ResponseEntity<PresencaDTO> buscar(@PathVariable Long presencaId){
        return presencaService.buscar(presencaId);
    }

    @PostMapping
    public PresencaDTO cadastrar(@Valid @RequestBody PresencaInputDTO presencaInputDTO) {
        Presenca newPresenca = presencaAssembler.toEntity(presencaInputDTO);
        Presenca presenca = presencaService.cadastrar(newPresenca);
        return presencaAssembler.toModel(presenca);
    }

    @PutMapping("/{presencaId}")
    public ResponseEntity<PresencaDTO> editar(@Valid @PathVariable Long presencaId,
                                           @RequestBody PresencaInputDTO presencaInputDTO){
        return presencaService.editar(presencaId, presencaInputDTO);
    }

    @DeleteMapping("/{presencaId}")
    public ResponseEntity<Presenca> remover(@PathVariable Long presencaId){
        if(!presencaRepository.existsById(presencaId)){
            return ResponseEntity.notFound().build();
        }

        presencaService.excluir(presencaId);

        return ResponseEntity.noContent().build();
    }
}
