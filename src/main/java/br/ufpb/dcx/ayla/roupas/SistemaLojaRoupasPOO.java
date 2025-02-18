package br.ufpb.dcx.ayla.roupas;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    private GravadorDeRoupas gravadorDeRoupas;
    private Map<String, Roupa> roupasMap;


    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
        this.gravadorDeRoupas = new GravadorDeRoupas();
    }

    public void recuperaRoupas() throws IOException, RoupaJaExisteException {
        Collection<Roupa> roupasAchadas = this.gravadorDeRoupas.recuperaRoupas();
        for (Roupa r: roupasAchadas){
            this.cadastraRoupa(r.getCodigo(), r.getDescricao(), r.getQuantidade(), r.getTamanho());
        }
    }

    public void salvarRoupas() throws IOException {
        this.gravadorDeRoupas.gravaRoupas(this.roupasMap.values());
    }

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        //TODO
        return List.of();
    }

    @Override
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao) {
        //TODO
        return List.of();
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        //TODO
        return null;
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, int quantidade, Tamanho tamanho) throws RoupaJaExisteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        } else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, quantidade, tamanho);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {
        //TODO
    }

    @Override
    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException {
        //TODO
        return 0;
    }

    @Override
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if (this.roupasMap.containsKey(codigoRoupa)){
            return this.roupasMap.get(codigoRoupa);
        } else {
            throw new RoupaInexistenteException("Não existe roupa com este código:"+ codigoRoupa);
        }
    }
}