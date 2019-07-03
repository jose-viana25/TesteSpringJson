package br.com.telefonica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.telefonica.entity.Ticket;

@Controller
public class ControllerPublic {
	
	@RequestMapping(value="/index")
	public String chamaIndex() {
		return "public/index";
	}
	
	//@ResponseBody
	@RequestMapping(value="/criarTicket", method=RequestMethod.POST)
	public void criarTicket(@RequestBody Ticket ticket, HttpServletResponse response) {
		
		IControllerTicket ctrTicket = new ControllerTicket();
		
		try {
			ctrTicket.cadastrar(ticket);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
		
		response.setStatus(200);
		
	}
	
	
	//@RequestMapping(value="/pesquisarTicket", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	/*@ResponseBody
	public List<Ticket> pesquisarTicket(@RequestBody Ticket ticket, HttpServletResponse response) {
		
		IControllerTicket ctrTicket = new ControllerTicket();
		List<Ticket> listResultado = new ArrayList<>();
		try {
			listResultado = ctrTicket.pesquisar(ticket);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
		
		System.out.println(new Gson().toJson(listResultado));
		
		response.setStatus(200);
		return listResultado;
	}*/
	
	@RequestMapping(value="/alterarTicket")
	public void alterarTicket(@RequestBody Ticket ticket) {
		System.out.println("alterar");
		
	}
	
	@RequestMapping(value="/removerTicket")
	public void removerTicket(@RequestBody Ticket ticket) {
		System.out.println("remover");
		
	}
	
}
