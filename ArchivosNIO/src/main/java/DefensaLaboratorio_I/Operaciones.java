package DefensaLaboratorio_I;

import com.test.archivoObjeto.Cliente;
import com.test.archivoObjeto.OperacionesClienteTarjeta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operaciones {

    Scanner leer = new Scanner(System.in);
    private List<ProyecyoGrado> listaProyecto;
    private List<Libro> listaLibro;
 
    public Operaciones() {
        listaProyecto = new ArrayList<>();
        listaLibro = new ArrayList<>();
    }
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("C:\\Users\\JVC\\Documents\\ARCHIVOSNIO\\MaterialBibliografico.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="C:\\Users\\JVC\\Documents\\ARCHIVOSNIO\\MaterialBibliografico.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaProyecto);
              oos.writeObject(listaLibro);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerBibliografia(){
        String ruta="C:\\Users\\JVC\\Documents\\ARCHIVOSNIO\\MaterialBibliografico.txt";
        try {  
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaProyecto=(List<ProyecyoGrado>)ois.readObject();
                 listaLibro=(List<Libro>)ois.readObject();
            }else{ 
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarProyecto() {
        ProyecyoGrado p = new ProyecyoGrado();
        System.out.println("Ingrese Titulo");
        leer.nextLine();
        p.setTitulo(leer.nextLine());
        System.out.println("Ingrese autor");
        p.setAutor(leer.nextLine());
        System.out.println("Ingrese tutor");
        p.setTutor(leer.nextLine());
        System.out.println("Ingrese revisor");
        p.setRevisor(leer.nextLine());
        listaProyecto.add(p);
    }

    public void agregarLibro() {
        Libro l = new Libro();
        System.out.println("Ingrese Titulo");
        leer.nextLine();
        l.setTitulo(leer.nextLine());
        System.out.println("Ingrese autor");
        l.setAutor(leer.nextLine()); 
        System.out.println("Ingrese edicion");
        l.setEdicion(leer.nextInt());
        System.out.println("Ingrese area");
         leer.nextLine();
        l.setArea(leer.nextLine());
        listaLibro.add(l);
    }

    public void Agregar() {
        System.out.println("Desea agregar Proyecto de grado o Libro");
        System.out.println("1.- proyecto de grado");
        System.out.println("2.- libro");
        int op = leer.nextInt();
        if (op == 1) {
            agregarProyecto();
        } else {
            agregarLibro();
        }
    }

    public void mostrarp() {
        if (listaProyecto.size() > 0 || listaLibro.size() > 0) {
            System.out.println("1.- mostrar proyecto de grado");
            System.out.println("2.- mostrar libro");
            int op = leer.nextInt();
            if (op == 1) {
                System.out.println("*****MATERIAL BIBLIOGRAFICO******");
                for (ProyecyoGrado lista : listaProyecto) {
                    lista.mostrar();
                    System.out.println("--------------------");
                }
            } else {
                if (op == 2) {
                    System.out.println("*****MATERIAL BIBLIOGRAFICO******");
                    for (Libro lista : listaLibro) {
                        lista.mostrar();
                        System.out.println("--------------------");
                    }
                } else {
                    System.out.println(" usted no elegiio ninguna opcions");
                }
            }
        } else {
            System.out.println(" no registro ninugo material bibliografico");
        }
    }
    public void BuscarLibro(String ti){
        if(listaLibro.size()>0){
            System.out.println("---------LIBROS-----------");
            for (Libro lista : listaLibro) {
                if(ti.equalsIgnoreCase(lista.getTitulo())){
                    lista.mostrar();
                } 
            }
        }else{
            System.out.println(" no tiene ningun libro registrado");
        }
    }
    public void Eliminar(){
        if (listaProyecto.size() > 0 || listaLibro.size() > 0) {
            System.out.println("1.- eliminar proyecto de grado");
            System.out.println("2.- eliminar libro");
            int op = leer.nextInt();
            if (op == 1) {  
                      System.out.println(" digite titulo a del Proyecto a Eliminar");
                     leer.nextLine();
                     String ti=leer.nextLine();
                for (ProyecyoGrado lista : listaProyecto) {
                    if(ti.equalsIgnoreCase(lista.getTitulo())){
                              listaProyecto.remove(lista); 
                              System.out.println("eliminado....");
                                 break;
                    } 
                } 
            } else {
                if (op == 2) {
                        System.out.println(" digite titulo a del libro a eliminar");
                     leer.nextLine();
                     String ti=leer.nextLine();
             for (Libro lista : listaLibro) {
                    if(ti.equalsIgnoreCase(lista.getTitulo())){
                              listaLibro.remove(lista); 
                              System.out.println("eliminado....");
                                 break;
                    } 
                }
                } else {
                    System.out.println(" usted no elegiio ninguna opcions");
                }
            }
        } else {
            System.out.println(" no registro ninugo material bibliografico");
        }
    } 
    }

