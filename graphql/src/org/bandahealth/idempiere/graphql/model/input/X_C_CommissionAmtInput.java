package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommissionAmt;
import org.compiere.model.MCommissionLine;
import org.compiere.model.MCommissionRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionAmtInput extends MCommissionAmt implements I_C_CommissionAmtInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CommissionLine;
	private ForeignEntityInput mC_CommissionRun;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_CommissionAmt_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CommissionAmtInput(@JsonProperty("UU") String UU) {
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
	 * Set Commission Amount.
	 *
	 * @param C_CommissionAmt_ID Generated Commission Amount 
	 */
	@JsonProperty("C_CommissionAmt_ID")
	public void setC_CommissionAmt_IDFromJson(int C_CommissionAmt_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionAmt_ID(C_CommissionAmt_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_CommissionAmt_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_CommissionAmt_UU();
	}

	/**
	 * Set Commission Line.
	 *
	 * @param C_CommissionLine Commission Line
	 */
	@JsonProperty("C_CommissionLine")
	public void setC_CommissionLineInput(ForeignEntityInput C_CommissionLine) {
		this.mC_CommissionLine = C_CommissionLine;
		if (C_CommissionLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MCommissionLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CommissionLine", "C_CommissionLine_UU=?", get_TrxName())
							.setParameters(C_CommissionLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CommissionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CommissionLine with UU " + C_CommissionLine.getUU());
			}
		} else {
			this.setC_CommissionLine_ID(0);
		}
	}

	/**
	 * Get Commission Line.
	 *
	 * @return Commission Line
	 */
	@JsonProperty("C_CommissionLine")
	public ForeignEntityInput C_CommissionLine() {
		return mC_CommissionLine;
	}

	/**
	 * Set Commission Run.
	 *
	 * @param C_CommissionRun Commission Run or Process
	 */
	@JsonProperty("C_CommissionRun")
	public void setC_CommissionRunInput(ForeignEntityInput C_CommissionRun) {
		this.mC_CommissionRun = C_CommissionRun;
		if (get_ID() != 0) {
			return;
		}
		if (C_CommissionRun != null) {
			// Since an entity was passed, make sure it's in the DB
			MCommissionRun foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CommissionRun", "C_CommissionRun_UU=?", get_TrxName())
							.setParameters(C_CommissionRun.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_CommissionRun_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CommissionRun with UU " + C_CommissionRun.getUU());
			}
		} else {
			this.setC_CommissionRun_ID(0);
		}
	}

	/**
	 * Get Commission Run.
	 *
	 * @return Commission Run or Process
	 */
	@JsonProperty("C_CommissionRun")
	public ForeignEntityInput C_CommissionRun() {
		return mC_CommissionRun;
	}
}
