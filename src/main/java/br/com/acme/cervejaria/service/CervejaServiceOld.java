package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.exception.ResourceNotFoundException;
import br.com.acme.cervejaria.model.Cerveja;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CervejaServiceOld {
    List<Cerveja> cervejas = initValues();
    private List<Cerveja> initValues(){
        ArrayList<Cerveja> cervejas1 = new ArrayList<>();
        cervejas1.add( new Cerveja(0, "Delirium", "Imperial IPA"));
        cervejas1.add( new Cerveja(1, "Walls Petroleum", "Tripel"));
        return cervejas1;
    }

    public Cerveja getById(int id){
        if(id < 0){
            throw new ResourceNotFoundException("Valor Invalido - NAO PODE SER NEGATIVO");
        }else {
            Optional<Cerveja> cervejaOpt = cervejas.stream().filter(cerveja -> cerveja.getId() == id).findFirst();
            if(cervejaOpt.isEmpty()) throw new ResourceNotFoundException("Objeto Nao Encontrando");
            return cervejaOpt.get();
        }
    }
    public void save(Cerveja cerveja){
        cervejas.add(cerveja);

    }
    public List<Cerveja> getAll(){
        return this.cervejas;
    }
    public List<Cerveja> filterByName(String nome){
        List<Cerveja> all = getAll();
        List<Cerveja> resultado  = all.stream().filter(cerveja -> cerveja.getNome().startsWith(nome)).toList();

        return resultado;
    }
    public void deleteById(Integer id) {
       if(resourceNotFound(id)){
           throw new ResourceNotFoundException("Cerveja Não Localizada");
       }
       cervejas.remove(cervejas.get(id));
    }
    public void update(Integer id, Cerveja cerveja) {
        if(resourceNotFound(id)){
            throw new ResourceNotFoundException("Cerveja Não Localizada");
        }
        cervejas.set(id,cerveja);
    }

    private boolean resourceNotFound(Integer id) {
        return cervejas.stream().filter(cerveja -> cerveja.getId() == id).findFirst().isEmpty();
    }
}
