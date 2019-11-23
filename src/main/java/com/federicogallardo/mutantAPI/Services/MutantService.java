package com.federicogallardo.mutantAPI.Services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.federicogallardo.mutantAPI.DTOs.IStats;
import com.federicogallardo.mutantAPI.DTOs.PersonDTO;
import com.federicogallardo.mutantAPI.DTOs.StatsDTO;
import com.federicogallardo.mutantAPI.Entities.Person;
import com.federicogallardo.mutantAPI.Factories.MutantDNASearchStrategyFactory;
import com.federicogallardo.mutantAPI.Repositories.MutantRepository;
import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategy;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MutantService{
    private final MutantRepository repository;
    
    public MutantService(final MutantRepository repository) {
        super();
        this.repository = repository;
    }

    @Transactional
    public List<IStats> getStats() throws Exception{
      try{
        return this.repository.getStats();
      }catch(final Exception e){
        throw new Exception();
      }
    }

    @Transactional
    public boolean verifyDNAandSave(final PersonDTO persondto) throws Exception{
        //REVISAR SI LA PERSONA YA EXISTE?
        try{
            boolean result = false;
            final MutantDNASearchStrategy busquedaHorizontal = MutantDNASearchStrategyFactory.create("Horizontal");
            final MutantDNASearchStrategy busquedaVertical = MutantDNASearchStrategyFactory.create("Vertical");
            final MutantDNASearchStrategy busquedaDiagonal = MutantDNASearchStrategyFactory.create("Diagonal");
            if(busquedaHorizontal.isMutant(persondto.getDna())){
              result = true;
            }
            if(busquedaVertical.isMutant(persondto.getDna()) && result !=true){
              result = true;
            }
            if(busquedaDiagonal.isMutant(persondto.getDna()) && result !=true){
              result = true;
            }
            final ModelMapper modelmapper = new ModelMapper();
            final Person person = modelmapper.map(persondto,Person.class);
            if(result==true){
              person.setMutant(true);
            }
            else{
              person.setMutant(false);
            }
            //repository.save(person);
            if(result == true){
                return true;
            }
            return false;
        }catch(final Exception e){
            throw new Exception();
        }
    }
}