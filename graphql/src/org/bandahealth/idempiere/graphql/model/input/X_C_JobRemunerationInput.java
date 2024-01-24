package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobRemuneration;
import org.compiere.model.X_C_Remuneration;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_JobRemunerationInput extends X_C_JobRemuneration implements I_C_JobRemunerationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mC_Remuneration;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_JobRemuneration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_JobRemunerationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_JobRemuneration(null, (ResultSet) null, null),
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
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	@JsonProperty("C_Job")
	public void setC_JobInput(ForeignEntityInput C_Job) {
		this.mC_Job = C_Job;
		X_C_Job foreignEntity;
		if (get_ID() == 0 && C_Job != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
							.setParameters(C_Job.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Job with UUID " + C_Job.getUUID());
			}
		}
	}

	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	@JsonProperty("C_Job")
	public ForeignEntityInput C_Job() {
		return mC_Job;
	}
	/**
	 * Set Position Remuneration.
	 *
	 * @param C_JobRemuneration_ID Remuneration for the Position
	 */

	public void setC_JobRemuneration_ID(int C_JobRemuneration_ID) {
		if (get_ID() == 0) {
			super.setC_JobRemuneration_ID(C_JobRemuneration_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_JobRemuneration_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_JobRemuneration_UU();
	}

	/**
	 * Set Remuneration.
	 *
	 * @param C_Remuneration Wage or Salary
	 */
	@JsonProperty("C_Remuneration")
	public void setC_RemunerationInput(ForeignEntityInput C_Remuneration) {
		this.mC_Remuneration = C_Remuneration;
		X_C_Remuneration foreignEntity;
		if (get_ID() == 0 && C_Remuneration != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Remuneration", "C_Remuneration_UU=?", get_TrxName())
							.setParameters(C_Remuneration.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Remuneration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Remuneration with UUID " + C_Remuneration.getUUID());
			}
		}
	}

	/**
	 * Get Remuneration.
	 *
	 * @return Wage or Salary
	 */
	@JsonProperty("C_Remuneration")
	public ForeignEntityInput C_Remuneration() {
		return mC_Remuneration;
	}
}
