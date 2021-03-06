package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Solucao {
	

	/**
	 * 
	 * @param infoTransacoes dados das transações. A String está formatada da seguinte maneira:		
		<b>"valor,metodoPagamento,numeroCartao,nomeCartao,validade,cvv,idTransacao"</b>
		<ol>
		 <li> Valor é um decimal</li>
	 	 <li> O método de pagamento é 'DEBITO' ou 'CREDITO' </li>
	 	 <li> Validade é uma data no formato dd/MM/yyyy. </li>
	 	</ol>
	 	
	 * @param infoAdiantamentos informacao da transacao que pode ser recebida adiantada. A String está formatada da seguinte maneira:		
		<b>"idTransacao,taxa"</b>
		<ol>
	 	 <li> Taxa é um decimal </li>	 	 
	 	</ol> 
	 * 
	 * @return Uma lista de array de string com as informações na seguinte ordem:
	 * [status,valorOriginal,valorASerRecebidoDeFato,dataEsperadoRecebimento].
	 * <ol>
	 *  <li>O status pode ser 'pago' ou 'aguardando_pagamento'</li>
	 *  <li>O valor original e o a ser recebido de fato devem vir no formato decimal. Ex: 50.45</li>
	 *  <li>dataEsperadoRecebimento deve ser formatada como dd/MM/yyyy. Confira a classe {@link DateTimeFormatter}</li> 
	 * </ol> 
	 * 
	 * É esperado que o retorno respeite a ordem de recebimento
	 */
	public static List<String[]> executa(List<String> infoTransacoes, List<String> infoAdiantamentos) {
	
		final List<Recebivel> recebiveis = infoTransacoes
				.stream()
				
				// *Transformando o input inicial:
				.map(new TransacaoInputMapper()::process)
				
				// *Transformando para recebiveis:
				.map(new TransacaoToRecebiveisProcessor()::process)
				
				// *Aplicando taxa de operação:
				.map(new AplicaTaxaOperacional()::process)
				
				.collect(Collectors.toList());

		
		
		// TODO MAPPER OUTPUT --------------------------------------------------
		
		return recebiveis
				.stream()
				.map(recebivel -> new String[]{
						recebivel.getStatus().getDescricao(),
						recebivel.getTransacao().getValor().toPlainString(),
						recebivel.getValorAReceber().toPlainString(),
						recebivel.getDataRecebimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					})
				.collect(Collectors.toList());

		// TODO MAPPER OUTPUT --------------------------------------------------
	}

}
