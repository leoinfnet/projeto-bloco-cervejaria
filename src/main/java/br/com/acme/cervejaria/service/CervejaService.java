package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.exception.ResourceNotFoundException;
import br.com.acme.cervejaria.model.Cerveja;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CervejaService {
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
            try{
                return this.cervejas.get(id);
            }catch (IndexOutOfBoundsException ex){
                throw new ResourceNotFoundException("Objeto Nao Encontrando");
            }
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

        /*
        for(Cerveja ceveja: all){
            if(ceveja.getNome().startsWith(nome)){
                resultado.add(ceveja);
            }
        }
        return resultado;

         */
        return resultado;
    }


}
