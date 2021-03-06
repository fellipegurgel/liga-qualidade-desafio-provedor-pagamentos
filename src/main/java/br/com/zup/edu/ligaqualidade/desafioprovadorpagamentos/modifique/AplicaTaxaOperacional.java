package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoStatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoStatusRecebivel.PAGO;

public class AplicaTaxaOperacional implements Processor<Recebivel, Recebivel>{


    private static final BigDecimal TAXA_DEBITO_MULTIPLICADOR = new BigDecimal("0.97");
    private static final BigDecimal TAXA_CREDITO_MULTIPLICADOR = new BigDecimal("0.95");
    
    @Override
    public Recebivel process(Recebivel recebivel) {
        final Transacao transacao = recebivel.getTransacao();
        switch (transacao.metodoPagamento) {
            
            // *Por credito:
            case CARTAO_CREDITO: {
                final BigDecimal valorAReceber = transacao.valor.multiply(TAXA_CREDITO_MULTIPLICADOR);
                final LocalDate dataRecebimento = transacao.dataPagamento.plusDays(30);
                
                return recebivel
                        .withStatus(AGUARDANDO_LIBERACAO_FUNDOS)
                        .withValorAReceber(valorAReceber)
                        .withDataRecebimento(dataRecebimento);
            }

            // *Por debito:
            case CARTAO_DEBITO: {
                final BigDecimal valorAReceber = transacao.valor.multiply(TAXA_DEBITO_MULTIPLICADOR);
                final LocalDate dataRecebimento = transacao.dataPagamento.plusDays(0);
                
                return recebivel
                        .withStatus(PAGO)
                        .withValorAReceber(valorAReceber)
                        .withDataRecebimento(dataRecebimento);
            }
            
            default:
                throw new IllegalArgumentException();
        }
    }
}
