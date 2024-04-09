package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_FieldGroup;

/**
 * Generated Interface for AD_FieldGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_FieldGroupInput extends I_AD_FieldGroup {

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
	 * Column name BH_Abbreviation
	 */
	static final String COLUMNNAME_BH_Abbreviation = "BH_Abbreviation";

	/**
	 * Set BH_Abbreviation.
	 *
	 * @param BH_Abbreviation An abbreviation for a given name
	 */
	void setBH_Abbreviation(String BH_Abbreviation);

	/**
	 * Get BH_Abbreviation.
	 *
	 * @return An abbreviation for a given name
	 */
	String getBH_Abbreviation();

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
	 * Set FieldGroupType.
	 *
	 * @param FieldGroupType FieldGroupType
	 */
	void setFieldGroupTypeInput(I_AD_Ref_ListInput FieldGroupType);

	/**
	 * Get FieldGroupType.
	 *
	 * @return FieldGroupType
	 */
	I_AD_Ref_ListInput FieldGroupType();
}
