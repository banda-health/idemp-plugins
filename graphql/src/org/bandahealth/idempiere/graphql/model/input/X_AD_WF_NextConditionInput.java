package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_ColumnInput AD_Column;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AndOr_RL;
	 private I_AD_Ref_ListInput Operation_RL;
	 private I_AD_WF_NodeNextInput AD_WF_NodeNext;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_NextConditionInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	public void setAD_Column(I_AD_ColumnInput AD_Column) {
		this.AD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), MColumn.Table_Name, MColumn.COLUMNNAME_AD_Column_UU + "=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public I_AD_ColumnInput getAD_Column() {
		return AD_Column;
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
	public void setAD_WF_NodeNext(I_AD_WF_NodeNextInput AD_WF_NodeNext) {
		this.AD_WF_NodeNext = AD_WF_NodeNext;
		X_AD_WF_NodeNext foreignEntity;
		if (get_ID() == 0 &&AD_WF_NodeNext != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_NodeNext.Table_Name, X_AD_WF_NodeNext.COLUMNNAME_AD_WF_NodeNext_UU + "=?", get_TrxName())
						.setParameters(AD_WF_NodeNext.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_NodeNext_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Node Transition.
	 *
	 * @return Workflow Node Transition
	 */
	public I_AD_WF_NodeNextInput getAD_WF_NodeNext() {
		return AD_WF_NodeNext;
	}

	/**
	 * Set And/Or.
	 *
	 * @param AndOr_RL Logical operation: AND or OR
	 */
	public void setAndOr_RL(I_AD_Ref_ListInput AndOr_RL) {
		this.AndOr_RL = AndOr_RL;
		MRefList foreignEntity;
		if (AndOr_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AndOr_RL.getID())
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
	public I_AD_Ref_ListInput getAndOr_RL() {
		return AndOr_RL;
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
	 * Set Operation.
	 *
	 * @param Operation_RL Compare Operation
	 */
	public void setOperation_RL(I_AD_Ref_ListInput Operation_RL) {
		this.Operation_RL = Operation_RL;
		MRefList foreignEntity;
		if (Operation_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Operation_RL.getID())
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
	public I_AD_Ref_ListInput getOperation_RL() {
		return Operation_RL;
	}
}
