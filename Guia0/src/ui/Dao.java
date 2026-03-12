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
    public void agregar(Biblioteca b){
        Scanner sc= new Scanner(System.in);
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
        System.out.print("\nIngrese version: ");
        version = sc.nextInt();
        sc.nextLine();
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
        System.out.print("\nIngrese version: ");
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
        ArrayList arregloValores=(ArrayList)((Map)b).values();
        Collections.sort(arregloValores);
        StringBuilder sb= new StringBuilder();
        for (Object l: arregloValores){
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }
}
