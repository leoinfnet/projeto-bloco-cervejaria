package br.com.acme.cervejaria.controller;

import br.com.acme.cervejaria.exception.ResourceNotFoundException;
import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.payload.MessagePayload;
import br.com.acme.cervejaria.repository.CervejaRepository;
import br.com.acme.cervejaria.service.CervejaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cerveja")
public class CervejaController {
    Logger logger = LoggerFactory.getLogger(CervejaController.class);
    final CervejaRepository cervejaRepository;
    final CervejaService cervejaService;

    public CervejaController(CervejaService cervejaService, CervejaRepository cervejaRepository) {
        this.cervejaService = cervejaService;
        this.cervejaRepository = cervejaRepository;
    }
    /*
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
            @ApiResponse(responseCode = "201", description = "Cerveja Salva",
                            content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cerveja.class))} )
    })
    @PostMapping
    public ResponseEntity<MessagePayload> save(@RequestBody Cerveja cerveja){
        cervejaService.save(cerveja);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessagePayload("Criado com sucesso"));

    }
    @Operation(summary = "Atualizando uma cerveja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Atualizado com sucesso com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Ocorreu um Erro",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<MessagePayload> update(@PathVariable Integer id, @RequestBody Cerveja cerveja){
        try {
            cervejaService.update(id,cerveja);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Atualizado com sucesso"));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }

    }

    @Operation(summary = "Deleta uma cerveja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Deletado com sucesso",
                content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = MessagePayload.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Ocorreu um Erro",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<MessagePayload> delete(@PathVariable Integer id){
        logger.info("Deletando uma cerveja");
        try {
            cervejaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Deletado com sucesso"));
        }catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }
    }

     */
}
