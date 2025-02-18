package br.ufpb.dcx.ayla.roupas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaLojaRoupasPOOTest {

    @Test
    public void testaCadastro() throws RoupaJaExisteException, RoupaInexistenteException {

        SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
        sistema.cadastraRoupa("123","Calça Jeans escura", 30, Tamanho.M);
        Roupa roupa = sistema.pesquisaRoupa("123");
        assertEquals("123", roupa.getCodigo());
        assertEquals("Calça Jeans escura", roupa.getDescricao());
        assertEquals(Tamanho.M, roupa.getTamanho());
        assertTrue(roupa.getQuantidade() == 30);

    }
}
