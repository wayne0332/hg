/**
 * This class is generated by jOOQ
 */
package cn.hg.jooq;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Hg extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -901031149;

	/**
	 * The singleton instance of <code>hg</code>
	 */
	public static final Hg HG = new Hg();

	/**
	 * No further instances allowed
	 */
	private Hg() {
		super("hhgg853478196");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			cn.hg.jooq.tables.Config.CONFIG,
			cn.hg.jooq.tables.Description.DESCRIPTION,
			cn.hg.jooq.tables.Example.EXAMPLE,
			cn.hg.jooq.tables.ExampleGroup.EXAMPLE_GROUP,
			cn.hg.jooq.tables.History.HISTORY,
			cn.hg.jooq.tables.Manager.MANAGER,
			cn.hg.jooq.tables.Message.MESSAGE,
			cn.hg.jooq.tables.Picture.PICTURE,
			cn.hg.jooq.tables.Recruit.RECRUIT);
	}
}
