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
    
    public String ejecutarSentencias(){
        if(arbolSintactico.dato.equals("imprimir()")){
            String mensaje = arbolSintactico.hijos.get(0).dato;
            if(mensaje.contains("\"")){
                return mensaje;
            }else{
                for(Simbolo symbol: this.simbolos){
                    if(symbol.iden.equals(mensaje)){
                        return symbol.valor;
                    }
                }
            }
        }
        System.out.println("No se pudo imprimir el mensaje de "+arbolSintactico.hijos.get(0).dato);
        return "";
    }
}
