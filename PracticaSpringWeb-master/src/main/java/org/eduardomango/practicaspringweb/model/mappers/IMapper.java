package org.eduardomango.practicaspringweb.model.mappers;

public interface IMapper <T,U>{
    public T toEntity(U u);
    public U toDTO(T t);

}
