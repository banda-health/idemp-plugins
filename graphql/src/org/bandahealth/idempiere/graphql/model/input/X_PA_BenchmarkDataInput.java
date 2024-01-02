package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_BenchmarkData;
import org.compiere.util.Env;

/**
 * Generated Model for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataInput extends X_PA_BenchmarkData implements I_PA_BenchmarkDataInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_PA_BenchmarkInput mPA_Benchmark;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_BenchmarkDataInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	@JsonProperty("PA_Benchmark")
	public void setPA_BenchmarkInput(I_PA_BenchmarkInput PA_Benchmark) {
		this.mPA_Benchmark = PA_Benchmark;
		X_PA_Benchmark foreignEntity;
		if (get_ID() == 0 &&PA_Benchmark != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Benchmark.Table_Name, X_PA_Benchmark.COLUMNNAME_PA_Benchmark_UU + "=?", get_TrxName())
						.setParameters(PA_Benchmark.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Benchmark_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	@JsonProperty("PA_Benchmark")
	public I_PA_BenchmarkInput PA_Benchmark() {
		return mPA_Benchmark;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_BenchmarkData_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_BenchmarkData_UU();
	}
}
