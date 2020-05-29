package com.farmacias.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.farmacias.model.FarmaciaTurno;
import com.farmacias.model.FarmaciaTurnoResponse;

@Component
public class FarmaciaTurnoService {

	private static FarmaciaTurnoService fts = null;
	private ArrayList<FarmaciaTurno> listFarmacias;

	/**
	 * Constructor por defecto, si es usado, es necesario llenar manualmente ellistado de farmacias por medio de la 
	 * invocación del metodo setListFarmacias()
	 */
	public FarmaciaTurnoService() {
		this.listFarmacias = new ArrayList<FarmaciaTurno>();
	}
	
	/**
	 * Constructor que recibe la url del servicioRest para obtener las farmacias de turno de Santiago
	 * @param urlRestService
	 */
	public FarmaciaTurnoService(String urlRestService) {
		this.listFarmacias = getAllFarmaciasFromRest(urlRestService);
	}
	
	/**
	 * Metodo para obtener una instancia del servicio
	 * @return
	 */
	public static FarmaciaTurnoService getInstance(String urlRestService) {
		if (fts == null)
			fts = new FarmaciaTurnoService(urlRestService);
		return fts;
	}

	/**
	 * Metodo para obtener las farmacias de turno que cumplen con la comuna y el
	 * nombre de local
	 * 
	 * @param comunaNombre
	 * @param localNombre
	 * @return
	 */
	public ArrayList<FarmaciaTurnoResponse> getFarmaciasByFilter( String comunaNombre, String localNombre) {
		ArrayList<FarmaciaTurnoResponse> filteredList = new ArrayList<FarmaciaTurnoResponse>();

		for (FarmaciaTurno farmacia : listFarmacias) {
			if (comunaNombre != null && localNombre != null && farmacia.getComunaNombre().equalsIgnoreCase(comunaNombre)
					&& farmacia.getLocalNombre().equalsIgnoreCase(localNombre))
				filteredList.add(new FarmaciaTurnoResponse(farmacia));

			else if (comunaNombre == null && localNombre != null
					&& farmacia.getLocalNombre().equalsIgnoreCase(localNombre))
				filteredList.add(new FarmaciaTurnoResponse(farmacia));

			else if (comunaNombre != null && localNombre == null
					&& farmacia.getComunaNombre().equalsIgnoreCase(comunaNombre))
				filteredList.add(new FarmaciaTurnoResponse(farmacia));
			else if (comunaNombre == null && localNombre == null)
				filteredList.add(new FarmaciaTurnoResponse(farmacia));
		}

		return filteredList;
	}

	/**
	 * Este metodo está encargado de conectarse al servicio rest para obtener todas las farmacias de turno
	 * de la region metropolitana y almacenarlas en la variable listFarmacias
	 * @return
	 */
	private ArrayList<FarmaciaTurno> getAllFarmaciasFromRest(String url) {	
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<FarmaciaTurno> listFarmacias = new ArrayList<FarmaciaTurno>();

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			Iterator<JsonNode> elements = root.elements();

			while (elements.hasNext()) {
				JsonNode node = elements.next();
				FarmaciaTurno farmacia = mapper.treeToValue(node, FarmaciaTurno.class);

				listFarmacias.add(farmacia);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listFarmacias;
	}

	public ArrayList<FarmaciaTurno> getListFarmacias() {
		return listFarmacias;
	}

	public void setListFarmacias(ArrayList<FarmaciaTurno> listFarmacias) {
		this.listFarmacias = listFarmacias;
	}

	
}