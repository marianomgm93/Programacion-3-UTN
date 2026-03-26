package ui;

import exceptions.IdentificadorDuplicadoException;
import exceptions.NullDateException;
import exceptions.VersionNegativaException;
import model.Biblioteca;
import model.Expansion;
import model.Juego;
import model.Lanzamiento;

import java.util.*;

public class Dao {
        Scanner sc= new Scanner(System.in);
    public void agregar(Biblioteca b){
        String option;

        System.out.println("1\tNuevo Juego\n2\tNueva Expansion\n0\tSalir");
        option=sc.nextLine();
       switch (option){
            case "1":
                try {
                    b.create(nuevoJuego());
                } catch (IdentificadorDuplicadoException e) {
                    System.out.println(e.getMessage());
                }
                break;
           case "2":
               try {
                   b.create(nuevaExpansion());
               } catch (IdentificadorDuplicadoException e) {
                   System.out.println(e.getMessage());
               }
               break;
           default:
               System.out.println("Volviendo al menu principal...");
        }

    }
    private Juego nuevoJuego() {
        Scanner sc = new Scanner(System.in);
        String titulo, genero, creador;
        int version;
        System.out.print("Ingrese titulo: ");
        titulo = sc.nextLine();
        System.out.print("\nIngrese Genero: ");
        genero = sc.nextLine();
        System.out.print("\nIngrese Creador: ");
        creador = sc.nextLine();
        System.out.print("\nIngrese version (numero entero): ");
        try{
        version = sc.nextInt();
        sc.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Detectamos un problema, la version del juego quedará en 0, podra modificarla mas tarde");
            version=0;
        }
        try{
            Juego juego = new Juego(titulo,genero,creador,version);
            return juego;
        }catch (VersionNegativaException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private Expansion nuevaExpansion() {
        Scanner sc = new Scanner(System.in);
        String titulo, genero, creador,fechaLanzamiento;
        System.out.print("Ingrese titulo: ");
        titulo = sc.nextLine();
        System.out.print("\nIngrese Genero: ");
        genero = sc.nextLine();
        System.out.print("\nIngrese Creador: ");
        creador = sc.nextLine();
        System.out.print("\nIngrese fecha: ");
        fechaLanzamiento = sc.nextLine();

        try{
            Expansion expansion = new Expansion(titulo,genero,creador,fechaLanzamiento);
            return expansion;
        }catch (NullDateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String mostrar(Biblioteca b){
        ArrayList<Lanzamiento> ordenado=new ArrayList<>();
        Iterator it=b.getListado().values().iterator();
        while(it.hasNext()){
            ordenado.add((Lanzamiento)it.next());
        }
        Collections.sort(ordenado);
        StringBuilder sb= new StringBuilder();
        for (Object l: ordenado){
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }
    public void eliminar(Biblioteca b){
        int clave;
        System.out.println("Ingrese el id a eliminar: ");
        try{
            clave=sc.nextInt();
            sc.nextLine();

        }catch(ArithmeticException e){
            System.out.println("Debe ingresar un id numerico");
            clave=-1;
        }
        if(clave!=-1)
        b.getListado().remove(clave);
        else System.out.println();
    }
}
