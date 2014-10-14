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
public class Config extends org.jooq.impl.TableImpl<cn.hg.jooq.tables.records.ConfigRecord> {

	private static final long serialVersionUID = 1584044261;

	/**
	 * The singleton instance of <code>hg.config</code>
	 */
	public static final cn.hg.jooq.tables.Config CONFIG = new cn.hg.jooq.tables.Config();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<cn.hg.jooq.tables.records.ConfigRecord> getRecordType() {
		return cn.hg.jooq.tables.records.ConfigRecord.class;
	}

	/**
	 * The column <code>hg.config.id</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>hg.config.name</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.ConfigRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>hg.config.type</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Byte> TYPE = createField("type", org.jooq.impl.SQLDataType.TINYINT, this, "");

	/**
	 * The column <code>hg.config.content</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.ConfigRecord, java.lang.String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR.length(250), this, "");

	/**
	 * The column <code>hg.config.description_id</code>.
	 */
	public final org.jooq.TableField<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Integer> DESCRIPTION_ID = createField("description_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>hg.config</code> table reference
	 */
	public Config() {
		this("config", null);
	}

	/**
	 * Create an aliased <code>hg.config</code> table reference
	 */
	public Config(java.lang.String alias) {
		this(alias, cn.hg.jooq.tables.Config.CONFIG);
	}

	private Config(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.ConfigRecord> aliased) {
		this(alias, aliased, null);
	}

	private Config(java.lang.String alias, org.jooq.Table<cn.hg.jooq.tables.records.ConfigRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, cn.hg.jooq.Hg.HG, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Integer> getIdentity() {
		return cn.hg.jooq.Keys.IDENTITY_CONFIG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<cn.hg.jooq.tables.records.ConfigRecord> getPrimaryKey() {
		return cn.hg.jooq.Keys.KEY_CONFIG_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<cn.hg.jooq.tables.records.ConfigRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<cn.hg.jooq.tables.records.ConfigRecord>>asList(cn.hg.jooq.Keys.KEY_CONFIG_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public cn.hg.jooq.tables.Config as(java.lang.String alias) {
		return new cn.hg.jooq.tables.Config(alias, this);
	}

	/**
	 * Rename this table
	 */
	public cn.hg.jooq.tables.Config rename(java.lang.String name) {
		return new cn.hg.jooq.tables.Config(name, null);
	}
}