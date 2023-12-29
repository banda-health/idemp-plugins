package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_BenchmarkData;

/**
 * Generated Interface for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_BenchmarkDataInput extends I_PA_BenchmarkData {

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
	 * Set PA_Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	void setPA_Benchmark(I_PA_BenchmarkInput PA_Benchmark);

	/**
	 * Get PA_Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	I_PA_BenchmarkInput getPA_Benchmark();

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
}
