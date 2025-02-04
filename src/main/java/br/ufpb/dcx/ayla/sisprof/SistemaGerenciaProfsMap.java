package br.ufpb.dcx.ayla.sisprof;

public class SistemaGerenciaProfsMap implements SistemaGerenciaProfs {

    private Map <Integer, Professor> professores = new HashMap<>();
    private Map <Integer, Disciplina> disciplinas = new HashMap<>();

    public Professor pesquisaProfessor(int matriculaProf)
            throws ProfessorInexistenteException{
        Professor p = this.professores.get(matriculaProf);
        if (p == null)
            throw new ProfessorInexistenteException ("Não existe professor com essa  matrícula:"+ matriculaProf);
        else
            return p;
    }
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf)
            throws ProfessorInexistenteException{
        List <Horario> horarios = new LinkedList<>();
        for (Disciplina d: this.disciplinas.values()){
            if (d.getMatriculaProfessor() == matriculaProf){
                horarios.addAll(d.getHorarios());
            }
        }
        return horarios;
    }

    public List <String> consultaNomesDisciplinasDoProfessor(int matriculaProf){
        List<String> nomesDisciplinas = new LinkedList<>();
        for (Disciplina d: this.disciplinas.values()){
            if (d.getMatriculaProfessor()== matriculaProf){
                nomesDisciplinas.add(d.getNome());
            }
        }
        return nomesDisciplinas;
    }

    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina,
                                   int matriculaProfessor, List<Horario> horarios) throws
            DisciplinaJaExisteException{

        if (this.disciplinas.containsKey(codigoDisciplina)){
            throw new DisciplinaJaExisteException("Já existe a disciplina com código "+ codigoDisciplina);
        } else {
            this.disciplinas.put(codigoDisciplina, new Disciplina(nomeDisciplina, codigoDisciplina, matriculaProfessor, horarios));
        }

    }

}

