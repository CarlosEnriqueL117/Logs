package com.ks.practicaBD.demoFutbolistas.modelo;

import com.ks.practicaBD.demoFutbolistas.Repositorio.FutbolistaRepositorio;
import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("futbolistaServicioDelantero")
    public FutbolistaServicio futbolistaServicioDelantero(FutbolistaRepositorio futbolistaRepositorio){
        FutbolistaServicio futbolistaServicio = new FutbolistaServicio();
        futbolistaServicio.setFutbolistaRepositorio(futbolistaRepositorio);
        //futbolistaServicio.setPosicionEspecial("Delantero 9");
        return futbolistaServicio;
    }

    @Bean("futbolistaServicioDefensa")
    public FutbolistaServicio futbolistaServicioDefensa(FutbolistaRepositorio futbolistaRepositorio){
        FutbolistaServicio futbolistaServicio = new FutbolistaServicio();
        futbolistaServicio.setFutbolistaRepositorio(futbolistaRepositorio);
        //futbolistaServicio.setPosicionEspecial("Extremo");
        return futbolistaServicio;
    }
}
