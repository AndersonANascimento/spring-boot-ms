package br.com.prodam.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodam.converters.NumberConverter;
import br.com.prodam.exceptions.UnsupportedMathOperationException;
import br.com.prodam.math.SimpleMath;

@RestController
public class MathController {
	private static final String numericMessage = "Por favor informe um valor numerico!";
	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return math.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return math.sub(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return math.mult(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value = "/div/{num1}/{num2}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		if (NumberConverter.convertToDouble(num2) == 0) {
			throw new UnsupportedMathOperationException("Impossivel divisão por 0");
		}
		return math.div(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value = "/avg/{num1}/{num2}", method = RequestMethod.GET)
	public Double avg(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}

		return math.avg(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}

	@RequestMapping(value = "/sqrt/{num1}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value = "num1") String num1)
			throws Exception {
		if (!NumberConverter.isNumeric(num1)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}

		return math.sqrt(NumberConverter.convertToDouble(num1));
	}
}
