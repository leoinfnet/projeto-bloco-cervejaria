package br.com.acme.cervejaria.controller;

import br.com.acme.cervejaria.exception.ResourceNotFoundException;
import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.service.CervejaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cerveja")
public class CervejaController {

    final CervejaService cervejaService;

    public CervejaController(CervejaService cervejaService) {
        this.cervejaService = cervejaService;
    }
    @Operation(summary = "Busca todas as cervejas")
    @GetMapping
    public ResponseEntity<List<Cerveja>> getAll(@RequestParam(required = false) Optional<String> nome){
        System.out.println(nome);
        if(nome.isEmpty()){
            return ResponseEntity.ok(cervejaService.getAll());
        }else {
            List<Cerveja> cervejas = cervejaService.filterByName(nome.get());
            if(cervejas.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(cervejas);
            }
        }
    }

    @Operation(summary = "Busca uma cerveja pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cerveja encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cerveja.class)) }),
            @ApiResponse(responseCode = "400", description = "Id Invalido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cerveja nao encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Cerveja localizada = cervejaService.getById(id);
            return ResponseEntity.ok(localizada);

        }catch (ResourceNotFoundException ex){
            Map<String, String> message = Map.of("Message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @Operation(summary = "Salva uma cerveja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cerveja Salva",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cerveja.class)) })
    })
    @PostMapping
    public void save(@RequestBody Cerveja cerveja){
        System.out.println(cerveja);
        CervejaService cervejaService = new CervejaService();
        cervejaService.save(cerveja);

        System.out.println("Inserindo uma cerveja");
    }
    @Operation(summary = "Atualiza uma cerveja")

    @PutMapping
    public void update(){
        System.out.println("atualizando uma cerveja");
    }
    @Operation(summary = "Deleta uma cerveja")

    @DeleteMapping
    public void delete(){
        System.out.println("deletando uma cerveja");
    }
}
