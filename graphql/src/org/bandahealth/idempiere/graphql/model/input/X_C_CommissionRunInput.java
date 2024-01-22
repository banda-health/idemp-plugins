package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionRunInput extends MCommissionRun implements I_C_CommissionRunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Commission;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CommissionRunInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCommissionRun(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Commission.
	 *
	 * @param C_Commission Commission
	 */
	@JsonProperty("C_Commission")
	public void setC_CommissionInput(ForeignEntityInput C_Commission) {
		this.mC_Commission = C_Commission;
		MCommission foreignEntity;
		if (get_ID() == 0 && C_Commission != null &&
				(foreignEntity = new Query(getCtx(), "C_Commission", "C_Commission_UU=?", get_TrxName())
						.setParameters(C_Commission.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Commission_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CommissionRun_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
