package com.federicogallardo.mutantAPI.Controllers;

import com.federicogallardo.mutantAPI.DTOs.PersonDTO;
import com.federicogallardo.mutantAPI.MutantExceptions.PersonExistsException;
import com.federicogallardo.mutantAPI.Services.MutantService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mutant")
public class MutantController{

    private final MutantService service;

    public MutantController(final MutantService service){
        super();
        this.service = service;
    }

    @PostMapping("/")
    @CrossOrigin("*")
    public ResponseEntity verifyDNAandSave(@RequestBody final PersonDTO persondto){
        try{
            if(service.verifyDNAandSave(persondto)){
                return ResponseEntity.status(HttpStatus.OK).body("OK");
            }
            else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("FORBIDDEN");
            }
        }
        catch(PersonExistsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person already exists!");
        }
        catch(final Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");
        }
    }
    @GetMapping("/stats")
    @CrossOrigin("*")
    public ResponseEntity getStats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getStats());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity deletePerson(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.DeletePerson(id));
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id required");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}