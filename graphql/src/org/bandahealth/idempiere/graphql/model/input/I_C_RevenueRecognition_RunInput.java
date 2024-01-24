package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RevenueRecognition_Run;

/**
 * Generated Interface for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RevenueRecognition_RunInput extends I_C_RevenueRecognition_Run {

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
	 * Set C_RevenueRecog_Service.
	 *
	 * @param C_RevenueRecog_Service C_RevenueRecog_Service
	 */
	void setC_RevenueRecog_ServiceInput(ForeignEntityInput C_RevenueRecog_Service);

	/**
	 * Get C_RevenueRecog_Service.
	 *
	 * @return C_RevenueRecog_Service
	 */
	ForeignEntityInput C_RevenueRecog_Service();

	/**
	 * Set C_RevenueRecognition_Plan.
	 *
	 * @param C_RevenueRecognition_Plan Plan for recognizing or recording revenue
	 */
	void setC_RevenueRecognition_PlanInput(ForeignEntityInput C_RevenueRecognition_Plan);

	/**
	 * Get C_RevenueRecognition_Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	ForeignEntityInput C_RevenueRecognition_Plan();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set GL_Journal.
	 *
	 * @param GL_Journal General Ledger Journal
	 */
	void setGL_JournalInput(ForeignEntityInput GL_Journal);

	/**
	 * Get GL_Journal.
	 *
	 * @return General Ledger Journal
	 */
	ForeignEntityInput GL_Journal();
}
