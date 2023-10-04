package com.serratec.primeiraapi.model.FormaPagamento;

public class FormaPagamentoModel {

    private Long idFormaPagamento;
    private String descricaoFormaPagamento;

    // getters and setters
    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }
    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }
    public String getdescricaoFormaPagamento() {
        return descricaoFormaPagamento;
    }
    public void setdescricaoFormaPagamento(String descricaoFormaPagamento) {
        this.descricaoFormaPagamento = descricaoFormaPagamento;
    }
}
