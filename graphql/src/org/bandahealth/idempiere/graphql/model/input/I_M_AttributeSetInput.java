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
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set M_AttributeSet_Type.
	 *
	 * @param M_AttributeSet_Type M_AttributeSet_Type
	 */
	void setM_AttributeSet_TypeInput(I_AD_Ref_ListInput M_AttributeSet_Type);

	/**
	 * Get M_AttributeSet_Type.
	 *
	 * @return M_AttributeSet_Type
	 */
	I_AD_Ref_ListInput M_AttributeSet_Type();

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
	void setM_LotCtlInput(I_M_LotCtlInput M_LotCtl);

	/**
	 * Get M_LotCtl.
	 *
	 * @return Product Lot Control
	 */
	I_M_LotCtlInput M_LotCtl();

	/**
	 * Set M_SerNoCtl.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	void setM_SerNoCtlInput(I_M_SerNoCtlInput M_SerNoCtl);

	/**
	 * Get M_SerNoCtl.
	 *
	 * @return Product Serial Number Control
	 */
	I_M_SerNoCtlInput M_SerNoCtl();

	/**
	 * Set MandatoryType.
	 *
	 * @param MandatoryType The specification of a Product Attribute Instance is mandatory
	 */
	void setMandatoryTypeInput(I_AD_Ref_ListInput MandatoryType);

	/**
	 * Get MandatoryType.
	 *
	 * @return The specification of a Product Attribute Instance is mandatory
	 */
	I_AD_Ref_ListInput MandatoryType();
}
