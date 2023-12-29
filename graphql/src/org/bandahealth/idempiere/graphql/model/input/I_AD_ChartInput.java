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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set ChartOrientation_RL.
	 *
	 * @param ChartOrientation_RL The orientation of the chart.
	 */
	void setChartOrientation_RL(I_AD_Ref_ListInput ChartOrientation_RL);

	/**
	 * Get ChartOrientation_RL.
	 *
	 * @return The orientation of the chart.
	 */
	I_AD_Ref_ListInput getChartOrientation_RL();

	/**
	 * Set ChartType_RL.
	 *
	 * @param ChartType_RL Type of chart to render
	 */
	void setChartType_RL(I_AD_Ref_ListInput ChartType_RL);

	/**
	 * Get ChartType_RL.
	 *
	 * @return Type of chart to render
	 */
	I_AD_Ref_ListInput getChartType_RL();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set TimeUnit_RL.
	 *
	 * @param TimeUnit_RL The unit of time for grouping chart data.
	 */
	void setTimeUnit_RL(I_AD_Ref_ListInput TimeUnit_RL);

	/**
	 * Get TimeUnit_RL.
	 *
	 * @return The unit of time for grouping chart data.
	 */
	I_AD_Ref_ListInput getTimeUnit_RL();
}
