package model;

import exceptions.NullDateException;

public class Expansion extends Lanzamiento{
    private String fechaLanzamiento;

    public Expansion(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Expansion(String titulo, String genero, String creador, String fechaLanzamiento) throws NullDateException {
        super(titulo, genero, creador);
        if(!fechaLanzamiento.isEmpty())
            this.fechaLanzamiento = fechaLanzamiento;
        else
            throw new NullDateException("La fecha de lanzamiento no puede ser nula");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Lanzamiento){
            return Integer.compare(this.getId(), ((Lanzamiento) o).getId() );
        }else return 0;
    }
}
