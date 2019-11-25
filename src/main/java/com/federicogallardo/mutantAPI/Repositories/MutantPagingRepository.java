package com.federicogallardo.mutantAPI.Repositories;

import com.federicogallardo.mutantAPI.Entities.Person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantPagingRepository extends PagingAndSortingRepository<Person,Integer>{

}