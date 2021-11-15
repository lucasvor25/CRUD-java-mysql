package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.AgendaDAO;
import br.com.agenda.model.Agenda;

public class Main {

	public static void main(String[] args) {
		
	AgendaDAO agendaDao = new AgendaDAO();	
		
	Agenda agenda = new Agenda();
	agenda.setNome("Vitor Ramos");
	agenda.setId(55);
	agenda.setDataCadastro(new Date());
	
	agendaDao.save(agenda);

	}

}
