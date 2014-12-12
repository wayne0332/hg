package cn.hg.constant;

public enum GroupSub_type  implements ConstantGenerator.Constant {
	INTRODUCE(0, "网站简介"),POSITION_DESCRIPTION(1,"职位描述");
	private final int index;
	private final String name;
	public static final ConstantGenerator<GroupSub_type> GENERATOR = ConstantGenerator.create(GroupSub_type.class);
	
	GroupSub_type(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
