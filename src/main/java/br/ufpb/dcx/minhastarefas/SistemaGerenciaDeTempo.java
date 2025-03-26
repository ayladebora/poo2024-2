package br.ufpb.dcx.minhastarefas;

import java.util.Collection;
public interface SistemaGerenciaDeTempo {
    public void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria,
                                int tempoEmMinutos) throws TarefaJaExisteException;
    public Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoria);
    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos);
    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa);
    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa);
    public Collection<Tarefa> pesquisarTarefasPorDescricao(String descricao);
    public void alterarTempoDeTarefa(String codigoTarefa, int novoTempo)
            throws TarefaNaoExisteException;
}

