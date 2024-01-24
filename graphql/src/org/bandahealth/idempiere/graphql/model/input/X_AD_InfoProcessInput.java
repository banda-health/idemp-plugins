package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_InfoProcess;

import java.sql.ResultSet;

/**
 * Generated Model for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoProcessInput extends X_AD_InfoProcess implements I_AD_InfoProcessInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_InfoColumn;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private I_AD_Ref_ListInput mLayoutType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_InfoProcessInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_InfoProcess(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Info Column.
	 *
	 * @param AD_InfoColumn Info Window Column
	 */
	@JsonProperty("AD_InfoColumn")
	public void setAD_InfoColumnInput(ForeignEntityInput AD_InfoColumn) {
		this.mAD_InfoColumn = AD_InfoColumn;
		MInfoColumn foreignEntity;
		if (AD_InfoColumn != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
						.setParameters(AD_InfoColumn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoColumn_ID(foreignEntity.get_ID());
		} else {
			super.setAD_InfoColumn_ID(0);
		}
	}

	/**
	 * Get Info Column.
	 *
	 * @return Info Window Column
	 */
	@JsonProperty("AD_InfoColumn")
	public ForeignEntityInput AD_InfoColumn() {
		return mAD_InfoColumn;
	}
	/**
	 * Set Info Process.
	 *
	 * @param AD_InfoProcess_ID Info Process
	 */

	public void setAD_InfoProcess_ID(int AD_InfoProcess_ID) {
		if (get_ID() == 0) {
			super.setAD_InfoProcess_ID(AD_InfoProcess_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_InfoProcess_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_InfoProcess_UU();
	}

	/**
	 * Set Info Window.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow) {
		this.mAD_InfoWindow = AD_InfoWindow;
		MInfoWindow foreignEntity;
		if (get_ID() == 0 && AD_InfoWindow != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
						.setParameters(AD_InfoWindow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoWindow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public ForeignEntityInput AD_InfoWindow() {
		return mAD_InfoWindow;
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set LayoutType.
	 *
	 * @param LayoutType Layout type of info process
	 */
	@JsonProperty("LayoutType")
	public void setLayoutTypeInput(I_AD_Ref_ListInput LayoutType) {
		this.mLayoutType = LayoutType;
		MRefList_BH foreignEntity;
		if (LayoutType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LayoutType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLayoutType(foreignEntity.getValue());
		} else {
			this.setLayoutType(null);
		}
	}

	/**
	 * Get LayoutType.
	 *
	 * @return Layout type of info process
	 */
	@JsonProperty("LayoutType")
	public I_AD_Ref_ListInput LayoutType() {
		return mLayoutType;
	}
}
