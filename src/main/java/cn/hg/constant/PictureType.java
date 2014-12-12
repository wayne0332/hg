package cn.hg.constant;

public enum PictureType implements ConstantGenerator.Constant {
	//实力展示栏目提供10个类别
	ST1(1,"ST1"),ST2(2,"ST2"),ST3(3,"ST3"),ST4(4,"ST4"),
	ST5(5,"ST5"),ST6(6,"ST6"),ST7(7,"ST7"),
	ST8(8,"ST8"),ST9(9,"ST9"),ST10(10,"ST10"),
	
	BIAOSHIBIAOPAI(11,"标识标牌工程"),DAOSHIXITONG(12,"导视系统工程"),GUANGGAOPAI(13,"大型广告牌工程"),
	LITIFAGUANGZI(14,"立体发光字工程"),LOUPAN(15,"楼盘包装及工地围栏工程"),WAILIMIANDENGXIANG(16,"外立面灯箱工程"),
	
	//以下为首页8个logo位
	LOGO_1(17,"logo_1"),LOGO_2(18,"logo_2"),LOGO_3(19,"logo_3"),LOGO_4(20,"logo_4"),LOGO_5(21,"logo_5"),LOGO_6(22,"logo_6"),LOGO_7(23,"logo_7"),LOGO_8(24,"logo_8");
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
