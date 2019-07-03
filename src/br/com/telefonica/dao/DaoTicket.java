package br.com.telefonica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.telefonica.entity.Ticket;

public class DaoTicket implements IDao<Ticket> {

	List<Ticket> listBd = new ArrayList<>();

	@Override
	public void criar(Object ticket) throws DaoException {

		listBd.add((Ticket) ticket);

		/*
		 * Connection connection = ConnectionManager.getInstance().getConnection();
		 * 
		 * String query = "EXEC CriarTicket " + "Titulo=?," + "Descricao=?," + "Tipo=?,"
		 * + "Prioridade=?," + "UrlDoSistema=?," + "Sistema=?," + "DataObjetivo=?," +
		 * "AreaSolicitante=?," + "AreaDestinada=?," + "Gestor=?;";
		 * 
		 * try { PreparedStatement pstm = connection.prepareStatement(query);
		 * 
		 * pstm.setString(1, auxTicket.getTitulo()); pstm.setString(2,
		 * auxTicket.getDescricao()); pstm.setString(3, auxTicket.getTipo());
		 * pstm.setString(4, auxTicket.getPrioridade()); pstm.setString(5,
		 * auxTicket.getUrlDoSistema()); pstm.setString(6, auxTicket.getSistema());
		 * pstm.setDate(7, new java.sql.Date( auxTicket.getDataObjetivo().getTime()));
		 * pstm.setLong(8,auxTicket.getAreaSolicitante().getCodigo());
		 * pstm.setLong(9,auxTicket.getAreaDestinada().getCodigo());
		 * pstm.setLong(10,auxTicket.getGestor().getCodigo());
		 * 
		 * pstm.executeUpdate(); } catch (SQLException e) { new DaoException();
		 * e.printStackTrace(); }
		 */

	}

	@Override
	public List<Ticket> pesquisar(Object ticket) throws DaoException {

		Ticket auxTicket = (Ticket) ticket;
		List<Ticket> listResultados = new ArrayList<>();
		for (Ticket auxTicket1 : listBd) {

			if (auxTicket1.getTitulo().toLowerCase().contains(auxTicket.getTitulo().toLowerCase())) {
				listResultados.add(auxTicket1);
			}

		}
		/*
		 * Connection connection = ConnectionManager.getInstance().getConnection();
		 * List<Ticket> listResultados = new ArrayList<>(); ResultSet rsResultados;
		 * 
		 * String query = "EXEC PesquisarTicket " + "Titulo=?," + "Descricao=?," +
		 * "Tipo=?," + "Prioridade=?," + "UrlDoSistema=?," + "Sistema=?," +
		 * "DataObjetivo=?," + "AreaSolicitante=?," + "AreaDestinada=?," + "Gestor=?;";
		 * 
		 * try { PreparedStatement pstm = connection.prepareStatement(query);
		 * 
		 * pstm.setString(1, auxTicket.getTitulo()); pstm.setString(2,
		 * auxTicket.getDescricao()); pstm.setString(3, auxTicket.getTipo());
		 * pstm.setString(4, auxTicket.getPrioridade()); pstm.setString(5,
		 * auxTicket.getUrlDoSistema()); pstm.setString(6, auxTicket.getSistema());
		 * pstm.setDate(7, new java.sql.Date( auxTicket.getDataObjetivo().getTime()));
		 * pstm.setLong(8,auxTicket.getAreaSolicitante().getCodigo());
		 * pstm.setLong(9,auxTicket.getAreaDestinada().getCodigo());
		 * pstm.setLong(10,auxTicket.getGestor().getCodigo());
		 * 
		 * rsResultados = pstm.executeQuery();
		 * 
		 * 
		 * listResultados = resultSetToList(rsResultados);
		 * 
		 * } catch (SQLException e) { new DaoException(); e.printStackTrace(); }
		 */

		return listResultados;
	}

	/*private List<Ticket> resultSetToList(ResultSet rsResultados) throws SQLException {

		List<Ticket> listResultados = new ArrayList<>();

		while (rsResultados.next()) {

			Ticket auxTicket = new Ticket();

			auxTicket.setTitulo(rsResultados.getString("numero"));
			auxTicket.setTitulo(rsResultados.getString("titulo"));
			auxTicket.setTitulo(rsResultados.getString("descricao"));
			auxTicket.setTitulo(rsResultados.getString("tipo"));
			auxTicket.setTitulo(rsResultados.getString("prioridade"));
			auxTicket.setTitulo(rsResultados.getString("urlDoSistema"));
			auxTicket.setTitulo(rsResultados.getString("sistema"));
			auxTicket.setTitulo(rsResultados.getString("dataObjetivo"));
			auxTicket.setTitulo(rsResultados.getString("areaSolicitante"));
			auxTicket.setTitulo(rsResultados.getString("areaDestinada"));
			auxTicket.setTitulo(rsResultados.getString("gestor"));

			listResultados.add(auxTicket);

		}

		return listResultados;
	}*/

	@Override
	public void atualizar(Object ticketSelecionado, Object ticket) throws DaoException {

		Ticket auxTicketSelecionado = (Ticket) ticketSelecionado;
		Ticket auxTicket = (Ticket) ticket;

		Connection connection = ConnectionManager.getInstance().getConnection();

		String query = "EXEC AtualizarTicket " + "Titulo=?," + "Descricao=?," + "Tipo=?," + "Prioridade=?,"
				+ "UrlDoSistema=?," + "Sistema=?," + "DataObjetivo=?," + "AreaSolicitante=?," + "AreaDestinada=?,"
				+ "Gestor=?," + "Numero=?;";

		try {
			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, auxTicket.getTitulo());
			pstm.setString(2, auxTicket.getDescricao());
			pstm.setString(3, auxTicket.getTipo());
			pstm.setString(4, auxTicket.getPrioridade());
			pstm.setString(5, auxTicket.getUrlDoSistema());
			pstm.setString(6, auxTicket.getSistema());
			pstm.setDate(7, new java.sql.Date(auxTicket.getDataObjetivo().getTime()));
			pstm.setLong(8, auxTicket.getAreaSolicitante().getCodigo());
			pstm.setLong(9, auxTicket.getAreaDestinada().getCodigo());
			pstm.setLong(10, auxTicket.getGestor().getCodigo());
			pstm.setLong(11, auxTicketSelecionado.getNumero());

			pstm.executeUpdate();
		} catch (SQLException e) {
			new DaoException();
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Object ticket) throws DaoException {

		Ticket auxTicket = (Ticket) ticket;

		Connection connection = ConnectionManager.getInstance().getConnection();

		String query = "EXEC DeletarTicket " + "Codigo=?;";

		try {
			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setLong(1, auxTicket.getNumero());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// new DaoException();
			e.printStackTrace();
		}

	}

}
