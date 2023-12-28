

/* 1. Package e importaciones */
package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
/* 2. Configuraciones para el analisis (Opciones y Declaraciones) */
%{
    //Codigo de usuario en sintaxis java
    //Agregar clases, variables, arreglos, objetos etc...
    public class Lexema{        
            public String lexema;
            public String token;
            public int fila;
            public int columna;


            public Lexema(String lexema, String token, int fila, int columna){
            this.lexema = lexema;
            this.token = token;
            this.fila = fila;
            this.columna = columna;
        }
    }

    public List<Lexema> lexemas = new ArrayList<Lexema>();

%}

//Directivas
%class Scanner
%public 
%cup
%char
%column
%full
%line
%unicode
%ignorecase
//%debug

//Inicializar el contador de yychar y fila con 1
%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

//Expresiones regulares
BLANCOS=[ \r\t]+
ENTERO=[0-9]+
DECIMALES=[0-9]+("."[  |0-9]+)?
ID = [A-Za-z_][A-Za-z0-9_]*
BOOL = "true"| "false"
STR  =   \"([^\"]|"\\\"")+\"
CHAR = '[^']'
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

comentarioSimple = "//"(InputCharacter)*(LineTerminator)?

//Reglas Semanticas
//Palabras reservadas
%%
"void" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_VOID,yyline,yychar,yytext());}     
"main" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("main","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_MAIN,yyline,yychar,yytext());         
} 

"entero" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("entero","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_ENTERO,yyline,yychar,yytext());         
} 
"doble" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("doble","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_DOBLE,yyline,yychar,yytext());         
} 
"binario" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("binario","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_BIN,yyline,yychar,yytext());     
} 
"cadena" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("cadena","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CADENA,yyline,yychar,yytext());     
}  
"caracter" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("caracter","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CHAR,yyline,yychar,yytext());     
} 

"retorno" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema("retorno","Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_RETORNO,yyline,yychar,yytext());     
} 

