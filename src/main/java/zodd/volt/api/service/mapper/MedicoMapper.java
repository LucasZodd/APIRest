package zodd.volt.api.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import zodd.volt.api.service.dto.AtualizarMedicos;
import zodd.volt.api.service.dto.DadosListagemMedico;
import zodd.volt.api.service.dto.MedicoDTO;
import zodd.volt.api.domain.Medico;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoDTO toMedicoDTO (Medico medico);

    Medico toMedico (MedicoDTO medicoDTO);

    DadosListagemMedico toDadosListagemMedico (Medico medico);

    @Mapping(target = "nome", expression = "java(atualizarMedicos.nome() != null ? atualizarMedicos.nome() : medico.getNome())")
    @Mapping(target = "telefone", expression = "java(atualizarMedicos.telefone() != null ? atualizarMedicos.telefone() : medico.getTelefone())")
    @Mapping(target = "endereco", expression = "java(atualizarMedicos.endereco() != null ? atualizarMedicos.endereco() : medico.getEndereco())")
    Medico toAtualizarMedicos (AtualizarMedicos atualizarMedicos, @MappingTarget Medico medico);
}
