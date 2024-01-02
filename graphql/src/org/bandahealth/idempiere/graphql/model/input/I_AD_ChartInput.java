package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Chart;

/**
 * Generated Interface for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ChartInput extends I_AD_Chart {

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
	 * Set ChartOrientation.
	 *
	 * @param ChartOrientation The orientation of the chart.
	 */
	void setChartOrientationInput(I_AD_Ref_ListInput ChartOrientation);

	/**
	 * Get ChartOrientation.
	 *
	 * @return The orientation of the chart.
	 */
	I_AD_Ref_ListInput ChartOrientation();

	/**
	 * Set ChartType.
	 *
	 * @param ChartType Type of chart to render
	 */
	void setChartTypeInput(I_AD_Ref_ListInput ChartType);

	/**
	 * Get ChartType.
	 *
	 * @return Type of chart to render
	 */
	I_AD_Ref_ListInput ChartType();

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
	 * Set TimeUnit.
	 *
	 * @param TimeUnit The unit of time for grouping chart data.
	 */
	void setTimeUnitInput(I_AD_Ref_ListInput TimeUnit);

	/**
	 * Get TimeUnit.
	 *
	 * @return The unit of time for grouping chart data.
	 */
	I_AD_Ref_ListInput TimeUnit();
}
