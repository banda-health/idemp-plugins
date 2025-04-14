package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Benchmark;

/**
 * Generated Interface for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_PA_BenchmarkInput extends I_PA_Benchmark {

	/**
	 * Set AccumulationType.
	 *
	 * @param AccumulationType How to accumulate data on time axis
	 */
	void setAccumulationTypeInput(ForeignEntityInput AccumulationType);

	/**
	 * Get AccumulationType.
	 *
	 * @return How to accumulate data on time axis
	 */
	ForeignEntityInput AccumulationType();

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
}
