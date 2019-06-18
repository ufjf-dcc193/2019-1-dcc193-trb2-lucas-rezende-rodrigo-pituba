package br.ufjf.dcc193.trb2lucas_rodrigo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Avaliador
 */
@Entity
@Table(name = "AVALIADOR")
public class Avaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AVALIADOR_ID")
    private Integer id;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;

    @OneToMany(mappedBy = "avaliador")
    private List<Revisao> revisoes;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "AVALIADOR_AREA_CONHECIMENTO", joinColumns = {
            @JoinColumn(name = "AVALIADOR_ID") }, inverseJoinColumns = { @JoinColumn(name = "AREA_ID") })
    private List<Area> areas;

    public Avaliador() {
        areas = new ArrayList<>();
    }

    public Avaliador(Integer id, String nomeCompleto, String email, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        areas = new ArrayList<>();
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
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
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
     * @param areas the areas to set
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}