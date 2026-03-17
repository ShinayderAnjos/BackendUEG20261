package com.br.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="automovel")
public class Automovel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="datafabricacao")
	private Date dataFabricacao;
	
	@Column(name="quantidade")
	private Double quantidade;
	
	@Column(name="precovenda")
	private Double precoVenda;
	
	@Column(name="trieletrico")
	private boolean trioEletrico;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Marca marca;
	

	public Automovel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Automovel(Long codigo, String nome, String modelo, Date dataFabricacao, double quantidade, double precoVenda,
			boolean trioEletrico, Marca marca) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.trioEletrico = trioEletrico;
		this.marca = marca;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public boolean isTrioEletrico() {
		return trioEletrico;
	}

	public void setTrioEletrico(boolean trioEletrico) {
		this.trioEletrico = trioEletrico;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
}
