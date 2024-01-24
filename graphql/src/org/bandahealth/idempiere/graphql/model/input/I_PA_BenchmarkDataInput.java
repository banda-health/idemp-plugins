package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_BenchmarkData;

/**
 * Generated Interface for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_BenchmarkDataInput extends I_PA_BenchmarkData {

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
}
