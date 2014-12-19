package cn.hg.constant;

public enum GroupType   implements ConstantGenerator.Constant {
	STRENGTH(1, "实力展示"),CASE(2,"真实案例");
	private final int index;
	private final String name;
	public static final ConstantGenerator<GroupType> GENERATOR = ConstantGenerator.create(GroupType.class);
	
	GroupType(int index, String name) {
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
