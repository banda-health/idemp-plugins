package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Imp_Detail;

/**
 * Generated Interface for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_Package_Imp_DetailInput extends I_AD_Package_Imp_Detail {

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
	 * Set AD_Package_Imp.
	 *
	 * @param AD_Package_Imp AD_Package_Imp
	 */
	void setAD_Package_ImpInput(ForeignEntityInput AD_Package_Imp);

	/**
	 * Get AD_Package_Imp.
	 *
	 * @return AD_Package_Imp
	 */
	ForeignEntityInput AD_Package_Imp();

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
}
