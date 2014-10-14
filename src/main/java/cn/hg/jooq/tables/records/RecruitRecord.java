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
public class RecruitRecord extends org.jooq.impl.UpdatableRecordImpl<cn.hg.jooq.tables.records.RecruitRecord> implements org.jooq.Record11<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -350088803;

	/**
	 * Setter for <code>hg.recruit.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>hg.recruit.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>hg.recruit.position</code>.
	 */
	public void setPosition(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>hg.recruit.position</code>.
	 */
	public java.lang.String getPosition() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>hg.recruit.require_count</code>.
	 */
	public void setRequireCount(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>hg.recruit.require_count</code>.
	 */
	public java.lang.Integer getRequireCount() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>hg.recruit.location</code>.
	 */
	public void setLocation(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>hg.recruit.location</code>.
	 */
	public java.lang.String getLocation() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>hg.recruit.ability</code>.
	 */
	public void setAbility(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>hg.recruit.ability</code>.
	 */
	public java.lang.String getAbility() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>hg.recruit.education</code>.
	 */
	public void setEducation(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>hg.recruit.education</code>.
	 */
	public java.lang.String getEducation() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>hg.recruit.salary</code>.
	 */
	public void setSalary(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>hg.recruit.salary</code>.
	 */
	public java.lang.String getSalary() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>hg.recruit.description_id</code>.
	 */
	public void setDescriptionId(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>hg.recruit.description_id</code>.
	 */
	public java.lang.Integer getDescriptionId() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>hg.recruit.begin_time</code>.
	 */
	public void setBeginTime(java.sql.Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>hg.recruit.begin_time</code>.
	 */
	public java.sql.Timestamp getBeginTime() {
		return (java.sql.Timestamp) getValue(8);
	}

	/**
	 * Setter for <code>hg.recruit.end_time</code>.
	 */
	public void setEndTime(java.sql.Timestamp value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>hg.recruit.end_time</code>.
	 */
	public java.sql.Timestamp getEndTime() {
		return (java.sql.Timestamp) getValue(9);
	}

	/**
	 * Setter for <code>hg.recruit.time_stamp</code>.
	 */
	public void setTimeStamp(java.sql.Timestamp value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>hg.recruit.time_stamp</code>.
	 */
	public java.sql.Timestamp getTimeStamp() {
		return (java.sql.Timestamp) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.POSITION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.REQUIRE_COUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.LOCATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.ABILITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.EDUCATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.SALARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field8() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.DESCRIPTION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field9() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.BEGIN_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field10() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.END_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field11() {
		return cn.hg.jooq.tables.Recruit.RECRUIT.TIME_STAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getPosition();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getRequireCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getAbility();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getEducation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getSalary();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value8() {
		return getDescriptionId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value9() {
		return getBeginTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value10() {
		return getEndTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value11() {
		return getTimeStamp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value2(java.lang.String value) {
		setPosition(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value3(java.lang.Integer value) {
		setRequireCount(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value4(java.lang.String value) {
		setLocation(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value5(java.lang.String value) {
		setAbility(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value6(java.lang.String value) {
		setEducation(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value7(java.lang.String value) {
		setSalary(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value8(java.lang.Integer value) {
		setDescriptionId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value9(java.sql.Timestamp value) {
		setBeginTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value10(java.sql.Timestamp value) {
		setEndTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord value11(java.sql.Timestamp value) {
		setTimeStamp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecruitRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.Integer value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.String value7, java.lang.Integer value8, java.sql.Timestamp value9, java.sql.Timestamp value10, java.sql.Timestamp value11) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached RecruitRecord
	 */
	public RecruitRecord() {
		super(cn.hg.jooq.tables.Recruit.RECRUIT);
	}

	/**
	 * Create a detached, initialised RecruitRecord
	 */
	public RecruitRecord(java.lang.Integer id, java.lang.String position, java.lang.Integer requireCount, java.lang.String location, java.lang.String ability, java.lang.String education, java.lang.String salary, java.lang.Integer descriptionId, java.sql.Timestamp beginTime, java.sql.Timestamp endTime, java.sql.Timestamp timeStamp) {
		super(cn.hg.jooq.tables.Recruit.RECRUIT);

		setValue(0, id);
		setValue(1, position);
		setValue(2, requireCount);
		setValue(3, location);
		setValue(4, ability);
		setValue(5, education);
		setValue(6, salary);
		setValue(7, descriptionId);
		setValue(8, beginTime);
		setValue(9, endTime);
		setValue(10, timeStamp);
	}
}