package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Sequence_Audit;

/**
 * Generated Interface for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_Sequence_AuditInput extends I_AD_Sequence_Audit {

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
}
