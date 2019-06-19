package br.ufjf.dcc193.trb2lucas_rodrigo.repository;

import br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RevisaoRepository extends JpaRepository<Revisao, Integer> {

    @Query("Select new br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO(t.id, t.titulo,t.descricao,t.url,t.area, Count(t.id)) from Trabalho t join t.revisoes r with r.status = 1 where t.area = :area group by t.id order by Count(t.id)")
    List<TrabalhoDTO> findTrabalhosAvaliados(@Param("area") Area area);

    @Query("Select new br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO(t.id, t.titulo,t.descricao,t.url,t.area,0L) from Trabalho t left join Revisao r on r.trabalho.id = t.id where t.area = :area and (r.status <> 1 or r.status is null) group by t.id")
    List<TrabalhoDTO> findTrabalhosNaoAvaliados(@Param("area") Area area);

    List<Revisao> findAllByTrabalho(Trabalho trabalho);
}
