package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSLACriteria;
import org.compiere.model.Query;
import org.compiere.model.X_PA_SLA_Goal;
import org.compiere.util.Env;

/**
 * Generated Model for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_GoalInput extends X_PA_SLA_Goal implements I_PA_SLA_GoalInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_BPartnerInput C_BPartner;
	 private I_PA_SLA_CriteriaInput PA_SLA_Criteria;

	/**
	 * Standard constructor
	 */
	public X_PA_SLA_GoalInput(String ID) {
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}
	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner_ID Identifies a Business Partner
	 */

	public void setC_BPartner_ID(int C_BPartner_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_ID(C_BPartner_ID);
		}
	}

	/**
	 * Set SLA Criteria.
	 *
	 * @param PA_SLA_Criteria Service Level Agreement Criteria
	 */
	public void setPA_SLA_Criteria(I_PA_SLA_CriteriaInput PA_SLA_Criteria) {
		this.PA_SLA_Criteria = PA_SLA_Criteria;
		MSLACriteria foreignEntity;
		if (PA_SLA_Criteria != null &&
				(foreignEntity = new Query(getCtx(), MSLACriteria.Table_Name, MSLACriteria.COLUMNNAME_PA_SLA_Criteria_UU + "=?", get_TrxName())
						.setParameters(PA_SLA_Criteria.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_SLA_Criteria_ID(foreignEntity.get_ID());
		} else {
			this.setPA_SLA_Criteria_ID(0);
		}
	}

	/**
	 * Get SLA Criteria.
	 *
	 * @return Service Level Agreement Criteria
	 */
	public I_PA_SLA_CriteriaInput getPA_SLA_Criteria() {
		return PA_SLA_Criteria;
	}
	/**
	 * Set SLA Goal.
	 *
	 * @param PA_SLA_Goal_ID Service Level Agreement Goal
	 */

	public void setPA_SLA_Goal_ID(int PA_SLA_Goal_ID) {
		if (get_ID() == 0) {
			super.setPA_SLA_Goal_ID(PA_SLA_Goal_ID);
		}
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
