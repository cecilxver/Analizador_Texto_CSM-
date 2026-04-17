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
        FileWriter fw1 = new FileWriter(archivo_aguardar,false);
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
        bw1.close();
        fw1.close();

    }
    public static void analizarTexto(File archivoa, BufferedWriter bw1) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
        String ruta=sc.next();

        File archivo=new File(ruta);
        FileReader f=new FileReader(archivo);
        BufferedReader br=new BufferedReader(f);
        int n_lineas=0;
        int chars_lineas=0;
        int chars_sinl=0;
        String linea=br.readLine();
        while(linea!=null){
            n_lineas++;
            System.out.println(linea);
            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) != ' ') {
                    chars_sinl++;
                }
                chars_lineas++;
            }

            linea=br.readLine();

        }
        f.close();
        System.out.println("Haciendo estadísticas de texto. . .");
        System.out.println(n_lineas+" lineas");
        System.out.println("Los carácteres contando espacios son: "+chars_lineas);
        System.out.println("Los carácteres sin contar espacios son: "+chars_sinl);
        System.out.println("Guardando resultados. . .");
        bw1.write("Número de líneas: "+n_lineas+"\nLos carácteres contando espacios son: "+chars_lineas+"\n Los carácteres sin contar espacios son: "+chars_sinl);
        bw1.newLine();
        bw1.flush();
        System.out.println("Resultados guardados");



    }

public static void analisisContenido(File archivoa, BufferedWriter bw1) throws IOException {
    Scanner sc=new Scanner(System.in);
    System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
    String ruta=sc.next();
    System.out.println("Escribe la palabra que quieres que sea buscada");
    String palabra=sc.next();
    File archivo=new File(ruta);
    FileReader f=new FileReader(archivo);
    BufferedReader br=new BufferedReader(f);
    int n_palabra=0;
    String linea=br.readLine();
    while (linea!=null){
        if (linea.contains(palabra)){
            System.out.println(linea);
            n_palabra++;
        }
        linea=br.readLine();
    }
    f.close();
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
    for (int i = 0; i < linea.length(); i++) {
        if (linea.charAt(i) == '.') {
            n_frases++;
            System.out.println(linea);
        }
    }
    linea= br.readLine();
    }
    System.out.println("Hay "+n_frases+" en total");
    bw1.write("Hay "+n_frases+" frases en total");
    bw1.flush();
    br.close();

f.close();
}}
