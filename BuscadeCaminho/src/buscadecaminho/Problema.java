package buscadecaminho;

import java.util.ArrayList;

public class Problema {
    
    //Variaveis da classe [Problema]
    String estadoIncial;
    String estadoFinal;
    
    //Resebe variaveis da classe [Problema]
    ArrayList<AcaoResultado> mapa ;

   //Construtor um metodo que é chamado na hora de ser instanciar a objeto
    public Problema(String estadoIncial, String estadoFinal,ArrayList<AcaoResultado> mapa) {
        this.estadoIncial = estadoIncial;
        this.estadoFinal = estadoFinal;
        this.mapa = mapa;
    }
      
}   

