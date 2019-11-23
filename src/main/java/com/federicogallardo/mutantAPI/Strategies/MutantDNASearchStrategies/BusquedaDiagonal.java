package com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies;

import java.util.ArrayList;
import java.util.List;

import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategy;

public class BusquedaDiagonal implements MutantDNASearchStrategy{

    @Override
    public boolean isMutant(List<String> dna) {
        String arriba2 = "";
        String arriba1 = "";
        String medio = "";
        String abajo1 = "";
        String abajo2 = "";
        List<String> mDiagonal = new ArrayList<String>();
        int contador = 0;
        for(int i=0;i<6;i++){     
            if(i+2<=5){
             arriba2 += dna.get(i).charAt(i+2);
             abajo2 += dna.get(i+2).charAt(i);
            }
            
            if(i+1<=5){
             arriba1 += dna.get(i).charAt(i+1);
             abajo1 += dna.get(i+1).charAt(i);
            }
            medio += dna.get(i).charAt(i);
        }
        mDiagonal.add(arriba2);
        mDiagonal.add(arriba1);
        mDiagonal.add(medio);
        mDiagonal.add(abajo1);
        mDiagonal.add(abajo2);
        for(String cadena : mDiagonal){
            if(cadena.contains("AAAA") || cadena.contains("CCCC") || cadena.contains("GGGG") || cadena.contains("TTTT")){
                contador +=1;
            }
        }        
        if (contador >= 2)
            return true;
        else
            return false;
    }
    
}