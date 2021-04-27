package com.ks.practicaBD.demoFutbolistas.Repositorio;

import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import org.springframework.data.repository.CrudRepository;

public interface FutbolistaRepositorio extends CrudRepository<Futbolistas,Integer> {
    
}
