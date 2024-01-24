package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ColorSchema;

/**
 * Generated Interface for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_ColorSchemaInput extends I_PA_ColorSchema {

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
	 * Set AD_PrintColor1.
	 *
	 * @param AD_PrintColor1 First color used
	 */
	void setAD_PrintColor1Input(ForeignEntityInput AD_PrintColor1);

	/**
	 * Get AD_PrintColor1.
	 *
	 * @return First color used
	 */
	ForeignEntityInput AD_PrintColor1();

	/**
	 * Set AD_PrintColor2.
	 *
	 * @param AD_PrintColor2 Second color used
	 */
	void setAD_PrintColor2Input(ForeignEntityInput AD_PrintColor2);

	/**
	 * Get AD_PrintColor2.
	 *
	 * @return Second color used
	 */
	ForeignEntityInput AD_PrintColor2();

	/**
	 * Set AD_PrintColor3.
	 *
	 * @param AD_PrintColor3 Third color used
	 */
	void setAD_PrintColor3Input(ForeignEntityInput AD_PrintColor3);

	/**
	 * Get AD_PrintColor3.
	 *
	 * @return Third color used
	 */
	ForeignEntityInput AD_PrintColor3();

	/**
	 * Set AD_PrintColor4.
	 *
	 * @param AD_PrintColor4 Forth color used
	 */
	void setAD_PrintColor4Input(ForeignEntityInput AD_PrintColor4);

	/**
	 * Get AD_PrintColor4.
	 *
	 * @return Forth color used
	 */
	ForeignEntityInput AD_PrintColor4();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

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
