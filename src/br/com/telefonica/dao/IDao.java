package br.com.telefonica.dao;

import java.util.List;

public interface IDao<E> {

	public void criar(Object ticket) throws DaoException;
	
	public List<E> pesquisar(Object ticket) throws DaoException;
	
	public void atualizar(Object ticketSelecionado,Object ticket) throws DaoException;
	
	public void remover(Object ticket) throws DaoException;
	
	
	
}
