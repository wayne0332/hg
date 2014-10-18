package cn.hg.test.service;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class TestService {
	@Test
	public void test(@NotNull String test) {
        System.out.println(test);
    }

	@Test
	public void testProxy() {
		System.out.println("testProxy");
		test("test");
	}
}
