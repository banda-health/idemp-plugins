package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ChangeRequest;

/**
 * Generated Interface for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ChangeRequestInput extends I_M_ChangeRequest {

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
	 * Set M_ChangeNotice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice);

	/**
	 * Get M_ChangeNotice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	ForeignEntityInput M_ChangeNotice();

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
	 * Set M_FixChangeNotice.
	 *
	 * @param M_FixChangeNotice Fixed in Change Notice
	 */
	void setM_FixChangeNoticeInput(ForeignEntityInput M_FixChangeNotice);

	/**
	 * Get M_FixChangeNotice.
	 *
	 * @return Fixed in Change Notice
	 */
	ForeignEntityInput M_FixChangeNotice();

	/**
	 * Set PP_Product_BOM.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM);

	/**
	 * Get PP_Product_BOM.
	 *
	 * @return BOM & Formula
	 */
	ForeignEntityInput PP_Product_BOM();
}
