package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoStatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoStatusRecebivel.PAGO;

/**
 * Total CDD points = 6
 */

//1 pt Acomplamento contextual
public class AplicaTaxaOperacional implements Processor<Recebivel, Recebivel>{

    //1 pt Acoplamento contextual
    private static final BigDecimal TAXA_DEBITO_MULTIPLICADOR = new BigDecimal("0.97");
    private static final BigDecimal TAXA_CREDITO_MULTIPLICADOR = new BigDecimal("0.95");
    
    @Override
    public Recebivel process(Recebivel recebivel) {
        //1 pt Acoplamento contextual
        final Transacao transacao = recebivel.getTransacao();

        switch (transacao.metodoPagamento) {
            //1 pt branch
            // *Por credito:
            case CARTAO_CREDITO: {
                final BigDecimal valorAReceber = transacao.valor.multiply(TAXA_CREDITO_MULTIPLICADOR);
                final LocalDate dataRecebimento = transacao.dataPagamento.plusDays(30);
                
                return recebivel
                        .withStatus(AGUARDANDO_LIBERACAO_FUNDOS)
                        .withValorAReceber(valorAReceber)
                        .withDataRecebimento(dataRecebimento);
            }
            //1 pt branch
            // *Por debito:
            case CARTAO_DEBITO: {
                final BigDecimal valorAReceber = transacao.valor.multiply(TAXA_DEBITO_MULTIPLICADOR);
                final LocalDate dataRecebimento = transacao.dataPagamento.plusDays(0);
                
                return recebivel
                        .withStatus(PAGO)
                        .withValorAReceber(valorAReceber)
                        .withDataRecebimento(dataRecebimento);
            }
            //1 pt branch
            default:
                throw new IllegalArgumentException();
        }
    }
}
