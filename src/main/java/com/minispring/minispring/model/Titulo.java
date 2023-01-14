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

import java.math.BigDecimal;
import java.time.LocalDate;

public class Titulo {


	private LocalDate dataEmissao;

	private LocalDate dataVencimento;

	private String nossoNumero;

	private String numeroIdentificacaoTituloEmpresa;

	private String numeroNfe;

	private String numeroTitulo;

	private BigDecimal valorTitulo;

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

	public String getNumeroNfe() {
		return numeroNfe;
	}

	public void setNumeroNfe(String numeroNfe) {
		this.numeroNfe = numeroNfe;
	}

	public String getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(BigDecimal valorTitulo) {
		this.valorTitulo = valorTitulo;
	}
}
