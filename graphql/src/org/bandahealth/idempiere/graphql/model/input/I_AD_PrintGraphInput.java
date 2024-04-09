package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintGraph;

/**
 * Generated Interface for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_PrintGraphInput extends I_AD_PrintGraph {

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

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
	 * Set Data_PrintFormatItem.
	 *
	 * @param Data_PrintFormatItem Data Column for Pie and Line Charts
	 */
	void setData_PrintFormatItemInput(ForeignEntityInput Data_PrintFormatItem);

	/**
	 * Get Data_PrintFormatItem.
	 *
	 * @return Data Column for Pie and Line Charts
	 */
	ForeignEntityInput Data_PrintFormatItem();

	/**
	 * Set Data1_PrintFormatItem.
	 *
	 * @param Data1_PrintFormatItem Data Column for Line Charts
	 */
	void setData1_PrintFormatItemInput(ForeignEntityInput Data1_PrintFormatItem);

	/**
	 * Get Data1_PrintFormatItem.
	 *
	 * @return Data Column for Line Charts
	 */
	ForeignEntityInput Data1_PrintFormatItem();

	/**
	 * Set Data2_PrintFormatItem.
	 *
	 * @param Data2_PrintFormatItem Data Column for Line Charts
	 */
	void setData2_PrintFormatItemInput(ForeignEntityInput Data2_PrintFormatItem);

	/**
	 * Get Data2_PrintFormatItem.
	 *
	 * @return Data Column for Line Charts
	 */
	ForeignEntityInput Data2_PrintFormatItem();

	/**
	 * Set Data3_PrintFormatItem.
	 *
	 * @param Data3_PrintFormatItem Data Column for Line Charts
	 */
	void setData3_PrintFormatItemInput(ForeignEntityInput Data3_PrintFormatItem);

	/**
	 * Get Data3_PrintFormatItem.
	 *
	 * @return Data Column for Line Charts
	 */
	ForeignEntityInput Data3_PrintFormatItem();

	/**
	 * Set Data4_PrintFormatItem.
	 *
	 * @param Data4_PrintFormatItem Data Column for Line Charts
	 */
	void setData4_PrintFormatItemInput(ForeignEntityInput Data4_PrintFormatItem);

	/**
	 * Get Data4_PrintFormatItem.
	 *
	 * @return Data Column for Line Charts
	 */
	ForeignEntityInput Data4_PrintFormatItem();

	/**
	 * Set Description_PrintFormatItem.
	 *
	 * @param Description_PrintFormatItem Description Column for Pie/Line/Bar Charts
	 */
	void setDescription_PrintFormatItemInput(ForeignEntityInput Description_PrintFormatItem);

	/**
	 * Get Description_PrintFormatItem.
	 *
	 * @return Description Column for Pie/Line/Bar Charts
	 */
	ForeignEntityInput Description_PrintFormatItem();

	/**
	 * Set GraphType.
	 *
	 * @param GraphType Type of graph to be painted
	 */
	void setGraphTypeInput(I_AD_Ref_ListInput GraphType);

	/**
	 * Get GraphType.
	 *
	 * @return Type of graph to be painted
	 */
	I_AD_Ref_ListInput GraphType();
}
