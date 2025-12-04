/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelos.Sessao;
import modelos.CineAbc;
import java.util.List;

public class SessaoCadastro {
    private CineAbc cinema;

    public SessaoCadastro(CineAbc cinema) {
        this.cinema = cinema;
    }

    public void cadastrarSessao(Sessao sessao) {
        if (sessao == null) throw new IllegalArgumentException("Sessão não pode ser nula");
        cinema.adicionarSessao(sessao);
    }

    public void removerSessao(Sessao sessao) {
        cinema.removerSessao(sessao);
    }

    public List<Sessao> listarSessoes() {
        return cinema.getSessoes();
    }

    public Sessao buscarSessaoPorId(int id) {
        return cinema.getSessoes().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}