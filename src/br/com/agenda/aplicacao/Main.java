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
	
	Agenda c1 = new Agenda();
	
	c1.setNome("Vitor Ramos Barbosa");
	c1.setId(56);
	c1.setDataCadastro(new Date());
	c1.setId(1);
	agendaDao.update(c1);
	
	agendaDao.deletarPorId(1);
	
	for(Agenda a: agendaDao.getAgendas()) {
		System.out.println("Contato: "+ a.getNome());
	}

	}

}
