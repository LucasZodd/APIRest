package zodd.volt.api.service.dto;

import zodd.volt.api.domain.Medico;
import zodd.volt.api.domain.Endereco;
import zodd.volt.api.domain.enumeration.Especialidade;

public record DadosDetalhamentoMedicos(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosDetalhamentoMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
