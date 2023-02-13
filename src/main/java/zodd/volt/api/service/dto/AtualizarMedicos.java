package zodd.volt.api.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import zodd.volt.api.domain.Endereco;

public record AtualizarMedicos(
        @NotNull
        Long id,
        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        String nome,
        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        String telefone,
        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        Endereco endereco) {
}
