package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Chart;

/**
 * Generated Interface for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_ChartInput extends I_AD_Chart {

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
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

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
