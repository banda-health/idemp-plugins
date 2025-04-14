package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeUse;

/**
 * Generated Interface for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_AttributeUseInput extends I_M_AttributeUse {

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
	 * Set M_Attribute.
	 *
	 * @param M_Attribute Product Attribute
	 */
	void setM_AttributeInput(ForeignEntityInput M_Attribute);

	/**
	 * Get M_Attribute.
	 *
	 * @return Product Attribute
	 */
	ForeignEntityInput M_Attribute();

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
}
