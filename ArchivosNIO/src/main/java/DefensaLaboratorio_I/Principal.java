package DefensaLaboratorio_I;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        Operaciones obj = new Operaciones();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("MENU DE OPCIONES ");
            System.out.println("1.  Crear archivo");
            System.out.println("2. Registrar Proyecto de grado o Libro");
            System.out.println("3. Mostrar Datos"); 
            System.out.println("4. buscar  libro");
            System.out.println("5. eliminar");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1: 
                    obj.crearArchivo();
                    break;
                case 2:
                    String res = "S";
                    while (res.equalsIgnoreCase("S")) {
                        obj.Agregar();
                          obj.guardarObjetos();
                        leer.nextLine(); 
                        System.out.println("Desea seguir registrando material Bibliografico S/N");
                        res = leer.nextLine();
                    } 
                    break;  
                case 3:
                    obj.leerBibliografia();
                    obj.mostrarp();
                    break;
                case 4:
                    obj.leerBibliografia();
                    System.out.println(" digite titulo a buscar");
                    leer.nextLine();
                    String ti = leer.nextLine();
                    obj.BuscarLibro(ti);
                    obj.guardarObjetos();
                    break;
                case 5: 
                    obj.leerBibliografia();
                    obj.Eliminar();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            } 
        } while (continuar);
    }

}
