package com.federicogallardo.mutantAPI.Factories;

import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategy;
import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies.BusquedaDiagonal;
import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies.BusquedaHorizontal;
import com.federicogallardo.mutantAPI.Strategies.MutantDNASearchStrategies.BusquedaVertical;

public class MutantDNASearchStrategyFactory {
    public static MutantDNASearchStrategy create(String param){
        if(param.contains("Diagonal"))
            return new BusquedaDiagonal();
        if(param.contains("Horizontal"))
            return new BusquedaHorizontal();
        if(param.contains("Vertical"))
            return new BusquedaVertical();
        return null;
    }
}