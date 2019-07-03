package br.com.telefonica.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.telefonica.dao.DaoException;
import br.com.telefonica.dao.DaoTicket;
import br.com.telefonica.dao.IDao;
import br.com.telefonica.entity.Ticket;

@Controller
@RequestMapping(value="/tickets")
public class ControllerTicket implements IControllerTicket {

	@Override
	@RequestMapping(value= {"/",""},  method=RequestMethod.POST)
	public void cadastrar(Ticket ticket) throws ControllerException {
		
		System.out.println("Criar ticket");
		
		IDao<Ticket> daoTicket = new DaoTicket();

		try {
			daoTicket.criar(ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

	@Override
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ticket> pesquisar(Ticket ticket) throws ControllerException {
		
		System.out.println("Pesquisar ticket");
		
		IDao<Ticket> daoTicket = new DaoTicket();

		try {
			return daoTicket.pesquisar(ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void alterar(Ticket ticketSelecionado, Ticket ticket) throws ControllerException {
		
		IDao<Ticket> daoTicket = new DaoTicket();

		try {
			daoTicket.atualizar(ticketSelecionado, ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

	@Override
	
	public void deletar(Ticket ticket) throws ControllerException {
		
		IDao<Ticket> daoTicket = new DaoTicket();

		try {
			daoTicket.remover(ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

}
