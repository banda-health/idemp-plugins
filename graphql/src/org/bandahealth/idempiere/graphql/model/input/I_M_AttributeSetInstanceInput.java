package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSetInstance;

/**
 * Generated Interface for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_AttributeSetInstanceInput extends I_M_AttributeSetInstance {

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
	 * Set bh_update_reason_RL.
	 *
	 * @param bh_update_reason_RL bh_update_reason_RL
	 */
	void setbh_update_reason_RL(I_AD_Ref_ListInput bh_update_reason_RL);

	/**
	 * Get bh_update_reason_RL.
	 *
	 * @return bh_update_reason_RL
	 */
	I_AD_Ref_ListInput getbh_update_reason_RL();

	/**
	 * Set M_AttributeSet.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	void setM_AttributeSet(I_M_AttributeSetInput M_AttributeSet);

	/**
	 * Get M_AttributeSet.
	 *
	 * @return Product Attribute Set
	 */
	I_M_AttributeSetInput getM_AttributeSet();

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
	 * Set M_Lot.
	 *
	 * @param M_Lot Product Lot Definition
	 */
	void setM_Lot(I_M_LotInput M_Lot);

	/**
	 * Get M_Lot.
	 *
	 * @return Product Lot Definition
	 */
	I_M_LotInput getM_Lot();
}
