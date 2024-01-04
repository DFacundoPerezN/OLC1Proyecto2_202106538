/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

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
            if(mensaje.contains("\"")|| mensaje.contains("\'") || mensaje.equals("true") || mensaje.equals("false")){
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
        String condicion = this.arbolSintactico.hijos.get(0).hijos.get(0).getValor();    
        System.out.println("la condicion es: "+ condicion);
        if( condicion.contains("rue")){
            salida += this.arbolSintactico.hijos.get(1).EjecutarSentencias(this.arbolSintactico);
        }
        else{
            for (int i=this.arbolSintactico.hijos.size(); i>2; i--){
                AST extraSino= this.arbolSintactico.hijos.get(i-1);
                if(extraSino.dato.equals("sino")){
                    salida += extraSino.hijos.get(0).EjecutarSentencias(extraSino); 
                }else{
                    Interprete inter = new Interprete(extraSino, this.simbolos);
                    salida += inter.ejecutarSentenciaIf();
                }
            }
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
    
        public String ejecutarSentenciaFor(){
        String salida = "";
        //Parte de la declaracion
        AST declaracion = this.arbolSintactico.hijos.get(0);
        for(Simbolo sim: Analizadores.Parser.simbolos){
            if(sim.iden.equals(declaracion.hijos.get(1).dato)){
                if(declaracion.hijos.size()>2){
                    String cambiada = declaracion.hijos.get(2).getValor();
                    sim.valor = cambiada;
                }else{
                    String cambiada = Interprete.defaults.get(declaracion.hijos.get(0).dato);
                    sim.valor = cambiada;
                }
            }
        }
        //condicion
        String condicion = this.arbolSintactico.hijos.get(1).hijos.get(0).getValor();
        //ciclo
        while( condicion.contains("rue")){
            //sentencias
            salida += this.arbolSintactico.hijos.get(3).EjecutarSentencias(this.arbolSintactico);
            //actualizacion
            AST actualizacion =  this.arbolSintactico.hijos.get(2);
            //System.out.println("actualizacion tipo: "+ actualizacion.dato);   
            for(Simbolo sim: Analizadores.Parser.simbolos){
                if(sim.iden.equals(actualizacion.hijos.get(0).dato)){
                    if(actualizacion.dato.equals("incremento")){
                        int aumentado = Integer.valueOf(actualizacion.hijos.get(0).getValor())+1;                        
                        sim.valor = String.valueOf(aumentado);
                    }else{
                        int aumentado = Integer.valueOf(actualizacion.hijos.get(0).getValor())-1;                        
                        sim.valor = String.valueOf(aumentado);
                    }
                }
            }
            //condicion = this.arbolSintactico.hijos.get(1).hijos.get(0).getValor();    
            System.out.println("condicion = "+condicion);
        }    
        return salida;
    }
        
    public String ejecutarSentenciaDoWhile(){
        String salida = "";
        
        String condicion = "";
        do{
            salida += this.arbolSintactico.hijos.get(0).EjecutarSentencias(this.arbolSintactico);
            //System.out.println(this.arbolSintactico.hijos.get(1).dato);
            condicion = this.arbolSintactico.hijos.get(1).hijos.get(0).getValor();  
            System.out.println("condicion = "+condicion);          
        }while( condicion.contains("rue"));  
        return salida;
    }
    
    public String ejecutarSentenciaSwitch(){
        String salida = "";
        
        String valor = this.arbolSintactico.hijos.get(0).getValor();
        for (AST caso : this.arbolSintactico.hijos.get(1).hijos){
            if(caso.dato.equals("caso") && caso.hijos.get(0).dato.equals(valor)){
                salida += caso.hijos.get(1).EjecutarSentencias(this.arbolSintactico);
                break;
            }
            else if(caso.dato.equals("pordefecto")){
                salida += caso.hijos.get(0).EjecutarSentencias(this.arbolSintactico);
                break;
            }
        }
        
        return salida;
    }
    
    public static Map<String,String> defaults = Map.ofEntries(
            entry("entero","0"), entry("doble","0.0"), entry("binario","true"), entry("caracter","'\\u0000'"), entry("cadena","\"\"")
    );
    
}
