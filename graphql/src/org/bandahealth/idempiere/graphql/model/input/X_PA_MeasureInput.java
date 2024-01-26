package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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

import java.sql.ResultSet;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Measure_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_MeasureInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (C_ProjectType != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectType", "C_ProjectType_UU=?", get_TrxName())
							.setParameters(C_ProjectType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ProjectType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectType with UUID " + C_ProjectType.getUUID());
			}
		} else {
			this.setC_ProjectType_ID(0);
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
		if (MeasureDataType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MeasureDataType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setMeasureDataType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + MeasureDataType.getUUID());
			}
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
		if (MeasureType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MeasureType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setMeasureType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + MeasureType.getUUID());
			}
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
		if (PA_Benchmark != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_Benchmark foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Benchmark", "PA_Benchmark_UU=?", get_TrxName())
							.setParameters(PA_Benchmark.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_Benchmark_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Benchmark with UUID " + PA_Benchmark.getUUID());
			}
		} else {
			this.setPA_Benchmark_ID(0);
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
		if (PA_Hierarchy != null) {
			// Since an entity was passed, make sure it's in the DB
			MHierarchy foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Hierarchy", "PA_Hierarchy_UU=?", get_TrxName())
							.setParameters(PA_Hierarchy.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_Hierarchy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Hierarchy with UUID " + PA_Hierarchy.getUUID());
			}
		} else {
			this.setPA_Hierarchy_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_Measure_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (PA_MeasureCalc != null) {
			// Since an entity was passed, make sure it's in the DB
			MMeasureCalc foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_MeasureCalc", "PA_MeasureCalc_UU=?", get_TrxName())
							.setParameters(PA_MeasureCalc.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_MeasureCalc_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_MeasureCalc with UUID " + PA_MeasureCalc.getUUID());
			}
		} else {
			this.setPA_MeasureCalc_ID(0);
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
		if (PA_Ratio != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_Ratio foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Ratio", "PA_Ratio_UU=?", get_TrxName())
							.setParameters(PA_Ratio.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_Ratio_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Ratio with UUID " + PA_Ratio.getUUID());
			}
		} else {
			this.setPA_Ratio_ID(0);
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
		if (R_RequestType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequestType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UUID " + R_RequestType.getUUID());
			}
		} else {
			this.setR_RequestType_ID(0);
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
