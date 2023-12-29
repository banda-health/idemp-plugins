package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AccessLevel_RL;
	 private I_AD_Ref_ListInput ReplicationType_RL;
	 private I_AD_Val_RuleInput AD_Val_Rule;
	 private I_AD_WindowInput AD_Window;
	 private I_AD_WindowInput PO_Window;

	/**
	 * Standard constructor
	 */
	public X_AD_TableInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	public void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL) {
		this.AccessLevel_RL = AccessLevel_RL;
		MRefList foreignEntity;
		if (AccessLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel_RL.getID())
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
	public I_AD_Ref_ListInput getAccessLevel_RL() {
		return AccessLevel_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
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
	public void setAD_Val_Rule(I_AD_Val_RuleInput AD_Val_Rule) {
		this.AD_Val_Rule = AD_Val_Rule;
		MValRule foreignEntity;
		if (AD_Val_Rule != null &&
				(foreignEntity = new Query(getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_AD_Val_Rule_UU + "=?", get_TrxName())
						.setParameters(AD_Val_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Val_Rule_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public I_AD_Val_RuleInput getAD_Val_Rule() {
		return AD_Val_Rule;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	public void setAD_Window(I_AD_WindowInput AD_Window) {
		this.AD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public I_AD_WindowInput getAD_Window() {
		return AD_Window;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
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
	public void setPO_Window(I_AD_WindowInput PO_Window) {
		this.PO_Window = PO_Window;
		MWindow foreignEntity;
		if (PO_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(PO_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_Window_ID(foreignEntity.get_ID());
		} else {
			this.setPO_Window_ID(0);
		}
	}

	/**
	 * Get PO Window.
	 *
	 * @return Purchase Order Window
	 */
	public I_AD_WindowInput getPO_Window() {
		return PO_Window;
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType_RL Type of Data Replication
	 */
	public void setReplicationType_RL(I_AD_Ref_ListInput ReplicationType_RL) {
		this.ReplicationType_RL = ReplicationType_RL;
		MRefList foreignEntity;
		if (ReplicationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ReplicationType_RL.getID())
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
	public I_AD_Ref_ListInput getReplicationType_RL() {
		return ReplicationType_RL;
	}
}
