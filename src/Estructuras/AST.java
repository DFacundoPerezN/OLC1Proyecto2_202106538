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
public class AST {
    public String dato;
    public List<AST> hijos =  new ArrayList<>();
    
    public AST(String dato){
        this.dato = dato;
    }
    
    public void imprimirInfo(){
        for(int i=0; i<this.hijos.size(); i++){
            System.out.println(this.dato +" es padre de -> "+ this.hijos.get(i).dato);
        }
        for(int i=0; i<this.hijos.size(); i++){
            this.hijos.get(i).imprimirInfo();
            //System.out.println("#de hijos de "+this.hijos.get(i).dato+ ": "+this.hijos.get(i).hijos.size());
        }
    }
}
