package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * total cdd points = 1
 */
public class TransacaoCartao extends Transacao {
    
    private String numeroCartao;
    private String nomeDoCartao;
    private LocalDate validade;
    private String cvv;

    public TransacaoCartao(Long idTransacao, BigDecimal valor, TipoMetodoPagamento metodoPagamento, LocalDate dataPagamento, String numeroCartao, String nomeDoCartao, LocalDate validade, String cvv) {
        super(idTransacao, valor, metodoPagamento, dataPagamento);
        this.numeroCartao = numeroCartao;
        this.nomeDoCartao = nomeDoCartao;
        this.validade = validade;
        this.cvv = cvv;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeDoCartao() {
        return nomeDoCartao;
    }

    public void setNomeDoCartao(String nomeDoCartao) {
        this.nomeDoCartao = nomeDoCartao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
