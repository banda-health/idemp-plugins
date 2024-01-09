package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_NextCondition;
import org.compiere.model.X_AD_WF_NodeNext;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NextConditionInput extends X_AD_WF_NextCondition implements I_AD_WF_NextConditionInput {

	 private ForeignEntityInput mAD_Column;
	 private ForeignEntityInput mAD_EntityType;
	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mAD_WF_NodeNext;
	 private I_AD_Ref_ListInput mAndOr;
	 private I_AD_Ref_ListInput mOperation;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WF_NextConditionInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), MColumn.Table_Name, MColumn.COLUMNNAME_AD_Column_UU + "=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
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
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_NextCondition_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_NextCondition_UU();
	}

	/**
	 * Set Node Transition.
	 *
	 * @param AD_WF_NodeNext Workflow Node Transition
	 */
	@JsonProperty("AD_WF_NodeNext")
	public void setAD_WF_NodeNextInput(ForeignEntityInput AD_WF_NodeNext) {
		this.mAD_WF_NodeNext = AD_WF_NodeNext;
		X_AD_WF_NodeNext foreignEntity;
		if (get_ID() == 0 &&AD_WF_NodeNext != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_NodeNext.Table_Name, X_AD_WF_NodeNext.COLUMNNAME_AD_WF_NodeNext_UU + "=?", get_TrxName())
						.setParameters(AD_WF_NodeNext.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_NodeNext_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Node Transition.
	 *
	 * @return Workflow Node Transition
	 */
	@JsonProperty("AD_WF_NodeNext")
	public ForeignEntityInput AD_WF_NodeNext() {
		return mAD_WF_NodeNext;
	}

	/**
	 * Set And/Or.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public void setAndOrInput(I_AD_Ref_ListInput AndOr) {
		this.mAndOr = AndOr;
		MRefList_BH foreignEntity;
		if (AndOr != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AndOr.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAndOr(foreignEntity.getValue());
		} else {
			this.setAndOr(null);
		}
	}

	/**
	 * Get And/Or.
	 *
	 * @return Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public I_AD_Ref_ListInput AndOr() {
		return mAndOr;
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
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	@JsonProperty("Operation")
	public void setOperationInput(I_AD_Ref_ListInput Operation) {
		this.mOperation = Operation;
		MRefList_BH foreignEntity;
		if (Operation != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Operation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOperation(foreignEntity.getValue());
		} else {
			this.setOperation(null);
		}
	}

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	@JsonProperty("Operation")
	public I_AD_Ref_ListInput Operation() {
		return mOperation;
	}
}
