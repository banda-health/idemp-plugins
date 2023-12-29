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
	void setAD_Column(I_AD_ColumnInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	I_AD_ColumnInput getAD_Column();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	void setAD_WF_NodeNext(I_AD_WF_NodeNextInput AD_WF_NodeNext);

	/**
	 * Get AD_WF_NodeNext.
	 *
	 * @return Workflow Node Transition
	 */
	I_AD_WF_NodeNextInput getAD_WF_NodeNext();

	/**
	 * Set AndOr_RL.
	 *
	 * @param AndOr_RL Logical operation: AND or OR
	 */
	void setAndOr_RL(I_AD_Ref_ListInput AndOr_RL);

	/**
	 * Get AndOr_RL.
	 *
	 * @return Logical operation: AND or OR
	 */
	I_AD_Ref_ListInput getAndOr_RL();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set Operation_RL.
	 *
	 * @param Operation_RL Compare Operation
	 */
	void setOperation_RL(I_AD_Ref_ListInput Operation_RL);

	/**
	 * Get Operation_RL.
	 *
	 * @return Compare Operation
	 */
	I_AD_Ref_ListInput getOperation_RL();
}
