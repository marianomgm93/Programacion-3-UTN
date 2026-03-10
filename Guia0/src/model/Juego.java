package model;

import exceptions.VersionNegativaException;

public class Juego extends Lanzamiento{

    private int version;

    public Juego() {
    }

    public Juego(int version) {
        this.version = version;
    }

    public Juego(String titulo, String genero, String creador, int version) throws VersionNegativaException {
        super(titulo, genero, creador);
        if(version>0)
            this.version=version;
        else
            throw new VersionNegativaException("La version debe ser positiva");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Lanzamiento){
            return Integer.compare(this.getId(), ((Lanzamiento) o).getId() );
        }else return 0;
    }
}
