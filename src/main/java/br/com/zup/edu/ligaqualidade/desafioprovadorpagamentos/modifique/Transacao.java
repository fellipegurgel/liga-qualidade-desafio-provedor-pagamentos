package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * total cdd points = 1
 */
public abstract class Transacao {
    
    protected Long idTransacao;
    protected BigDecimal valor;
    protected TipoMetodoPagamento metodoPagamento;//1 pt
    protected LocalDate dataPagamento;

    
    
    public Transacao(Long idTransacao, BigDecimal valor, TipoMetodoPagamento metodoPagamento, LocalDate dataPagamento) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.dataPagamento = dataPagamento;
    }

    
    
    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoMetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(TipoMetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
