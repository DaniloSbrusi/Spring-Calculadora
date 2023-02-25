package br.edu.unoesc.calculadora.controller;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.calculadora.error.DivisaoPorZeroException;
import br.edu.unoesc.calculadora.service.Calculadora;
import br.edu.unoesc.calculadora.service.ConversorNumerico;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
	
	private Logger logger = Logger.getLogger(CalculadoraController.class.getName()); 

	@GetMapping
	public String home() {
		return "Bem vindo a Calculadora 2000! O melhor software para cálculos matemáticos desde hoje!";
	}
	
	@GetMapping("/somar")
	public Double somar(@RequestParam(value = "num1", defaultValue = "0") String num1,
						@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando soma: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.somar(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando soma: %s + %s = %.2f", num1, num2, resultado));	
		return resultado;
	}
	
	@GetMapping("/somar/{num1}/{num2}")
	public Double somarPath(@PathVariable(value="num1") String num1,
							@PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando soma: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.somar(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando soma: %s + %s = %.2f", num1, num2, resultado));	
		return resultado;
	}
	
	@GetMapping("/subtrair")
	public Double subtrair(@RequestParam(value = "num1", defaultValue = "0") String num1,
						@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando subtração: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.subtrair(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando subtração: %s - %s = %.2f", num1, num2, resultado));	
		return resultado;
	}
	
	@GetMapping("/subtrair/{num1}/{num2}")
	public Double subtrairPath(@PathVariable(value="num1") String num1,
							   @PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando subtração: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.subtrair(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando subtração: %s - %s = %.2f", num1, num2, resultado));	
		return resultado;
	}
	
	@GetMapping("/multiplicar")
	public Double multiplicar(@RequestParam(value = "num1", defaultValue = "0") String num1,
							  @RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando multiplicação: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.multiplicar(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando multiplicação: %s * %s = %.2f", num1, num2, resultado));	
		return resultado;
		
	}

	@GetMapping("/multiplicar/{num1}/{num2}")
	public Double multiplicarPath(@PathVariable(value="num1") String num1,
								  @PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando multiplicação: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.multiplicar(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando multiplicação: %s * %s = %.2f", num1, num2, resultado));	
		return resultado;
		
	}

	@GetMapping("/dividir")
	public ResponseEntity<Double> dividir(@RequestParam(value = "num1", defaultValue = "0") String num1,
						  				  @RequestParam(value = "num2", defaultValue = "0") String num2) {

		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando divisão: Erro! Valores não numéricos");
			return ResponseEntity.badRequest().build();
		}
	
		try {
			Double resultado = Calculadora.dividir(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
			logger.info(String.format("Operando divisão: %s / %s = %.2f", num1, num2, resultado));	
			return ResponseEntity.ok(resultado);
		} catch (DivisaoPorZeroException e) {
			logger.info("Operando divisão: Erro! Divisão por zero");
			return ResponseEntity.badRequest().build();
		}
		 
	}
	
	@GetMapping("/dividir/{num1}/{num2}")
	public ResponseEntity<Double> dividirPath(@PathVariable(value="num1") String num1, 
							  				  @PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando divisão: Erro! Valores não numéricos");
			return ResponseEntity.badRequest().build();
		}
		
		try {
			Double resultado = Calculadora.dividir(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
			logger.info(String.format("Operando divisão: %s / %s = %.2f", num1, num2, resultado));	
			return ResponseEntity.ok(resultado);
		} catch (DivisaoPorZeroException e) {
			logger.info("Operando divisão: Erro! Divisão por zero");
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/media")
	public Double media(@RequestParam(value = "num1", defaultValue = "0") String num1,
						@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando média: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.media(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando média: (%s + %s)/2 = %.2f", num1, num2, resultado));
		return resultado;
	}
	
	@GetMapping("/media/{num1}/{num2}")
	public Double mediaPath(@PathVariable(value="num1") String num1,
							@PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando média: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.media(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando média: (%s + %s)/2 = %.2f", num1, num2, resultado));
		return resultado;
	}
	
	@GetMapping("/potenciacao")
	public Double potenciacao(@RequestParam(value = "num1", defaultValue = "0") String num1,
							  @RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando potenciação: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.potenciacao(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando potenciação: %s ^ %s = %.2f", num1, num2, resultado));
		return resultado;
	}
	
	@GetMapping("/potenciacao/{num1}/{num2}")
	public Double potenciacaoPath(@PathVariable(value="num1") String num1,
								  @PathVariable(value="num2") String num2) {
		
		if(!ConversorNumerico.ehNumerico(num1) || !ConversorNumerico.ehNumerico(num2)) {
			logger.info("Operando potenciação: Erro! Valores não numéricos");
			return 0D;
		}
		
		Double resultado = Calculadora.potenciacao(ConversorNumerico.converteParaDouble(num1), ConversorNumerico.converteParaDouble(num2));
		logger.info(String.format("Operando potenciação: %s ^ %s = %.2f", num1, num2, resultado));
		return resultado;
	}
	
	@GetMapping("/raiz-quadrada")
	public ResponseEntity<Double> potenciacao(@RequestParam(value = "num", defaultValue = "0") String num) {
		
		if(!ConversorNumerico.ehNumerico(num)) {
			logger.info("Operando raiz quadrada: Erro! Valor não numérico");
			return ResponseEntity.badRequest().build();
		}
		
		try {
			Double resultado = Calculadora.raizQuadrada(ConversorNumerico.converteParaDouble(num));
			logger.info(String.format("Operando raiz quadrada: sqrt(%s) = %.2f", num, resultado));	
			return ResponseEntity.ok(resultado);
		} catch (DivisaoPorZeroException e) {
			logger.info("Operando raiz quadrada: Erro! Valor negativo");
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/raiz-quadrada/{num}")
	public ResponseEntity<Double> potenciacaoPath(@PathVariable(value="num") String num) {
		
		if(!ConversorNumerico.ehNumerico(num)) {
			logger.info("Operando raiz quadrada: Erro! Valor não numérico");
			return ResponseEntity.badRequest().build();
		}
		
		try {
			Double resultado = Calculadora.raizQuadrada(ConversorNumerico.converteParaDouble(num));
			logger.info(String.format("Operando raiz quadrada: sqrt(%s) = %.2f", num, resultado));	
			return ResponseEntity.ok(resultado);
		} catch (DivisaoPorZeroException e) {
			logger.info("Operando raiz quadrada: Erro! Valor negativo");
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
