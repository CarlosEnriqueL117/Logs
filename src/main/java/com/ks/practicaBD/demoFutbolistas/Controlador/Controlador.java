package com.ks.practicaBD.demoFutbolistas.Controlador;

import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/futbolistas")//Hace que los path de los métodos sean iguales
public class Controlador {
    @Autowired
    private FutbolistaServicio futbolistaServicio;

   @GetMapping(path = "/inicio")
    public String saludo(){
        return "Holas";
    }
    //Select
    @GetMapping
    public List<Futbolistas> fiutbolindAllF() {
        return futbolistaServicio.findAll();
    }
    //Agregar
    @PostMapping
    public Futbolistas save(@RequestBody Futbolistas futbolistas){
       return futbolistaServicio.save(futbolistas);
    }
    //Actualizar
    @PutMapping
    public Futbolistas update(@RequestBody Futbolistas futbolistas){
        return futbolistaServicio.save(futbolistas);
    }
    ///Borrar
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        futbolistaServicio.deletById(id);
    }


    /*@PostMapping(path = "/futbolistasI")
    public Futbolistas createFutbolista(@RequestBody Futbolistas futbolistas){
        return futbolistaServicio.futbolistaRepositorio.save(futbolistas);
    }*/
}
