package cn.hg.constant;

public enum PictureType implements ConstantGenerator.Constant {
	BANJIN(1,"钣金车间"),BAOZHUANG(2,"包装车间"),DIAOKE(3,"包装车间"),DIAOZHUANG(4,"吊装车间"),
	JIGUANGDIAOKE(5,"激光雕刻车间"),JIGUANGQIEGE(6,"激光切割车间"),PENYIN(7,"喷印车间"),
	ZHIZI(8,"制字车间"),ZUZHUANG(9,"组装车间"),SHEJISHIWUSUO(10,"设计事务所");
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
