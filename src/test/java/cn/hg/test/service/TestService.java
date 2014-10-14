package cn.hg.test.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class TestService {
    public void test(@NotNull String test) {
        System.out.println(test);
    }
}
