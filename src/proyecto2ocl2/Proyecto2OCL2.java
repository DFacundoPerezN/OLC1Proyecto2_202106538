/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2ocl2;

/**
 *
 * @author Faxx
 */
public class Proyecto2OCL2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new InterfazPrincipal().setVisible(true);
                
        String p = "void mimetodo(){\n" +
"	entero x=10;\n" +
"	cadena cad =\"holamundo\";\n" +
"	si(x==10){\n" +
"		imprimir(cad);\n" +
"	}\n" +
"\n" +
"	selector(x){\n" +
"		caso 1: \n" +
"			imprimir(\"soy el caso 1\");\n" +
"			cortar;\n" +
"		pordefecto:\n" +
"			imprimir(\"soy el caso por defecto\");\n" +
"			cortar;\n" +
"	}\n" +
"	mimetodo2();\n" +
"}\n" +
"\n" +
"void mimetodo2(){\n" +
"	entero h=0;\n" +
"	mientras(h<10){\n" +
"		imprimir(h);\n" +
"	}\n" +
"	para(entero i=0; i<10; i++){\n" +
"		imprimir(i);\n" +
"	}\n" +
"}\n" +
"\n" +
"ejecutar mimetodo();";
      
        
        //System.out.println(Analizador.TablaSimbolosHTML(p));
    }
    
}
