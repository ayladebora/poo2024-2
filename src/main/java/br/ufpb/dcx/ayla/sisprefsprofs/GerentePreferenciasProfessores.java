package br.ufpb.dcx.ayla.sisprefsprofs;

import br.ufpb.dcx.ayla.sisprof.DisciplinaInexistenteException;
import br.ufpb.dcx.ayla.sisprof.DisciplinaJaExisteException;
import br.ufpb.dcx.ayla.sisprof.ProfessorInexistenteException;
import br.ufpb.dcx.ayla.sisprof.ProfessorJaExisteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class GerentePreferenciasProfessores implements IProfessoresPrefs {

    private Map<String, Disciplina> disciplinas; //chave é o código da disciplina
    private Map<String, Professor> professores; //chave é a matrícula do professor
    private Map<String, Area> areas; //chave é o código da área
    private Map<Disciplina, RelatorioInteressePorDisciplina> interessesPorDisciplina;
    private Map<Professor, RelatorioInteressePorProfessor> interessesPorProfessor;
    private Map<Area, RelatorioInteressePorArea> interessesPorArea;

    public GerentePreferenciasProfessores() {
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
        if (this.disciplinas.containsKey(codDisciplina)) {
            throw new DisciplinaJaExisteException();
        } else {
            Disciplina dis = new Disciplina(codDisciplina, nomeDisciplina);
            this.disciplinas.put(codDisciplina, dis);
            this.interessesPorDisciplina.put(dis,
                    new RelatorioInteressePorDisciplina(dis));
        }
    }


    public void cadastraProfessor(String matriculaProf, String nomeProf)
            throws ProfessorJaExisteException{
        if (this.professores.containsKey(matriculaProf)) {
            throw new ProfessorJaExisteException("Já existe professor com matrícula "+matriculaProf);
        } else {
            Professor prof = new Professor(matriculaProf, nomeProf);
            this.professores.put(matriculaProf, prof);
            this.interessesPorProfessor.put(prof,
                    new RelatorioInteressePorProfessor(prof));
        }
    }

    public void cadastraInteresseDeProfessorPorDisciplina(String matriculaProf,
                                                          String codDisciplina, NivelInteresse nivel)
            throws ProfessorInexistenteException, DisciplinaInexistenteException{
        if (!this.professores.containsKey(matriculaProf)){
            throw new ProfessorInexistenteException("Não existe professor:"+matriculaProf);
        }
        if (!this.disciplinas.containsKey(codDisciplina)){
            throw new DisciplinaInexistenteException("Não existe disciplina:"+codDisciplina);
        }
        Professor prof = this.professores.get(matriculaProf);
        this.interessesPorDisciplina.get(this.disciplinas.get(codDisciplina))
                .cadastraInteresseDeProfessor(prof, nivel);
    }
    public void cadastraArea(String codArea, String nomeArea)
            throws AreaExistenteException{
        if (this.areas.containsKey(codArea)) {
            throw new AreaExistenteException("Já existe área com código "+codArea);
        } else {
            this.areas.put(codArea, new Area(codArea, nomeArea));
        }
    }
    public void cadastraInteresseDeProfessorPorArea(String matriculaProf, String codArea)
            throws ProfessorInexistenteException, AreaInexistenteException {
        if (!this.professores.containsKey(matriculaProf)){
            throw new ProfessorInexistenteException("Não existe professor:"+matriculaProf);
        }
        if (!this.areas.containsKey(codArea)){
            throw new AreaInexistenteException("Não existe área:"+codArea);
        }
        Professor prof = this.professores.get(matriculaProf);
        this.interessesPorArea.get(this.areas.get(codArea))
                .adicionaProfessor(prof);
    }

    public Professor pesquisaProfessor(String matriculaProf)
            throws ProfessorInexistenteException{
        if (!this.professores.containsKey(matriculaProf)){
            throw new ProfessorInexistenteException("Não existe professor:"+matriculaProf);
        } else {
            return this.professores.get(matriculaProf);
        }
    }
    public Disciplina pesquisaDisciplina(String codDisciplina)
            throws DisciplinaInexistenteException {
        if (!this.disciplinas.containsKey(codDisciplina)){
            throw new DisciplinaInexistenteException("Não existe disciplina:"+codDisciplina);
        } else {
            return this.disciplinas.get(codDisciplina);
        }
    }

    public Area pesquisaArea(String codArea)  throws AreaInexistenteException {
        if (!this.areas.containsKey(codArea)){
            throw new AreaInexistenteException("Não existe área:"+codArea);
        } else {
            return this.areas.get(codArea);
        }
    }
    public Collection<Professor> getProfessoresInteressadosPorArea(String codArea) {
        if (!this.areas.containsKey(codArea)){
            return new ArrayList<>();
        } else {
            return this.interessesPorArea.get(this.areas.get(codArea)).getInteressados();
        }
    }
    public Collection <Professor> getProfessoresInteressadosPorDisciplina(
            String codDisciplina, NivelInteresse nivel){
        if (!this.disciplinas.containsKey(codDisciplina)){
            return new ArrayList<>();
        } else {
            return this.interessesPorDisciplina.get(this.disciplinas.get(codDisciplina))
                    .getProfessoresInteressadosComNivel(nivel);
        }
    }
    public NivelInteresse getNivelInteresseDeProfessorPorDisciplina(
            String matriculaProf, String codDisciplina)
            throws ProfessorInexistenteException, DisciplinaInexistenteException {
        if (!this.professores.containsKey(matriculaProf)){
            throw new ProfessorInexistenteException("Não existe professor:"+matriculaProf);
        } else {
            Professor prof = this.professores.get(matriculaProf);
            if (!this.disciplinas.containsKey(codDisciplina)){
                throw new DisciplinaInexistenteException("Não existe disciplina:"+codDisciplina);
            } else {
                return this.interessesPorDisciplina.get(this.disciplinas.get(codDisciplina)).getInteresseDoProfessor(prof);
            }
        }
    }

}

