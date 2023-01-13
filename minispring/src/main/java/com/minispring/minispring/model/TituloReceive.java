/*
 * Copyright © 2021 Alpe (https://www.alpe.com.br)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.minispring.minispring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TituloReceive implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate dataEmissao;

	private LocalDate dataVencimento;

	private LocalDate dataBaixa;

	private String nossoNumero;

	private String numeroIdentificacaoTituloEmpresa;

	private String numeroTitulo;

	private BigDecimal valorAberto;

	private BigDecimal valorFace;

	private BigDecimal valorBaixado;

	private String numeroNfe;

	private String statusTitulo;

	private String statusLiquidez;

	private String numeroPedido;

	private String numeroSequencialTitulo;

	private Long codigoBancoCobrador;

	private Boleto boleto;

	private String action;

	public TituloReceive() {
	}

	public TituloReceive(LocalDate dataEmissao, LocalDate dataVencimento, String numeroIdentificacaoTituloEmpresa,
						 String numeroTitulo, BigDecimal valorFace, String numeroNfe, String statusTitulo,
						 String numeroPedido, Long codigoBancoCobrador, Boleto boleto) {
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.numeroIdentificacaoTituloEmpresa = numeroIdentificacaoTituloEmpresa;
		this.numeroTitulo = numeroTitulo;
		this.valorFace = valorFace;
		this.numeroNfe = numeroNfe;
		this.statusTitulo = statusTitulo;
		this.numeroPedido = numeroPedido;
		this.codigoBancoCobrador = codigoBancoCobrador;
		this.boleto = boleto;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataBaixa() {
		return dataBaixa;
	}

	public void setDataBaixa(LocalDate dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getNumeroIdentificacaoTituloEmpresa() {
		return numeroIdentificacaoTituloEmpresa;
	}

	public void setNumeroIdentificacaoTituloEmpresa(String numeroIdentificacaoTituloEmpresa) {
		this.numeroIdentificacaoTituloEmpresa = numeroIdentificacaoTituloEmpresa;
	}

	public String getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public BigDecimal getValorAberto() {
		return valorAberto;
	}

	public void setValorAberto(BigDecimal valorAberto) {
		this.valorAberto = valorAberto;
	}

	public BigDecimal getValorFace() {
		return valorFace;
	}

	public void setValorFace(BigDecimal valorFace) {
		this.valorFace = valorFace;
	}

	public BigDecimal getValorBaixado() {
		return valorBaixado;
	}

	public void setValorBaixado(BigDecimal valorBaixado) {
		this.valorBaixado = valorBaixado;
	}

	public String getNumeroNfe() {
		return numeroNfe;
	}

	public void setNumeroNfe(String numeroNfe) {
		this.numeroNfe = numeroNfe;
	}

	public String getStatusTitulo() {
		return statusTitulo;
	}

	public void setStatusTitulo(String statusTitulo) {
		this.statusTitulo = statusTitulo;
	}

	public String getStatusLiquidez() {
		return statusLiquidez;
	}

	public void setStatusLiquidez(String statusLiquidez) {
		this.statusLiquidez = statusLiquidez;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getNumeroSequencialTitulo() {
		return numeroSequencialTitulo;
	}

	public void setNumeroSequencialTitulo(String numeroSequencialTitulo) {
		this.numeroSequencialTitulo = numeroSequencialTitulo;
	}

	public Long getCodigoBancoCobrador() {
		return codigoBancoCobrador;
	}

	public void setCodigoBancoCobrador(Long codigoBancoCobrador) {
		this.codigoBancoCobrador = codigoBancoCobrador;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}

// numeroSequencialTitulo:8012
// numeroTitulo:"FOMENTO 23"
// valorAberto:35229.94
// codigoBancoCobrador:341
// carteira:"341-2937-23810-112-0"
// cnpjSacado:"04.820.606/0001-24"
// cnpjCedente:"04.820.606/0001-24"
// cedente:188
// sacado:188
// dataVencimento:"18/05/2021"
// dataEmissao:"14/05/2021"
// dataEfetivacao:"-"
// dataBaixa:"-"
// nossoNumero:null
// multaVencimento:null
// taxaMoraBancaria:10
// diasProtestoAuto:0
// codigoEmpresa:1
// codigoFilial:1
// statusLiquidez:"ABERTO"
// statusTitulo:"VENCIDO"
// valorCorrigido:35229.94
// valorDesagio:0
// valorBaixado:0
// valorFace:35229.94
// numeroNfe:null
// numeroPedido:0
