package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Sequence_No;

/**
 * Generated Interface for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Sequence_NoInput extends I_AD_Sequence_No {

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
	 * Set AD_Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	void setAD_SequenceInput(ForeignEntityInput AD_Sequence);

	/**
	 * Get AD_Sequence.
	 *
	 * @return Document Sequence
	 */
	ForeignEntityInput AD_Sequence();

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
}
