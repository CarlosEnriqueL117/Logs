package com.ks.practicaBD.demoFutbolistas.Controlador;

import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//Quitar el Scope
//@Lazy Crea el bean hasta que se llama, NO desde el inicio, esto evita una sobrecarga de beans que no se usarán hasta que sean usados
@Scope("prototype")// Para que cuando cree una instancia de http, se cree el bean y a la siguiente petición se destriuya el bean y se cree una nueva copia
@RestController
@RequestMapping(path = "/futbolistas")//Hace que los path de los métodos sean iguales
//Si esta clase no fuera un controlador, servicio se requiere un @Controller
public class Controlador {

    @PostConstruct//permite ejeuctar um método despúes de que se ejcuta el contructor e inyecta dependencias
    public void postConstruct(){
        System.out.println("Texto después de crear el objeto, como evidencia, esta es la referencia en memoria de FutbolistaService: "+futbolistaServicio);
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Texto antes de que se destruya");
    }


    public Controlador(FutbolistaServicio futbolistaServicio) {
        System.out.println("Entrando en el constructor");
        this.futbolistaServicio = futbolistaServicio;
    }

    @Autowired
    private FutbolistaServicio futbolistaServicio;

    @Autowired
    @Qualifier("futbolistaServicioDefensa")
    FutbolistaServicio futbolistaServicioDefensa;

    @Autowired
    @Qualifier("futbolistaServicioDelantero")
    FutbolistaServicio futbolistaServicioDelantero;


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

    /**
     * This method delete an Futbolista by id
     * @param id is the param to delete
     */
    ///Borrar
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        futbolistaServicio.deletById(id);
    }

    /**
     * This method save a futbolista whit "defensa" specific parameters
     * @param futbolistas is the new futbolista to add
     * @return is te value to save in BD
     */
    @PostMapping(path = "/defensa")
    public Futbolistas saveDefensa(@RequestBody Futbolistas futbolistas) {
        return futbolistaServicioDefensa.saveDefensa(futbolistas);
    }

    /**
     * This method save a futbolista whith "delantero" specific parameters
     * @param futbolistas is the new futbolista to add
     * @return is the valua to save in BD
     */
    @PostMapping(path = "/delantero")
        public Futbolistas saveDelantero(@RequestBody Futbolistas futbolistas) throws Exception {

          return futbolistaServicioDelantero.saveDelantero(futbolistas);
    }

    //Transactiona y Modifying
    @GetMapping(path = "/Custom")
    public List<Futbolistas> fiutbolindAllC() {
        return futbolistaServicio.findAllC();
    }

    @GetMapping(path = "/CustomD")
    public List<Futbolistas> fiutbolindAllDelanteros() {
        return futbolistaServicio.findAllDelanteros();
    }

    @PutMapping(path = "/updateC/{id}")
    public int updatenumCamisa(@PathVariable int id){
        return futbolistaServicio.updateCamisaFutbolistas(id);
    }

    //Ciclo del Bean


}
