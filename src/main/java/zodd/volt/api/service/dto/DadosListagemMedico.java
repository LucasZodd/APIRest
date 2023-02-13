package zodd.volt.api.service.dto;

import zodd.volt.api.domain.enumeration.Especialidade;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {
}
