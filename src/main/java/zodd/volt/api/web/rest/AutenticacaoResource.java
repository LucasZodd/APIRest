package zodd.volt.api.web.rest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zodd.volt.api.domain.Usuario;
import zodd.volt.api.infra.security.TokenService;
import zodd.volt.api.infra.security.dto.DadosTokenJWT;
import zodd.volt.api.service.dto.DadosAutenticacao;

@Slf4j
@RestController
@RequestMapping("/login")
public class AutenticacaoResource {

    @Autowired
    private AuthenticationManager maneger;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = maneger.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
