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
        
        //new InterfazPrincipal().setVisible(true);
                
        String p = "void mimetodo(){\n" +
"	entero x=10;\n" +
"	cadena cad =\"holamundo\";\n" +
"	si(x==10){\n" +
"		imprimir(cad);\n" +
"	}\n" +
"\n" +
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
        
        String c = "para(entero i=0; i<10; i++){\n" +
"		imprimir(i);\n" +
"	}";
      
        String graf = Analizador.TablaSimbolosHTML(p);
        //System.out.println(graf);
    }
    
}
