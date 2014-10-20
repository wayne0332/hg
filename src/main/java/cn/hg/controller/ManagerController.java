package cn.hg.controller;

import cn.hg.pojo.Manager;
import org.jooq.DSLContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static cn.hg.Constant.Param;
import static cn.hg.jooq.Tables.MANAGER;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Resource
	private DSLContext dsl;

	@Resource
	private HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("back/login");
	}

	@RequestMapping(value = "/login", method =RequestMethod.POST)
	public ModelAndView login(Manager user) {
		Manager manager = dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal(user.getName())).and(MANAGER.PASSWORD.equal(user.getPassword())).fetchOne().into(Manager.class);
		if (manager != null) {
			session.setAttribute(Param.MANAGER, manager);
			return new ModelAndView("redirect:/manager/main").addObject(Param.MANAGER, manager);
		}
		return new ModelAndView("redirect:/manager/login");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("back/main").addObject(Param.MANAGER, session.getAttribute(Param.MANAGER));
	}

	@RequestMapping("/testInsert")
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView test() {
		dsl.insertInto(MANAGER).set(MANAGER.NAME, "test").set(MANAGER.PASSWORD, "test").execute();
		return new ModelAndView("main").addObject("test", dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal("admin")).fetchOne(MANAGER.PASSWORD));
	}
}
