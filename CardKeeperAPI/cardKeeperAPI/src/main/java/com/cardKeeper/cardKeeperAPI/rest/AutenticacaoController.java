package com.cardKeeper.cardKeeperAPI.rest;

import com.cardKeeper.cardKeeperAPI.Domain.users.LoginPostDTO;
import com.cardKeeper.cardKeeperAPI.Domain.users.User;
import com.cardKeeper.cardKeeperAPI.Infra.security.TokenDTO;
import com.cardKeeper.cardKeeperAPI.Infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity tryLogin(@RequestBody @Valid LoginPostDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.tokenBuilder((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenJWT));

    }

}
