/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2olc1;

/**
 *
 * @author Faxx
 */
public class Proyecto2OLC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new InterfazPrincipal().setVisible(true);
                
        String p = "void mimetodo(){\n" +
"	entero x=9+1;\n" +
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
        
        String s = "entero suma(entero x, entero y){\n" +
"	entero result = x+y;\n" +
"	retorno result;\n" +
"}\n" +
"\n" +
"entero multi(entero x, entero y){\n" +
"	entero result = x*y;\n" +
"	retorno result;\n" +
"}\n" +
"\n" +
"void mimetodo(){\n" +
"	\n" +
"	entero var1;\n" +
"	entero var2 = 10;\n" +
"	\n" +
"	var1 = suma(1, 10);\n" +
"	var2 = multi(var1, 50);\n" +
"\n" +
"	imprimir(var1);\n" +
"	imprimir(var2);\n" +
"\n" +
"	si(var1 > var2){\n" +
"		imprimir(\"entra en el if\");\n" +
"	}sino{\n" +
"		imprimir(\"entra en el else\");\n" +
"	}\n" +
"	\n" +
"	imprimir(\"empieza el for\");	\n" +
"	entero var3 = var2;\n" +
"\n" +
"	para (entero i =0; i < 10; i++){\n" +
"		var3= suma(var3, i);\n" +
"		imprimir(var3);\n" +
"	}\n" +
"\n" +
"	imprimir(\"finaliza el for\");\n" +
"\n" +
"	binario bandera = true;\n" +
"	entero var4=10;\n" +
"\n" +
"	hacer{\n" +
"		si(var4==1){\n" +
"			bandera=false;\n" +
"		}\n" +
"		var4=var4-1;\n" +
"		imprimir(var4);\n" +
"	}mientras(bandera);\n" +
"	\n" +
"}\n" +
"\n" +
"ejecutar mimetodo();";
      
        String n ="void mimetodo(){\n" +
"	imprimir(\"intentando\");"
        + "mimetodo2();"
        + "} " +
    "void mimetodo2(){\n" +
"	entero h=0;\n" +
"mientras(h<10){\n" +
"		imprimir(h);\n" +
"                h=h+1;\n" +
"}}"+
"ejecutar mimetodo();";        
        
        //String graf = Analizador.TablaSimbolosHTML(n);
        //String ass = Analizador.Salidas(n); System.out.println("---------Consola----------\n"+ass+"\n---------Fin consola----------");
    }
    
}
