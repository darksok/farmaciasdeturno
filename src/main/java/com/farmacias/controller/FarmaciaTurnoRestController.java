package com.farmacias.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farmacias.model.FarmaciaFilter;
import com.farmacias.model.FarmaciaTurnoResponse;
import com.farmacias.service.FarmaciaTurnoService;

@Controller
public class FarmaciaTurnoRestController {

	@Value("${farmacia.url}")
	private String farmaciasRestService;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/farmaciasturno")
	@ResponseBody
	public ArrayList<FarmaciaTurnoResponse> getFarmacias(@RequestBody FarmaciaFilter filter) {
		return FarmaciaTurnoService.getInstance(farmaciasRestService).getFarmaciasByFilter(filter.getComuna(),
				filter.getLocal());
	}
}
