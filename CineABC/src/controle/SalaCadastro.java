/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelos.Sala;
import modelos.CineAbc;
import java.util.List;

public class SalaCadastro {
    private CineAbc cinema;

    public SalaCadastro(CineAbc cinema) {
        this.cinema = cinema;
    }

    public void cadastrarSala(Sala sala) {
        if (sala == null) throw new IllegalArgumentException("Sala não pode ser nula");
        cinema.adicionarSala(sala);
    }

    public void removerSala(Sala sala) {
        cinema.removerSala(sala);
    }

    public List<Sala> listarSalas() {
        return cinema.getSalas();
    }

    public Sala buscarSalaPorNumero(int numero) {
        return cinema.getSalas().stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
}