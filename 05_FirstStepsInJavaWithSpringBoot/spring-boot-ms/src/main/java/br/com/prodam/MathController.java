package br.com.prodam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodam.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	private static final String numericMessage = "Por favor informe um valor numerico!";

	@RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return convertToDouble(num1) + convertToDouble(num2);
	}

	@RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return convertToDouble(num1) - convertToDouble(num2);
	}

	@RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		return convertToDouble(num1) * convertToDouble(num2);
	}

	@RequestMapping(value = "/div/{num1}/{num2}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}
		if (convertToDouble(num2) == 0) {
			throw new UnsupportedMathOperationException("Impossivel divisão por 0");
		}
		return convertToDouble(num1) / convertToDouble(num2);
	}

	@RequestMapping(value = "/avg/{num1}/{num2}", method = RequestMethod.GET)
	public Double avg(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {
		if (!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}

		return (convertToDouble(num1) + convertToDouble(num2)) / 2D;
	}

	@RequestMapping(value = "/sqrt/{num1}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value = "num1") String num1)
			throws Exception {
		if (!isNumeric(num1)) {
			throw new UnsupportedMathOperationException(numericMessage);
		}

		return Math.sqrt(convertToDouble(num1));
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
