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
import org.springframework.web.util.UriComponentsBuilder;
import zodd.volt.api.domain.Medico;
import zodd.volt.api.service.MedicoService;
import zodd.volt.api.service.dto.AtualizarMedicos;
import zodd.volt.api.service.dto.DadosListagemMedico;
import zodd.volt.api.service.dto.MedicoDTO;
import zodd.volt.api.service.mapper.MedicoMapper;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/medicos")
public class MedicoResource {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoMapper medicoMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDTO> cadastrar(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = this.medicoService.cadastar(medicoDTO);
        URI location = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(location).body(medicoMapper.toMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok(medicoService.getMedicos(pageable));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizarMedicos atualizarMedicos) {
        return ResponseEntity.ok(medicoService.atualizar(atualizarMedicos));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        this.medicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.detalhar(id));
    }


}
