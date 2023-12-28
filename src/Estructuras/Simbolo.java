/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Faxx
 */
public class Simbolo {
    public String iden;
    public String rol;
    public String tipo;
    public String entorno;
    public int linea;
    public int columna;
    
    public String valor = "";
    
    public Simbolo(String identificador, String rol, String tipo,String entorno, int linea, int columna){
        this.iden = identificador;
        this.rol = rol;
        this.tipo = tipo;
        this.entorno = entorno;
        this.columna = columna;
        this.linea = linea;
    }
}
