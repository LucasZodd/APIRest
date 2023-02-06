package zodd.volt.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import zodd.volt.api.endereco.Endereco;
import zodd.volt.api.enumeration.Especialidade;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="TAB_MEDICOS")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ID", nullable = false)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CRM")
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    @Column(name = "ATIVO")
    private Boolean ativo;

    public void excluir() {
        this.ativo = false;
    }
}
