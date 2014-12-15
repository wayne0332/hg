package cn.hg.controller;
import static org.springframework.transaction.TransactionDefinition.PROPAGATION_NESTED;

import java.util.HashMap;
import java.util.List;

import cn.hg.Constant.Param;
import cn.hg.constant.DescriptionType;
import cn.hg.constant.PictureType;
import cn.hg.jooq.tables.records.DescriptionRecord;
import cn.hg.jooq.tables.records.ManagerRecord;
import cn.hg.jooq.tables.records.MessageRecord;
import cn.hg.jooq.tables.records.PictureRecord;
import cn.hg.jooq.tables.records.RecruitRecord;
import cn.hg.pojo.Manager;
import cn.hg.validator.PositionValidator;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TransactionalRunnable;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static cn.hg.jooq.Tables.MANAGER;
import static cn.hg.jooq.tables.Description.DESCRIPTION;
import static cn.hg.jooq.tables.Picture.PICTURE;
import static cn.hg.jooq.tables.Recruit.RECRUIT;
import static cn.hg.jooq.tables.Message.MESSAGE;


@RestController
@RequestMapping("/manager")
public class ManagerController
{
	@Resource
	private DSLContext dsl;
	
	@Resource
	private DataSourceTransactionManager manager;
	
	@Resource
	private PositionValidator validator;

