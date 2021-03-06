/**
 * This class is generated by jOOQ
 */
package cn.hg.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Group extends org.jooq.impl.TableImpl<cn.hg.jooq.tables.records.GroupRecord> {

	private static final long serialVersionUID = 528568145;

	/**
	 * The singleton instance of <code>hg.group</code>
	 */
	public static final cn.hg.jooq.tables.Group GROUP = new cn.hg.jooq.tables.Group();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<cn.hg.jooq.tables.records.GroupRecord> getRecordType() {
		return cn.hg.jooq.tables.records.GroupRecord.class;
	}

	/**
	 * The column <code>hg.group.id</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>hg.group.name</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>hg.group.description_id</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, java.lang.Integer> DESCRIPTION_ID = createField("description_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>hg.group.time_stamp</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, java.sql.Timestamp> TIME_STAMP = createField("time_stamp", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>hg.group.type</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, cn.hg.constant.ConstantGenerator.Constant> TYPE = createField("type", org.jooq.impl.SQLDataType.TINYINT, this, "", new cn.hg.extend.jooq.ConstantConverter(java.lang.Byte.class, cn.hg.constant.GroupType.class));

	/**
	 * The column <code>hg.group.sub_type</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.GroupRecord, cn.hg.constant.ConstantGenerator.Constant> SUB_TYPE = createField("sub_type", org.jooq.impl.SQLDataType.TINYINT, this, "", new cn.hg.extend.jooq.ConstantConverter(java.lang.Byte.class, cn.hg.constant.GroupSub_type.class));

	/**
	 * Create a <code>hg.group</code> table reference
	 */
	public Group() {
		this("group", null);
	}

	/**
	 * Create an aliased <code>hg.group</code> table reference
	 */
	public Group(java.lang.String alias) {
		this(alias, cn.hg.jooq.tables.Group.GROUP);
	}

	private Group(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.GroupRecord> aliased) {
		this(alias, aliased, null);
	}

	private Group(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.GroupRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, cn.hg.jooq.Hg.HG, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<cn.hg.jooq.tables.records.GroupRecord, java.lang.Integer> getIdentity() {
		return cn.hg.jooq.Keys.IDENTITY_GROUP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<cn.hg.jooq.tables.records.GroupRecord> getPrimaryKey() {
		return cn.hg.jooq.Keys.KEY_GROUP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<cn.hg.jooq.tables.records.GroupRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<cn.hg.jooq.tables.records.GroupRecord>>asList(cn.hg.jooq.Keys.KEY_GROUP_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public cn.hg.jooq.tables.Group as(java.lang.String alias) {
		return new cn.hg.jooq.tables.Group(alias, this);
	}

	/**
	 * Rename this table
	 */
	public cn.hg.jooq.tables.Group rename(java.lang.String name) {
		return new cn.hg.jooq.tables.Group(name, null);
	}
}
