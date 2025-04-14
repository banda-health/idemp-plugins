package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_SLA_Goal;

/**
 * Generated Interface for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_PA_SLA_GoalInput extends I_PA_SLA_Goal {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set PA_SLA_Criteria.
	 *
	 * @param PA_SLA_Criteria Service Level Agreement Criteria
	 */
	void setPA_SLA_CriteriaInput(ForeignEntityInput PA_SLA_Criteria);

	/**
	 * Get PA_SLA_Criteria.
	 *
	 * @return Service Level Agreement Criteria
	 */
	ForeignEntityInput PA_SLA_Criteria();

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
