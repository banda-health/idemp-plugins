package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionRunInput extends MCommissionRun implements I_C_CommissionRunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Commission;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_CommissionRun_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CommissionRunInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MCommissionRun(null, (ResultSet) null, null),
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
	 * Set Commission.
	 *
	 * @param C_Commission Commission
	 */
	@JsonProperty("C_Commission")
	public void setC_CommissionInput(ForeignEntityInput C_Commission) {
		this.mC_Commission = C_Commission;
		MCommission foreignEntity;
		if (get_ID() == 0 && C_Commission != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Commission", "C_Commission_UU=?", get_TrxName())
							.setParameters(C_Commission.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Commission_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Commission with UUID " + C_Commission.getUUID());
			}
		}
	}

	/**
	 * Get Commission.
	 *
	 * @return Commission
	 */
	@JsonProperty("C_Commission")
	public ForeignEntityInput C_Commission() {
		return mC_Commission;
	}
	/**
	 * Set Commission Run.
	 *
	 * @param C_CommissionRun_ID Commission Run or Process
	 */

	public void setC_CommissionRun_ID(int C_CommissionRun_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionRun_ID(C_CommissionRun_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_CommissionRun_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_CommissionRun_UU();
	}
	/**
	 * Set Grand Total.
	 *
	 * @param GrandTotal Total amount of document
	 */

	public void setGrandTotal(BigDecimal GrandTotal) {
		if (get_ID() == 0) {
			super.setGrandTotal(GrandTotal);
		}
	}
}
