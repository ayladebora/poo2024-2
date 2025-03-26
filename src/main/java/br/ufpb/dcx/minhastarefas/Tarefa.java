package br.ufpb.dcx.minhastarefas;

public class Tarefa {
    private String codigo;
    private String descricao;
    private CategoriaTarefa categoria;
    private int tempoTarefaEmMinutos;


    public Tarefa(String codigo, String descricao, CategoriaTarefa categoria,
                  int tempoTarefaEmMinutos) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tempoTarefaEmMinutos = tempoTarefaEmMinutos;
    }
//… outros métodos da classe


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaTarefa getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTarefa categoria) {
        this.categoria = categoria;
    }

    public int getTempoTarefaEmMinutos() {
        return tempoTarefaEmMinutos;
    }

    public void setTempoTarefaEmMinutos(int tempoTarefaEmMinutos) {
        this.tempoTarefaEmMinutos = tempoTarefaEmMinutos;
    }
}

