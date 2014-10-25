package cn.hg.constant;

public enum PictureType implements ConstantGenerator.Constant {
	;
	private final int index;
	private final String name;
	public static final ConstantGenerator<PictureType> GENERATOR = ConstantGenerator.create(PictureType.class);

	PictureType(int index, String name) {
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
