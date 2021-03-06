/**
 * This class is generated by jOOQ
 */
package cn.hg.jooq;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>hg</code> 
 * schema
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Integer> IDENTITY_CONFIG = Identities0.IDENTITY_CONFIG;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.DescriptionRecord, java.lang.Integer> IDENTITY_DESCRIPTION = Identities0.IDENTITY_DESCRIPTION;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.GroupRecord, java.lang.Integer> IDENTITY_GROUP = Identities0.IDENTITY_GROUP;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.HistoryRecord, java.lang.Integer> IDENTITY_HISTORY = Identities0.IDENTITY_HISTORY;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.ManagerRecord, java.lang.Integer> IDENTITY_MANAGER = Identities0.IDENTITY_MANAGER;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.MessageRecord, java.lang.Integer> IDENTITY_MESSAGE = Identities0.IDENTITY_MESSAGE;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.PictureRecord, java.lang.Integer> IDENTITY_PICTURE = Identities0.IDENTITY_PICTURE;
	public static final org.jooq.Identity<cn.hg.jooq.tables.records.RecruitRecord, java.lang.Integer> IDENTITY_RECRUIT = Identities0.IDENTITY_RECRUIT;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.ConfigRecord> KEY_CONFIG_PRIMARY = UniqueKeys0.KEY_CONFIG_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.DescriptionRecord> KEY_DESCRIPTION_PRIMARY = UniqueKeys0.KEY_DESCRIPTION_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.GroupRecord> KEY_GROUP_PRIMARY = UniqueKeys0.KEY_GROUP_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.HistoryRecord> KEY_HISTORY_PRIMARY = UniqueKeys0.KEY_HISTORY_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.ManagerRecord> KEY_MANAGER_PRIMARY = UniqueKeys0.KEY_MANAGER_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.MessageRecord> KEY_MESSAGE_PRIMARY = UniqueKeys0.KEY_MESSAGE_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.PictureRecord> KEY_PICTURE_PRIMARY = UniqueKeys0.KEY_PICTURE_PRIMARY;
	public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.RecruitRecord> KEY_RECRUIT_PRIMARY = UniqueKeys0.KEY_RECRUIT_PRIMARY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<cn.hg.jooq.tables.records.ConfigRecord, java.lang.Integer> IDENTITY_CONFIG = createIdentity(cn.hg.jooq.tables.Config.CONFIG, cn.hg.jooq.tables.Config.CONFIG.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.DescriptionRecord, java.lang.Integer> IDENTITY_DESCRIPTION = createIdentity(cn.hg.jooq.tables.Description.DESCRIPTION, cn.hg.jooq.tables.Description.DESCRIPTION.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.GroupRecord, java.lang.Integer> IDENTITY_GROUP = createIdentity(cn.hg.jooq.tables.Group.GROUP, cn.hg.jooq.tables.Group.GROUP.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.HistoryRecord, java.lang.Integer> IDENTITY_HISTORY = createIdentity(cn.hg.jooq.tables.History.HISTORY, cn.hg.jooq.tables.History.HISTORY.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.ManagerRecord, java.lang.Integer> IDENTITY_MANAGER = createIdentity(cn.hg.jooq.tables.Manager.MANAGER, cn.hg.jooq.tables.Manager.MANAGER.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.MessageRecord, java.lang.Integer> IDENTITY_MESSAGE = createIdentity(cn.hg.jooq.tables.Message.MESSAGE, cn.hg.jooq.tables.Message.MESSAGE.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.PictureRecord, java.lang.Integer> IDENTITY_PICTURE = createIdentity(cn.hg.jooq.tables.Picture.PICTURE, cn.hg.jooq.tables.Picture.PICTURE.ID);
		public static org.jooq.Identity<cn.hg.jooq.tables.records.RecruitRecord, java.lang.Integer> IDENTITY_RECRUIT = createIdentity(cn.hg.jooq.tables.Recruit.RECRUIT, cn.hg.jooq.tables.Recruit.RECRUIT.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.ConfigRecord> KEY_CONFIG_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Config.CONFIG, cn.hg.jooq.tables.Config.CONFIG.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.DescriptionRecord> KEY_DESCRIPTION_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Description.DESCRIPTION, cn.hg.jooq.tables.Description.DESCRIPTION.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.GroupRecord> KEY_GROUP_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Group.GROUP, cn.hg.jooq.tables.Group.GROUP.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.HistoryRecord> KEY_HISTORY_PRIMARY = createUniqueKey(cn.hg.jooq.tables.History.HISTORY, cn.hg.jooq.tables.History.HISTORY.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.ManagerRecord> KEY_MANAGER_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Manager.MANAGER, cn.hg.jooq.tables.Manager.MANAGER.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.MessageRecord> KEY_MESSAGE_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Message.MESSAGE, cn.hg.jooq.tables.Message.MESSAGE.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.PictureRecord> KEY_PICTURE_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Picture.PICTURE, cn.hg.jooq.tables.Picture.PICTURE.ID);
		public static final org.jooq.UniqueKey<cn.hg.jooq.tables.records.RecruitRecord> KEY_RECRUIT_PRIMARY = createUniqueKey(cn.hg.jooq.tables.Recruit.RECRUIT, cn.hg.jooq.tables.Recruit.RECRUIT.ID);
	}
}
