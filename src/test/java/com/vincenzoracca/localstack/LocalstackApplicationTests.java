package com.vincenzoracca.localstack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(LocalStackConfiguration.class)
class LocalstackApplicationTests {

	@Test
	void contextLoads() {
	}

}
