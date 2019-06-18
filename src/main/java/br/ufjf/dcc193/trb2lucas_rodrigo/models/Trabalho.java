package br.ufjf.dcc193.trb2lucas_rodrigo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

/**
 * Trabalho
 */
@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRABALHO_ID")
    private Integer id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @URL(message = "É necessário seguir o protocolo http")
    private String url;
    @ManyToOne
    private Area area;
    @OneToMany(mappedBy = "trabalho")
    private List<Revisao> revisoes;

    public Trabalho() {
    }

    public Trabalho(Integer id, String titulo, String descricao, String url, Area area) {
        this.id = id;
        this.titulo = titulo;
        this.area = area;
        this.url = url;
        this.descricao = descricao;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the revisoes
     */
    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    /**
     * @param revisoes the revisoes to set
     */
    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}