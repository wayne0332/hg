package cn.hg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cn.hg.jooq.tables.records.RecruitRecord;

@Component
public class PositionValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0)
	{
		return RecruitRecord.class.isAssignableFrom(arg0);  
	}

	@Override
	public void validate(Object arg0, Errors errors) 
	{
		RecruitRecord record = (RecruitRecord)arg0;
		ValidationUtils.rejectIfEmpty(errors, "requireCount", "","招聘人数需填入大于0的数字！");
		ValidationUtils.rejectIfEmpty(errors, "ability", "","任职条件不能为空！");
		ValidationUtils.rejectIfEmpty(errors, "position", "","职位名称不能为空！");
		
		if(null==record.getDescriptionId())
		{
			errors.rejectValue("descriptionId", null,"职位描述不能为空！");
		}
	}

}
