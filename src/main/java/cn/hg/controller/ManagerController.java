package cn.hg.controller;
import static org.springframework.transaction.TransactionDefinition.PROPAGATION_NESTED;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.hg.Constant.Param;
import cn.hg.constant.DescriptionType;
import cn.hg.constant.GroupType;
import cn.hg.constant.PictureType;
import cn.hg.jooq.tables.Group;
import cn.hg.jooq.tables.records.DescriptionRecord;
import cn.hg.jooq.tables.records.GroupRecord;
import cn.hg.jooq.tables.records.ManagerRecord;
import cn.hg.jooq.tables.records.MessageRecord;
import cn.hg.jooq.tables.records.PictureRecord;
import cn.hg.jooq.tables.records.RecruitRecord;
import cn.hg.pojo.Manager;
import cn.hg.util.ImgUploadAndCompress;
import cn.hg.validator.PositionValidator;

import org.apache.commons.io.FileUtils;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TransactionalRunnable;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static cn.hg.jooq.Tables.MANAGER;
import static cn.hg.jooq.tables.Description.DESCRIPTION;
import static cn.hg.jooq.tables.Picture.PICTURE;
import static cn.hg.jooq.tables.Recruit.RECRUIT;
import static cn.hg.jooq.tables.Message.MESSAGE;
import static cn.hg.jooq.tables.Group.GROUP;



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
	
	@RequestMapping(value = "/img/{t_path}", method = RequestMethod.GET)
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
        return new ModelAndView("back/image").addObject(Param.PICTURE_LIST, picture_list).addObject(Param.PICTURE_BAR,picture_bar).addObject(Param.STRENGTH_MAP,descript_map).addObject("img_name",picture_bar.get(type+"")).addObject("img_key",type+"").addObject("t_path",t_path);
	}
	
	
	/*
	 * 修改和删除实力展示的bar
	 */
	@RequestMapping(value="/strength_update",method=RequestMethod.POST)
	public @ResponseBody String  strength_update(Integer id,String value)
	{
		 dsl.update(GROUP).set(GROUP.NAME, value==null?"":value).where(GROUP.ID.eq(id)).execute();
		if(value==null)
		{
		dsl.delete(PICTURE).where(PICTURE.GROUP_ID.eq(id)).execute();
		}
		return "scuess!";
	}
	/*
	 * 添加实力展示的bar
	 */
	@RequestMapping(value="/img_add/{t_path}",method=RequestMethod.POST)
	public @ResponseBody String  strength_add(String name,@PathVariable String t_path)
	{
		List<Integer> list = null;
		if(t_path.equals("strength"))
		{
			 list = dsl.selectFrom(GROUP).where(GROUP.NAME.eq("")).or(GROUP.NAME.isNull()).and(GROUP.TYPE.eq(GroupType.STRENGTH)).orderBy(GROUP.ID).fetch(GROUP.ID);
		}
		if(t_path.equals("case"))
		{
			 list = dsl.selectFrom(GROUP).where(GROUP.NAME.eq("")).or(GROUP.NAME.isNull()).and(GROUP.TYPE.eq(GroupType.CASE)).orderBy(GROUP.ID).fetch(GROUP.ID);
		}
		int i = dsl.update(GROUP).set(GROUP.NAME, name).where(GROUP.ID.eq(list.get(0))).execute();
		return i>0?"scuess!":"failed!";
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
	/*
	 * 上传图片
	 */
	@RequestMapping(value="/upload_img",method=RequestMethod.POST)
	public ModelAndView upload_img(String type,String pic_type,@RequestParam MultipartFile file,HttpServletRequest request)
	{
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		File ifile = new File(realPath, file.getOriginalFilename());
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),ifile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = upload(ifile, type, request.getSession().getServletContext().getRealPath("/"));
		dsl.insertInto(PICTURE).set(PICTURE.GROUP_ID, Integer.valueOf(pic_type)).set(PICTURE.PATH, path).execute();
		return new ModelAndView("redirect:/manager/img/"+type+"?type="+pic_type);
	}
	
	/*
	 * 服务客户
	 */
	@RequestMapping(value="/client",method=RequestMethod.GET)
	public ModelAndView client(String type)
	{
		return new ModelAndView("back/client");
	}
	
	/*
	 * 上传图片
	 */
	private String upload(File file,String type,String path)
	{
		ImgUploadAndCompress iuac = new ImgUploadAndCompress();
		return iuac.dealWithImg(file, type, 680, 600, true, path);
	}
}
