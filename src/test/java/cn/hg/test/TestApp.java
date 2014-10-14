package cn.hg.test;

import cn.hg.test.service.TestService;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static cn.hg.jooq.Tables.MANAGER;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml", "classpath:spring-database.xml"})
public class TestApp
{
    @Resource
    private DSLContext dsl;

    @Resource
    private TestService testService;

    @Test
    public void testQuery() {
        System.out.println(dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal("admin")).fetchOne().getName());
    }

    @Test
    public void testParam() {
        testService.test("test");
        testService.test(null);
    }
}
