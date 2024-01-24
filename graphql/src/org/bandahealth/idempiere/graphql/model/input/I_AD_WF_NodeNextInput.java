package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_NodeNext;

/**
 * Generated Interface for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_WF_NodeNextInput extends I_AD_WF_NodeNext {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_WF_Next.
	 *
	 * @param AD_WF_Next Next Node in workflow
	 */
	void setAD_WF_NextInput(ForeignEntityInput AD_WF_Next);

	/**
	 * Get AD_WF_Next.
	 *
	 * @return Next Node in workflow
	 */
	ForeignEntityInput AD_WF_Next();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	ForeignEntityInput AD_WF_Node();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

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
}
