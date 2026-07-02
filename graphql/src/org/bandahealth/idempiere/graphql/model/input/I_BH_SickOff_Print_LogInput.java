package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_SickOff_Print_Log;

/**
 * Generated Interface for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_SickOff_Print_LogInput extends I_BH_SickOff_Print_Log {

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
	 * Set BH_SickOff.
	 *
	 * @param BH_SickOff BH_SickOff
	 */
	void setBH_SickOffInput(ForeignEntityInput BH_SickOff);

	/**
	 * Get BH_SickOff.
	 *
	 * @return BH_SickOff
	 */
	ForeignEntityInput BH_SickOff();

	/**
	 * Set PrintedBy.
	 *
	 * @param PrintedBy User who printed this record
	 */
	void setPrintedByInput(ForeignEntityInput PrintedBy);

	/**
	 * Get PrintedBy.
	 *
	 * @return User who printed this record
	 */
	ForeignEntityInput PrintedBy();

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
