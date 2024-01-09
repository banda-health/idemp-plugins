package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MHierarchy;
import org.compiere.model.MMeasure;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.MRequestType;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_Ratio;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureInput extends MMeasure implements I_PA_MeasureInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_ProjectType;
	 private ForeignEntityInput mPA_Benchmark;
	 private ForeignEntityInput mPA_Hierarchy;
	 private ForeignEntityInput mPA_MeasureCalc;
	 private ForeignEntityInput mPA_Ratio;
	 private ForeignEntityInput mR_RequestType;
	 private I_AD_Ref_ListInput mMeasureDataType;
	 private I_AD_Ref_ListInput mMeasureType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_MeasureInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Project Type.
	 *
	 * @param C_ProjectType Type of the project
	 */
	@JsonProperty("C_ProjectType")
	public void setC_ProjectTypeInput(ForeignEntityInput C_ProjectType) {
		this.mC_ProjectType = C_ProjectType;
		MProjectType foreignEntity;
		if (C_ProjectType != null &&
				(foreignEntity = new Query(getCtx(), MProjectType.Table_Name, MProjectType.COLUMNNAME_C_ProjectType_UU + "=?", get_TrxName())
						.setParameters(C_ProjectType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectType_ID(foreignEntity.get_ID());
		} else {
			super.setC_ProjectType_ID(0);
		}
	}

	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	@JsonProperty("C_ProjectType")
	public ForeignEntityInput C_ProjectType() {
		return mC_ProjectType;
	}

	/**
	 * Set Measure Data Type.
	 *
	 * @param MeasureDataType Type of data - Status or in Time
	 */
	@JsonProperty("MeasureDataType")
	public void setMeasureDataTypeInput(I_AD_Ref_ListInput MeasureDataType) {
		this.mMeasureDataType = MeasureDataType;
		MRefList_BH foreignEntity;
		if (MeasureDataType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureDataType.getID())
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
	@JsonProperty("MeasureDataType")
	public I_AD_Ref_ListInput MeasureDataType() {
		return mMeasureDataType;
	}

	/**
	 * Set Measure Type.
	 *
	 * @param MeasureType Determines how the actual performance is derived
	 */
	@JsonProperty("MeasureType")
	public void setMeasureTypeInput(I_AD_Ref_ListInput MeasureType) {
		this.mMeasureType = MeasureType;
		MRefList_BH foreignEntity;
		if (MeasureType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureType.getID())
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
	@JsonProperty("MeasureType")
	public I_AD_Ref_ListInput MeasureType() {
		return mMeasureType;
	}

	/**
	 * Set Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	@JsonProperty("PA_Benchmark")
	public void setPA_BenchmarkInput(ForeignEntityInput PA_Benchmark) {
		this.mPA_Benchmark = PA_Benchmark;
		X_PA_Benchmark foreignEntity;
		if (PA_Benchmark != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Benchmark.Table_Name, X_PA_Benchmark.COLUMNNAME_PA_Benchmark_UU + "=?", get_TrxName())
						.setParameters(PA_Benchmark.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Benchmark_ID(foreignEntity.get_ID());
		} else {
			super.setPA_Benchmark_ID(0);
		}
	}

	/**
	 * Get Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	@JsonProperty("PA_Benchmark")
	public ForeignEntityInput PA_Benchmark() {
		return mPA_Benchmark;
	}

	/**
	 * Set Reporting Hierarchy.
	 *
	 * @param PA_Hierarchy Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	@JsonProperty("PA_Hierarchy")
	public void setPA_HierarchyInput(ForeignEntityInput PA_Hierarchy) {
		this.mPA_Hierarchy = PA_Hierarchy;
		MHierarchy foreignEntity;
		if (PA_Hierarchy != null &&
				(foreignEntity = new Query(getCtx(), MHierarchy.Table_Name, MHierarchy.COLUMNNAME_PA_Hierarchy_UU + "=?", get_TrxName())
						.setParameters(PA_Hierarchy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Hierarchy_ID(foreignEntity.get_ID());
		} else {
			super.setPA_Hierarchy_ID(0);
		}
	}

	/**
	 * Get Reporting Hierarchy.
	 *
	 * @return Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	@JsonProperty("PA_Hierarchy")
	public ForeignEntityInput PA_Hierarchy() {
		return mPA_Hierarchy;
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
	@JsonProperty("PA_MeasureCalc")
	public void setPA_MeasureCalcInput(ForeignEntityInput PA_MeasureCalc) {
		this.mPA_MeasureCalc = PA_MeasureCalc;
		MMeasureCalc foreignEntity;
		if (PA_MeasureCalc != null &&
				(foreignEntity = new Query(getCtx(), MMeasureCalc.Table_Name, MMeasureCalc.COLUMNNAME_PA_MeasureCalc_UU + "=?", get_TrxName())
						.setParameters(PA_MeasureCalc.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_MeasureCalc_ID(foreignEntity.get_ID());
		} else {
			super.setPA_MeasureCalc_ID(0);
		}
	}

	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	@JsonProperty("PA_MeasureCalc")
	public ForeignEntityInput PA_MeasureCalc() {
		return mPA_MeasureCalc;
	}

	/**
	 * Set Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public void setPA_RatioInput(ForeignEntityInput PA_Ratio) {
		this.mPA_Ratio = PA_Ratio;
		X_PA_Ratio foreignEntity;
		if (PA_Ratio != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_Ratio.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Ratio_ID(foreignEntity.get_ID());
		} else {
			super.setPA_Ratio_ID(0);
		}
	}

	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public ForeignEntityInput PA_Ratio() {
		return mPA_Ratio;
	}

	/**
	 * Set Request Type.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public void setR_RequestTypeInput(ForeignEntityInput R_RequestType) {
		this.mR_RequestType = R_RequestType;
		MRequestType foreignEntity;
		if (R_RequestType != null &&
				(foreignEntity = new Query(getCtx(), MRequestType.Table_Name, MRequestType.COLUMNNAME_R_RequestType_UU + "=?", get_TrxName())
						.setParameters(R_RequestType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_RequestType_ID(foreignEntity.get_ID());
		} else {
			super.setR_RequestType_ID(0);
		}
	}

	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public ForeignEntityInput R_RequestType() {
		return mR_RequestType;
	}
}
