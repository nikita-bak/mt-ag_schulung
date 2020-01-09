package de.rewe.schulungen.kasseclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class KasseServerApplicationTests {

	@Autowired
	MockMvc mockMvc;

	JacksonTester<Tankvorgang> tankvorgangJson;
	JacksonTester<Ventil> ventilJson;

	@BeforeEach
	void init() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	void contextLoads() {
	}

	@Test
	void KasseNeuerVorgangTest() throws Exception {
		Ventil ventil = new Ventil(1, KraftstoffArt.Super);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
					.post("/kasse/neuerVorgangAnlegen")
					.contentType(MediaType.APPLICATION_JSON)
					.content(ventilJson.write(ventil).getJson())
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		Tankvorgang tankvorgang = tankvorgangJson.parseObject(result.getResponse().getContentAsString());
		assertEquals(tankvorgang.säulenNummer, ventil.säulenNummer);
	}

	@Test
	void KasseAuftankenAbgeschlossenTest() throws Exception {

		BigDecimal preisProLiter = new BigDecimal(BigInteger.ONE);
		BigDecimal gesamtMenge = new BigDecimal(BigInteger.ONE);
		Tankvorgang tankvorgang = new Tankvorgang(1, preisProLiter, gesamtMenge); //Preis in

		mockMvc.perform(MockMvcRequestBuilders
				.put("/kasse/auftankenAbgeschlossen")
				.contentType(MediaType.APPLICATION_JSON)
				.content(tankvorgangJson.write(tankvorgang).getJson())
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
}
