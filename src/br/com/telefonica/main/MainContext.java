package br.com.telefonica.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.telefonica.controller.ControllerTicket;
import br.com.telefonica.dao.DaoTicket;
import br.com.telefonica.dao.IDao;
import br.com.telefonica.entity.Area;
import br.com.telefonica.entity.Gestor;
import br.com.telefonica.entity.Ticket;

@Configuration
public class MainContext {
	
	@Bean
	public Area area() {
		return new Area();
	}
	
	@Bean
	public Gestor gestor() {
		return new Gestor();
	}
	
	@Bean
	public Ticket ticket() {
		Ticket ticket = new Ticket();
		
		ticket.setAreaDestinada(area());
		ticket.setAreaSolicitante(area());
		ticket.setGestor(gestor());
				
		return ticket;
	}
	
	public IDao<Ticket> daoTicket() {
		
		return new DaoTicket();
				
	}
	
	public ControllerTicket controllerTicket() {
		
		return new ControllerTicket();
		
	}

}
