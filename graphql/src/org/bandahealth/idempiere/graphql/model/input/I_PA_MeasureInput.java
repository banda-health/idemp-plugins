package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Measure;

/**
 * Generated Interface for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_MeasureInput extends I_PA_Measure {

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
	 * Set C_ProjectType.
	 *
	 * @param C_ProjectType Type of the project
	 */
	void setC_ProjectTypeInput(ForeignEntityInput C_ProjectType);

	/**
	 * Get C_ProjectType.
	 *
	 * @return Type of the project
	 */
	ForeignEntityInput C_ProjectType();

	/**
	 * Set MeasureDataType.
	 *
	 * @param MeasureDataType Type of data - Status or in Time
	 */
	void setMeasureDataTypeInput(ForeignEntityInput MeasureDataType);

	/**
	 * Get MeasureDataType.
	 *
	 * @return Type of data - Status or in Time
	 */
	ForeignEntityInput MeasureDataType();

	/**
	 * Set MeasureType.
	 *
	 * @param MeasureType Determines how the actual performance is derived
	 */
	void setMeasureTypeInput(ForeignEntityInput MeasureType);

	/**
	 * Get MeasureType.
	 *
	 * @return Determines how the actual performance is derived
	 */
	ForeignEntityInput MeasureType();

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
	 * Set PA_Hierarchy.
	 *
	 * @param PA_Hierarchy Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	void setPA_HierarchyInput(ForeignEntityInput PA_Hierarchy);

	/**
	 * Get PA_Hierarchy.
	 *
	 * @return Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	ForeignEntityInput PA_Hierarchy();

	/**
	 * Set PA_MeasureCalc.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	void setPA_MeasureCalcInput(ForeignEntityInput PA_MeasureCalc);

	/**
	 * Get PA_MeasureCalc.
	 *
	 * @return Calculation method for measuring performance
	 */
	ForeignEntityInput PA_MeasureCalc();

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
	 * Set PA_Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	void setPA_RatioInput(ForeignEntityInput PA_Ratio);

	/**
	 * Get PA_Ratio.
	 *
	 * @return Performance Ratio
	 */
	ForeignEntityInput PA_Ratio();

	/**
	 * Set R_RequestType.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	void setR_RequestTypeInput(ForeignEntityInput R_RequestType);

	/**
	 * Get R_RequestType.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	ForeignEntityInput R_RequestType();
}
