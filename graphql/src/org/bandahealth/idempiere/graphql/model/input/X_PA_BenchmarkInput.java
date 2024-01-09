package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkInput extends X_PA_Benchmark implements I_PA_BenchmarkInput {

	 private ForeignEntityInput mAD_Org;
	 private I_AD_Ref_ListInput mAccumulationType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_BenchmarkInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Accumulation Type.
	 *
	 * @param AccumulationType How to accumulate data on time axis
	 */
	@JsonProperty("AccumulationType")
	public void setAccumulationTypeInput(I_AD_Ref_ListInput AccumulationType) {
		this.mAccumulationType = AccumulationType;
		MRefList_BH foreignEntity;
		if (AccumulationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccumulationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccumulationType(foreignEntity.getValue());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Benchmark_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Benchmark_UU();
	}
}
