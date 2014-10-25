package cn.hg.constant;

public enum ConfigType implements ConstantGenerator.Constant {
	;
	private final int index;
	private final String name;
	public static final ConstantGenerator<ConfigType> GENERATOR = ConstantGenerator.create(ConfigType.class);

	ConfigType(int index, String name) {
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
