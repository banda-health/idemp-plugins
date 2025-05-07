package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeSetExclude;

/**
 * Generated Interface for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_AttributeSetExcludeInput extends I_M_AttributeSetExclude {

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
}
