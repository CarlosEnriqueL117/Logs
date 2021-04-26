package com.ks.practicaBD.demoFutbolistas;
import com.ks.practicaBD.demoFutbolistas.Repositorio.FutbolistaRepositorio;
import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;

@SpringBootApplication
public class DemoFutbolistasApplication implements ApplicationRunner {
@Autowired
	FutbolistaRepositorio futbolistaRepositorio;
@Autowired
	FutbolistaServicio futbolistaServicio;

	public static void main(String[] args) {
		SpringApplication.run(DemoFutbolistasApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hola");
		//Guardar
		Futbolistas futbolistas = futbolistaServicio.futbolistaRepositorio.save(new Futbolistas("carlos", "defensa", 10));
		System.out.println(futbolistaServicio.futbolistaRepositorio.findAll());

		//Actualizar
		/*futbolistas.setPosicion("Delantero");
		futbolistas.setNumcamisa(22);
		futbolistaServicio.futbolistaRepositorio.save(futbolistas);
		System.out.println(futbolistaServicio.futbolistaRepositorio.findAll());*/


		/*futbolistaServicio.futbolistaRepositorio.deleteById(1);
		System.out.println(futbolistaServicio.futbolistaRepositorio.findAll());*/

	}
}
