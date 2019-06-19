package br.ufjf.dcc193.trb2lucas_rodrigo.repository;

import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliadorRepository extends JpaRepository<Avaliador, Integer> {
    Avaliador findByEmailAndSenha(String email,String senha);
}
