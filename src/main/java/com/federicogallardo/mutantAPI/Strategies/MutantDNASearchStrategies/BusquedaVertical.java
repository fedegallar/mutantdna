package com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies;

import java.util.ArrayList;
import java.util.List;

import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategy;

public class BusquedaVertical implements MutantDNASearchStrategy{

    @Override
    public boolean isMutant(List<String> dna) {
        List<String> mVertical = new ArrayList<String>();
        String cadena = "";
        int contador = 0;
        for(int i = 0; i<6; i++){
            cadena ="";
            mVertical.add("");
            for(int j = 0;j<6;j++){
                cadena +=dna.get(j).charAt(i);
                if(cadena.contains("AAAA") || cadena.contains("CCCC") || cadena.contains("TTTT") || cadena.contains("GGGG"))
                    contador +=1;
                if(contador==2)
                    break;
            }
            if (contador==2)
                break;
            mVertical.add(i,cadena);
        }
        if(contador==2)
            return true;
        else
            return false;
    }
}