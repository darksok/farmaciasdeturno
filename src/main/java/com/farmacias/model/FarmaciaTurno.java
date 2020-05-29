package com.farmacias.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class FarmaciaTurno {

	@JsonProperty(value = "fecha")
	String fecha;

	@JsonProperty(value = "local_id")
	String localId;

	@JsonProperty(value = "local_nombre")
	String localNombre;

	@JsonProperty(value = "comuna_nombre")
	String comunaNombre;

	@JsonProperty(value = "localidad_nombre")
	String localidadNombre;

	@JsonProperty(value = "local_direccion")
	String localDireccion;

	@JsonProperty(value = "funcionamiento_hora_apertura")
	String funcionamientoHoraApertura;

	@JsonProperty(value = "funcionamiento_hora_cierre")
	String funcionamientoHoraCierre;

	@JsonProperty(value = "local_telefono")
	String localTelefono;

	@JsonProperty(value = "local_lat")
	double localLat;

	@JsonProperty(value = "local_lng")
	double localLng;

	@JsonProperty(value = "funcionamiento_dia")
	String funcionamientoDia;

	@JsonProperty(value = "fk_region")
	int fkRegion;

	@JsonProperty(value = "fk_comuna")
	int fkComuna;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getLocalNombre() {
		return localNombre;
	}

	public void setLocalNombre(String localNombre) {
		this.localNombre = localNombre;
	}

	public String getComunaNombre() {
		return comunaNombre;
	}

	public void setComunaNombre(String comunaNombre) {
		this.comunaNombre = comunaNombre;
	}

	public String getLocalidadNombre() {
		return localidadNombre;
	}

	public void setLocalidadNombre(String localidadNombre) {
		this.localidadNombre = localidadNombre;
	}

	public String getLocalDireccion() {
		return localDireccion;
	}

	public void setLocalDireccion(String localDireccion) {
		this.localDireccion = localDireccion;
	}

	public String getFuncionamientoHoraApertura() {
		return funcionamientoHoraApertura;
	}

	public void setFuncionamientoHoraApertura(String funcionamientoHoraApertura) {
		this.funcionamientoHoraApertura = funcionamientoHoraApertura;
	}

	public String getFuncionamientoHoraCierre() {
		return funcionamientoHoraCierre;
	}

	public void setFuncionamientoHoraCierre(String funcionamientoHoraCierre) {
		this.funcionamientoHoraCierre = funcionamientoHoraCierre;
	}

	public String getLocalTelefono() {
		return localTelefono;
	}

	public void setLocalTelefono(String localTelefono) {
		this.localTelefono = localTelefono;
	}

	public double getLocalLat() {
		return localLat;
	}

	public void setLocalLat(double localLat) {
		this.localLat = localLat;
	}

	public double getLocalLng() {
		return localLng;
	}

	public void setLocalLng(double localLng) {
		this.localLng = localLng;
	}

	public String getFuncionamientoDia() {
		return funcionamientoDia;
	}

	public void setFuncionamientoDia(String funcionamientoDia) {
		this.funcionamientoDia = funcionamientoDia;
	}

	public int getFkRegion() {
		return fkRegion;
	}

	public void setFkRegion(int fkRegion) {
		this.fkRegion = fkRegion;
	}

	public int getFkComuna() {
		return fkComuna;
	}

	public void setFkComuna(int fkComuna) {
		this.fkComuna = fkComuna;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre de Local: " + this.getLocalNombre() + "\n");
		sb.append("Dirección :" + this.getLocalDireccion() + "\n");
		sb.append("Comuna :" + this.getFkComuna() + "\n");
		sb.append("Teléfono :" + this.getLocalDireccion() + "\n");
		sb.append("Latitud " + this.getLocalLat() + "\n");
		sb.append("Longitud " + this.getLocalLng() + "\n");
		return sb.toString();
	}

}