package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ColorSchema;

/**
 * Generated Interface for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_ColorSchemaInput extends I_PA_ColorSchema {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_PrintColor1.
	 *
	 * @param AD_PrintColor1 First color used
	 */
	void setAD_PrintColor1Input(I_AD_PrintColorInput AD_PrintColor1);

	/**
	 * Get AD_PrintColor1.
	 *
	 * @return First color used
	 */
	I_AD_PrintColorInput AD_PrintColor1();

	/**
	 * Set AD_PrintColor2.
	 *
	 * @param AD_PrintColor2 Second color used
	 */
	void setAD_PrintColor2Input(I_AD_PrintColorInput AD_PrintColor2);

	/**
	 * Get AD_PrintColor2.
	 *
	 * @return Second color used
	 */
	I_AD_PrintColorInput AD_PrintColor2();

	/**
	 * Set AD_PrintColor3.
	 *
	 * @param AD_PrintColor3 Third color used
	 */
	void setAD_PrintColor3Input(I_AD_PrintColorInput AD_PrintColor3);

	/**
	 * Get AD_PrintColor3.
	 *
	 * @return Third color used
	 */
	I_AD_PrintColorInput AD_PrintColor3();

	/**
	 * Set AD_PrintColor4.
	 *
	 * @param AD_PrintColor4 Forth color used
	 */
	void setAD_PrintColor4Input(I_AD_PrintColorInput AD_PrintColor4);

	/**
	 * Get AD_PrintColor4.
	 *
	 * @return Forth color used
	 */
	I_AD_PrintColorInput AD_PrintColor4();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

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
}
