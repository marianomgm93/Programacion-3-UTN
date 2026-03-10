package ui;

import exceptions.VersionNegativaException;
import model.Biblioteca;
import model.Juego;
import model.Lanzamiento;

import java.util.Scanner;

public class Dao {
    public void agregar(Biblioteca b){
        Scanner sc= new Scanner(System.in);
        String option;

        System.out.println("1\tNuevo Juego\n2\tNueva Expansion\n0\tSalir");
        option=sc.nextLine();
       /* switch (option){
            case "1":
                b.add(nuevoJuego());
                break;

        }*/

    }
    public Juego nuevoJuego() {
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
            System.out.println(e);
            return null;
        }
    }
}
