package group.paises.paises2902274.services;

import java.util.List;
import java.util.Optional;

import group.paises.paises2902274.entities.Pais;

public interface IPaisService {

    //metodos de la CRUD que 
    //se podran utilizar en el software
    //seleccionar todos los paises 
    List <Pais> findAll();
    //seleccionar un pais por el id 
    Optional<Pais> findByid(Long id);
    //guardar un pais (nuevo o para actualizar)
    Pais save(Pais pais);
    //delete pais
    Optional<Pais> delete(Long id);
    


}