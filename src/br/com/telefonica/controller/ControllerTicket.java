package br.com.telefonica.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.telefonica.dao.DaoException;
import br.com.telefonica.dao.DaoTicket;
import br.com.telefonica.dao.IDao;
import br.com.telefonica.entity.Ticket;
import br.com.telefonica.main.MainContext;

public class ControllerTicket implements IControllerTicket {

	ApplicationContext context = new AnnotationConfigApplicationContext(MainContext.class);
	
	@Override
	public void cadastrar(Ticket ticket) throws ControllerException {
		IDao<Ticket> daoTicket = context.getBean("daoTicket",DaoTicket.class);

		try {
			daoTicket.criar(ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Ticket> pesquisar(Ticket ticket) throws ControllerException {
		
		IDao<Ticket> daoTicket = context.getBean("daoTicket",DaoTicket.class);

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
		
		IDao<Ticket> daoTicket = context.getBean("daoTicket",DaoTicket.class);

		try {
			daoTicket.atualizar(ticketSelecionado, ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(Ticket ticket) throws ControllerException {
		
		IDao<Ticket> daoTicket = context.getBean("daoTicket",DaoTicket.class);

		try {
			daoTicket.remover(ticket);
		} catch (DaoException e) {
			new ControllerException();
			e.printStackTrace();
		}
		
	}

}
