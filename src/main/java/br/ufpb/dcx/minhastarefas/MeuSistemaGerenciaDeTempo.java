package br.ufpb.dcx.minhastarefas;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeuSistemaGerenciaDeTempo implements SistemaGerenciaDeTempo {
    private Map<String, Tarefa> tarefas;

    public MeuSistemaGerenciaDeTempo() {
        this.tarefas = new HashMap<>();
    }


    @Override
    public void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria, int tempoEmMinutos) throws TarefaJaExisteException {
        if (this.tarefas.containsKey(codigo)){
            throw new TarefaJaExisteException("Já existe");
        } else {
            this.tarefas.put(codigo, new Tarefa(codigo, descricao, categoria, tempoEmMinutos));
        }
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoria) {
//        Collection<Tarefa> tarefasPesq = new LinkedList<>();
//        for (Tarefa tarefa : this.tarefas.values()) {
//            if (tarefa.getCategoria().equals(categoria)) {
//                tarefasPesq.add(tarefa);
//            }
//        }
//        return tarefasPesq;
        return this.tarefas.values().stream().filter(
                t -> t.getCategoria().equals(categoria)).toList();
    }//… Outros métodos da classe

//    @Override
//    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos) {
//        Collection<Tarefa> tarefasDuracao = new LinkedList<>();
//        for (Tarefa t: this.tarefas.values()){
//            if (t.getTempoTarefaEmMinutos()> tempoEmMinutos){
//                tarefasDuracao.add(t);
//            }
//        }
//        return tarefasDuracao;
//    }


    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos) {
        return this.tarefas.values().stream().filter(t -> t.getTempoTarefaEmMinutos()> tempoEmMinutos).toList();
    }

    @Override
    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
        return this.tarefas.values().stream().filter(
                t -> t.getCategoria().equals(categoriaTarefa)).mapToInt(
                        Tarefa::getTempoTarefaEmMinutos).sum();
    }

//    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
//        int tempoTotal = 0;
//        for (Tarefa t: this.tarefas.values()){
//            if (t.getCategoria().equals(categoriaTarefa)){
//                tempoTotal+= t.getTempoTarefaEmMinutos();
//            }
//        }
//        return tempoTotal;
//    }

    @Override
    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa) {
        return this.tarefas.values().stream().filter(
                t -> t.getDescricao().equals(descricaoTarefa)).
                mapToInt(Tarefa::getTempoTarefaEmMinutos).reduce(0, (a,b)-> a+b);
    }


//    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa) {
//        int total = 0;
//        for (Tarefa t: this.tarefas.values()){
//            if (t.getDescricao().equals(descricaoTarefa)){
//                total+=t.getTempoTarefaEmMinutos();
//            }
//        }
//        return total;
//    }

    @Override
    public Collection<Tarefa> pesquisarTarefasPorDescricao(String descricao) {
        return List.of(); //TODO
    }

    @Override
    public void alterarTempoDeTarefa(String codigoTarefa, int novoTempo) throws TarefaNaoExisteException {
        Tarefa t = this.tarefas.get(codigoTarefa);
        if (t == null){
            throw new TarefaNaoExisteException("Não existe tarefa com o código "+ codigoTarefa);
        } else {
            t.setTempoTarefaEmMinutos(novoTempo);
        }
    }
}