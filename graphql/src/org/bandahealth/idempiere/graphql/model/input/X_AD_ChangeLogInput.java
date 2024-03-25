package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeLog;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MSession;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ChangeLogInput extends MChangeLog implements I_AD_ChangeLogInput {

	private ForeignEntityInput mAD_ChangeLog;
	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Session;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mEventChangeLog;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ChangeLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ChangeLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Change Log.
	 *
	 * @param AD_ChangeLog Log of data changes
	 */
	@JsonProperty("AD_ChangeLog")
	public void setAD_ChangeLogInput(ForeignEntityInput AD_ChangeLog) {
		this.mAD_ChangeLog = AD_ChangeLog;
		if (get_ID() != 0) {
			return;
		}
		if (AD_ChangeLog != null) {
			// Since an entity was passed, make sure it's in the DB
			MChangeLog foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ChangeLog", "AD_ChangeLog_UU=?", get_TrxName())
							.setParameters(AD_ChangeLog.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_ChangeLog_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ChangeLog with UUID " + AD_ChangeLog.getUUID());
			}
		} else {
			this.setAD_ChangeLog_ID(0);
		}
	}

	/**
	 * Get Change Log.
	 *
	 * @return Log of data changes
	 */
	@JsonProperty("AD_ChangeLog")
	public ForeignEntityInput AD_ChangeLog() {
		return mAD_ChangeLog;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_ChangeLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_ChangeLog_UU();
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Session.
	 *
	 * @param AD_Session User Session Online or Web
	 */
	@JsonProperty("AD_Session")
	public void setAD_SessionInput(ForeignEntityInput AD_Session) {
		this.mAD_Session = AD_Session;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Session != null) {
			// Since an entity was passed, make sure it's in the DB
			MSession foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Session", "AD_Session_UU=?", get_TrxName())
							.setParameters(AD_Session.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Session_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Session with UUID " + AD_Session.getUUID());
			}
		} else {
			this.setAD_Session_ID(0);
		}
	}

	/**
	 * Get Session.
	 *
	 * @return User Session Online or Web
	 */
	@JsonProperty("AD_Session")
	public ForeignEntityInput AD_Session() {
		return mAD_Session;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Event Change Log.
	 *
	 * @param EventChangeLog Type of Event in Change Log
	 */
	@JsonProperty("EventChangeLog")
	public void setEventChangeLogInput(I_AD_Ref_ListInput EventChangeLog) {
		this.mEventChangeLog = EventChangeLog;
		if (get_ID() != 0) {
			return;
		}
		if (EventChangeLog != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(EventChangeLog.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEventChangeLog(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + EventChangeLog.getUUID());
			}
		} else {
			this.setEventChangeLog(null);
		}
	}

	/**
	 * Get Event Change Log.
	 *
	 * @return Type of Event in Change Log
	 */
	@JsonProperty("EventChangeLog")
	public I_AD_Ref_ListInput EventChangeLog() {
		return mEventChangeLog;
	}
	/**
	 * Set New Value.
	 *
	 * @param NewValue New field value
	 */

	public void setNewValue(String NewValue) {
		if (get_ID() == 0) {
			super.setNewValue(NewValue);
		}
	}
	/**
	 * Set Old Value.
	 *
	 * @param OldValue The old file data
	 */

	public void setOldValue(String OldValue) {
		if (get_ID() == 0) {
			super.setOldValue(OldValue);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setRecord_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getRecord_UU();
	}
	/**
	 * Set Transaction.
	 *
	 * @param TrxName Name of the transaction
	 */

	public void setTrxName(String TrxName) {
		if (get_ID() == 0) {
			super.setTrxName(TrxName);
		}
	}
}
