import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Bienvenido al analizador de texto 3000");
        System.out.println("Elige una opción \n1. Estadísticas de texto\n2. Análisis de contenido \n3. Contador de frases \n4. Salir");
        int opcion=sc.nextInt();
        boolean menu_bucle=true;
        File archivo_aguardar=new File("resultados.txt");
        archivo_aguardar.createNewFile();
        FileWriter fw1 = new FileWriter(archivo_aguardar,false); //creamos aquí para escribir en el archivo,
        // para que no se sobreescriba cuando se hacen varias opciones
        BufferedWriter bw1 = new BufferedWriter(fw1);
//───────────────{ MENU }───────────────
        while (opcion!=4){ //mientras no sea la opción de salida, debe continuar el bucle
            if(!menu_bucle){ //si el boolean es false, debe mostrar de nuevo el menú
                System.out.println("Elige una opción \n1. Estadísticas de texto\n2. Análisis de contenido\n3. Contador de frases \n4. Salir");
                 opcion=sc.nextInt();
            }
            switch (opcion){
                case 1:
                    analizarTexto(archivo_aguardar,bw1);
                    menu_bucle=false;
                    break;
                case 2:
                    analisisContenido(archivo_aguardar,bw1);
                    menu_bucle=false;
                    break;
                case 3:
                    ampliación(archivo_aguardar,bw1);
                    menu_bucle=false;
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. . .");
                    break;
                default:
                    System.out.println("Opción no válida, por favor, vuelve a intentarlo");
                    menu_bucle=false;
                    break;

            }
        }
        bw1.close(); //cerramos el FileWriter y el BufferedWriter después de que termine el while
        fw1.close();

    }
    //───────────────{ Estadísticas de texto }───────────────
    public static void analizarTexto(File archivoa, BufferedWriter bw1) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
        String ruta=sc.next(); //pedimos la ruta por pantalla y la guardamos

        File archivo=new File(ruta); //creamos un archivo con esa misma ruta
        FileReader f=new FileReader(archivo); //leemos el archivo
        BufferedReader br=new BufferedReader(f);
        int n_lineas=0; //inicializamos las variables que usaremos en el while
        int chars_lineas=0;
        int chars_sinl=0;
        String linea=br.readLine(); //le damos a "linea" el valor de la linea que sea leida
        while(linea!=null){ //mientras linea no sea nula
            n_lineas++; //aumenta el numero de lineas
            System.out.println(linea); //muestra la linea
            for (int i = 0; i < linea.length(); i++) { //recorre la linea
                if (linea.charAt(i) != ' ') {//mientras no haya espacios, seguirá contando carácteres
                    chars_sinl++; //aumentan los caracteres sin espacios
                }
                chars_lineas++; //aumenta caracteres con espacios
            }

            linea=br.readLine(); //pedimos que lea la siguiente linea cuando haya terminado la anterior

        }
        f.close(); //cerramos los lectores
        br.close();
        System.out.println("Haciendo estadísticas de texto. . ."); //mostramos resultados
        System.out.println(n_lineas+" lineas");
        System.out.println("Los carácteres contando espacios son: "+chars_lineas);
        System.out.println("Los carácteres sin contar espacios son: "+chars_sinl);
        System.out.println("Guardando resultados. . .");
        //guardamos resultados en el archivo resultados.txt
        bw1.write("Número de líneas: "+n_lineas+"\nLos carácteres contando espacios son: "+chars_lineas+"\n Los carácteres sin contar espacios son: "+chars_sinl);
        bw1.newLine(); //hacemos una nueva linea
        bw1.flush();//guardamos los resultados
        System.out.println("Resultados guardados");



    }

public static void analisisContenido(File archivoa, BufferedWriter bw1) throws IOException {
    Scanner sc=new Scanner(System.in);
    System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
    String ruta=sc.next();
    System.out.println("Escribe la palabra que quieres que sea buscada"); //pedimos la palabra y la guardamos
    String palabra=sc.next();
    File archivo=new File(ruta);
    FileReader f=new FileReader(archivo);
    BufferedReader br=new BufferedReader(f);
    int n_palabra=0;//inicializamos la variable
    String linea=br.readLine();
    while (linea!=null){ //mientras linea no sea nulo
        if (linea.contains(palabra)){ //comprobamos si contiene la palabra, si es afirmativo, la mostramos y aumentamos n_palabra
            System.out.println(linea);
            n_palabra++;
        }
        linea=br.readLine(); //pedimos que lea la siguiente linea
    }
    f.close();
    br.close();
    System.out.println("Sale un total de "+n_palabra);
    bw1.write("La palabra "+palabra+" sale un total de "+n_palabra+" veces");
    bw1.newLine();
    bw1.flush();
    System.out.println("Resultados guardados");

}
public static void ampliación(File archivoa, BufferedWriter bw1) throws IOException {
    Scanner sc=new Scanner(System.in);
    System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
    String ruta=sc.next();
    File archivo=new File(ruta);
    FileReader f=new FileReader(archivo);
    BufferedReader br=new BufferedReader(f);
    String linea=br.readLine();
    System.out.println("Haciendo conteo de frases. . .");
    int n_frases=0;
    while(linea!=null){
    for (int i = 0; i < linea.length(); i++) { //recorremos la línea
        if (linea.charAt(i) == '.') { //si hay un . en la línea, aumentará n_frases y mostrará la línea
            n_frases++;
            System.out.println(linea);
        }
    }
    linea= br.readLine(); //pedimos que lea la siguiente
    }
    System.out.println("Hay "+n_frases+" en total");
    bw1.write("Hay "+n_frases+" frases en total"); //guardamos resultados
    bw1.flush();
    br.close();
    f.close();
}}
