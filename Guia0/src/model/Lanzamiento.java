package model;

import interfaces.Identificable;

import java.util.Objects;

public abstract class Lanzamiento implements Comparable, Identificable {
    private static int total;
    private int id;
    private String titulo;
    private String genero;
    private String creador;

    public Lanzamiento() {
        this.id=total++;
    }

    public Lanzamiento(String titulo, String genero, String creador) {
        this.id = total++;
        this.titulo = titulo;
        this.genero = genero;
        this.creador = creador;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Lanzamiento){
            return this.titulo.compareTo (((Lanzamiento)o).getTitulo());
        }else return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lanzamiento that = (Lanzamiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
