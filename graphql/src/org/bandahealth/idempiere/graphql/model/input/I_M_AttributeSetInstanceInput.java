package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSetInstance;

/**
 * Generated Interface for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_AttributeSetInstanceInput extends I_M_AttributeSetInstance {

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
	 * Column name BH_GuaranteeDateString
	 */
	static final String COLUMNNAME_BH_GuaranteeDateString = "BH_GuaranteeDateString";

	/**
	 * Set Guarantee Date String.
	 *
	 * @param BH_GuaranteeDateString String date when guarantee expires
	 */
	void setBH_GuaranteeDateString(String BH_GuaranteeDateString);

	/**
	 * Get Guarantee Date String.
	 *
	 * @return String date when guarantee expires
	 */
	String getBH_GuaranteeDateString();

	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	void setbh_update_reasonInput(I_AD_Ref_ListInput bh_update_reason);

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	I_AD_Ref_ListInput bh_update_reason();

	/**
	 * Set M_AttributeSet.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet);

	/**
	 * Get M_AttributeSet.
	 *
	 * @return Product Attribute Set
	 */
	ForeignEntityInput M_AttributeSet();

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
	 * Set M_Lot.
	 *
	 * @param M_Lot Product Lot Definition
	 */
	void setM_LotInput(ForeignEntityInput M_Lot);

	/**
	 * Get M_Lot.
	 *
	 * @return Product Lot Definition
	 */
	ForeignEntityInput M_Lot();
}
