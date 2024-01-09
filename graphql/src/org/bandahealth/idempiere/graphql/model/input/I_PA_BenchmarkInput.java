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
	 * Set AccumulationType.
	 *
	 * @param AccumulationType How to accumulate data on time axis
	 */
	void setAccumulationTypeInput(I_AD_Ref_ListInput AccumulationType);

	/**
	 * Get AccumulationType.
	 *
	 * @return How to accumulate data on time axis
	 */
	I_AD_Ref_ListInput AccumulationType();

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
