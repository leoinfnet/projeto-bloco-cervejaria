package br.com.acme.cervejaria.controller;

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

        Map<String, String> retorno = Map.of("message", "sucesso");
        return retorno;
    }
}
