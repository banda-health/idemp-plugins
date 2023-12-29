package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_NodeNext;

/**
 * Generated Interface for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_NodeNextInput extends I_AD_WF_NodeNext {

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
	 * Set AD_WF_Next.
	 *
	 * @param AD_WF_Next Next Node in workflow
	 */
	void setAD_WF_Next(I_AD_WF_NodeInput AD_WF_Next);

	/**
	 * Get AD_WF_Next.
	 *
	 * @return Next Node in workflow
	 */
	I_AD_WF_NodeInput getAD_WF_Next();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_AD_WF_NodeInput getAD_WF_Node();

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
}
