package br.ufpb.dcx.ayla.posto;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaGerenciadorAtendimentosPostoRioTintoTest {

    @Test
    public void testaCadastroMedido(){
        SistemaGerenciadorAtendimentosPostoRioTinto sistema = new SistemaGerenciadorAtendimentosPostoRioTinto();
        try {
            sistema.cadastrarMedico("11111", "Ana Julia Lopes");
            sistema.cadastrarAtendimento("123", CategoriaAtendimento.CARDIOLOGICO, "222.222.222-22", "111111", new Data(8,8, 2024));
            Collection<AtendimentoMedico> atendimentosData = sistema.pesquisaAtendimentosDoDia(new Data(8,8,2024));
            assertTrue(atendimentosData.size()==1);
        } catch (Exception e){
            fail("Não deveria lançar a exceção");
        }

    }

}