	@Resource
	private HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("back/login");
	}

	@RequestMapping(value = "/login", method =RequestMethod.POST)
	public ModelAndView login(Manager user)
	{
		ManagerRecord manager = dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal(user.getName())).and(MANAGER.PASSWORD.equal(user.getPassword())).fetchOne();
		if (manager != null)
		{
			session.setAttribute(Param.MANAGER, manager);
			return new ModelAndView("redirect:/manager/aboutUs").addObject(Param.MANAGER, manager);
		}
		return new ModelAndView("redirect:/manager/login");
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView main()
	{
		DescriptionRecord description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.TYPE.equal(DescriptionType.INTRODUCE)).fetchOne();
		return new ModelAndView("back/aboutUs").addObject("description", description).addObject(Param.MANAGER, session.getAttribute(Param.MANAGER));
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit()
	{
		return new ModelAndView("back/wysiwyg-editors");
	}
	
	@RequestMapping("/testInsert")
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView testInsert() 
	{
		dsl.insertInto(MANAGER).set(MANAGER.NAME, "test").set(MANAGER.PASSWORD, "test").execute();
		return new ModelAndView("main").addObject("test", dsl.selectFrom(MANAGER).where(MANAGER.NAME.equal("admin")).fetchOne(MANAGER.PASSWORD));
	}
	
	@RequestMapping(value = "/strength", method = RequestMethod.GET)
	public ModelAndView strength(String type)
	{
		PictureType pictureType = null;
        //默认进入‘钣金车间’
        if (null == type || "".equals(type)) 
        {
            type = "ST1";
        }
        pictureType = PictureType.GENERATOR.getByName(type);
        List<PictureRecord> picture_list = dsl.selectFrom(PICTURE).where(PICTURE.TYPE.eq(pictureType)).and(PICTURE.GROUP_ID.eq(Param.STREGTH_GROUP_ID)).fetchInto(PictureRecord.class);
        HashMap<String,String> descript_map = new HashMap<String,String>();
        for(PictureRecord record : picture_list)
        {
        	//查找对应的描述文字。真tm长
        	String descript = dsl.select(DESCRIPTION.TEXT).from(DESCRIPTION).where(DESCRIPTION.TYPE.eq(DescriptionType.PICTURE_DESCRIPTION)).and(DESCRIPTION.ID.eq(dsl.select(PICTURE.DESCRIPTION_ID).from(PICTURE).where(PICTURE.ID.eq(record.getId())))).fetchOne(DESCRIPTION.TEXT);
        	descript_map.put(record.getId()+"", descript);
        }
        //查询所有栏目
        List<PictureRecord> picture_bar = dsl.selectFrom(PICTURE).where(PICTURE.GROUP_ID.eq(Param.STREGTH_GROUP_ID)).groupBy(PICTURE.TYPE).orderBy(PICTURE.TYPE).fetchInto(PictureRecord.class);
        return new ModelAndView("back/strength").addObject(Param.PICTURE_LIST, picture_list).addObject(Param.PICTURE_BAR,picture_bar).addObject(Param.STRENGTH_MAP,descript_map);
	}
	
	/*
	 * 进入社会招聘管理界面
	 */
	@RequestMapping(value="/joinus",method=RequestMethod.GET)
	public ModelAndView joinus(String type)
	{
	     List<RecruitRecord> recruit_list = dsl.selectFrom(RECRUIT).orderBy(RECRUIT.ID).fetchInto(RecruitRecord.class);
	        if (null == type || "".equals(type))
	        {
	            type = recruit_list.size() > 0 ? recruit_list.get(0).getId() + "" : 0 + "";
	        }
	        RecruitRecord recruitRecord = dsl.selectFrom(RECRUIT).where(RECRUIT.ID.eq(Integer.valueOf(type))).fetchOne();
	        String description = dsl.selectFrom(DESCRIPTION).where(DESCRIPTION.ID.eq(recruitRecord.getDescriptionId())).fetchOne().getText();
	        return new ModelAndView("back/joinus").addObject(Param.RECRUIT_LIST, recruit_list).addObject(Param.RECRUIT_RECORD, recruitRecord).addObject(Param.RECRUIT_DESCRIPTION, description).addObject("recruitRecord",recruitRecord);
	}
	
	/*
	 * 修改职位名称
	 */
	@RequestMapping(value="/joinus_position",method=RequestMethod.POST)
	public @ResponseBody String joinus_position(String id,String position)
	{
		int i = dsl.update(RECRUIT).set(RECRUIT.POSITION,position).where(RECRUIT.ID.eq(Integer.valueOf(id))).execute();
		return i>0?"scuess!":"failed!";
	}
	
	/*
	 * 进入添加招聘界面
	 */
	@RequestMapping(value="/joinus_add",method=RequestMethod.GET)
	public ModelAndView joinus_add_get(RecruitRecord recruitRecord)
	{
		return new ModelAndView("back/joinus_add").addObject("recruitRecord",recruitRecord);
	}
	
	/*
	 * 添加招聘（验证）
	 */
	@RequestMapping(value="/joinus_add",method=RequestMethod.POST)
	public ModelAndView joinus_add_post( @Valid RecruitRecord recruitRecord,String descriptionContent,String require_count,BindingResult result)
	{
		this.validator(recruitRecord, descriptionContent, require_count);
		this.validator.validate(recruitRecord, result);
		if(result.hasErrors())
		{
			return new ModelAndView("back/joinus_add").addObject("recruitRecord",recruitRecord).addObject("descriptionContent",descriptionContent);
		}
		int id = dsl.insertInto(DESCRIPTION,DESCRIPTION.TEXT , DESCRIPTION.TYPE).values(descriptionContent,DescriptionType.POSITION_DESCRIPTION).returning(DESCRIPTION.ID).fetchOne().getValue(DESCRIPTION.ID);
		recruitRecord.setDescriptionId(Integer.valueOf(id));
		dsl.insertInto(RECRUIT,RECRUIT.POSITION,RECRUIT.REQUIRE_COUNT,RECRUIT.ABILITY,RECRUIT.SALARY,RECRUIT.DESCRIPTION_ID,RECRUIT.APPLY).values(recruitRecord.getPosition(),recruitRecord.getRequireCount(),recruitRecord.getAbility(),recruitRecord.getSalary(),recruitRecord.getDescriptionId(),recruitRecord.getApply()).execute();
		return new ModelAndView("redirect:/manager/joinus");
	}
	
	/*
	 * 删除职位
	 */
	@RequestMapping(value="/joinus_delete",method=RequestMethod.POST)
	public @ResponseBody String  joinus_delete(String id)
	{
		int i = dsl.delete(RECRUIT).where(RECRUIT.ID.eq(Integer.valueOf(id))).execute();
		return i>0?"scuess!":"failed!";
	}
	
	/*
	 * 更新职位（验证）
	 */
	@RequestMapping(value="/joinus_update",method=RequestMethod.POST)
	public ModelAndView joinus_update( @Valid final RecruitRecord recruitRecord,final String descriptionContent,String require_count,BindingResult result)
	{
		this.validator(recruitRecord, descriptionContent, require_count);
		this.validator.validate(recruitRecord, result);
		if(result.hasErrors())
		{
			List<RecruitRecord> recruit_list = dsl.selectFrom(RECRUIT).orderBy(RECRUIT.ID).fetchInto(RecruitRecord.class);
			 return new ModelAndView("back/joinus").addObject("recruitRecord",recruitRecord).addObject("recruit_description",descriptionContent).addObject(Param.RECRUIT_LIST, recruit_list);
		}
		final TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition(PROPAGATION_NESTED));
		dsl.transaction(new TransactionalRunnable() {
			
			@Override
			public void run(Configuration configuration) throws Exception {
				// TODO Auto-generated method stub
				try
				{
				dsl.update(DESCRIPTION).set(DESCRIPTION.TEXT, descriptionContent).where(DESCRIPTION.ID.eq(recruitRecord.getDescriptionId())).execute();
				dsl.update(RECRUIT).set(RECRUIT.REQUIRE_COUNT, recruitRecord.getRequireCount()).set(RECRUIT.ABILITY,recruitRecord.getAbility()).set(RECRUIT.SALARY,recruitRecord.getSalary()).set(RECRUIT.APPLY,recruitRecord.getApply()).where(RECRUIT.ID.eq(recruitRecord.getId())).execute();
				}catch(Exception e)
				{
					manager.rollback(status);
					e.printStackTrace();
				}
				}
		});
		return new ModelAndView("redirect:/manager/joinus?type="+recruitRecord.getId());
	}
	
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public ModelAndView message()
	{
		List<MessageRecord> message = dsl.selectFrom(MESSAGE).fetchInto(MessageRecord.class);
		return new ModelAndView("back/message").addObject(Param.MESSAGE_LIST,message);
	}
	
	/*
	 * 社会招聘信息验证
	 */
	private void validator( RecruitRecord recruitRecord,String descriptionContent,String require_count)
	{
		//验证人数，需为数字，不能为空
		String reg = "^[1-9]*$";
		if(null==require_count||"".equals(require_count)||!require_count.matches(reg))
		{
			recruitRecord.setRequireCount(null);
		}else
		{
			recruitRecord.setRequireCount(Integer.valueOf(require_count));
		}
		//描述不能为空
		if(null!=descriptionContent&&!"".equals(descriptionContent)){
			recruitRecord.setDescriptionId(-1);
		}else{
			recruitRecord.setDescriptionId(null);
		}
	}
	
	/*
	 * 修改图片描述信息
	 */
	@RequestMapping(value="/update_description",method=RequestMethod.POST)
	public @ResponseBody String  update_description(final String id,String des_id,final String content)
	{
		//如果还没有描述信息，添加
		if(null==des_id||"".equals(des_id))
		{
			final TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition(PROPAGATION_NESTED));
			dsl.transaction(new TransactionalRunnable() {
				
				@Override
				public void run(Configuration configuration) throws Exception {
					// TODO Auto-generated method stub
					try
					{
					int	return_id = 	dsl.insertInto(DESCRIPTION).set(DESCRIPTION.TEXT, content).set(DESCRIPTION.TYPE, DescriptionType.PICTURE_DESCRIPTION).returning(DESCRIPTION.ID).fetchOne().getValue(DESCRIPTION.ID);
					dsl.update(PICTURE).set(PICTURE.DESCRIPTION_ID, return_id).where(PICTURE.ID.eq(Integer.valueOf(id))).execute();
					}catch(Exception e)
					{
						manager.rollback(status);
						e.printStackTrace();
					}
					}
			});
		}else
		{
			dsl.update(DESCRIPTION).set(DESCRIPTION.TEXT, content).where(DESCRIPTION.ID.eq(Integer.valueOf(des_id))).and(DESCRIPTION.TYPE.eq(DescriptionType.PICTURE_DESCRIPTION)).execute();
		}
		return "success!";
	}
	
	/*
	 * 删除图片
	 */
	@RequestMapping(value="/delete_img",method=RequestMethod.POST)
	public @ResponseBody String delete_img(final String id)
	{
		final TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition(PROPAGATION_NESTED));
		dsl.transaction(new TransactionalRunnable() {
			
			@Override
			public void run(Configuration configuration) throws Exception {
				// TODO Auto-generated method stub
				try
				{
					for(String eid : id.split(","))
					{
						dsl.delete(PICTURE).where(PICTURE.ID.eq(Integer.valueOf(eid))).execute();
					}
				}catch(Exception e)
				{
					manager.rollback(status);
					e.printStackTrace();
				}
				}
		});
	
		return "success!";
	}
}
