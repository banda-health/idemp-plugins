package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_BenchmarkData;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_BenchmarkDataInput extends X_PA_BenchmarkData implements I_PA_BenchmarkDataInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mPA_Benchmark;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_BenchmarkData_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_BenchmarkDataInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (PA_Benchmark != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_Benchmark foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Benchmark", "PA_Benchmark_UU=?", get_TrxName())
							.setParameters(PA_Benchmark.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_Benchmark_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Benchmark with UU " + PA_Benchmark.getUU());
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
	 * Set Benchmark Data.
	 *
	 * @param PA_BenchmarkData_ID Performance Benchmark Data Point
	 */
	@JsonProperty("PA_BenchmarkData_ID")
	public void setPA_BenchmarkData_IDFromJson(int PA_BenchmarkData_ID) {
		if (get_ID() == 0) {
			super.setPA_BenchmarkData_ID(PA_BenchmarkData_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_BenchmarkData_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPA_BenchmarkData_UU();
	}
}
