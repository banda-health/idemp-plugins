package org.bandahealth.idempiere.graphql.model.input;

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

	 private I_AD_OrgInput AD_Org;
	 private I_PA_BenchmarkInput PA_Benchmark;

	/**
	 * Standard constructor
	 */
	public X_PA_BenchmarkDataInput(String ID) {
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
	 * Set Benchmark.
	 *
	 * @param PA_Benchmark Performance Benchmark
	 */
	public void setPA_Benchmark(I_PA_BenchmarkInput PA_Benchmark) {
		this.PA_Benchmark = PA_Benchmark;
		X_PA_Benchmark foreignEntity;
		if (get_ID() == 0 &&PA_Benchmark != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Benchmark.Table_Name, X_PA_Benchmark.COLUMNNAME_PA_Benchmark_UU + "=?", get_TrxName())
						.setParameters(PA_Benchmark.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Benchmark_ID(foreignEntity.get_ID());
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
