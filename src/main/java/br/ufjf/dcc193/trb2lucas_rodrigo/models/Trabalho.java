package br.ufjf.dcc193.trb2lucas_rodrigo.models;

import java.awt.geom.Area;

/**
 * Trabalho
 */
public class Trabalho {

    private Integer id;
    private String titulo;
    private String descricao;
    private String url;
    private Area area;

    public Trabalho() {
    }

    public Trabalho(Integer id, String titulo, String descricao, String url, Area area) {
        this.id = id;
        this.titulo = titulo;
        this.area = area;
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