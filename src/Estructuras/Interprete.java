/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faxx
 */
public class Interprete {
    public AST arbolSintactico;
    public List<Simbolo> simbolos;
    
    public Interprete(AST arbol, List<Simbolo> simbolos){
        this.simbolos = simbolos;
        this.arbolSintactico = arbol;
    }
    
    public String ejecutarSentenciaImprimir(){
            String mensaje = this.arbolSintactico.hijos.get(0).dato;
            if(mensaje.contains("\"")){
                return mensaje.replace("\"","");
            }else{
                   //System.out.println(mensaje+this.simbolos.size());
                for(Simbolo sim: Analizadores.Parser.simbolos){
                    if(sim.iden.equals(mensaje)){
                    return sim.valor;
                    }
                }
            }
            System.out.println("No se pudo imprimir el mensaje de "+arbolSintactico.hijos.get(0).dato);
        return "";
    }
        
    public String ejecutarSentenciaIf(){
        //System.out.println(simbolos.size());
        String salida = "";
        String  condicion = this.arbolSintactico.hijos.get(0).hijos.get(0).getValor();        
        if( condicion.contains("rue")){
            salida += this.arbolSintactico.hijos.get(1).EjecutarSentencias(this.arbolSintactico);
        }
        return salida;
    }

    public String ejecutarSentenciaWhile(){
        String salida = "";
        
        String  condicion = this.arbolSintactico.hijos.get(0).hijos.get(0).getValor();
        //System.out.println(condicion);
        while( condicion.contains("rue")){
            salida += this.arbolSintactico.hijos.get(1).EjecutarSentencias(this.arbolSintactico);
            //System.out.println(this.arbolSintactico.hijos.get(1).dato);
            condicion = this.arbolSintactico.hijos.get(0).hijos.get(0).getValor();
            
        }    
        return salida;
    }
    
    
    
}
