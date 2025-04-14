package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_IssueKnown;

/**
 * Generated Interface for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_R_IssueKnownInput extends I_R_IssueKnown {

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
	 * Set R_IssueRecommendation.
	 *
	 * @param R_IssueRecommendation Recommendations how to fix an Issue
	 */
	void setR_IssueRecommendationInput(ForeignEntityInput R_IssueRecommendation);

	/**
	 * Get R_IssueRecommendation.
	 *
	 * @return Recommendations how to fix an Issue
	 */
	ForeignEntityInput R_IssueRecommendation();

	/**
	 * Set R_IssueStatus.
	 *
	 * @param R_IssueStatus Status of an Issue
	 */
	void setR_IssueStatusInput(ForeignEntityInput R_IssueStatus);

	/**
	 * Get R_IssueStatus.
	 *
	 * @return Status of an Issue
	 */
	ForeignEntityInput R_IssueStatus();

	/**
	 * Set R_Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	void setR_RequestInput(ForeignEntityInput R_Request);

	/**
	 * Get R_Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	ForeignEntityInput R_Request();
}
