package controle;

import modelos.Ingresso;
import modelos.CineAbc;
import modelos.Sessao;
import java.util.List;

public class IngressoCadastro {
    private CineAbc cinema;

    public IngressoCadastro(CineAbc cinema) {
        this.cinema = cinema;
    }

    public void cadastrarIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            throw new IllegalArgumentException("Ingresso não pode ser nulo");
        }
        if (ingresso.getSessao() == null) {
            throw new IllegalArgumentException("Sessão do ingresso não pode ser nula");
        }
        Sessao sessao = ingresso.getSessao();
        if (sessao.getIngressosDisponiveis() <= 0) {
            throw new IllegalStateException("Não há ingressos disponíveis para esta sessão");
        }
        cinema.adicionarIngresso(ingresso); // CineAbc já chama sessao.adicionarIngresso(ingresso)
    }

    public void removerIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            throw new IllegalArgumentException("Ingresso não pode ser nulo");
        }
        cinema.removerIngresso(ingresso); // CineAbc já cuida da remoção na sessão e atualização de ingressosVendidos
    }

    public List<Ingresso> listarIngressos() {
        return cinema.getIngressos();
    }

    public Ingresso buscarIngressoPorId(int id) {
        return cinema.getIngressos().stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }
}