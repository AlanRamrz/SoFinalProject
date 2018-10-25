package com.finalso.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.finalso.dao.PartidosDao;
import com.finalso.dao.VpAlineacionesDao;
import com.finalso.data.Partidos;
import com.finalso.data.VpAlineaciones;

@Named
@ViewScoped
public class AlineacionesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5375832418897313052L;
	private String idPartido;
	private List<VpAlineaciones> alineacionLocal;
	private List<VpAlineaciones> alineacionVisitante;
	private boolean existePartido;
	private String equipoLocal;
	private String equipoVisitante;
	private String urlFoto;

	public AlineacionesBean() {
		System.out.println("Constructor de AlineacionesBean");
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		
		this.existePartido = false;
		this.idPartido = (String) map.get("id");
		this.alineacionLocal = new ArrayList<>();
		this.alineacionVisitante = new ArrayList<>();
		this.equipoLocal = "";
		this.equipoVisitante = "";
		this.urlFoto="";
		
		desplegarPartido();
	}

	public String getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}

	public List<VpAlineaciones> getAlineacionLocal() {
		return alineacionLocal;
	}

	public void setAlineacionLocal(List<VpAlineaciones> alineacionLocal) {
		this.alineacionLocal = alineacionLocal;
	}

	public List<VpAlineaciones> getAlineacionVisitante() {
		return alineacionVisitante;
	}

	public void setAlineacionVisitante(List<VpAlineaciones> alineacionVisitante) {
		this.alineacionVisitante = alineacionVisitante;
	}

	
	public boolean isExistePartido() {
		return existePartido;
	}

	public void setExistePartido(boolean existePartido) {
		this.existePartido = existePartido;
	}

	
	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	
	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
		System.out.println("El nuevo url es: "+urlFoto);
	}

	public void desplegarPartido() {
		PartidosDao dao = new PartidosDao();
		List<Partidos> lista = new ArrayList<>();
		
		lista = dao.obtenerPartido(this.idPartido);
		
		if(lista.isEmpty()) {
			System.out.println("El partido no existe");
			this.existePartido = false;
		}
		else {
			System.out.println("El partido si existe.");
			this.existePartido = true;
			obtenerAlineaciones(lista.get(0));
		}
	}
	
	public void obtenerAlineaciones(Partidos partido) {
		VpAlineacionesDao dao = new VpAlineacionesDao();
		
		this.equipoLocal = partido.getEquipoLocal();
		this.equipoVisitante = partido.getEquipoVisitante();
		
		this.alineacionLocal = dao.getAlineacionesPartido(partido.getId(), "Local");
		this.alineacionVisitante = dao.getAlineacionesPartido(partido.getId(), "Visitante");
	}
}
