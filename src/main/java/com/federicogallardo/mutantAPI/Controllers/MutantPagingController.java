package com.federicogallardo.mutantAPI.Controllers;

import javax.transaction.Transactional;

import com.federicogallardo.mutantAPI.Entities.Person;
import com.federicogallardo.mutantAPI.Repositories.MutantPagingRepository;
import com.federicogallardo.mutantAPI.Services.MutantPagingService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mutant")
public class MutantPagingController {

    MutantPagingService service;

    public MutantPagingController(MutantPagingService service) {
        super();
        this.service = service;
    }
    

    @GetMapping("/{page}")
    @Transactional
    public Page<Person> getAllPeople(Pageable pageable, @PathVariable int page){
        try{
            return this.service.getPeople(pageable, page);
        }catch(Exception e){
            return Page.empty();
        }
    }


}