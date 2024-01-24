package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSLACriteria;
import org.compiere.model.MSLAGoal;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_SLA_GoalInput extends MSLAGoal implements I_PA_SLA_GoalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mPA_SLA_Criteria;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_SLA_Goal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_SLA_GoalInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MSLAGoal(null, (ResultSet) null, null),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
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
		if (PA_SLA_Criteria != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PA_SLA_Criteria", "PA_SLA_Criteria_UU=?", get_TrxName())
							.setParameters(PA_SLA_Criteria.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_SLA_Criteria_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_SLA_Criteria with UUID " + PA_SLA_Criteria.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_SLA_Goal_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_SLA_Goal_UU();
	}
}
