package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_LotCtlExclude;

/**
 * Generated Interface for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_LotCtlExcludeInput extends I_M_LotCtlExclude {

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
}
