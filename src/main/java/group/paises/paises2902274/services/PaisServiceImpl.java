package group.paises.paises2902274.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.paises.paises2902274.entities.Pais;
import group.paises.paises2902274.repositories.PaisRepository;


@Service
public class PaisServiceImpl implements IPaisService{


    //Referencia al PaisRepository
    @Autowired

    private PaisRepository repository;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Pais> findAll() {
        return (List<Pais>) repository.findAll();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Optional<Pais> findByid(Long id) {
        return repository.findById(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Pais save(Pais pais) {
        return repository.save(pais);
    }

    @Override
    public Optional<Pais> delete(Long id) {
        //1.Seleccionar el pais por id
        Optional<Pais> paisDb = repository.findById(id);
        paisDb.ifPresent(p -> {
            //2. Si existe el pais, borrelo de la base de datos 
            repository.delete(p);
        });
        return paisDb;
       
    }

}