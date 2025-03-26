package br.ufpb.dcx.minhastarefas;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class MeuSistemaGerenciaDeTempoTest {


    @Test
    public void testaCadastroEPesquisa() {
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("T001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            assertEquals(120,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.alterarTempoDeTarefa("T001", 20);
            //TODO: ACRESCENTAR CÓDIGO AQUI
            assertEquals(20,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.cadastrarTarefa("T002", "Estudar Cálculo", CategoriaTarefa.ESTUDO, 40);
            Collection <Tarefa> tarefasEstudo = sistema.pesquisarTarefasDaCategoria(CategoriaTarefa.ESTUDO);
            assertEquals(2, tarefasEstudo.size());

        } catch (TarefaJaExisteException | TarefaNaoExisteException e){
            fail("Não deveria lançar exceção aqui");
        }
    }


    @Test
    public void testaCadastroEPesquisaDuracao() {
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("T001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            assertEquals(120,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.cadastrarTarefa("T002", "Estudar POO", CategoriaTarefa.ESTUDO, 300);
            sistema.cadastrarTarefa("T003", "Estudar POO", CategoriaTarefa.ESTUDO, 300);

            assertEquals(720,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            int tempoEstudoPOO = sistema.calcularTempoTotalDeTarefasComDescricao("Estudar POO");
            assertEquals(600, tempoEstudoPOO);

        } catch (TarefaJaExisteException  e){
            fail("Não deveria lançar exceção aqui");
        }
    }
}
