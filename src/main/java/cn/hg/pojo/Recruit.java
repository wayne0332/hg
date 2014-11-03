package cn.hg.pojo;

import java.sql.Timestamp;

import org.joda.time.DateTime;

import cn.hg.constant.PictureType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
	public Integer id;
	public String position;
	public Integer require_count;
	public String location;
	public String ability;
	public String education;
	public String salary;
	public Integer description_id;
	public DateTime begin_time;
	public DateTime end_time;
	public Timestamp time_stamp;
	
	public String description;
}
