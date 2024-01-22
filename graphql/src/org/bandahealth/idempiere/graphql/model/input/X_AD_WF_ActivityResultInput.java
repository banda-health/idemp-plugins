package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.model.X_AD_WF_ActivityResult;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_ActivityResultInput extends X_AD_WF_ActivityResult implements I_AD_WF_ActivityResultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_WF_Activity;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WF_ActivityResultInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_WF_ActivityResult(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Workflow Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	@JsonProperty("AD_WF_Activity")
	public void setAD_WF_ActivityInput(ForeignEntityInput AD_WF_Activity) {
		this.mAD_WF_Activity = AD_WF_Activity;
		X_AD_WF_Activity foreignEntity;
		if (get_ID() == 0 && AD_WF_Activity != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Activity", "AD_WF_Activity_UU=?", get_TrxName())
						.setParameters(AD_WF_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Activity_ID(foreignEntity.get_ID());
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

	public void setAD_WF_ActivityResult_ID(int AD_WF_ActivityResult_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_ActivityResult_ID(AD_WF_ActivityResult_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_ActivityResult_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_ActivityResult_UU();
	}
}
