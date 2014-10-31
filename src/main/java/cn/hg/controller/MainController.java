package cn.hg.controller;

import java.util.ArrayList;
import java.util.List;

import cn.hg.Constant.Param;
import cn.hg.constant.ConstantGenerator.Constant;
import cn.hg.constant.DescriptionType;
import cn.hg.constant.ManagerType;
import cn.hg.constant.PictureType;
import cn.hg.jooq.tables.records.DescriptionRecord;
import cn.hg.jooq.tables.records.PictureRecord;
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
	public ModelAndView index() 
	{
		//公司简介文字
		DescriptionRecord description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.TYPE.equal(DescriptionType.INTRODUCE)).fetchOne();
		//logo及logo图片
		List<List<PictureRecord>> picture_bag = new ArrayList<List<PictureRecord>>();
		for(int i =17;i<25;i++)
		{
			PictureType pt = PictureType.GENERATOR.getByIndex(i);
			List<PictureRecord> pl = dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pt)).and(PICTURE.GROUP_ID.eq(Param.LOGO_GROUP_ID)).fetchInto(PictureRecord.class);
			picture_bag.add(pl);
		}
		//实力展示轮播图片
		List<PictureRecord> picture_list = dsl.selectFrom(PICTURE).where(PICTURE.GROUP_ID.eq(Param.STREGTH_GROUP_ID)).fetchInto(PictureRecord.class);
		return new ModelAndView("fore/index").addObject("description", description).addObject(Param.PICTURE_BAG,picture_bag).addObject(Param.PICTURE_LIST,picture_list);
	}
	
	@RequestMapping("aboutus")
	public ModelAndView aboutus()
	{
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
		PictureType pictureType = PictureType.GENERATOR.getByIndex(Integer.valueOf(type));
		List<PictureRecord> picture_list =	dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pictureType)).and(PICTURE.GROUP_ID.eq(Param.STREGTH_GROUP_ID)).fetchInto(PictureRecord.class);
		//前台最多显示4张图片
		if(picture_list.size()>4)
		{
			picture_list = picture_list.subList(0, 3);
		}
		return new ModelAndView("fore/strength").addObject(Param.PICTURE_LIST, picture_list);
	}
	
	@RequestMapping("case")
	public ModelAndView cases(String type) {
		//真实案例，默认进入‘立体发光字工程’
		if(null==type||"".equals(type))
		{
			type="14";
		}
		PictureType pictureType = PictureType.GENERATOR.getByIndex(Integer.valueOf(type));
		List<PictureRecord> picture_list = dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pictureType)).and(PICTURE.GROUP_ID.eq(Param.CASE_GROUP_ID)).fetchInto(PictureRecord.class);
		return new ModelAndView("fore/case").addObject(Param.PICTURE_LIST, picture_list);
	}
	
	@RequestMapping("contact")
	public ModelAndView contact()
	{
		return new ModelAndView("fore/contact");
	}
	
	@RequestMapping("joinus")
	public ModelAndView joinus() 
	{
		return new ModelAndView("fore/joinus");
	}
}
