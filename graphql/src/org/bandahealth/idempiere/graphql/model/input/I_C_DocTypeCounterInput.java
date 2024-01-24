package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DocTypeCounter;

/**
 * Generated Interface for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_DocTypeCounterInput extends I_C_DocTypeCounter {

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
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();
}
