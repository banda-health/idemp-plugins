package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Sequence_Audit;

/**
 * Generated Interface for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_Sequence_AuditInput extends I_AD_Sequence_Audit {

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
