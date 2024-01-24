package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequest;
import org.compiere.model.Query;
import org.compiere.model.X_R_IssueKnown;
import org.compiere.model.X_R_IssueRecommendation;
import org.compiere.model.X_R_IssueStatus;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueKnownInput extends X_R_IssueKnown implements I_R_IssueKnownInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mR_IssueRecommendation;
	private ForeignEntityInput mR_IssueStatus;
	private ForeignEntityInput mR_Request;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_IssueKnown_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_IssueKnownInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_R_IssueKnown(null, (ResultSet) null, null),
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
	 * Set Known Issue.
	 *
	 * @param R_IssueKnown_ID Known Issue
	 */

	public void setR_IssueKnown_ID(int R_IssueKnown_ID) {
		if (get_ID() == 0) {
			super.setR_IssueKnown_ID(R_IssueKnown_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_IssueKnown_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_IssueKnown_UU();
	}

	/**
	 * Set Issue Recommendation.
	 *
	 * @param R_IssueRecommendation Recommendations how to fix an Issue
	 */
	@JsonProperty("R_IssueRecommendation")
	public void setR_IssueRecommendationInput(ForeignEntityInput R_IssueRecommendation) {
		this.mR_IssueRecommendation = R_IssueRecommendation;
		X_R_IssueRecommendation foreignEntity;
		if (R_IssueRecommendation != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueRecommendation", "R_IssueRecommendation_UU=?", get_TrxName())
							.setParameters(R_IssueRecommendation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_IssueRecommendation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueRecommendation with UUID " + R_IssueRecommendation.getUUID());
			}
		} else {
			super.setR_IssueRecommendation_ID(0);
		}
	}

	/**
	 * Get Issue Recommendation.
	 *
	 * @return Recommendations how to fix an Issue
	 */
	@JsonProperty("R_IssueRecommendation")
	public ForeignEntityInput R_IssueRecommendation() {
		return mR_IssueRecommendation;
	}

	/**
	 * Set Issue Status.
	 *
	 * @param R_IssueStatus Status of an Issue
	 */
	@JsonProperty("R_IssueStatus")
	public void setR_IssueStatusInput(ForeignEntityInput R_IssueStatus) {
		this.mR_IssueStatus = R_IssueStatus;
		X_R_IssueStatus foreignEntity;
		if (R_IssueStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueStatus", "R_IssueStatus_UU=?", get_TrxName())
							.setParameters(R_IssueStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_IssueStatus_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueStatus with UUID " + R_IssueStatus.getUUID());
			}
		} else {
			super.setR_IssueStatus_ID(0);
		}
	}

	/**
	 * Get Issue Status.
	 *
	 * @return Status of an Issue
	 */
	@JsonProperty("R_IssueStatus")
	public ForeignEntityInput R_IssueStatus() {
		return mR_IssueStatus;
	}

	/**
	 * Set Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public void setR_RequestInput(ForeignEntityInput R_Request) {
		this.mR_Request = R_Request;
		MRequest foreignEntity;
		if (R_Request != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
							.setParameters(R_Request.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Request_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Request with UUID " + R_Request.getUUID());
			}
		} else {
			super.setR_Request_ID(0);
		}
	}

	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public ForeignEntityInput R_Request() {
		return mR_Request;
	}
}
