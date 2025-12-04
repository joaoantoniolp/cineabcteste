/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controle;

import modelos.Filme;
import modelos.Sala;
import modelos.Sessao;
import modelos.Ingresso;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface CineCRUD {

    // Operações para Filmes
    void criarFilme(Filme filme);
    Filme lerFilme(int id);
    void atualizarFilme(Filme filme);
    void excluirFilme(int id);
    List<Filme> listarFilmes();

    // Operações para Salas
    void criarSala(Sala sala);
    Sala lerSala(int numero);
    void atualizarSala(Sala sala);
   void excluirSala(int numero);
    List<Sala> listarSalas();

    // Operações para Sessões
    void criarSessao(Sessao sessao);
    Sessao lerSessao(int id);
    void atualizarSessao(Sessao sessao);
    void excluirSessao(int id);
    List<Sessao> listarSessoes();

    // Operações para Ingressos
    void criarIngresso(Ingresso ingresso);
    Ingresso lerIngresso(int id);
    void atualizarIngresso(Ingresso ingresso);
    void excluirIngresso(int id);
    List<Ingresso> listarIngressos();
}