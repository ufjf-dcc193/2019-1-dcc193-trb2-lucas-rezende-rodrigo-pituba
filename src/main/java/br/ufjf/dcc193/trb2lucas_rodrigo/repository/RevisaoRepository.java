package br.ufjf.dcc193.trb2lucas_rodrigo.repository;

import br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.EnumStatus;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RevisaoRepository extends JpaRepository<Revisao, Integer> {

    @Query("Select new br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO(t.id, t.titulo,t.descricao,t.url,t.area, Count(t.id)) from Trabalho t join t.revisoes r with r.status = 1 where t.area = :area group by t.id order by Count(t.id) asc")
    List<TrabalhoDTO> findTrabalhosAvaliados(@Param("area") Area area);

    @Query("Select new br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO(t.id, t.titulo,t.descricao,t.url,t.area,0L) from Trabalho t left join Revisao r on r.trabalho.id = t.id inner join t.avaliador a where t.area = :area and (r.status <> 1 or r.status is null) and a.id = :id group by t.id")
    List<TrabalhoDTO> findTrabalhosNaoAvaliados(@Param("area") Area area,@Param("id") Integer id);

    List<Revisao> findAllByTrabalho(Trabalho trabalho);

    List<Revisao> findByAvaliadorIdAndStatus(Integer id, EnumStatus enumStatus);
}
