package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSet;

/**
 * Generated Interface for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_AttributeSetInput extends I_M_AttributeSet {

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
	 * Column name BH_Locked
	 */
	static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	boolean isBH_Locked();

	/**
	 * Set M_AttributeSet_Type.
	 *
	 * @param M_AttributeSet_Type M_AttributeSet_Type
	 */
	void setM_AttributeSet_TypeInput(ForeignEntityInput M_AttributeSet_Type);

	/**
	 * Get M_AttributeSet_Type.
	 *
	 * @return M_AttributeSet_Type
	 */
	ForeignEntityInput M_AttributeSet_Type();

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
	 * Set M_LotCtl.
	 *
	 * @param M_LotCtl Product Lot Control
	 */
	void setM_LotCtlInput(ForeignEntityInput M_LotCtl);

	/**
	 * Get M_LotCtl.
	 *
	 * @return Product Lot Control
	 */
	ForeignEntityInput M_LotCtl();

	/**
	 * Set M_SerNoCtl.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	void setM_SerNoCtlInput(ForeignEntityInput M_SerNoCtl);

	/**
	 * Get M_SerNoCtl.
	 *
	 * @return Product Serial Number Control
	 */
	ForeignEntityInput M_SerNoCtl();

	/**
	 * Set MandatoryType.
	 *
	 * @param MandatoryType The specification of a Product Attribute Instance is mandatory
	 */
	void setMandatoryTypeInput(ForeignEntityInput MandatoryType);

	/**
	 * Get MandatoryType.
	 *
	 * @return The specification of a Product Attribute Instance is mandatory
	 */
	ForeignEntityInput MandatoryType();
}
