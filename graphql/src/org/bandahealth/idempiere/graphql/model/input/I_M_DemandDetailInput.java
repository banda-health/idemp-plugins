package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_DemandDetail;

/**
 * Generated Interface for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_DemandDetailInput extends I_M_DemandDetail {

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
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();

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
	 * Set M_DemandLine.
	 *
	 * @param M_DemandLine Material Demand Line
	 */
	void setM_DemandLineInput(ForeignEntityInput M_DemandLine);

	/**
	 * Get M_DemandLine.
	 *
	 * @return Material Demand Line
	 */
	ForeignEntityInput M_DemandLine();

	/**
	 * Set M_ForecastLine.
	 *
	 * @param M_ForecastLine Forecast Line
	 */
	void setM_ForecastLineInput(ForeignEntityInput M_ForecastLine);

	/**
	 * Get M_ForecastLine.
	 *
	 * @return Forecast Line
	 */
	ForeignEntityInput M_ForecastLine();

	/**
	 * Set M_RequisitionLine.
	 *
	 * @param M_RequisitionLine Material Requisition Line
	 */
	void setM_RequisitionLineInput(ForeignEntityInput M_RequisitionLine);

	/**
	 * Get M_RequisitionLine.
	 *
	 * @return Material Requisition Line
	 */
	ForeignEntityInput M_RequisitionLine();
}
