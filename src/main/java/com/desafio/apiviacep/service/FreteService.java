package com.desafio.apiviacep.service;

import com.desafio.apiviacep.model.Frete;
import org.springframework.stereotype.Service;

@Service
public class FreteService {

    public Frete getFrete(String uf){
        Frete frete = new Frete();
        //Sudeste
        if (uf .equals("ES")  | uf .equals("MG")  | uf .equals("RJ")  | uf .equals("SP") ){
            frete.setFrete("R$7,85");
        }
        //Centro-oeste
        else if (uf .equals("DF")  | uf .equals("GO")  | uf .equals("MT")  | uf .equals("MS") ){
            frete.setFrete("R$12,50");
        }//Nordeste
        else if (uf .equals("AL")  | uf .equals("BA")  | uf .equals("CE")  | uf .equals("MA") | uf .equals("PB")  |
                uf .equals("PI")  | uf .equals("PE")  | uf .equals("RN") | uf .equals("SE") ){
            frete.setFrete("R$15,98");
        }//Sul
        else if (uf .equals("PR")  | uf .equals("RS")  | uf .equals("SC") ){
            frete.setFrete("17,30");
        }//Norte
        else if (uf .equals("AC")  | uf .equals("AP" ) | uf .equals("AM")  | uf .equals("PA") | uf .equals("RO") |
                uf .equals("RR") | uf .equals("TO") ){
            frete.setFrete("R$20,83");
        }

        return frete;
    }
}
