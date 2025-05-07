package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Ref_List;

/**
 * Generated Interface for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_ASP_Ref_ListInput extends I_ASP_Ref_List {

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
	 * Set AD_Ref_List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List);

	/**
	 * Get AD_Ref_List.
	 *
	 * @return Reference List based on Table
	 */
	ForeignEntityInput AD_Ref_List();

	/**
	 * Set ASP_Level.
	 *
	 * @param ASP_Level ASP_Level
	 */
	void setASP_LevelInput(ForeignEntityInput ASP_Level);

	/**
	 * Get ASP_Level.
	 *
	 * @return ASP_Level
	 */
	ForeignEntityInput ASP_Level();

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
	 * Set ASP_Status.
	 *
	 * @param ASP_Status ASP_Status
	 */
	void setASP_StatusInput(ForeignEntityInput ASP_Status);

	/**
	 * Get ASP_Status.
	 *
	 * @return ASP_Status
	 */
	ForeignEntityInput ASP_Status();
}
