package br.com.acme.cervejaria.controller;

import br.com.acme.cervejaria.model.Cerveja;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cerveja")
public class CervejaController {
    static List<Cerveja> cervejas = initValues();
    private static List<Cerveja> initValues(){
        ArrayList<Cerveja> cervejas1 = new ArrayList<>();
        cervejas1.add( new Cerveja(0, "Delirium", "Imperial IPA"));
        cervejas1.add( new Cerveja(1, "Walls Petroleum", "Tripel"));
        return cervejas1;

    }
    @GetMapping
    public List<Cerveja> getAll(){
        System.out.println("Listando todas as cervejas");
        return cervejas;
    }
    @GetMapping("/{id}")
    public Cerveja getById(@PathVariable Integer id){
        System.out.println("ID====> " + id);
        return cervejas.get(id);
    }
    @PostMapping
    public void save(@RequestBody Cerveja cerveja){
        System.out.println(cerveja);
        cervejas.add(cerveja);
        System.out.println("Inserindo uma cerveja");
    }
    @PutMapping
    public void update(){
        System.out.println("atualizando uma cerveja");
    }
    @DeleteMapping
    public void delete(){
        System.out.println("deletando uma cerveja");
    }
}
