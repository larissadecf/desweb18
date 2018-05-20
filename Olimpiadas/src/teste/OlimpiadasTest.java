package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Olimpiadas;
import service.OlimpiadasService;

public class OlimpiadasTest {
	Olimpiadas olimpiadas, copia;
	static int ano = 0;
	OlimpiadasService olimpiadasService; 
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tamb√©m que sobrecarregou o equals na classe
	 * Pais. 
	 * Certifique-se que a fixture pais1 foi criada no banco.
	 * Al√©m disso, a ordem de execu√ß√£o dos testes √© importante; por
	 * isso a anota√ß√£o FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		
		olimpiadasService = new OlimpiadasService ();
		
		System.out.println("setup");
		olimpiadas = new Olimpiadas(2018, "ver„o", null, null);
		copia = new Olimpiadas(2018, "ver„o", null, null);
		System.out.println(olimpiadas);
		System.out.println(copia);
		System.out.println(ano);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Olimpiadas fixture = new Olimpiadas(2018, "ver„o", null, null);
		Olimpiadas novo = new Olimpiadas(2018, "ver„o", null, null);
		olimpiadasService.carregar(novo);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		olimpiadasService.criar(olimpiadas);
		ano = olimpiadas.getAno();
		System.out.println(ano);
		copia.setAno(ano);
		assertEquals("testa criacao", olimpiadas, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		olimpiadas.setTipo("");
		copia.setTipo("");		
		olimpiadasService.atualizar(olimpiadas);
		olimpiadasService.carregar(olimpiadas);
		assertEquals("testa atualizacao", olimpiadas, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setAno(-1);
		copia.setTipo(null);
		olimpiadasService.excluir(olimpiadas);
		olimpiadasService.carregar(olimpiadas);
		assertEquals("testa exclusao", olimpiadas, copia);
	}
}
