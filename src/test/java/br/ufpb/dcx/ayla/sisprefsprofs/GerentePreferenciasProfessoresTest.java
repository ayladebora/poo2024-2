package br.ufpb.dcx.ayla.sisprefsprofs;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class GerentePreferenciasProfessoresTest {

    @Test
    public void testaCadastrosDeInteresse() throws Exception{
        GerentePreferenciasProfessores sistema = new GerentePreferenciasProfessores();
            sistema.cadastraProfessor("123", "João");
            sistema.cadastraDisciplina("44", "POO");
            sistema.cadastraInteresseDeProfessorPorDisciplina("123", "44", NivelInteresse.P1);
            Collection<Professor> profsInteressados = sistema.getProfessoresInteressadosPorDisciplina("44", NivelInteresse.P1);
            assertEquals(1, profsInteressados.size());
            boolean contemJoao = false;
            for (Professor prof: profsInteressados){
                if (prof.getNome().equals("João")){
                    contemJoao = true;
                }
            }
            assertTrue(contemJoao);
            NivelInteresse nivelJoao = sistema.getNivelInteresseDeProfessorPorDisciplina("123", "44");
            assertEquals(NivelInteresse.P1, nivelJoao);
    }
}
