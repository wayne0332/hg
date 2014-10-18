package cn.hg.pojo;

import cn.hg.constant.ManagerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
	public Integer id;
	public String name;
	public String password;
	public ManagerType type;
}
