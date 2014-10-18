package cn.hg.constant;

public enum ManagerType implements ConstantGenerator.Constant {
	ADMIN(0, "超级管理员"), NORMAL(1, "普通管理员");
	private final int index;
	private final String name;
	public static final ConstantGenerator<ManagerType> GENERATOR = ConstantGenerator.create(ManagerType.class);

	ManagerType(int index, String name) {
		this.index = index;
		this.name = name;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public String getName() {
		return name;
	}
}
