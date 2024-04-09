package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_BenchmarkInput extends X_PA_Benchmark implements I_PA_BenchmarkInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAccumulationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_Benchmark_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_BenchmarkInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Accumulation Type.
	 *
	 * @param AccumulationType How to accumulate data on time axis
	 */
	@JsonProperty("AccumulationType")
	public void setAccumulationTypeInput(I_AD_Ref_ListInput AccumulationType) {
		this.mAccumulationType = AccumulationType;
		if (AccumulationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccumulationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccumulationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccumulationType.getUU());
			}
		} else {
			this.setAccumulationType(null);
		}
	}

	/**
	 * Get Accumulation Type.
	 *
	 * @return How to accumulate data on time axis
	 */
	@JsonProperty("AccumulationType")
	public I_AD_Ref_ListInput AccumulationType() {
		return mAccumulationType;
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
	 * @param PA_Benchmark_ID Performance Benchmark
	 */

	public void setPA_Benchmark_ID(int PA_Benchmark_ID) {
		if (get_ID() == 0) {
			super.setPA_Benchmark_ID(PA_Benchmark_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_Benchmark_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPA_Benchmark_UU();
	}
}
