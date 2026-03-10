package model;

import exceptions.IdentificadorDuplicadoException;

import java.util.HashSet;

public class Biblioteca <T extends Comparable>{
    HashSet<T> listado;

    public void add(T t) throws IdentificadorDuplicadoException {
        if (t != null) {
            if (listado.contains(t))
                throw new IdentificadorDuplicadoException("Ese lanzamiento ya esta en la biblioteca");
            else listado.add(t);
        }
    }
}
