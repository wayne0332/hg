package cn.hg.controller;

import java.util.List;

import cn.hg.Constant.Param;
import cn.hg.constant.ConstantGenerator.Constant;
import cn.hg.constant.DescriptionType;
import cn.hg.constant.ManagerType;
import cn.hg.constant.PictureType;
import cn.hg.jooq.tables.records.DescriptionRecord;
import cn.hg.pojo.Picture;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import static cn.hg.jooq.tables.Description.DESCRIPTION;
import static cn.hg.jooq.tables.Picture.PICTURE;

@RestController
public class MainController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Resource
	private DSLContext dsl;

	@RequestMapping("")
	public ModelAndView index() {
		DescriptionRecord description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.TYPE.equal(DescriptionType.INTRODUCE)).fetchOne();
		return new ModelAndView("fore/index").addObject("description", description);
	}
	
	@RequestMapping("aboutus")
	public ModelAndView aboutus() {
		return new ModelAndView("fore/aboutus");
	}
	
	@RequestMapping("strength")
	public ModelAndView strength(String type) 
	{
		//默认进入‘钣金车间’
		if(null==type||"".equals(type))
		{
			type = "1";
		}
		PictureType pictureType = PictureType.valueOf("BANJIN");
		PictureType.GENERATOR.getByIndex(Integer.valueOf(type)).getIndex();
		//实力展示group_id默认为1
		Integer group_id = 1;
		List<Picture> picture_list =	dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pictureType)).and(PICTURE.GROUP_ID.eq(group_id)).fetchInto(Picture.class);
		//前台最多显示4张图片
		if(picture_list.size()>4)
		{
			picture_list = picture_list.subList(0, 3);
		}
		return new ModelAndView("fore/strength").addObject(Param.PICTURE_LIST, picture_list);
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
