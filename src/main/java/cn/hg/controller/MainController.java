package cn.hg.controller;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import static cn.hg.jooq.Tables.MANAGER;

@RestController
public class MainController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Resource
	private DSLContext dsl;

	@RequestMapping("/")
	public ModelAndView main()
	{
		LOGGER.info("test");
		return new ModelAndView("main").addObject("test", dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal("admin")).fetchOne(MANAGER.PASSWORD));
	}

    @RequestMapping("/testInsert")
    @Transactional(propagation = Propagation.REQUIRED)
    public ModelAndView test() {
	    dsl.insertInto(MANAGER).set(MANAGER.NAME, "test").set(MANAGER.PASSWORD, "test").execute();
        return new ModelAndView("main").addObject("test", dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal("admin")).fetchOne(MANAGER.PASSWORD));
    }
}
