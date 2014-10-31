package cn.hg.constant;

public enum PictureType implements ConstantGenerator.Constant {
	BANJIN(1,"钣金车间"),BAOZHUANG(2,"包装车间"),DIAOKE(3,"包装车间"),DIAOZHUANG(4,"吊装车间"),
	JIGUANGDIAOKE(5,"激光雕刻车间"),JIGUANGQIEGE(6,"激光切割车间"),PENYIN(7,"喷印车间"),
	ZHIZI(8,"制字车间"),ZUZHUANG(9,"组装车间"),SHEJISHIWUSUO(10,"设计事务所"),
	
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
