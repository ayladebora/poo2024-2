package br.ufpb.dcx.ayla.posto;
import java.util.HashMap;
import java.util.Map;
public class SistemaGerenciadorAtendimentosPostoRioTinto implements
        SistemaGerenciadorDeAtendimentos{


    private Map<String,Medico> medicos;
    private Map<String,AtendimentoMedico> atendimentos;

    public SistemaGerenciadorAtendimentosPostoRioTinto() {
        this.medicos = new HashMap<>();
        this.atendimentos = new HashMap<>();
    }


    @Override
    public void cadastrarMedico(String crmMedico, String nomeMedico)
            throws MedicoJaCadastradoException {
        if (this.medicos.containsKey(crmMedico)) {
            throw new MedicoJaCadastradoException(
                    "Já existe médico com o CRM "+crmMedico);
        } else {
            this.medicos.put(crmMedico, new Medico(crmMedico, nomeMedico));
        }

    }
//Demais métodos da classe considerando que implementa a interface
// e que lança em seus métodos mesmas exceções dos métodos da interface.
