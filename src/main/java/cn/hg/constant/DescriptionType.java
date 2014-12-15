package cn.hg.constant;

public enum DescriptionType implements ConstantGenerator.Constant {
	INTRODUCE(0, "网站简介"),POSITION_DESCRIPTION(1,"职位描述"),PICTURE_DESCRIPTION(2,"图片描述");
	private final int index;
	private final String name;
	public static final ConstantGenerator<DescriptionType> GENERATOR = ConstantGenerator.create(DescriptionType.class);

	DescriptionType(int index, String name) {
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
