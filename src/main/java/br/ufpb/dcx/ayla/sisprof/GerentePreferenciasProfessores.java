package br.ufpb.dcx.ayla.sisprof;

import java.util.Map;
import java.util.HashMap;

public class GerentePreferenciasProfessores implements IProfessoresPrefs{
    private Map<String,Disciplina> disciplinas; //chave é o código da disciplina
    private Map <String, Professor> professores; //chave é a matrícula do professor
    private Map <String, Area> areas; //chave é o código da área
    private Map <Disciplina, RelatorioInteressePorDisciplina> interessesPorDisciplina;
    private Map <Professor, RelatorioInteressePorProfessor> interessesPorProfessor;
    private Map <Area, RelatorioInteressePorArea> interessesPorArea;

    public GerentePreferenciasProfessores(){
        this.disciplinas = new HashMap<String, Disciplina>();
        this.professores = new HashMap<String, Professor>();
        this.interessesPorDisciplina =
                new HashMap<Disciplina, RelatorioInteressePorDisciplina>();
        this.interessesPorProfessor =
                new HashMap<Professor, RelatorioInteressePorProfessor>();
        this.areas = new HashMap<String, Area>();
        this.interessesPorArea = new HashMap<Area, RelatorioInteressePorArea>();
    }
    @Override
    public void cadastraDisciplina(String codDisciplina, String nomeDisciplina)
            throws DisciplinaJaExisteException {
        if (this.disciplinas.containsKey(codDisciplina)){
            throw new DisciplinaJaExisteException();
        } else {
            Disciplina dis = new Disciplina(codDisciplina, nomeDisciplina);
            this.disciplinas.put(codDisciplina, dis);
            this.interessesPorDisciplina.put(dis,
                    new RelatorioInteressePorDisciplina(dis));
        }
    } ...

