/**
 * This class is generated by jOOQ
 */
package cn.hg.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DealIdsRecord extends org.jooq.impl.TableRecordImpl<cn.hg.jooq.tables.records.DealIdsRecord> implements org.jooq.Record1<java.lang.Integer> {

	private static final long serialVersionUID = 1430274155;

	/**
	 * Setter for <code>test.deal_ids.deal_id</code>.
	 */
	public void setDealId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>test.deal_ids.deal_id</code>.
	 */
	public java.lang.Integer getDealId() {
		return (java.lang.Integer) getValue(0);
	}

	// -------------------------------------------------------------------------
	// Record1 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.Integer> fieldsRow() {
		return (org.jooq.Row1) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.Integer> valuesRow() {
		return (org.jooq.Row1) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return cn.hg.jooq.tables.DealIds.DEAL_IDS.DEAL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getDealId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DealIdsRecord value1(java.lang.Integer value) {
		setDealId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DealIdsRecord values(java.lang.Integer value1) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DealIdsRecord
	 */
	public DealIdsRecord() {
		super(cn.hg.jooq.tables.DealIds.DEAL_IDS);
	}

	/**
	 * Create a detached, initialised DealIdsRecord
	 */
	public DealIdsRecord(java.lang.Integer dealId) {
		super(cn.hg.jooq.tables.DealIds.DEAL_IDS);

		setValue(0, dealId);
	}
}