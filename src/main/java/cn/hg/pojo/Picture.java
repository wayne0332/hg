package cn.hg.pojo;

import java.sql.Timestamp;

import cn.hg.constant.PictureType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
	public Integer id;
	public Integer group_id;
	public String name;
	public String path;
	public PictureType type;
	public Integer description_id;
	public Timestamp timestamp;
}
