package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Measure;

/**
 * Generated Interface for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_MeasureInput extends I_PA_Measure {

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
	 * Set C_ProjectType.
	 *
	 * @param C_ProjectType Type of the project
	 */
	void setC_ProjectType(I_C_ProjectTypeInput C_ProjectType);

	/**
	 * Get C_ProjectType.
	 *
	 * @return Type of the project
	 */
	I_C_ProjectTypeInput getC_ProjectType();

	/**
	 * Set MeasureDataType_RL.
	 *
	 * @param MeasureDataType_RL Type of data - Status or in Time
	 */
	void setMeasureDataType_RL(I_AD_Ref_ListInput MeasureDataType_RL);

	/**
	 * Get MeasureDataType_RL.
	 *
	 * @return Type of data - Status or in Time
	 */
	I_AD_Ref_ListInput getMeasureDataType_RL();

	/**
	 * Set MeasureType_RL.
	 *
	 * @param MeasureType_RL Determines how the actual performance is derived
	 */
	void setMeasureType_RL(I_AD_Ref_ListInput MeasureType_RL);

	/**
	 * Get MeasureType_RL.
	 *
	 * @return Determines how the actual performance is derived
	 */
	I_AD_Ref_ListInput getMeasureType_RL();

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
	 * Set PA_Hierarchy.
	 *
	 * @param PA_Hierarchy Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	void setPA_Hierarchy(I_PA_HierarchyInput PA_Hierarchy);

	/**
	 * Get PA_Hierarchy.
	 *
	 * @return Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	I_PA_HierarchyInput getPA_Hierarchy();

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
	 * Set PA_MeasureCalc.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	void setPA_MeasureCalc(I_PA_MeasureCalcInput PA_MeasureCalc);

	/**
	 * Get PA_MeasureCalc.
	 *
	 * @return Calculation method for measuring performance
	 */
	I_PA_MeasureCalcInput getPA_MeasureCalc();

	/**
	 * Set PA_Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	void setPA_Ratio(I_PA_RatioInput PA_Ratio);

	/**
	 * Get PA_Ratio.
	 *
	 * @return Performance Ratio
	 */
	I_PA_RatioInput getPA_Ratio();

	/**
	 * Set R_RequestType.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	void setR_RequestType(I_R_RequestTypeInput R_RequestType);

	/**
	 * Get R_RequestType.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	I_R_RequestTypeInput getR_RequestType();
}
