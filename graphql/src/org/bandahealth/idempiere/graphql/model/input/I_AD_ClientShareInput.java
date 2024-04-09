package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ClientShare;

/**
 * Generated Interface for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ClientShareInput extends I_AD_ClientShare {

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
	 * Set ShareType.
	 *
	 * @param ShareType Type of sharing
	 */
	void setShareTypeInput(I_AD_Ref_ListInput ShareType);

	/**
	 * Get ShareType.
	 *
	 * @return Type of sharing
	 */
	I_AD_Ref_ListInput ShareType();
}
