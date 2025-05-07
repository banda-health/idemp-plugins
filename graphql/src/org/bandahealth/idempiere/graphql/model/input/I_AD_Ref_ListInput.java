package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Ref_List;

/**
 * Generated Interface for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_Ref_ListInput extends I_AD_Ref_List {

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
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(ForeignEntityInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	ForeignEntityInput AD_Reference();

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
	 * Column name BH_Add_All
	 */
	static final String COLUMNNAME_BH_Add_All = "BH_Add_All";

	/**
	 * Set Add All Access.
	 *
	 * @param BH_Add_All Add All Access
	 */
	void setBH_Add_All(String BH_Add_All);

	/**
	 * Get Add All Access.
	 *
	 * @return Add All Access
	 */
	String getBH_Add_All();

	/**
	 * Column name BH_Update_Existing
	 */
	static final String COLUMNNAME_BH_Update_Existing = "BH_Update_Existing";

	/**
	 * Set Update Existing.
	 *
	 * @param BH_Update_Existing Update Existing
	 */
	void setBH_Update_Existing(String BH_Update_Existing);

	/**
	 * Get Update Existing.
	 *
	 * @return Update Existing
	 */
	String getBH_Update_Existing();

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
