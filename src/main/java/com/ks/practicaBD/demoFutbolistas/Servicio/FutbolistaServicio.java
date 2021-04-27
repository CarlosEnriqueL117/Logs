package com.ks.practicaBD.demoFutbolistas.Servicio;

import com.ks.practicaBD.demoFutbolistas.Repositorio.FutbolistaRepositorio;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2 //Liberias para notas
@Service
@Setter

public class FutbolistaServicio {
    public static final Marker marker= MarkerManager.getMarker("marker");
    private String posicionEspecial;
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
            log.error(marker,"Error - No se puede asignar la posición {}",futbolistas.getPosicion());
            log.fatal(marker,"Fatal - No se puede asignar la posición: {}",futbolistas.getPosicion());
            log.info(marker,"Info - No se puede asignar la posición: {}",futbolistas.getPosicion());
            log.warn(marker,"Warn - No se puede asignar la posición {}",futbolistas.getPosicion());
            log.debug(marker,"Debug - No se puede asignar la posición: {}", futbolistas.getPosicion());
            log.trace(marker,"Trace - No se puede asignar la posición: {}",futbolistas.getPosicion());
            return futbolistas;
        }
    }

    /**
     * This methos use to repositorio to delete an specific futbolista
     *
     * @param id is the param to delete
     */
    //Delete
    public void deletById(int id){
       // if (futbolistas.getId()!=id){
          /*  log.debug("Debug - Error: {}", id);
            log.trace("Trace - Error: {}",id);*/
       // }else{
            futbolistaRepositorio.deleteById(id);
        //}
    }

    public Futbolistas saveDefensa(Futbolistas futbolistas){
            futbolistas.setPosicion("defensa");
        return futbolistaRepositorio.save(futbolistas);
    }
    public Futbolistas saveDelantero(Futbolistas futbolistas){
        futbolistas.setPosicion("delantero");
        return futbolistaRepositorio.save(futbolistas);
    }
}
