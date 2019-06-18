package br.ufjf.dcc193.trb2lucas_rodrigo.repository;

import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
}
