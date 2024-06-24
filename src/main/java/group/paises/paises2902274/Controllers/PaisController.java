package group.paises.paises2902274.Controllers;

import org.springframework.web.bind.annotation.RestController;

import group.paises.paises2902274.entities.Pais;
import group.paises.paises2902274.services.PaisServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisServiceImpl service;
    
    @GetMapping
    public List<Pais> mostrarPais(){
        //buscar todos los paises en bases de datos 
        //utilizando el service
        return service.findAll();
    }

        //Traer un unico pais por id
        @GetMapping("/{id}")
        public  Pais mostrarPaisPorId(@PathVariable Long id){
            Optional<Pais>  opsPais = service.findByid(id);
            return opsPais.get();
        
    }

    //Ruta para grabar un pais en BD
    @PostMapping
    public Pais crearPais(@RequestBody Pais paisGrabar) {
        Pais paisNew = service.save(paisGrabar);
        return paisNew;
        
    }

    //Ruta para actualizar un pais en BD
    @PutMapping("/{id}")
    public Pais actualizarPais(@PathVariable Long id, @RequestBody Pais PaisUpd){
        //buscar el pais por id
        Pais p = service.findByid(id).get();
        // actualizamos atributos del pais a guardar
        p.setCapital(PaisUpd.getCapital());
        p.setNombre(PaisUpd.getNombre());
        //Grabar cambios es BD
        service.save(p);
        return service.save(p);
    }
    
    // ruta para borrar pais
    @DeleteMapping("/{id}")
    public Pais eliminarPais(@PathVariable Long id){

        //Grabar cambios es BD
        return service.delete(id).get();
    }

    

}
