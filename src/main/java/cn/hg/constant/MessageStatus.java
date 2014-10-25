package cn.hg.constant;

public enum MessageStatus implements ConstantGenerator.Constant {
	;
	private final int index;
	private final String name;
	public static final ConstantGenerator<MessageStatus> GENERATOR = ConstantGenerator.create(MessageStatus.class);

	MessageStatus(int index, String name) {
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
