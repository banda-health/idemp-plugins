package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_NextCondition;

/**
 * Generated Interface for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_NextConditionInput extends I_AD_WF_NextCondition {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(I_AD_ColumnInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	I_AD_ColumnInput AD_Column();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set AD_WF_NodeNext.
	 *
	 * @param AD_WF_NodeNext Workflow Node Transition
	 */
	void setAD_WF_NodeNextInput(I_AD_WF_NodeNextInput AD_WF_NodeNext);

	/**
	 * Get AD_WF_NodeNext.
	 *
	 * @return Workflow Node Transition
	 */
	I_AD_WF_NodeNextInput AD_WF_NodeNext();

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
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

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
