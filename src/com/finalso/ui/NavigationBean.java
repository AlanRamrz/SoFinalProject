package com.finalso.ui;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NavigationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7567225887856357759L;
	private String contenido;
	
	public NavigationBean() {
		System.out.println("Constructor de Navigation Bean");
		this.contenido="subirArchivo.xhtml";
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
