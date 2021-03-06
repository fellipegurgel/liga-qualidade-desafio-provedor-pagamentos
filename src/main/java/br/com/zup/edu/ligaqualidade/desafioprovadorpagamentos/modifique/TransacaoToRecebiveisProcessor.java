package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoStatusRecebivel.NAO_PROCESSADO;

public class TransacaoToRecebiveisProcessor implements Processor<TransacaoCartao, Recebivel>{
    @Override
    public Recebivel process(TransacaoCartao transacaoCartao) {
        return new Recebivel(transacaoCartao, NAO_PROCESSADO, transacaoCartao.valor, transacaoCartao.dataPagamento);
    }
}
