package zodd.volt.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zodd.volt.api.domain.Medico;
import zodd.volt.api.exception.BusinessException;
import zodd.volt.api.repository.MedicoRepository;
import zodd.volt.api.service.dto.AtualizarMedicos;
import zodd.volt.api.service.dto.DadosListagemMedico;
import zodd.volt.api.service.dto.MedicoDTO;
import zodd.volt.api.service.mapper.MedicoMapper;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    public Page<DadosListagemMedico> getMedicos(Pageable pageable) {

        return medicoRepository.findAllByAtivoTrue(pageable)
                .map(this.medicoMapper::toDadosListagemMedico);
    }

    public void cadastar(MedicoDTO medicoDTO) {
        this.medicoRepository.save(this.medicoMapper.toMedico(medicoDTO));
    }

    public void atualizar(AtualizarMedicos atualizarMedicosDTO) {
        Optional<Medico> optionalMedico = medicoRepository.findById(atualizarMedicosDTO.id());
        if(optionalMedico.isEmpty()){
            throw new BusinessException("Medico não encontrado");
        }
        Medico medico = medicoMapper.toAtualizarMedicos(atualizarMedicosDTO, optionalMedico.get());
        this.medicoRepository.save(medico);
    }

    public void excluir(Long id) {
        Medico medico = this.medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
