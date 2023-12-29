package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Table;

/**
 * Generated Interface for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_TableInput extends I_AD_Table {

	/**
	 * Set AccessLevel_RL.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL);

	/**
	 * Get AccessLevel_RL.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput getAccessLevel_RL();

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
	 * Set AD_Val_Rule.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	void setAD_Val_Rule(I_AD_Val_RuleInput AD_Val_Rule);

	/**
	 * Get AD_Val_Rule.
	 *
	 * @return Dynamic Validation Rule
	 */
	I_AD_Val_RuleInput getAD_Val_Rule();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_Window(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput getAD_Window();

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
	 * Set PO_Window.
	 *
	 * @param PO_Window Purchase Order Window
	 */
	void setPO_Window(I_AD_WindowInput PO_Window);

	/**
	 * Get PO_Window.
	 *
	 * @return Purchase Order Window
	 */
	I_AD_WindowInput getPO_Window();

	/**
	 * Set ReplicationType_RL.
	 *
	 * @param ReplicationType_RL Type of Data Replication
	 */
	void setReplicationType_RL(I_AD_Ref_ListInput ReplicationType_RL);

	/**
	 * Get ReplicationType_RL.
	 *
	 * @return Type of Data Replication
	 */
	I_AD_Ref_ListInput getReplicationType_RL();
}
