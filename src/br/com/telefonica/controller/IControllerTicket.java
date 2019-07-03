package br.com.telefonica.controller;

import java.util.List;

import br.com.telefonica.entity.Ticket;

public interface IControllerTicket {
	
	public void cadastrar(Ticket ticket) throws ControllerException;
	
	public List<Ticket> pesquisar(Ticket ticket) throws ControllerException;
	
	public void alterar(Ticket ticketSelecionado,Ticket ticket) throws ControllerException;
	
	public void deletar(Ticket ticket) throws ControllerException;

}
