package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

public enum TipoStatusRecebivel {
    NAO_PROCESSADO("nao_processado"),
    PAGO("pago"), 
    AGUARDANDO_LIBERACAO_FUNDOS("aguardando_pagamento");
    
    
    private final String descricao;

    
    TipoStatusRecebivel(String descricao) {
        this.descricao = descricao;
    }
    

    public String getDescricao() {
        return descricao;
    }
}
