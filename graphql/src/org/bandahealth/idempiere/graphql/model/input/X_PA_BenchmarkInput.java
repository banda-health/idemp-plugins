package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AccumulationType_RL;

	/**
	 * Standard constructor
	 */
	public X_PA_BenchmarkInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Accumulation Type.
	 *
	 * @param AccumulationType_RL How to accumulate data on time axis
	 */
	public void setAccumulationType_RL(I_AD_Ref_ListInput AccumulationType_RL) {
		this.AccumulationType_RL = AccumulationType_RL;
		MRefList foreignEntity;
		if (AccumulationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccumulationType_RL.getID())
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
	public I_AD_Ref_ListInput getAccumulationType_RL() {
		return AccumulationType_RL;
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
