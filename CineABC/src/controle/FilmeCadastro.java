/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelos.Filme;
import modelos.*;
import java.util.List;

public class FilmeCadastro {
    private CineAbc cinema;

    public FilmeCadastro(CineAbc cinema) {
        this.cinema = cinema;
    }

    public void cadastrarFilme(Filme filme) {
        if (filme == null) throw new IllegalArgumentException("Filme não pode ser nulo");
        cinema.adicionarFilme(filme);
    }

    public void removerFilme(Filme filme) {
        cinema.removerFilme(filme);
    }

    public List<Filme> listarFilmes() {
        return cinema.getFilmes();
    }

    public Filme buscarFilmePorId(int id) {
        return cinema.getFilmes().stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }
}