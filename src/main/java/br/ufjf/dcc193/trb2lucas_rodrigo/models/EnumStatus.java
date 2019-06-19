package br.ufjf.dcc193.trb2lucas_rodrigo.models;

/**
 * EnumStatus
 */
public enum EnumStatus {

    AFAZER(0, "A Fazer"), AVALIADO(1, "Avaliado"), IMPEDIDO(2, "Impedido"), VALIDADO(3, "Validado"),
    INVALIDADO(4, "Invalidado");

    private Integer id;
    private String descricao;

    private EnumStatus(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

}