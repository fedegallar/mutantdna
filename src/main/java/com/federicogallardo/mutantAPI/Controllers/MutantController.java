package com.federicogallardo.mutantAPI.Controllers;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.federicogallardo.mutantAPI.DTOs.PersonDTO;
import com.federicogallardo.mutantAPI.Services.MutantService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
        }catch(final Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");
        }
    }
    @GetMapping("/stats")
    @CrossOrigin("*")
    public ResponseEntity getStats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getStats());
        }catch(Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sStackTrace);
        }
    }

}