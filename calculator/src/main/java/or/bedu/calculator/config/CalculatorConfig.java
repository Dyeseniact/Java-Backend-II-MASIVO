package or.bedu.calculator.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import or.bedu.calculator.utils.Calculator;

@Configuration
public class CalculatorConfig {
    //Bean: una instancia que se utilizan en cualqwuier parte del codigo
    @Bean
    public Calculator createCalculator(){
        return new Calculator();
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }
}
