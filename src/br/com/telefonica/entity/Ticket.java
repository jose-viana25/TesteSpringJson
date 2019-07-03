package br.com.telefonica.entity;

import java.util.Date;

public class Ticket {
	
	private long numero;
	private String titulo;
	private String descricao;
	private String tipo;
	private String prioridade;
	private String urlDoSistema;
	private String sistema;
	private Date dataObjetivo;
	private Area areaSolicitante;
	private Area areaDestinada;
	private Gestor gestor;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getUrlDoSistema() {
		return urlDoSistema;
	}
	public void setUrlDoSistema(String urlDoSistema) {
		this.urlDoSistema = urlDoSistema;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public Date getDataObjetivo() {
		return dataObjetivo;
	}
	public void setDataObjetivo(Date dataObjetivo) {
		this.dataObjetivo = dataObjetivo;
	}
	public Area getAreaSolicitante() {
		return areaSolicitante;
	}
	public void setAreaSolicitante(Area areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}
	public Area getAreaDestinada() {
		return areaDestinada;
	}
	public void setAreaDestinada(Area areaDestinada) {
		this.areaDestinada = areaDestinada;
	}
	public Gestor getGestor() {
		return gestor;
	}
	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
	
	
}
