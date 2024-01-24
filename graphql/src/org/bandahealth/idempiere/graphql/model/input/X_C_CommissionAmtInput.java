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
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionAmtInput extends MCommissionAmt implements I_C_CommissionAmtInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CommissionLine;
	private ForeignEntityInput mC_CommissionRun;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_CommissionAmt_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CommissionAmtInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MCommissionAmt(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Commission Amount.
	 *
	 * @param C_CommissionAmt_ID Generated Commission Amount 
	 */

	public void setC_CommissionAmt_ID(int C_CommissionAmt_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionAmt_ID(C_CommissionAmt_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_CommissionAmt_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MCommissionLine foreignEntity;
		if (C_CommissionLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_CommissionLine", "C_CommissionLine_UU=?", get_TrxName())
							.setParameters(C_CommissionLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_CommissionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CommissionLine with UUID " + C_CommissionLine.getUUID());
			}
		} else {
			super.setC_CommissionLine_ID(0);
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
		MCommissionRun foreignEntity;
		if (get_ID() == 0 && C_CommissionRun != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_CommissionRun", "C_CommissionRun_UU=?", get_TrxName())
							.setParameters(C_CommissionRun.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_CommissionRun_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CommissionRun with UUID " + C_CommissionRun.getUUID());
			}
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
