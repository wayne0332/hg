package cn.hg.controller;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class MainController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Resource
	private DSLContext dsl;

	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("fore/index");
	}
	
	@RequestMapping("aboutus")
	public ModelAndView aboutus() {
		return new ModelAndView("fore/aboutus");
	}
	
	@RequestMapping("strength")
	public ModelAndView strength() {
		return new ModelAndView("fore/strength");
	}
	
	@RequestMapping("case")
	public ModelAndView cases() {
		return new ModelAndView("fore/case");
	}
	
	@RequestMapping("contact")
	public ModelAndView contact() {
		return new ModelAndView("fore/contact");
	}
	
	@RequestMapping("joinus")
	public ModelAndView joinus() {
		return new ModelAndView("fore/joinus");
	}
	
	@RequestMapping("topbar")
	public ModelAndView topbar() {
		return new ModelAndView("fore/topbar");
	}
}
