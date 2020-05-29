package com.farmacias.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class FarmaciaTurnoResponse {

	@JsonProperty(value = "local_nombre")
	String localNombre;

	@JsonProperty(value = "local_direccion")
	String localDireccion;

	@JsonProperty(value = "comuna_nombre")
	String comunaNombre;

	@JsonProperty(value = "local_telefono")
	String localTelefono;

	@JsonProperty(value = "local_lat")
	double localLat;

	@JsonProperty(value = "local_lng")
	double localLng;

	public FarmaciaTurnoResponse(String localNombre, String localDireccion, String comunaNombre, String localTelefono,
			double localLat, double localLng) {
		this.setLocalNombre(localNombre);
		this.setLocalDireccion(localDireccion);
		this.setComunaNombre(comunaNombre);
		this.setLocalTelefono(localTelefono);
		this.setLocalLat(localLat);
		this.setLocalLng(localLng);
	}

	public FarmaciaTurnoResponse(FarmaciaTurno farmacia) {
		this(farmacia.getLocalNombre(), farmacia.getLocalDireccion(), farmacia.getComunaNombre(),
				farmacia.getLocalTelefono(), farmacia.getLocalLat(), farmacia.getLocalLng());
	}

	public String getLocalNombre() {
		return localNombre;
	}

	public void setLocalNombre(String localNombre) {
		this.localNombre = localNombre;
	}

	public String getLocalDireccion() {
		return localDireccion;
	}

	public void setLocalDireccion(String localDireccion) {
		this.localDireccion = localDireccion;
	}

	public String getComunaNombre() {
		return comunaNombre;
	}

	public void setComunaNombre(String comunaNombre) {
		this.comunaNombre = comunaNombre;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre de Local: " + this.getLocalNombre() + "\n");
		sb.append("Dirección :" + this.getLocalDireccion() + "\n");
		sb.append("Comuna :" + this.getComunaNombre() + "\n");
		sb.append("Teléfono :" + this.getLocalDireccion() + "\n");
		sb.append("Latitud " + this.getLocalLat() + "\n");
		sb.append("Longitud " + this.getLocalLng() + "\n");
		return sb.toString();
	}

}