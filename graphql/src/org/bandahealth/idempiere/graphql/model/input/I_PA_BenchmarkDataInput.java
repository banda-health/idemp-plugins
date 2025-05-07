package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_BenchmarkData;

/**
 * Generated Interface for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_BenchmarkDataInput extends I_PA_BenchmarkData {

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

	/**
	 * Set PA_Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	void setPA_BenchmarkInput(ForeignEntityInput PA_Benchmark);

	/**
	 * Get PA_Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	ForeignEntityInput PA_Benchmark();
}
