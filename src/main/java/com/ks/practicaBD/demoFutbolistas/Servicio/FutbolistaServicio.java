package com.ks.practicaBD.demoFutbolistas.Servicio;

import com.ks.practicaBD.demoFutbolistas.Repositorio.FutbolistaRepositorio;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2 //Liberias para notas
@Service

public class FutbolistaServicio {

    @Autowired
    public FutbolistaRepositorio futbolistaRepositorio;
    public Futbolistas futbolistas;

    //Find
    public List<Futbolistas> findAll(){
        return (List<Futbolistas>)futbolistaRepositorio.findAll();
    }
    //Save
    public Futbolistas save(Futbolistas futbolistas){
        if (futbolistas.getPosicion().equals("portero")||futbolistas.getPosicion().equals("defensa")
        ||futbolistas.getPosicion().equals("delantero")||futbolistas.getPosicion().equals("centro")){

            return futbolistaRepositorio.save(futbolistas);
        }else{
            log.error("Error - No se puede asignar la posición {}",futbolistas.getPosicion());
            log.fatal("Fatal - No se puede asignar la posición: {}",futbolistas.getPosicion());
            log.info("Info - No se puede asignar la posición: {}",futbolistas.getPosicion());
            log.warn("Warn - No se puede asignar la posición {}",futbolistas.getPosicion());
            log.debug("Debug - No se puede asignar la posición: {}", futbolistas.getPosicion());
            log.trace("Trace - No se puede asignar la posición: {}",futbolistas.getPosicion());
            return futbolistas;
        }
    }
    //Delete
    public void deletById(int id){
       // if (futbolistas.getId()!=id){
          /*  log.debug("Debug - Error: {}", id);
            log.trace("Trace - Error: {}",id);*/
       // }else{
            futbolistaRepositorio.deleteById(id);
        //}
    }
}
