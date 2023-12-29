package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Benchmark;

/**
 * Generated Interface for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_BenchmarkInput extends I_PA_Benchmark {

	/**
	 * Set AccumulationType_RL.
	 *
	 * @param AccumulationType_RL How to accumulate data on time axis
	 */
	void setAccumulationType_RL(I_AD_Ref_ListInput AccumulationType_RL);

	/**
	 * Get AccumulationType_RL.
	 *
	 * @return How to accumulate data on time axis
	 */
	I_AD_Ref_ListInput getAccumulationType_RL();

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
