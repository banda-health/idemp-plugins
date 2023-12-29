package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSet;

/**
 * Generated Interface for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_AttributeSetInput extends I_M_AttributeSet {

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
	 * Set M_AttributeSet_Type_RL.
	 *
	 * @param M_AttributeSet_Type_RL M_AttributeSet_Type_RL
	 */
	void setM_AttributeSet_Type_RL(I_AD_Ref_ListInput M_AttributeSet_Type_RL);

	/**
	 * Get M_AttributeSet_Type_RL.
	 *
	 * @return M_AttributeSet_Type_RL
	 */
	I_AD_Ref_ListInput getM_AttributeSet_Type_RL();

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
	 * Set M_LotCtl.
	 *
	 * @param M_LotCtl Product Lot Control
	 */
	void setM_LotCtl(I_M_LotCtlInput M_LotCtl);

	/**
	 * Get M_LotCtl.
	 *
	 * @return Product Lot Control
	 */
	I_M_LotCtlInput getM_LotCtl();

	/**
	 * Set M_SerNoCtl.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	void setM_SerNoCtl(I_M_SerNoCtlInput M_SerNoCtl);

	/**
	 * Get M_SerNoCtl.
	 *
	 * @return Product Serial Number Control
	 */
	I_M_SerNoCtlInput getM_SerNoCtl();

	/**
	 * Set MandatoryType_RL.
	 *
	 * @param MandatoryType_RL The specification of a Product Attribute Instance is mandatory
	 */
	void setMandatoryType_RL(I_AD_Ref_ListInput MandatoryType_RL);

	/**
	 * Get MandatoryType_RL.
	 *
	 * @return The specification of a Product Attribute Instance is mandatory
	 */
	I_AD_Ref_ListInput getMandatoryType_RL();
}
