package com.ks.practicaBD.demoFutbolistas.Repositorio;

import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FutbolistaRepositorio extends CrudRepository<Futbolistas,Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT u FROM Futbolistas u")
    List<Futbolistas> findAllC();

    @Transactional(readOnly = true)
    @Query(value = "SELECT u FROM Futbolistas u WHERE posicion='delantero'")
    List<Futbolistas> findAllDelanteros();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Futbolistas SET numcamisa = 10 WHERE Id = ?", nativeQuery = true)
    int updateCamisaFutbolistas(int numcamisa);

}
