package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_BenchmarkData;

import java.sql.ResultSet;

/**
 * Generated Model for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataInput extends X_PA_BenchmarkData implements I_PA_BenchmarkDataInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mPA_Benchmark;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_BenchmarkDataInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PA_BenchmarkData(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	 * Set Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	@JsonProperty("PA_Benchmark")
	public void setPA_BenchmarkInput(ForeignEntityInput PA_Benchmark) {
		this.mPA_Benchmark = PA_Benchmark;
		X_PA_Benchmark foreignEntity;
		if (get_ID() == 0 && PA_Benchmark != null &&
				(foreignEntity = new Query(getCtx(), "PA_Benchmark", "PA_Benchmark_UU=?", get_TrxName())
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
	public ForeignEntityInput PA_Benchmark() {
		return mPA_Benchmark;
	}
	/**
	 * Set Benchmark Data.
	 *
	 * @param PA_BenchmarkData_ID Performance Benchmark Data Point
	 */

	public void setPA_BenchmarkData_ID(int PA_BenchmarkData_ID) {
		if (get_ID() == 0) {
			super.setPA_BenchmarkData_ID(PA_BenchmarkData_ID);
		}
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
