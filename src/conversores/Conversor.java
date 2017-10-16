package conversores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversor {
	public LocalDate data(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data,formatter);
		return date;
	}
	public String[] lista(String palavras) {
		String[] lista = palavras.split(", ");
		return lista;
	}
}