"imprimir" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_IMPRI,yyline,yychar,yytext());     
} 
"si" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_SI,yyline,yychar,yytext());     
} 
"sino" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_SINO,yyline,yychar,yytext());     
}
"para" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_PARA,yyline,yychar,yytext());     
}
"selector" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_SELECT,yyline,yychar,yytext());     
}  
"caso" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CASO,yyline,yychar,yytext());     
}
"cortar" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CORTAR,yyline,yychar,yytext());     
}
"pordefecto" {
    System.out.println("Reconocio PR: "+yytext());
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_PDEFECT,yyline,yychar,yytext());
}
"mientras" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_MIENTRAS,yyline,yychar,yytext());     
}
"hacer" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_HACER,yyline,yychar,yytext());     
}
"continuar" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CONTINUAR,yyline,yychar,yytext());     
}
"ejecutar" {  
    System.out.println("Reconocio PR: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_EJECUTAR,yyline,yychar,yytext());     
}

//Simbolos importantes
";" { 
    System.out.println("Reconocio "+yytext()+" punto y coma"); 
    //lexemas.add( new Lexema(";"," punto y coma",yyline,yychar));
    return new Symbol(sym.PTCOMA,yyline,yychar,yytext());     
} 
"(" { 
    System.out.println("Reconocio "+yytext()+" parentesis abre"); 
    //lexemas.add( new Lexema("(","Abre parentesis",yyline,yychar));    
    return new Symbol(sym.PARIZQ,yyline,yychar,yytext());
} 
")" { 
    System.out.println("Reconocio "+yytext()+" parentesis cierra"); 
    //lexemas.add( new Lexema(")","Cierra parentesis",yyline,yychar));
    return new Symbol(sym.PARDER,yyline,yychar,yytext());
} 
"}" { 
    System.out.println("Reconocio "+yytext()+" llave cierra"); 
    //lexemas.add( new Lexema("}","Abre llave",yyline,yychar));
    return new Symbol(sym.LLAVDER,yyline,yychar,yytext());    
} 
"{" { 
    System.out.println("Reconocio "+yytext()+" llave abre"); 
    //lexemas.add( new Lexema("{","Cierra llave",yyline,yychar));
    return new Symbol(sym.LLAVIZQ,yyline,yychar,yytext());
} 
 
"[" { 
    System.out.println("Reconocio "+yytext()+" parentesis abre"); 
    //lexemas.add( new Lexema("(","Abre corchetes",yyline,yychar));    
    return new Symbol(sym.CORIZQ,yyline,yychar,yytext());
} 
"]" { 
    System.out.println("Reconocio "+yytext()+" parentesis cierra"); 
    //lexemas.add( new Lexema(")","Cierra corchetes",yyline,yychar));
    return new Symbol(sym.CORDER,yyline,yychar,yytext());
} 
"=" { 
    System.out.println("Reconocio "+yytext()+" igual"); 
    //lexemas.add( new Lexema("=","Igual",yyline,yychar));
    return new Symbol(sym.IGUAL,yyline,yychar,yytext());
} 
"." { 
    System.out.println("Reconocio "+yytext()+" punto"); 
    //lexemas.add( new Lexema(".","Punto",yyline,yychar));
    return new Symbol(sym.PUNTO,yyline,yychar,yytext()); 
} 
"," { 
    System.out.println("Reconocio "+yytext()+" coma"); 
    //lexemas.add( new Lexema(yytext(),"Coma",yyline,yychar));
    return new Symbol(sym.COMA,yyline,yychar,yytext());
 
} 
":" { 
    System.out.println("Reconocio "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Dos Puntos",yyline,yychar));
    return new Symbol(sym.DOSPUNTOS,yyline,yychar,yytext()); 
} 
"$" { 
    System.out.println("Reconocio "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Simbolo monetario",yyline,yychar));
    return new Symbol(sym.DOLLAR,yyline,yychar,yytext()); 
} 



//Operaciones
"+" {
    //lexemas.add( new Lexema("+","Operador Más",yyline,yychar));
    return new Symbol(sym.MAS,yyline,yychar,yytext());
} 
"-" {
    //lexemas.add( new Lexema("-","Operador Menos",yyline,yychar));
    return new Symbol(sym.MENOS,yyline,yychar,yytext());
} 
"*" {
    //lexemas.add( new Lexema("*","Operador Multiplicador",yyline,yychar));
    return new Symbol(sym.POR,yyline,yychar,yytext());
} 
"/" {
    //lexemas.add( new Lexema("/","Operador Division",yyline,yychar));
    return new Symbol(sym.DIVIDIDO,yyline,yychar,yytext());
}  
"^" {
    //lexemas.add( new Lexema("^","Operador Potencia",yyline,yychar));
    return new Symbol(sym.POTENCIA,yyline,yychar,yytext());
} 
"<" {
    //lexemas.add( new Lexema(yytext(),"Operador Menorque",yyline,yychar));
    return new Symbol(sym.MENORQUE,yyline,yychar,yytext());
} 
">" {
    //lexemas.add( new Lexema(yytext(),"Operador Mayorque",yyline,yychar));
    return new Symbol(sym.MAYORQUE,yyline,yychar,yytext());
} 
"<=" {
    //lexemas.add( new Lexema(yytext(),"Operador Mayor O Igual Que",yyline,yychar));
    return new Symbol(sym.MENOROIGUAL,yyline,yychar,yytext());
} 
">=" {
    //lexemas.add( new Lexema(yytext(),"Operador Mayor O Igual Que",yyline,yychar));
    return new Symbol(sym.MAYOROIGUAL,yyline,yychar,yytext());
}
"==" {
    //lexemas.add( new Lexema(yytext(),"Operador Igual Que",yyline,yychar));
    return new Symbol(sym.EQUALS,yyline,yychar,yytext());
} 
"!=" {
    //lexemas.add( new Lexema(yytext(),"Operador Distinto Que",yyline,yychar));
    return new Symbol(sym.DISTINTO,yyline,yychar,yytext());
} 
"&&" {
    //lexemas.add( new Lexema(yytext(),"Operador And",yyline,yychar));
    return new Symbol(sym.AND,yyline,yychar,yytext());
}
"||" {
    //lexemas.add( new Lexema(yytext(),"Operador Or",yyline,yychar));
    return new Symbol(sym.OR,yyline,yychar,yytext());
} 
"!" {
    //lexemas.add( new Lexema(yytext(),"Operador Not",yyline,yychar));
    return new Symbol(sym.NOT,yyline,yychar,yytext());
}

\n {yychar=1;}

{BLANCOS} {} 
{comentarioSimple} {System.out.println("Comentario: "+yytext()); }
{BOOL} {System.out.println("Reconocio BOOL: "+yytext());  
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.BOOLEANO,yyline,yychar, yytext());} 
{ID} {System.out.println("Reconocio ID: "+yytext());    
    //lexemas.add( new Lexema(yytext(),"ID",yyline,yychar));
    return new Symbol(sym.ID,yyline,yychar, yytext()); } 
{ENTERO} {System.out.println("Reconocio entero: "+yytext()); 
    //lexemas.add( new Lexema(yytext(),"Número Entero",yyline,yychar));
    return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
{DECIMALES} {
    //lexemas.add( new Lexema(yytext(),"Numero Decimal",yyline,yychar));
    return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
{STR} {System.out.println("Reconocio cadena: "+yytext());
    //lexemas.add( new Lexema(yytext(),"Cadena de caracteres",yyline,yychar));
    return new Symbol(sym.STR,yyline,yychar, yytext());}
{CHAR} {
    //lexemas.add( new Lexema(yytext(),"Caracter",yyline,yychar));
    return new Symbol(sym.CHAR,yyline,yychar, yytext());}
. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}