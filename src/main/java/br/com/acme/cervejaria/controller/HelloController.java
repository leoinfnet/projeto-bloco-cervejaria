package br.com.acme.cervejaria.controller;

import br.com.acme.cervejaria.model.Aluno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public Map<String,String> ola(){
        System.out.println("Ola");
        Aluno aluno = new Aluno(1312,"moedas");
        Aluno aluno2 = new Aluno();
        aluno2.setNome("Leonardo");
        aluno2.setMatricula(1234);
        List<Aluno> alunos = List.of(aluno2, aluno);
        Map<String, String> retorno = Map.of("message", "sucesso");
        return retorno;
    }
}
