package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Form;

/**
 * Generated Interface for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_FormInput extends I_AD_Form {

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
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelp(I_AD_CtxHelpInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	I_AD_CtxHelpInput getAD_CtxHelp();

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
