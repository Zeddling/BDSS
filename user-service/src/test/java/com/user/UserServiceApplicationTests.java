package com.user;

import com.user.model.User;
import com.user.service.UserService;

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
class UserServiceApplicationTests {	//	Test API endpoints

	@Autowired
	UserService userService;

	@Autowired
	WebTestClient webTestClient;

	@Test	//	Test register user endpoint
	@Order(1)
	public void testRegisterUser() {
		User user = new User("jd103", "john@email.com", "+254712345678");

		webTestClient.post().uri("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(user), User.class)		//	post user
				.exchange()
				.expectStatus().isCreated()				//	expect 201 response
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.id").isNotEmpty()			//	ensure id was created
				.jsonPath("$.localDate").isNotEmpty()	//	ensure local date was created
				.jsonPath("$.username").isEqualTo("jd103")	//	check username
				.jsonPath("$.emailAddress").isEqualTo("john@email.com")
				.jsonPath("$.phoneNumber").isEqualTo("+254712345678");
	}

	@Test	//	Test find user by email endpoint
	@Order(2)
	public void testFindUserByUsername(){
		webTestClient.get().uri("/user/jd103")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.id").isNotEmpty()			//	ensure id was created
				.jsonPath("$.localDate").isNotEmpty()	//	ensure local date was created
				.jsonPath("$.username").isEqualTo("jd103")	//check username
				.jsonPath("$.emailAddress").isEqualTo("john@email.com")	//	check email
				.jsonPath("$.phoneNumber").isEqualTo("+254712345678");	//	check phone number
	}

	@Test	//	Test if delete user is ok
	@Order(3)
	public void testDeleteByUsername() {
		webTestClient.delete().uri("/user/jd103")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk();
	}

}
