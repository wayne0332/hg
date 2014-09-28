package cn.hg.controller;

import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import static cn.hg.jooq.tables.Test.TEST;

@RestController
public class MainController
{
	@Resource
	DSLContext dsl;

	@RequestMapping("/")
	public ModelAndView main()
	{
		return new ModelAndView("main").addObject("test", dsl.select(TEST.NAME).from(TEST).fetchOne().value1());
	}
}
