package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSetInstance;

/**
 * Generated Interface for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_AttributeSetInstanceInput extends I_M_AttributeSetInstance {

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
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	void setbh_update_reasonInput(ForeignEntityInput bh_update_reason);

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	ForeignEntityInput bh_update_reason();

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
