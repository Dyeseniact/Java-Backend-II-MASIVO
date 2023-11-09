package org.bedu.introduccion;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*ANOTACIÓN: AGREGAR CARACTERISTICAS ADICIONALES*/

/* Anotacion permite hacer un escaneo del todo el codigo para detectar las clases con anotaciones */
@SpringBootApplication 
public class IntroduccionApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IntroduccionApplication.class, args);
	}

	//Los 3 puntos de la clase es recibir parametros indeterminados

	@Override
	public void run(String... args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingresa un primer numero: ");
		int a = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingresa un segundo numero: ");
		int b = sc.nextInt();
		sc.nextLine();

		int resultado = a * b;

		System.out.println("Resultado: " + resultado);
		sc.close();

	}

}
