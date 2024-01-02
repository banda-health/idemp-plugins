package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TableInput extends MTable implements I_AD_TableInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mAccessLevel;
	 private I_AD_Ref_ListInput mReplicationType;
	 private I_AD_Val_RuleInput mAD_Val_Rule;
	 private I_AD_WindowInput mAD_Window;
	 private I_AD_WindowInput mPO_Window;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_TableInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		MRefList_BH foreignEntity;
		if (AccessLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccessLevel(foreignEntity.getValue());
		} else {
			this.setAccessLevel(null);
		}
	}

	/**
	 * Get Data Access Level.
	 *
	 * @return Access Level required
	 */
	@JsonProperty("AccessLevel")
	public I_AD_Ref_ListInput AccessLevel() {
		return mAccessLevel;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Table_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Table_UU();
	}

	/**
	 * Set Dynamic Validation.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public void setAD_Val_RuleInput(I_AD_Val_RuleInput AD_Val_Rule) {
		this.mAD_Val_Rule = AD_Val_Rule;
		MValRule foreignEntity;
		if (AD_Val_Rule != null &&
				(foreignEntity = new Query(getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_AD_Val_Rule_UU + "=?", get_TrxName())
						.setParameters(AD_Val_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Val_Rule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public I_AD_Val_RuleInput AD_Val_Rule() {
		return mAD_Val_Rule;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(I_AD_WindowInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public I_AD_WindowInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
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
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}
	/**
	 * Set Sequence.
	 *
	 * @param LoadSeq Sequence
	 */

	public void setLoadSeq(int LoadSeq) {
		if (get_ID() == 0) {
			super.setLoadSeq(LoadSeq);
		}
	}

	/**
	 * Set PO Window.
	 *
	 * @param PO_Window Purchase Order Window
	 */
	@JsonProperty("PO_Window")
	public void setPO_WindowInput(I_AD_WindowInput PO_Window) {
		this.mPO_Window = PO_Window;
		MWindow foreignEntity;
		if (PO_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(PO_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_Window_ID(foreignEntity.get_ID());
		} else {
			super.setPO_Window_ID(0);
		}
	}

	/**
	 * Get PO Window.
	 *
	 * @return Purchase Order Window
	 */
	@JsonProperty("PO_Window")
	public I_AD_WindowInput PO_Window() {
		return mPO_Window;
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public void setReplicationTypeInput(I_AD_Ref_ListInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		MRefList_BH foreignEntity;
		if (ReplicationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ReplicationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReplicationType(foreignEntity.getValue());
		} else {
			this.setReplicationType(null);
		}
	}

	/**
	 * Get Replication Type.
	 *
	 * @return Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public I_AD_Ref_ListInput ReplicationType() {
		return mReplicationType;
	}
}
