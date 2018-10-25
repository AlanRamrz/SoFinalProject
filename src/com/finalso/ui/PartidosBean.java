package com.finalso.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.finalso.dao.PartidosDao;
import com.finalso.data.Partidos;

@Named
@RequestScoped
public class PartidosBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3574020427157307830L;
	private List<Partidos> listaPartidos;
	
	public PartidosBean() {
		System.out.println("Constructor de Partidos Bean");
		this.listaPartidos = new ArrayList<>();
		obtenerPartidos();
	}

	public List<Partidos> getListaPartidos() {
		return listaPartidos;
	}

	public void setListaPartidos(List<Partidos> listaPartidos) {
		this.listaPartidos = listaPartidos;
	}
	
	public void obtenerPartidos() {
		PartidosDao dao = new PartidosDao();
		
		this.listaPartidos = dao.getPartidos();
	}
	
}
