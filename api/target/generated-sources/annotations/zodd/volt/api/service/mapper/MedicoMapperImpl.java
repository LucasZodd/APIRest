package zodd.volt.api.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import zodd.volt.api.domain.Medico;
import zodd.volt.api.endereco.DadosEndereco;
import zodd.volt.api.endereco.Endereco;
import zodd.volt.api.enumeration.Especialidade;
import zodd.volt.api.service.dto.AtualizarMedicos;
import zodd.volt.api.service.dto.DadosListagemMedico;
import zodd.volt.api.service.dto.MedicoDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-06T13:55:58-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public MedicoDTO toMedicoDTO(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        String nome = null;
        String email = null;
        String telefone = null;
        String crm = null;
        Especialidade especialidade = null;
        DadosEndereco endereco = null;

        nome = medico.getNome();
        email = medico.getEmail();
        telefone = medico.getTelefone();
        crm = medico.getCrm();
        especialidade = medico.getEspecialidade();
        endereco = enderecoToDadosEndereco( medico.getEndereco() );

        MedicoDTO medicoDTO = new MedicoDTO( nome, email, telefone, crm, especialidade, endereco );

        return medicoDTO;
    }

    @Override
    public Medico toMedico(MedicoDTO medicoDTO) {
        if ( medicoDTO == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setNome( medicoDTO.nome() );
        medico.setEmail( medicoDTO.email() );
        medico.setTelefone( medicoDTO.telefone() );
        medico.setCrm( medicoDTO.crm() );
        medico.setEspecialidade( medicoDTO.especialidade() );
        medico.setEndereco( dadosEnderecoToEndereco( medicoDTO.endereco() ) );

        return medico;
    }

    @Override
    public DadosListagemMedico toDadosListagemMedico(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;
        String crm = null;
        Especialidade especialidade = null;

        id = medico.getId();
        nome = medico.getNome();
        email = medico.getEmail();
        crm = medico.getCrm();
        especialidade = medico.getEspecialidade();

        DadosListagemMedico dadosListagemMedico = new DadosListagemMedico( id, nome, email, crm, especialidade );

        return dadosListagemMedico;
    }

    @Override
    public Medico toAtualizarMedicos(AtualizarMedicos atualizarMedicos, Medico medico) {
        if ( atualizarMedicos == null ) {
            return null;
        }

        medico.setId( atualizarMedicos.id() );

        medico.setNome( atualizarMedicos.nome() != null ? atualizarMedicos.nome() : medico.getNome() );
        medico.setTelefone( atualizarMedicos.telefone() != null ? atualizarMedicos.telefone() : medico.getTelefone() );
        medico.setEndereco( atualizarMedicos.endereco() != null ? atualizarMedicos.endereco() : medico.getEndereco() );

        return medico;
    }

    protected DadosEndereco enderecoToDadosEndereco(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        String logradouro = null;
        String bairro = null;
        String cep = null;
        String cidade = null;
        String uf = null;
        String complemento = null;
        String numero = null;

        logradouro = endereco.getLogradouro();
        bairro = endereco.getBairro();
        cep = endereco.getCep();
        cidade = endereco.getCidade();
        uf = endereco.getUf();
        complemento = endereco.getComplemento();
        numero = endereco.getNumero();

        DadosEndereco dadosEndereco = new DadosEndereco( logradouro, bairro, cep, cidade, uf, complemento, numero );

        return dadosEndereco;
    }

    protected Endereco dadosEnderecoToEndereco(DadosEndereco dadosEndereco) {
        if ( dadosEndereco == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setLogradouro( dadosEndereco.logradouro() );
        endereco.setBairro( dadosEndereco.bairro() );
        endereco.setCep( dadosEndereco.cep() );
        endereco.setNumero( dadosEndereco.numero() );
        endereco.setComplemento( dadosEndereco.complemento() );
        endereco.setCidade( dadosEndereco.cidade() );
        endereco.setUf( dadosEndereco.uf() );

        return endereco;
    }
}
