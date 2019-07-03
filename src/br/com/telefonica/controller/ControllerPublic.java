package br.com.telefonica.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.telefonica.entity.Ticket;
import br.com.telefonica.main.MainContext;

@Controller
public class ControllerPublic {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(MainContext.class);
	
	@RequestMapping(value="/index")
	public String chamaIndex() {
		return "public/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/criarTicket", method=RequestMethod.POST)
	public void criarTicket(@RequestBody Ticket ticket, HttpServletRequest request) {
	
		System.out.println();
		
		
		
		
		System.out.println(new Gson().toJson(ticket));
		
		/*IControllerTicket ctrTicket = context.getBean("controllerTicket", ControllerTicket.class);
		
		try {
			ctrTicket.cadastrar(ticket);
		} catch (ControllerException e) {
			e.printStackTrace();
		}*/
		
	}
	
	@RequestMapping(value="/pesquisarTicket")
	public void pesquisarTicket(@RequestBody Ticket ticket) {
		System.out.println("pesquisar");
	}
	
	@RequestMapping(value="/alterarTicket")
	public void alterarTicket(@RequestBody Ticket ticket) {
		System.out.println("alterar");
		
	}
	
	@RequestMapping(value="/removerTicket")
	public void removerTicket(@RequestBody Ticket ticket) {
		System.out.println("remover");
		
	}
	
}
