package model;

import exceptions.IdentificadorDuplicadoException;
import interfaces.IRepository;
import interfaces.Identificable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class Biblioteca <T extends Identificable<Integer>> implements IRepository<Lanzamiento, Integer> {
    private Map<Lanzamiento,Integer> listado;

    public Biblioteca(){
        listado= new HashMap<>();
    }
    public void add(T t) throws IdentificadorDuplicadoException {

    }

    public Map<Lanzamiento, Integer> getListado() {
        return listado;
    }

    @Override
    public void create(Lanzamiento lanzamiento) throws IdentificadorDuplicadoException {
        if (lanzamiento != null) {
            if (listado.containsKey(lanzamiento.getId()))
                throw new IdentificadorDuplicadoException("Ese lanzamiento ya esta en la biblioteca");
            else listado.put(lanzamiento,lanzamiento.getId());
        }
    }
    @Override
    public void update(Lanzamiento lanzamiento) {
         listado.put(lanzamiento,lanzamiento.getId());
    }

    @Override
    public void delete(Lanzamiento lanzamiento) {
        listado.remove(lanzamiento.getId());
    }
}
