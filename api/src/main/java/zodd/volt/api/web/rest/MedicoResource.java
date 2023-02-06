package zodd.volt.api.web.rest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import zodd.volt.api.domain.Medico;
import zodd.volt.api.service.MedicoService;
import zodd.volt.api.service.dto.AtualizarMedicos;
import zodd.volt.api.service.dto.DadosListagemMedico;
import zodd.volt.api.service.dto.MedicoDTO;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/medicos")
public class MedicoResource {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid MedicoDTO medicoDTO) {
         this.medicoService.cadastar(medicoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok(medicoService.getMedicos(pageable));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizarMedicos atualizarMedicos) {
        this.medicoService.atualizar(atualizarMedicos);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        this.medicoService.excluir(id);
        return ResponseEntity.ok().build();
    }


}
