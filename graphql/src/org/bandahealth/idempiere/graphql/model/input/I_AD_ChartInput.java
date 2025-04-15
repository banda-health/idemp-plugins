package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Chart;

/**
 * Generated Interface for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_ChartInput extends I_AD_Chart {

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
	 * Set ChartOrientation.
	 *
	 * @param ChartOrientation The orientation of the chart.
	 */
	void setChartOrientationInput(ForeignEntityInput ChartOrientation);

	/**
	 * Get ChartOrientation.
	 *
	 * @return The orientation of the chart.
	 */
	ForeignEntityInput ChartOrientation();

	/**
	 * Set ChartType.
	 *
	 * @param ChartType Type of chart to render
	 */
	void setChartTypeInput(ForeignEntityInput ChartType);

	/**
	 * Get ChartType.
	 *
	 * @return Type of chart to render
	 */
	ForeignEntityInput ChartType();

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
	void setTimeUnitInput(ForeignEntityInput TimeUnit);

	/**
	 * Get TimeUnit.
	 *
	 * @return The unit of time for grouping chart data.
	 */
	ForeignEntityInput TimeUnit();
}
