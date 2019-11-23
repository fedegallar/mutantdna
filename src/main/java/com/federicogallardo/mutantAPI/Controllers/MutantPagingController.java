package com.federicogallardo.mutantAPI.Controllers;

import javax.transaction.Transactional;

import com.federicogallardo.mutantAPI.Entities.Person;
import com.federicogallardo.mutantAPI.Repositories.MutantPagingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mutant")
public class MutantPagingController {

    MutantPagingRepository repository;

    public MutantPagingController(MutantPagingRepository repository) {
        super();
        this.repository = repository;
    }
    

    @GetMapping("/")
    @Transactional
    public Page<Person> getAllPeople(Pageable pageable){
        try{
            return repository.findAllPeopleById(pageable);
        }catch(Exception e){
            return Page.empty();
        }
    }

}