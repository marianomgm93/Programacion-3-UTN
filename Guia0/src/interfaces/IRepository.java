package interfaces;

import exceptions.IdentificadorDuplicadoException;

public interface IRepository<T, id> {
    void create(T t) throws IdentificadorDuplicadoException;
    void update(T t);
    void delete(T t);
}
