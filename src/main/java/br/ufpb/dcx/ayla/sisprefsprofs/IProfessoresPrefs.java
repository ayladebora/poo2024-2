package br.ufpb.dcx.ayla.sisprefsprofs;

import java.util.Collection;
import br.ufpb.dcx.ayla.sisprof.DisciplinaJaExisteException;
import br.ufpb.dcx.ayla.sisprof.ProfessorJaExisteException;
import br.ufpb.dcx.ayla.sisprof.ProfessorInexistenteException;
import br.ufpb.dcx.ayla.sisprof.DisciplinaInexistenteException;

public interface IProfessoresPrefs {

    public void cadastraDisciplina(String codDisciplina, String nomeDisciplina)
            throws DisciplinaJaExisteException;
    public void cadastraProfessor(String matriculaProf, String nomeProf)
            throws ProfessorJaExisteException;
    public void cadastraInteresseDeProfessorPorDisciplina(String matriculaProf,
                                                          String codDisciplina, NivelInteresse nivel)
            throws ProfessorInexistenteException, DisciplinaInexistenteException;
    public void cadastraArea(String codArea, String nomeArea)
            throws AreaExistenteException;
    public void cadastraInteresseDeProfessorPorArea(String matriculaProf, String codArea)
            throws ProfessorInexistenteException, AreaInexistenteException;
    public Professor pesquisaProfessor(String matriculaProf)
            throws ProfessorInexistenteException;
    public Disciplina pesquisaDisciplina(String codDisciplina)
            throws DisciplinaInexistenteException;
    public Area pesquisaArea(String codArea)  throws AreaInexistenteException;
    public Collection <Professor> getProfessoresInteressadosPorArea(String codArea);
    public Collection <Professor> getProfessoresInteressadosPorDisciplina(
            String codDisciplina, NivelInteresse nivel);
    public NivelInteresse getNivelInteresseDeProfessorPorDisciplina(
            String matriculaProf, String codDisciplina)
            throws ProfessorInexistenteException, DisciplinaInexistenteException;
}

