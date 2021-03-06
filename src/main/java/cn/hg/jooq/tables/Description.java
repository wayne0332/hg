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
public class Description extends org.jooq.impl.TableImpl<cn.hg.jooq.tables.records.DescriptionRecord> {

	private static final long serialVersionUID = -73783089;

	/**
	 * The singleton instance of <code>hg.description</code>
	 */
	public static final cn.hg.jooq.tables.Description DESCRIPTION = new cn.hg.jooq.tables.Description();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<cn.hg.jooq.tables.records.DescriptionRecord> getRecordType() {
		return cn.hg.jooq.tables.records.DescriptionRecord.class;
	}

	/**
	 * The column <code>hg.description.id</code>. 通用描述信息
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.DescriptionRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "通用描述信息");

	/**
	 * The column <code>hg.description.text</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.DescriptionRecord, java.lang.String> TEXT = createField("text", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "");

	/**
	 * The column <code>hg.description.type</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.DescriptionRecord, cn.hg.constant.ConstantGenerator.Constant> TYPE = createField("type", org.jooq.impl.SQLDataType.TINYINT, this, "", new cn.hg.extend.jooq.ConstantConverter(java.lang.Byte.class, cn.hg.constant.DescriptionType.class));

	/**
	 * Create a <code>hg.description</code> table reference
	 */
	public Description() {
		this("description", null);
	}

	/**
	 * Create an aliased <code>hg.description</code> table reference
	 */
	public Description(java.lang.String alias) {
		this(alias, cn.hg.jooq.tables.Description.DESCRIPTION);
	}

	private Description(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.DescriptionRecord> aliased) {
		this(alias, aliased, null);
	}

	private Description(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.DescriptionRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, cn.hg.jooq.Hg.HG, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<cn.hg.jooq.tables.records.DescriptionRecord, java.lang.Integer> getIdentity() {
		return cn.hg.jooq.Keys.IDENTITY_DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<cn.hg.jooq.tables.records.DescriptionRecord> getPrimaryKey() {
		return cn.hg.jooq.Keys.KEY_DESCRIPTION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<cn.hg.jooq.tables.records.DescriptionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<cn.hg.jooq.tables.records.DescriptionRecord>>asList(cn.hg.jooq.Keys.KEY_DESCRIPTION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public cn.hg.jooq.tables.Description as(java.lang.String alias) {
		return new cn.hg.jooq.tables.Description(alias, this);
	}

	/**
	 * Rename this table
	 */
	public cn.hg.jooq.tables.Description rename(java.lang.String name) {
		return new cn.hg.jooq.tables.Description(name, null);
	}
}
