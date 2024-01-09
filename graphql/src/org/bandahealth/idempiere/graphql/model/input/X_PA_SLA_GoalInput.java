package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSLACriteria;
import org.compiere.model.MSLAGoal;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_GoalInput extends MSLAGoal implements I_PA_SLA_GoalInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_BPartner;
	 private ForeignEntityInput mPA_SLA_Criteria;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_SLA_GoalInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set SLA Criteria.
	 *
	 * @param PA_SLA_Criteria Service Level Agreement Criteria
	 */
	@JsonProperty("PA_SLA_Criteria")
	public void setPA_SLA_CriteriaInput(ForeignEntityInput PA_SLA_Criteria) {
		this.mPA_SLA_Criteria = PA_SLA_Criteria;
		MSLACriteria foreignEntity;
		if (PA_SLA_Criteria != null &&
				(foreignEntity = new Query(getCtx(), MSLACriteria.Table_Name, MSLACriteria.COLUMNNAME_PA_SLA_Criteria_UU + "=?", get_TrxName())
						.setParameters(PA_SLA_Criteria.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_SLA_Criteria_ID(foreignEntity.get_ID());
		} else {
			super.setPA_SLA_Criteria_ID(0);
		}
	}

	/**
	 * Get SLA Criteria.
	 *
	 * @return Service Level Agreement Criteria
	 */
	@JsonProperty("PA_SLA_Criteria")
	public ForeignEntityInput PA_SLA_Criteria() {
		return mPA_SLA_Criteria;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_SLA_Goal_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_SLA_Goal_UU();
	}
}
