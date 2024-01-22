package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeLog;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MSession;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ChangeLogInput extends MChangeLog implements I_AD_ChangeLogInput {

	private ForeignEntityInput mAD_ChangeLog;
	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Session;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mEventChangeLog;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ChangeLogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MChangeLog(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Change Log.
	 *
	 * @param AD_ChangeLog Log of data changes
	 */
	@JsonProperty("AD_ChangeLog")
	public void setAD_ChangeLogInput(ForeignEntityInput AD_ChangeLog) {
		this.mAD_ChangeLog = AD_ChangeLog;
		MChangeLog foreignEntity;
		if (get_ID() == 0 && AD_ChangeLog != null &&
				(foreignEntity = new Query(getCtx(), "AD_ChangeLog", "AD_ChangeLog_UU=?", get_TrxName())
						.setParameters(AD_ChangeLog.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ChangeLog_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ChangeLog_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MColumn foreignEntity;
		if (get_ID() == 0 && AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
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
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
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
		MSession foreignEntity;
		if (get_ID() == 0 && AD_Session != null &&
				(foreignEntity = new Query(getCtx(), "AD_Session", "AD_Session_UU=?", get_TrxName())
						.setParameters(AD_Session.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Session_ID(foreignEntity.get_ID());
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
		MTable_BH foreignEntity;
		if (get_ID() == 0 && AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
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
		MRefList_BH foreignEntity;
		if (EventChangeLog != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventChangeLog.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEventChangeLog(foreignEntity.getValue());
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
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */

	public void setRecord_ID(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
		}
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
