package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingInput extends MBHPayrollFiling implements I_BH_Payroll_FilingInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payroll_Run;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payroll_Filing_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payroll_FilingInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Payroll Run.
	 *
	 * @param BH_Payroll_Run Payroll Run
	 */
	@JsonProperty("BH_Payroll_Run")
	public void setBH_Payroll_RunInput(ForeignEntityInput BH_Payroll_Run) {
		this.mBH_Payroll_Run = BH_Payroll_Run;
		if (BH_Payroll_Run != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayrollRun foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payroll_Run", "BH_Payroll_Run_UU=?", get_TrxName())
							.setParameters(BH_Payroll_Run.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Payroll_Run_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payroll_Run with UU " + BH_Payroll_Run.getUU());
			}
		} else {
			this.setBH_Payroll_Run_ID(0);
		}
	}

	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	@JsonProperty("BH_Payroll_Run")
	public ForeignEntityInput BH_Payroll_Run() {
		return mBH_Payroll_Run;
	}

	/**
	 * Set Payroll Filing.
	 *
	 * @param BH_Payroll_Filing_ID Payroll Filing
	 */
	@JsonProperty("BH_Payroll_Filing_ID")
	public void setBH_Payroll_Filing_IDFromJson(int BH_Payroll_Filing_ID) {
		if (get_ID() == 0) {
			super.setBH_Payroll_Filing_ID(BH_Payroll_Filing_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Payroll_Filing_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Payroll_Filing_UU();
	}
}
