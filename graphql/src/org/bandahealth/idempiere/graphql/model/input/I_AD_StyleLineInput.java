package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_StyleLine;

/**
 * Generated Interface for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_StyleLineInput extends I_AD_StyleLine {

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
	 * Set AD_Style.
	 *
	 * @param AD_Style CSS style for field and label
	 */
	void setAD_StyleInput(ForeignEntityInput AD_Style);

	/**
	 * Get AD_Style.
	 *
	 * @return CSS style for field and label
	 */
	ForeignEntityInput AD_Style();

	/**
	 * Set UUID.
	 *
	 * @param UUID CSS Style Line
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return CSS Style Line
	 */
	String getUUID();

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
}
