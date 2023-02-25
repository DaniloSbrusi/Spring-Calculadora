package br.edu.unoesc.calculadora.service;

import br.edu.unoesc.calculadora.error.DivisaoPorZeroException;

public class Calculadora {

	public static Double somar(Double num1, Double num2) {
		return num1 + num2;
	}
	public static Double subtrair(Double num1, Double num2) {
		return num1 - num2;
	}
	public static Double multiplicar(Double num1, Double num2) {
		return num1 * num2;
	}
	public static Double dividir(Double num1, Double num2) throws DivisaoPorZeroException {
		if (num2 == 0.0 || num2 == 0)
			throw new DivisaoPorZeroException();
		return num1 / num2;
	}
	public static Double media(Double num1, Double num2) {
		return somar(num1, num2)/2;
	}
	public static Double potenciacao(Double num1, Double num2) {
		return Math.pow(num1, num2);
	}
	public static Double raizQuadrada(Double num) throws DivisaoPorZeroException{
		if (num < 0) 
			throw new DivisaoPorZeroException();
		return Math.sqrt(num);
	}
	
}
