package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_SickOff;

/**
 * Generated Interface for BH_SickOff - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_SickOffInput extends I_BH_SickOff {

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
	 * Set BH_Clinician_User.
	 *
	 * @param BH_Clinician_User BH_Clinician_User
	 */
	void setBH_Clinician_UserInput(ForeignEntityInput BH_Clinician_User);

	/**
	 * Get BH_Clinician_User.
	 *
	 * @return BH_Clinician_User
	 */
	ForeignEntityInput BH_Clinician_User();

	/**
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_VisitInput(ForeignEntityInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	ForeignEntityInput BH_Visit();

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
