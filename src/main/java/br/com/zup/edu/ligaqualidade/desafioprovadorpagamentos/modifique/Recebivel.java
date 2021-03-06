package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Recebivel {

    private final Transacao transacao;
    private TipoStatusRecebivel status;
    private BigDecimal valorAReceber;
    private LocalDate dataRecebimento;


    
    public Recebivel(Transacao transacao, TipoStatusRecebivel status, BigDecimal valorAReceber, LocalDate dataRecebimento) {
        this.transacao = transacao;
        this.status = status;
        this.valorAReceber = valorAReceber;
        this.dataRecebimento = dataRecebimento;
    }

    

    public Transacao getTransacao() {
        return transacao;
    }
    
    public TipoStatusRecebivel getStatus() {
        return status;
    }

    public Recebivel withStatus(TipoStatusRecebivel status) {
        Recebivel recebivel = shallowClone();
        recebivel.status = status;
        return recebivel;
    }

    public BigDecimal getValorAReceber() {
        return valorAReceber;
    }

    public Recebivel withValorAReceber(BigDecimal valorAReceber) {
        Recebivel recebivel = shallowClone();
        recebivel.valorAReceber = valorAReceber;
        return recebivel;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public Recebivel withDataRecebimento(LocalDate dataRecebimento) {
        Recebivel recebivel = shallowClone();
        recebivel.dataRecebimento = dataRecebimento;
        return recebivel;
    }

    

    private Recebivel shallowClone(){
        return new Recebivel(transacao, status, valorAReceber, dataRecebimento);
    }
}
