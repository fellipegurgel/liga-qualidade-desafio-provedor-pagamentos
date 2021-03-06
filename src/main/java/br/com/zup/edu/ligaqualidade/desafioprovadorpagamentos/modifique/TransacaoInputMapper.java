package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.Constants.DATE_FORMAT_DD_MM_YYYY;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoMetodoPagamento.CARTAO_CREDITO;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.TipoMetodoPagamento.CARTAO_DEBITO;

public class TransacaoInputMapper implements Processor<String, TransacaoCartao>{
    
    private final String DEBITO_LABEL = "DEBITO";
    private final String CREDITO_LABEL = "CREDITO";


    /**
     * Transforma o input recebido como texto em uma transação de cartão
     * @param linhaTransacao linha referente à transação, com as propriedades separadas por vírgula
     * @return Transação referente à linha inputada
     */
    @Override
    public TransacaoCartao process(String linhaTransacao) {
        // *Dividindo essa linha pelas virgulas:
        final String[] props = linhaTransacao.split(",");
        
        
        
        // *Valor do pagamento:
        final BigDecimal valor = new BigDecimal(props[0]);
        
        // *Metodo do pagamento:
        final TipoMetodoPagamento metodoPagamento = DEBITO_LABEL.equals(props[1])
                ? CARTAO_DEBITO
                : CARTAO_CREDITO;

        // *Data do pagamento:
        final LocalDate dataPagamento = LocalDate.now();

        // *Numero do cartao:
        final String numeroCartao = props[2];
        
        // *Nome do cartao:
        final String nomeCartao = props[3];
        
        // *Validade do cartao:
        final LocalDate validade = LocalDate.parse(props[4], DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY));

        // *CVV do cartao (Código de segurança):
        final String cvv = props[5];

        // *Id do pagamento:
        final Long id = Long.valueOf(props[6]);
        
        
        // *Retornando a transação mapeada a partir do input:
        return new TransacaoCartao(id, valor, metodoPagamento, dataPagamento, numeroCartao, nomeCartao, validade, cvv);
    }
    
}
