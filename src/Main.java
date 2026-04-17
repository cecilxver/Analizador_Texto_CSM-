import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Bienvenido al analizador de texto 3000");
        System.out.println("Elige una opción \n1. Estadísticas de texto\n2. Análisis de contenido\n4. Salir");
        int opcion=sc.nextInt();
        boolean menu_bucle=true;
        File archivo_aguardar=new File("resultados.txt");
        archivo_aguardar.createNewFile();
        while (opcion!=4){
            if(!menu_bucle){
                System.out.println("Elige una opción \n1. Estadísticas de texto\n2. Análisis de contenido\n4. Salir");
                 opcion=sc.nextInt();
            }
            switch (opcion){
                case 1:
                    analizarTexto(archivo_aguardar);
                    menu_bucle=false;
                    break;
                case 2:
                    analisisContenido();
                    menu_bucle=false;
                    break;
                case 3:



            }
        }


    }
    public static void analizarTexto(File archivo) throws IOException {
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
        System.out.println("Los carácteres contando espacios son "+chars_lineas);
        System.out.println("Los carácteres sin contar espacios son: "+chars_sinl);
        System.out.println("Guardando resultados. . .");
        
    }

public static void analisisContenido() throws IOException {
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
}
public static void ampliación(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Escriba la ruta del archivo que quiere que sea leída: ");
    String ruta=sc.next();
    }

}
