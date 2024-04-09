package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_NextCondition;

/**
 * Generated Interface for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_WF_NextConditionInput extends I_AD_WF_NextCondition {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set AD_WF_NodeNext.
	 *
	 * @param AD_WF_NodeNext Workflow Node Transition
	 */
	void setAD_WF_NodeNextInput(ForeignEntityInput AD_WF_NodeNext);

	/**
	 * Get AD_WF_NodeNext.
	 *
	 * @return Workflow Node Transition
	 */
	ForeignEntityInput AD_WF_NodeNext();

	/**
	 * Set AndOr.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	void setAndOrInput(I_AD_Ref_ListInput AndOr);

	/**
	 * Get AndOr.
	 *
	 * @return Logical operation: AND or OR
	 */
	I_AD_Ref_ListInput AndOr();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	void setOperationInput(I_AD_Ref_ListInput Operation);

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	I_AD_Ref_ListInput Operation();
}
