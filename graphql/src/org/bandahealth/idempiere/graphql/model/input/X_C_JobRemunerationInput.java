package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobRemuneration;
import org.compiere.model.X_C_Remuneration;

import java.sql.ResultSet;

/**
 * Generated Model for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobRemunerationInput extends X_C_JobRemuneration implements I_C_JobRemunerationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mC_Remuneration;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_JobRemunerationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_JobRemuneration(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	@JsonProperty("C_Job")
	public void setC_JobInput(ForeignEntityInput C_Job) {
		this.mC_Job = C_Job;
		X_C_Job foreignEntity;
		if (get_ID() == 0 && C_Job != null &&
				(foreignEntity = new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
						.setParameters(C_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Job_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_JobRemuneration_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (get_ID() == 0 && C_Remuneration != null &&
				(foreignEntity = new Query(getCtx(), "C_Remuneration", "C_Remuneration_UU=?", get_TrxName())
						.setParameters(C_Remuneration.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Remuneration_ID(foreignEntity.get_ID());
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
