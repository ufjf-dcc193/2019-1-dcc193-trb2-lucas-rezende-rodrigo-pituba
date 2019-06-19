package br.ufjf.dcc193.trb2lucas_rodrigo.DTO;

import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrabalhoDTO {

    private Integer id;

    private String titulo;

    private String descricao;

    private String url;

    private Area area;

    private long contador;

    private List<Revisao> revisoes;

    private Revisao revisao;

    private boolean minhaRevisao;

    public TrabalhoDTO() {
    }

    public TrabalhoDTO(Integer id, String titulo, String descricao, String url, Area area, long contador) {
        this.id = id;
        this.titulo = titulo;
        this.area = area;
        this.url = url;
        this.contador = contador;
        this.descricao = descricao;
        this.minhaRevisao = false;
        this.revisoes = new ArrayList<Revisao>();
        this.revisao  = new Revisao();
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

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public boolean isMinhaRevisao() {
        return minhaRevisao;
    }

    public void setMinhaRevisao(boolean minhaRevisao) {
        this.minhaRevisao = minhaRevisao;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }
}