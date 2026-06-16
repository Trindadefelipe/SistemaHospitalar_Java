package controller;

import java.util.ArrayList;
import model.*;
import view.AtendimentoView;

public class AtendimentoController {
    private AtendimentoView view = new AtendimentoView();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();

    public AtendimentoController(ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u instanceof Paciente) {
                pacientes.add((Paciente) u);
            } else if (u instanceof Medico) {
                medicos.add((Medico) u);
            }
        }
    }

    public void abrirMenu() {
        view.mostrarPacientes(pacientes);
        int iPaciente = view.escolherPaciente();
        Paciente p = pacientes.get(iPaciente);

        view.mostrarMedicos(medicos);
        int iMedico = view.escolherMedico();
        Medico m = medicos.get(iMedico);

        int tipo = view.pedirTipoAtendimento();
        String data = view.pedirDataAtendimento();
        double valor = view.pedirValorBase();
        String tipoExame = view.pedirTipoEspecialidade();
        String tipoCirurgia = view.pedirTipoEspecificoCirurgia();
        String tipoConsulta = view.pedirTipoEspecialidade();

        Atendimento at;

        if (tipo == 2) {
            at = new Exame(p, m, data, valor, tipoExame);
        } else if (tipo == 3) {
            at = new Cirurgia(p, m, data, valor, tipoCirurgia);
        } else {
            at = new Consulta(p, m, data, valor, tipoConsulta);
        }

        Fatura f = new Fatura(p);
        f.adicionarAtendimento(at);
        view.mostrarFatura(f.toString());
        view.mostrarTotal(f.calcularTotalFatura());
    }
}
