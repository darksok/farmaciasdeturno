package com.farmacias.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FarmaciaTurnoServiceTests {

	private FarmaciaTurnoService fts;
	@Value("${farmacia.url}")
	private String farmaciasRestService;
	
	@Test
	public void contextLoad() throws Exception{
		assertThat(fts.getInstance(farmaciasRestService)).isNotNull();
	}
	
	@Test
	public void getFarmaciasByFilterTest() throws Exception{
		assertThat(fts.getInstance(farmaciasRestService).getFarmaciasByFilter(null, null)).isNotNull();
	}
}
