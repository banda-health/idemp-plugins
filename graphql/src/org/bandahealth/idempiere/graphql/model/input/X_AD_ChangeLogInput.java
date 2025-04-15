package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ChangeLogResolver;
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
 * @version Release 12 - $Id$
 */
public class X_AD_ChangeLogInput extends MChangeLog implements I_AD_ChangeLogInput {

	private ForeignEntityInput mAD_ChangeLog;
	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Session;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mEventChangeLog;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ChangeLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ChangeLogInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_ChangeLog.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ChangeLog_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ChangeLog with UU " + AD_ChangeLog.getUU());
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ChangeLog_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_Session.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Session_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Session with UU " + AD_Session.getUU());
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
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
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
	public void setEventChangeLogInput(ForeignEntityInput EventChangeLog) {
		this.mEventChangeLog = EventChangeLog;
		if (get_ID() != 0) {
			return;
		}
		if (EventChangeLog != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ChangeLogResolver.EVENTCHANGELOG_UUIDS_BY_VALUE.containsValue(EventChangeLog.getUU())) {
				throw new AdempiereException("The reference list UU of " + EventChangeLog.getUU() +
						" is not in the list defined for the EventChangeLog column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(EventChangeLog.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEventChangeLog(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + EventChangeLog.getUU());
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
	public ForeignEntityInput EventChangeLog() {
		return mEventChangeLog;
	}
	/**
	 * Set New Value.
	 *
	 * @param NewValue New field value
	 */
	@JsonProperty("NewValue")
	public void setNewValueFromJson(String NewValue) {
		if (get_ID() == 0) {
			super.setNewValue(NewValue);
		}
	}
	/**
	 * Set Old Value.
	 *
	 * @param OldValue The old file data
	 */
	@JsonProperty("OldValue")
	public void setOldValueFromJson(String OldValue) {
		if (get_ID() == 0) {
			super.setOldValue(OldValue);
		}
	}
	/**
	 * Set Transaction.
	 *
	 * @param TrxName Name of the transaction
	 */
	@JsonProperty("TrxName")
	public void setTrxNameFromJson(String TrxName) {
		if (get_ID() == 0) {
			super.setTrxName(TrxName);
		}
	}
}
