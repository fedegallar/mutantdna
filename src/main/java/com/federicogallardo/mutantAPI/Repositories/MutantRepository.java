package com.federicogallardo.mutantAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.federicogallardo.mutantAPI.DTOs.IStats;
import java.util.List;
import com.federicogallardo.mutantAPI.Entities.Person;

@Repository
public interface MutantRepository extends JpaRepository<Person, Integer>{
    
    @Query(value="SELECT MUTANT,HUMAN FROM MutantDB.mutantdbstats s",nativeQuery = true)
    List<IStats> getStats();
}