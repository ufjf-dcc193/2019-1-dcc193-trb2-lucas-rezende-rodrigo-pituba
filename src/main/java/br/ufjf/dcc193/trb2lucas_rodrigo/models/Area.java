package br.ufjf.dcc193.trb2lucas_rodrigo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Area
 */
@Entity
@Table(name = "AREA_CONHECIMENTO")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AREA_ID")
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "areas")
    private List<Avaliador> avaliadores;
    @OneToMany(mappedBy = "area")
    private List<Trabalho> trabalhos;

    public Area() {
    }

    /**
     * @return the avaliadores
     */
    public List<Avaliador> getAvaliadores() {
        return avaliadores;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the trabalhos
     */
    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    /**
     * @param avaliadores the avaliadores to set
     */
    public void setAvaliadores(List<Avaliador> avaliadores) {
        this.avaliadores = avaliadores;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param trabalhos the trabalhos to set
     */
    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    @Override
    public String toString() {
        return nome;
    }
}