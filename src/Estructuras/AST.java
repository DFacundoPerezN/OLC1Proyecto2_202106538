/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Analizadores.Parser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faxx
 */
public class AST {
    public String dato;
    public List<AST> hijos =  new ArrayList<>();
    
    public  List<Simbolo> simbolos = new ArrayList<>();
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
    
    public String infoGraphviz(int contador){
        int inicial = contador;
        String salida ="";
        salida += "n"+contador+"[label=\""+this.dato.replace("\"", "\\\"")+"\"];\n";
        contador++;
        
        int i=0;
        while( i<this.hijos.size() ){
            
            salida += "n"+(inicial)+" -> n"+(contador+i)+"\n";
            
            salida += hijos.get(i).infoGraphviz(contador+i);//(1+0)       (2+0)
            
            contador = contador +  hijos.get(i).crecimiento();
            i++;
        }        
        return salida;
    }  
    
    public int crecimiento(){
        int c = 0;        
            c = c + hijos.size();
            
        for( AST hijo : this.hijos){
            c = c + hijo.crecimiento();
        }        
        return c;
    }
    
    public String getValor(){
       switch(this.dato) {
           //aritmeticos
           case "+" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   int number = Integer.valueOf(hijos.get(0).getValor()) +Integer.valueOf(hijos.get(1).getValor()) ;
                   return Integer.toString(number);
               }else if( hijos.get(0).getValor().matches("[0-9].+")){
                   double number = Double.parseDouble(hijos.get(0).getValor()) +Double.parseDouble(hijos.get(1).dato) ;
                   return String.valueOf(number);
               }
               return hijos.get(0).getValor() + hijos.get(1).getValor();
               //break;
            }
           case "-" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   int number = Integer.valueOf(hijos.get(0).getValor())-Integer.valueOf(hijos.get(1).getValor()) ;
                   return Integer.toString(number);
               }
                double number = Double.parseDouble(hijos.get(0).getValor())-Double.parseDouble(hijos.get(1).getValor()) ;
                return String.valueOf(number);
            }           
           case "*" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   int number = Integer.valueOf(hijos.get(0).getValor())*Integer.valueOf(hijos.get(1).getValor()) ;
                   return Integer.toString(number);
               }
                double number = Double.parseDouble(hijos.get(0).getValor())*Double.parseDouble(hijos.get(1).getValor()) ;
                return String.valueOf(number);
            }           
           case "/" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   double number = Integer.valueOf(hijos.get(0).getValor())/Integer.valueOf(hijos.get(1).getValor()) ;
                   return String.valueOf(number);
               }
                double number = Double.parseDouble(hijos.get(0).getValor())/ Double.parseDouble(hijos.get(1).getValor()) ;
                return String.valueOf(number);
            }           
           case "^" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   int number =  (int) Math.pow(Integer.valueOf(hijos.get(0).getValor()), Integer.valueOf(hijos.get(1).getValor()));
                   return String.valueOf(number);
               }
                double number = Math.pow(Double.parseDouble(hijos.get(0).getValor()),Double.parseDouble(hijos.get(1).getValor())) ;
                return String.valueOf(number);
            }
           case "%" -> {
               if( hijos.get(0).getValor().matches("[0-9]+")){
                   int number = Integer.valueOf(hijos.get(0).getValor()) % Integer.valueOf(hijos.get(1).getValor()) ;
                   return String.valueOf(number);
               }
                double number = Double.parseDouble(hijos.get(0).getValor())% Double.parseDouble(hijos.get(1).getValor()) ;
                return String.valueOf(number);
            }
            //relacionales
            case "==" -> { System.out.println("comparando "+hijos.get(0).getValor()+" con "+hijos.get(1).getValor());
               if( hijos.get(0).getValor().equals(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }case "!=" -> {
               if( !hijos.get(0).getValor().equals(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }case ">" -> {
                System.out.println("Comparando: "+hijos.get(0).getValor()+" y "+hijos.get(1).dato);
               if( Double.parseDouble(hijos.get(0).getValor()) > Double.parseDouble(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }case "<" -> {
               if( Double.parseDouble(hijos.get(0).getValor()) < Double.parseDouble(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }case ">=" -> {
               if( Double.parseDouble(hijos.get(0).getValor()) >= Double.parseDouble(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }case "<=" -> {
               if( Double.parseDouble(hijos.get(0).getValor()) <= Double.parseDouble(hijos.get(1).getValor())){
                   return "true";
               }
                return "false";
            }
            // Logicos
            case "||" -> {
               if( hijos.get(0).getValor().equals("true") || hijos.get(1).getValor().equals("true")){
                   return "true";
               }
                return "false";
            }case "&&" -> {
               if( hijos.get(0).getValor().equals("true") && hijos.get(1).getValor().equals("true")){
                   return "true";
               }
                return "false";
            }case "!" -> {
               if( hijos.get(0).getValor().equals("true") ){
                   return "false";
               }
                return "true";
            }
            //especiales
            case "true"->{
                return "true";
            }case "false"->{
                return "false";
            }case "()"->{
                return  hijos.get(0).getValor();
            }
            //ojala salga bien papi
           default -> {
                if(this.dato.contains("\"") || this.dato.contains("\'") || this.dato.matches("[0-9.]+")){
                        return this.dato;
                 }else{
                         return getValorfromSimbolo(dato);
                         }
            }
       }
    }
    
    public String getValorfromSimbolo(String id){
        //System.out.println(this.simbolos.size());
        for(Simbolo sim: Analizadores.Parser.simbolos){
            if(sim.iden.equals(id)){
                return sim.valor;
            }
        }
        return "nulo";
    }
    
    public String EjecutarSentencias(AST sentenciasRaiz){
        System.out.println(this.simbolos.size());
        String salidas ="";
        for (AST sentencia: this.hijos){
            System.out.println("Se leyo sentencia: "+ sentencia.dato);
           switch(sentencia.dato) {
            case "imprimir()" -> {
                Interprete inter = new Interprete(sentencia, this.simbolos);
                salidas += "\n"+inter.ejecutarSentenciaImprimir();
                }
            case "si" -> {
                Interprete inter = new Interprete(sentencia, this.simbolos);
                salidas += inter.ejecutarSentenciaIf();
                }
            case "mientras" -> {
                Interprete inter = new Interprete(sentencia, this.simbolos);
                salidas += inter.ejecutarSentenciaWhile();
                }
            case "para" -> {
                Interprete inter = new Interprete(sentencia, this.simbolos);
                salidas += inter.ejecutarSentenciaFor();
                }
            case "incremento" -> {
                for(Simbolo sim: Analizadores.Parser.simbolos){
                    if(sim.iden.equals(sentencia.hijos.get(0).dato)){
                        //System.out.println(sentencia.hijos.get(0).dato);
                        int aumentado = Integer.valueOf(sentencia.hijos.get(0).getValor())+1;
                        //System.out.println("intento de incremento");
                        sim.valor = String.valueOf(aumentado);
                    }
                }//System.out.println("succes in decrement");
                }
            case "decremento" -> {
                for(Simbolo sim: Analizadores.Parser.simbolos){
                    if(sim.iden.equals(sentencia.hijos.get(0).dato)){
                        int bajado = Integer.valueOf(sentencia.hijos.get(0).getValor())-1;
                        sim.valor = String.valueOf(bajado); break;
                    }
                }
            }
            case "declaracion" -> {
                for(Simbolo sim: Analizadores.Parser.simbolos){
                    if(sim.iden.equals(sentencia.hijos.get(1).dato)){
                        if(sentencia.hijos.size()>2){
                            String cambiada = sentencia.hijos.get(2).getValor();
                            sim.valor = cambiada;
                        }else{
                            System.out.println("default of "+sentencia.hijos.get(0).dato+" " +Interprete.defaults.get(sentencia.hijos.get(0).getValor()));
                            String cambiada = Interprete.defaults.get(sentencia.hijos.get(0).dato);
                            sim.valor = cambiada;
                        }
                    }
                }
            }
            case "definicion" -> {
                for(Simbolo sim: Analizadores.Parser.simbolos){
                    if(sim.iden.equals(sentencia.hijos.get(0).dato)){
                        String cambiada = sentencia.hijos.get(1).getValor();
                        //System.out.println(sim.iden + " = "+ cambiada);
                        sim.valor = cambiada;
                    }
                }
            }
            
            default -> { 
                    if(sentencia.dato.contains("()")){// si tene parentecis entonce ses la llamada a una funcion                            
                        //System.out.println("Fue llamado el metodo: "+sentencia.dato);
                        String metodo = sentencia.dato;                             
                        for (AST opcion: sentenciasRaiz.hijos.get(0).hijos){
                            if(opcion.dato.contains(metodo)){
                                //System.out.println("Se econtro a "+sentencia.dato);                
                                salidas +=  opcion.hijos.get(0).EjecutarSentencias(sentenciasRaiz);
                                break;
                            }
                        }
                    }else{
                            System.out.println("No tienes definida este dato, crack "+ sentencia.dato);
                    }
                    salidas += "";       
                 }
            }
        }
        return salidas;
    }
    
    
    public String Ejecutar(){
        String salida ="";
        String metodo = "$%";
        for(AST sentencia: this.hijos.get(0).hijos){
                if(sentencia.dato.contains("ejecutar")){
                    metodo = sentencia.dato.split(" ")[1];
                    //System.out.println("Se busca ejecutar el metodo "+metodo);
                    break;
                }
            }
        for (AST sentencia: this.hijos.get(0).hijos){
            if(sentencia.dato.contains(metodo)){
                //System.out.println("Se econtro a "+sentencia.dato);                
                salida += sentencia.hijos.get(0).EjecutarSentencias(this);
                break;
            }
        }
        return salida;
    }
}
