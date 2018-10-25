package com.finalso.data;
// Generated 06-may-2018 8:19:03 by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VpAlineacionesId generated by hbm2java
 */
@Entity
@Table(name = "vp_alineaciones", catalog = "mlb")
public class VpAlineaciones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 195099935952624787L;
	private int id;
	private String idPartido;
	private String claveJugador;
	private Integer idPosicion;
	private String equipo;
	private String nombre;
	private String urlFoto;
	private String posicion;

	public VpAlineaciones() {
	}

	@Id
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ID_partido", length = 100)
	public String getIdPartido() {
		return this.idPartido;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}

	@Column(name = "Clave_jugador", length = 100)
	public String getClaveJugador() {
		return this.claveJugador;
	}

	public void setClaveJugador(String claveJugador) {
		this.claveJugador = claveJugador;
	}

	@Column(name = "ID_posicion")
	public Integer getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(Integer idPosicion) {
		this.idPosicion = idPosicion;
	}

	@Column(name = "Equipo", length = 100)
	public String getEquipo() {
		return this.equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Column(name = "Nombre", length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Url_foto", length = 100)
	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@Column(name = "Posicion", length = 100)
	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
