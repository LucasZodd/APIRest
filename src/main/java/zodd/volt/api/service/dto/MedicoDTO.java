package zodd.volt.api.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import zodd.volt.api.domain.enumeration.Especialidade;

public record MedicoDTO(
//        o notBlank e para validar um compo, para não vir nuno e nem vazio, somente para string
        @NotBlank
        String nome,
//        o @Email para validar sé é email
        @Email
        @NotBlank
        String email,
        @NotBlank
        String telefone,
//        O @Pattern e para fazer uma validação com regex, no caso o \\d e para validar se é número o de {4,6} e para validar de 4 a 6 digitos
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
//        @NotNull para validar para não ser nulo
        @NotNull
        Especialidade especialidade,
//        o valid e para validar a dto dadosEndereco
        @Valid
        @NotNull
        DadosEndereco endereco,
        @NotNull
        boolean ativo) {
}
