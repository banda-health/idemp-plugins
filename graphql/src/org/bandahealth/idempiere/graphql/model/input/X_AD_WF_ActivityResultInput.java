package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.model.X_AD_WF_ActivityResult;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ActivityResultInput extends X_AD_WF_ActivityResult implements I_AD_WF_ActivityResultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Activity;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_WF_ActivityResult_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WF_ActivityResultInput(@JsonProperty("UU") String UU) {
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
	 * Set Workflow Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	@JsonProperty("AD_WF_Activity")
	public void setAD_WF_ActivityInput(ForeignEntityInput AD_WF_Activity) {
		this.mAD_WF_Activity = AD_WF_Activity;
		if (get_ID() != 0) {
			return;
		}
		if (AD_WF_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Activity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Activity", "AD_WF_Activity_UU=?", get_TrxName())
							.setParameters(AD_WF_Activity.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Activity with UU " + AD_WF_Activity.getUU());
			}
		} else {
			this.setAD_WF_Activity_ID(0);
		}
	}

	/**
	 * Get Workflow Activity.
	 *
	 * @return Workflow Activity
	 */
	@JsonProperty("AD_WF_Activity")
	public ForeignEntityInput AD_WF_Activity() {
		return mAD_WF_Activity;
	}
	/**
	 * Set Workflow Activity Result.
	 *
	 * @param AD_WF_ActivityResult_ID Result of the Workflow Process Activity
	 */
	@JsonProperty("AD_WF_ActivityResult_ID")
	public void setAD_WF_ActivityResult_IDFromJson(int AD_WF_ActivityResult_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_ActivityResult_ID(AD_WF_ActivityResult_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_WF_ActivityResult_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_WF_ActivityResult_UU();
	}
}
