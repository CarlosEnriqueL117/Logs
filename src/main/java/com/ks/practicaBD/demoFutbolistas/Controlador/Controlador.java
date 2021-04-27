package com.ks.practicaBD.demoFutbolistas.Controlador;

import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;
import com.ks.practicaBD.demoFutbolistas.modelo.Config;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/futbolistas")//Hace que los path de los métodos sean iguales
public class Controlador implements InitializingBean, DisposableBean {
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
        afterPropertiesSet();
        destroy();
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

    @Override
    public void destroy() throws Exception {
        System.out.println("Después de haber destruido el Bean");
        System.out.println(futbolistaServicio.findAll());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Después de inicializar el bean");
        System.out.println(futbolistaServicio.findAll());
    }
}
