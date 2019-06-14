package br.ufjf.dcc193.trb2lucas_rodrigo.models;

import java.awt.geom.Area;
import java.util.List;

/**
 * Avaliador
 */
public class Avaliador {

    private Integer id;
    private String nCompleto;
    private String email;
    private String senha;
    private List<Area> areas;

    public Avaliador() {
    }

    public Avaliador(Integer id, String nCompleto, String email, String senha, List<Area> area) {
        this.id = id;
        this.nCompleto = nCompleto;
        this.email = email;
        this.senha = senha;
        this.areas = areas;
    }

    /**
     * @return the areas
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the nCompleto
     */
    public String getnCompleto() {
        return nCompleto;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param nCompleto the nCompleto to set
     */
    public void setnCompleto(String nCompleto) {
        this.nCompleto = nCompleto;
    }

    /**
     * @param areas the areas to set
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}