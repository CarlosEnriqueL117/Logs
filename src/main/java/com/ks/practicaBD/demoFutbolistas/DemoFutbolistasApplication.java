package com.ks.practicaBD.demoFutbolistas;
import com.ks.practicaBD.demoFutbolistas.Repositorio.FutbolistaRepositorio;
import com.ks.practicaBD.demoFutbolistas.Servicio.FutbolistaServicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ks.practicaBD.demoFutbolistas.modelo.Futbolistas;
import com.ks.practicaBD.demoFutbolistas.modelo.Config;

@SpringBootApplication
public class DemoFutbolistasApplication implements ApplicationRunner {
@Autowired
	FutbolistaRepositorio futbolistaRepositorio;

	@Autowired
	@Qualifier("futbolistaServicioDelantero")
	FutbolistaServicio futbolistaServicio;

	@Autowired
	@Qualifier("futbolistaServicioDefensa")
	FutbolistaServicio futbolistaServicioDefensa;

	public static void main(String[] args) {
		SpringApplication.run(DemoFutbolistasApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Corriendo");
		//Guardar
		Futbolistas futbolistas = futbolistaServicio.save(new Futbolistas("carlos", "delantero", 10));
		System.out.println(futbolistaServicio.findAll());
		//System.out.println(futbolistaServicioDefensa);
		//Actualizar
		/*futbolistas.setPosicion("Delantero");
		futbolistas.setNumcamisa(22);
		futbolistaServicio.futbolistaRepositorio.save(futbolistas);
		System.out.println(futbolistaServicio.futbolistaRepositorio.findAll());*/


		/*futbolistaServicio.futbolistaRepositorio.deleteById(1);
		System.out.println(futbolistaServicio.futbolistaRepositorio.findAll());*/

	}
}
