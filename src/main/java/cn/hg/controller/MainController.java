package cn.hg.controller;

import cn.hg.Constant.Param;
import cn.hg.constant.DescriptionType;
import cn.hg.constant.GroupType;
import cn.hg.constant.MessageStatus;
import cn.hg.constant.PictureType;
import cn.hg.jooq.tables.records.DescriptionRecord;
import cn.hg.jooq.tables.records.GroupRecord;
import cn.hg.jooq.tables.records.PictureRecord;
import cn.hg.jooq.tables.records.RecruitRecord;
import cn.hg.pojo.Message;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static cn.hg.jooq.tables.Description.DESCRIPTION;
import static cn.hg.jooq.tables.Group.GROUP;
import static cn.hg.jooq.tables.Message.MESSAGE;
import static cn.hg.jooq.tables.Picture.PICTURE;
import static cn.hg.jooq.tables.Recruit.RECRUIT;

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
        for (int i = 17; i < 25; i++) 
        {
            PictureType pt = PictureType.GENERATOR.getByIndex(i);
            List<PictureRecord> pl = dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pt)).and(PICTURE.GROUP_ID.eq(Param.LOGO_GROUP_ID)).fetchInto(PictureRecord.class);
            picture_bag.add(pl);
        }
        //实力展示轮播图片
        List<PictureRecord> picture_list = dsl.selectFrom(PICTURE).where(PICTURE.GROUP_ID.eq(Param.STREGTH_GROUP_ID)).fetchInto(PictureRecord.class);
        return new ModelAndView("fore/index").addObject("description", description).addObject(Param.PICTURE_BAG, picture_bag).addObject(Param.PICTURE_LIST, picture_list);
    }

    @RequestMapping("aboutus")
    public ModelAndView aboutus() 
    {
        DescriptionRecord description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.TYPE.equal(DescriptionType.INTRODUCE)).fetchOne();
        return new ModelAndView("fore/aboutus").addObject("description", description);
    }

    @RequestMapping(value="/img/{t_path}", method = RequestMethod.GET)
    public ModelAndView strength(Integer type,@PathVariable String t_path) 
    {
    	//查询所有栏目
		List<GroupRecord> group_id_list = null ;
		if(t_path.equals("strength"))
		{
			group_id_list = dsl.selectFrom(GROUP).where(GROUP.NAME.isNotNull()).and(GROUP.NAME.ne("")).and(GROUP.TYPE.eq(GroupType.STRENGTH)).fetchInto(GroupRecord.class);
		}
		if(t_path.equals("case"))
		{
			group_id_list = dsl.selectFrom(GROUP).where(GROUP.NAME.isNotNull()).and(GROUP.NAME.ne("")).and(GROUP.TYPE.eq(GroupType.CASE)).fetchInto(GroupRecord.class);
		}
        Map<String,String> picture_bar = new LinkedHashMap<String,String>();
        for(GroupRecord groupRecord :group_id_list )
        {
        	String name = groupRecord.getName();
        	if(name!=null&&!name.equals(""))
        	{
        		picture_bar.put(groupRecord.getId()+"", name);
        	}
        }
        if (null == type ) 
        {
            type = Integer.valueOf(picture_bar.keySet().iterator().next());
        }
        List<PictureRecord> picture_list = dsl.selectFrom(PICTURE).where(PICTURE.GROUP_ID.eq(type)).fetchInto(PictureRecord.class);
        HashMap<String,String> descript_map = new HashMap<String,String>();
        for(PictureRecord record : picture_list)
        {
        	//查找对应的描述文字。
        	String descript = dsl.select(DESCRIPTION.TEXT).from(DESCRIPTION).where(DESCRIPTION.TYPE.eq(DescriptionType.PICTURE_DESCRIPTION)).and(DESCRIPTION.ID.eq(dsl.select(PICTURE.DESCRIPTION_ID).from(PICTURE).where(PICTURE.ID.eq(record.getId())))).fetchOne(DESCRIPTION.TEXT);
        	descript_map.put(record.getId()+"", descript==null?"":descript);
        }
        return new ModelAndView("fore/strength").addObject(Param.PICTURE_LIST, picture_list).addObject(Param.PICTURE_BAR,picture_bar).addObject(Param.STRENGTH_MAP,descript_map).addObject("img_name",picture_bar.get(type+"")).addObject("i_path",t_path);
	
    }
   
    @RequestMapping("contact")
    public ModelAndView contact() 
    {
        return new ModelAndView("fore/contact");
    }

    @RequestMapping("joinus")
    public ModelAndView joinus(String type) 
    {
        List<RecruitRecord> recruit_list = dsl.selectFrom(RECRUIT).orderBy(RECRUIT.ID).fetchInto(RecruitRecord.class);
        if (null == type || "".equals(type))
        {
            type = recruit_list.size() > 0 ? recruit_list.get(0).getId() + "" : 0 + "";
        }
        RecruitRecord recruitRecord = dsl.selectFrom(RECRUIT).where(RECRUIT.ID.eq(Integer.valueOf(type))).fetchOne();
        String description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.ID.eq(recruitRecord.getDescriptionId())).fetchOne().getText();
        return new ModelAndView("fore/joinus").addObject(Param.RECRUIT_LIST, recruit_list).addObject(Param.RECRUIT_RECORD, recruitRecord).addObject(Param.RECRUIT_DESCRIPTION, description);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView message() 
    {
        return new ModelAndView("fore/message");
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ModelAndView message(Message message) 
    {
	    dsl.insertInto(MESSAGE).set(MESSAGE.NAME, message.getName()).set(MESSAGE.EMAIL, message.getEmail())
			    .set(MESSAGE.PHONE, message.getPhone()).set(MESSAGE.STATUS, MessageStatus.NOT_REPLAY)
			    .set(MESSAGE.CONTENT, message.getContent()).execute();
	    RedirectView redirectView = new RedirectView("/thanks");
	    redirectView.addStaticAttribute("name", message.getName());
	    return new ModelAndView(redirectView);
    }

    @RequestMapping(value = "/thanks", method = RequestMethod.GET)
    public ModelAndView thanks(String name) throws Exception
    {
        return new ModelAndView("fore/thanks").addObject("name", new String(name.getBytes("ISO-8859-1"),"UTF-8"));
    }
    
    @RequestMapping("client")
    public ModelAndView client()
    {
        //logo及logo图片
        List<List<PictureRecord>> picture_bag = new ArrayList<List<PictureRecord>>();
        for (int i = 17; i < 25; i++) 
        {
            PictureType pt = PictureType.GENERATOR.getByIndex(i);
            List<PictureRecord> pl = dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pt)).and(PICTURE.GROUP_ID.eq(Param.LOGO_GROUP_ID)).fetchInto(PictureRecord.class);
            picture_bag.add(pl);
        }
    	return new ModelAndView("fore/client").addObject(Param.PICTURE_BAG, picture_bag);
    }
}
