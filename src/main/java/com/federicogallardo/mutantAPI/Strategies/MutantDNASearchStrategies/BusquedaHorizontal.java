package com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies;

import java.util.List;

import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategy;

public class BusquedaHorizontal implements MutantDNASearchStrategy{

    @Override
    public boolean isMutant(List<String> dna) {
        int count=0;
        for(String dnastring : dna){
            if(dnastring.contains("AAAA"))
                count +=1;
            if(dnastring.contains("CCCC"))
                count +=1;
            if(dnastring.contains("TTTT"))
                count +=1;
            if(dnastring.contains("GGGG"))
                count +=1;
            if(count==2)
                break;
        }
        if (count==2)
            return true;
        return false;
    }
}