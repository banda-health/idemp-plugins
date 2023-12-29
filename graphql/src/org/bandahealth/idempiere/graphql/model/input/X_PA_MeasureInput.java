package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MHierarchy;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.MRefList;
import org.compiere.model.MRequestType;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_Measure;
import org.compiere.model.X_PA_Ratio;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureInput extends X_PA_Measure implements I_PA_MeasureInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput MeasureDataType_RL;
	 private I_AD_Ref_ListInput MeasureType_RL;
	 private I_C_ProjectTypeInput C_ProjectType;
	 private I_PA_BenchmarkInput PA_Benchmark;
	 private I_PA_HierarchyInput PA_Hierarchy;
	 private I_PA_MeasureCalcInput PA_MeasureCalc;
	 private I_PA_RatioInput PA_Ratio;
	 private I_R_RequestTypeInput R_RequestType;

	/**
	 * Standard constructor
	 */
	public X_PA_MeasureInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Project Type.
	 *
	 * @param C_ProjectType Type of the project
	 */
	public void setC_ProjectType(I_C_ProjectTypeInput C_ProjectType) {
		this.C_ProjectType = C_ProjectType;
		MProjectType foreignEntity;
		if (C_ProjectType != null &&
				(foreignEntity = new Query(getCtx(), MProjectType.Table_Name, MProjectType.COLUMNNAME_C_ProjectType_UU + "=?", get_TrxName())
						.setParameters(C_ProjectType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectType_ID(foreignEntity.get_ID());
		} else {
			this.setC_ProjectType_ID(0);
		}
	}

	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	public I_C_ProjectTypeInput getC_ProjectType() {
		return C_ProjectType;
	}

	/**
	 * Set Measure Data Type.
	 *
	 * @param MeasureDataType_RL Type of data - Status or in Time
	 */
	public void setMeasureDataType_RL(I_AD_Ref_ListInput MeasureDataType_RL) {
		this.MeasureDataType_RL = MeasureDataType_RL;
		MRefList foreignEntity;
		if (MeasureDataType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureDataType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMeasureDataType(foreignEntity.getValue());
		} else {
			this.setMeasureDataType(null);
		}
	}

	/**
	 * Get Measure Data Type.
	 *
	 * @return Type of data - Status or in Time
	 */
	public I_AD_Ref_ListInput getMeasureDataType_RL() {
		return MeasureDataType_RL;
	}

	/**
	 * Set Measure Type.
	 *
	 * @param MeasureType_RL Determines how the actual performance is derived
	 */
	public void setMeasureType_RL(I_AD_Ref_ListInput MeasureType_RL) {
		this.MeasureType_RL = MeasureType_RL;
		MRefList foreignEntity;
		if (MeasureType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMeasureType(foreignEntity.getValue());
		} else {
			this.setMeasureType(null);
		}
	}

	/**
	 * Get Measure Type.
	 *
	 * @return Determines how the actual performance is derived
	 */
	public I_AD_Ref_ListInput getMeasureType_RL() {
		return MeasureType_RL;
	}

	/**
	 * Set Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	public void setPA_Benchmark(I_PA_BenchmarkInput PA_Benchmark) {
		this.PA_Benchmark = PA_Benchmark;
		X_PA_Benchmark foreignEntity;
		if (PA_Benchmark != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Benchmark.Table_Name, X_PA_Benchmark.COLUMNNAME_PA_Benchmark_UU + "=?", get_TrxName())
						.setParameters(PA_Benchmark.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Benchmark_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Benchmark_ID(0);
		}
	}

	/**
	 * Get Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	public I_PA_BenchmarkInput getPA_Benchmark() {
		return PA_Benchmark;
	}

	/**
	 * Set Reporting Hierarchy.
	 *
	 * @param PA_Hierarchy Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	public void setPA_Hierarchy(I_PA_HierarchyInput PA_Hierarchy) {
		this.PA_Hierarchy = PA_Hierarchy;
		MHierarchy foreignEntity;
		if (PA_Hierarchy != null &&
				(foreignEntity = new Query(getCtx(), MHierarchy.Table_Name, MHierarchy.COLUMNNAME_PA_Hierarchy_UU + "=?", get_TrxName())
						.setParameters(PA_Hierarchy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Hierarchy_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Hierarchy_ID(0);
		}
	}

	/**
	 * Get Reporting Hierarchy.
	 *
	 * @return Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	public I_PA_HierarchyInput getPA_Hierarchy() {
		return PA_Hierarchy;
	}
	/**
	 * Set Measure.
	 *
	 * @param PA_Measure_ID Concrete Performance Measurement
	 */

	public void setPA_Measure_ID(int PA_Measure_ID) {
		if (get_ID() == 0) {
			super.setPA_Measure_ID(PA_Measure_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Measure_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Measure_UU();
	}

	/**
	 * Set Measure Calculation.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	public void setPA_MeasureCalc(I_PA_MeasureCalcInput PA_MeasureCalc) {
		this.PA_MeasureCalc = PA_MeasureCalc;
		MMeasureCalc foreignEntity;
		if (PA_MeasureCalc != null &&
				(foreignEntity = new Query(getCtx(), MMeasureCalc.Table_Name, MMeasureCalc.COLUMNNAME_PA_MeasureCalc_UU + "=?", get_TrxName())
						.setParameters(PA_MeasureCalc.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_MeasureCalc_ID(foreignEntity.get_ID());
		} else {
			this.setPA_MeasureCalc_ID(0);
		}
	}

	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	public I_PA_MeasureCalcInput getPA_MeasureCalc() {
		return PA_MeasureCalc;
	}

	/**
	 * Set Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	public void setPA_Ratio(I_PA_RatioInput PA_Ratio) {
		this.PA_Ratio = PA_Ratio;
		X_PA_Ratio foreignEntity;
		if (PA_Ratio != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_Ratio.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Ratio_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Ratio_ID(0);
		}
	}

	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	public I_PA_RatioInput getPA_Ratio() {
		return PA_Ratio;
	}

	/**
	 * Set Request Type.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public void setR_RequestType(I_R_RequestTypeInput R_RequestType) {
		this.R_RequestType = R_RequestType;
		MRequestType foreignEntity;
		if (R_RequestType != null &&
				(foreignEntity = new Query(getCtx(), MRequestType.Table_Name, MRequestType.COLUMNNAME_R_RequestType_UU + "=?", get_TrxName())
						.setParameters(R_RequestType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_RequestType_ID(foreignEntity.get_ID());
		} else {
			this.setR_RequestType_ID(0);
		}
	}

	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public I_R_RequestTypeInput getR_RequestType() {
		return R_RequestType;
	}
}
