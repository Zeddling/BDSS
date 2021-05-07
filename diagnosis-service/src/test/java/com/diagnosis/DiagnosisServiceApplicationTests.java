package com.diagnosis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.diagnosis.model.Diagnosis;
import com.diagnosis.service.DiagnosisService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = {"spring.cloud.discovery.enabled = false"})
@TestMethodOrder(OrderAnnotation.class)
class DiagnosisServiceApplicationTests {

	@Autowired
	DiagnosisService diagnosisService;

	@Autowired
	WebTestClient webTestClient;

	private final static UUID testUid = UUID.randomUUID();

	@Test	//	test save diagnosis
	@Order(1)
	public void testSaveDiagnosis() {
		List<Diagnosis> diagnosisList = new ArrayList<>();
		Diagnosis diagnosis = new Diagnosis("Janete Doe", "10345578", "LEFT", "MLO", "mass", "round", "obscured", "comments");
		diagnosis.setDiagnosisId(testUid);
		diagnosisList.add(new Diagnosis("Janice Doe", "12345678", "RIGHT", "CC", "mass", "irregular", "obscured", "comments"));
		diagnosisList.add(new Diagnosis("Janice Doe", "12345678", "RIGHT", "CC", "mass", "irregular", "spiculated", "comments"));
		diagnosisList.add(diagnosis);
		diagnosisList.add(new Diagnosis("Lidfhu Doe", "54676879", "LEFT", "MLO", "mass", "irregular", "ill_defined", "comments"));

		//	Test insertion of each instance
		for(Diagnosis item: diagnosisList){
			webTestClient.post().uri("/diagnosis")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(item), Diagnosis.class)
				.exchange()
				.expectStatus().isCreated()				//	expect 201 response
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.diagnosisId").isNotEmpty()
				.jsonPath("$.diagnosisDate").isNotEmpty();
		}
	}

	@Test	//	find all diagnosis by id number
	@Order(2)
	public void testFindAllByIdNumber() {
		webTestClient.get().uri("/diagnosis/idNumber/12345678")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBodyList(Diagnosis.class);
	}

	@Test
	@Order(3)
	public void testFindDiagnosisByDiagnosisId() {
		StringBuilder uri = new StringBuilder("/diagnosis/diagnosisId/");
		uri.append(testUid);
		webTestClient.get().uri(uri.toString())
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON)
			.expectBody();
	}

	@Test
	@Order(4)
	public void testDeleteByDiagnosisId() {
		StringBuilder uri = new StringBuilder("/diagnosis/");
		uri.append(testUid);
		webTestClient.delete().uri(uri.toString())
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk();
	}

}
