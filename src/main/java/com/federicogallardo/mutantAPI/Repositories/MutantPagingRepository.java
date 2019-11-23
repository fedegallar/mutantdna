package com.federicogallardo.mutantAPI.Repositories;

import com.federicogallardo.mutantAPI.Entities.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MutantPagingRepository extends PagingAndSortingRepository<Person,Integer>{

    @Query("from Person p order by p.id asc")

    Page<Person> findAllPeopleById(Pageable pageable);
}