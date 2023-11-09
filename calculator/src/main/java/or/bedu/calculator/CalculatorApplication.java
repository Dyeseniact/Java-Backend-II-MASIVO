package or.bedu.calculator;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import or.bedu.calculator.utils.Calculator;

@SpringBootApplication
public class CalculatorApplication implements CommandLineRunner {

	//Autowired: etiqueta de inyeccion de dependecias
	@Autowired
	private Calculator cal;

	@Autowired
	private Scanner sc;

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("¿Que operación deseas realizar? ");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		int opcion = sc.nextInt();

		sc.nextLine();

		if ( opcion < 1 || opcion > 3 ) {
			System.out.println("No existe la operación...");
			return;
		}

		System.out.println("Ingresa el primer numero: ");
		int a = sc.nextInt();

		sc.nextLine();

		System.out.println("Ingresa el segundo numero: ");
		int b = sc.nextInt();

		sc.nextLine();

		int resultado = 0;

		switch (opcion) {
			case 1:
				resultado = cal.sum(a, b);
				break;

			case 2:
				resultado = cal.subs(a, b);
				break;

			case 3:
				resultado = cal.mult(a, b);
				break;
		
			default:
				break;
		}

		System.out.println("Resultado: " +  resultado);
		sc.close();

		
	}

}
