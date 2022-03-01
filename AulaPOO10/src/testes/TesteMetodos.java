package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.saolucas.app.Metodos;

class TesteMetodos {

	@Test	
	void metodoSoma() {		
		float valorEsperado = 10;
		
		float valorApresentado = Metodos.somaNumeros(5, 5);
		
		assertEquals(valorEsperado, valorApresentado);
	}
	
	@Test
	void metodoSubtracao() {		
		float valorEsperado = 8;
		
		float valorApresentado = Metodos.subtrairNumeros(13, 5);
		
		assertEquals(valorEsperado, valorApresentado);
	}
	
	@Test
	void metodoMultiplicacao() {		
		float valorEsperado = 35;
		
		float valorApresentado = Metodos.multiplicarNumeros(7, 5);
		
		assertEquals(valorEsperado, valorApresentado);
	}
	
	@Test
	void metodoDivisao() {		
		float valorEsperado = 12;
		
		float valorApresentado = Metodos.dividirNumeros(120, 10);
		
		assertEquals(valorEsperado, valorApresentado);
	}
}
