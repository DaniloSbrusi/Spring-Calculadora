package br.edu.unoesc.calculadora.service;

public class ConversorNumerico {
	
	public static Double converteParaDouble(String strNum) {
		strNum = strNum.replaceAll(",", ".");
		return Double.parseDouble(strNum);
	}

	public static boolean ehNumerico(String strNum) {
		if (strNum == null) {
//			logger.info("Valor ausente");
			return false;
		}
		String numero = strNum.replaceAll(",", ".");
		return numero.matches("[-+]?\\d*\\.?\\d*");	
	}

}
