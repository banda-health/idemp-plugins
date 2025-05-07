package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DocTypeCounter;

/**
 * Generated Interface for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_DocTypeCounterInput extends I_C_DocTypeCounter {

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
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

	/**
	 * Set Counter_C_DocType.
	 *
	 * @param Counter_C_DocType Generated Counter Document Type (To)
	 */
	void setCounter_C_DocTypeInput(ForeignEntityInput Counter_C_DocType);

	/**
	 * Get Counter_C_DocType.
	 *
	 * @return Generated Counter Document Type (To)
	 */
	ForeignEntityInput Counter_C_DocType();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();
}
