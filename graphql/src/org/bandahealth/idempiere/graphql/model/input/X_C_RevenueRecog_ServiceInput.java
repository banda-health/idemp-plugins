package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecogService;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecog_ServiceInput extends MRevenueRecogService implements I_C_RevenueRecog_ServiceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RevenueRecog_ServiceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRevenueRecogService(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Revenue Recognition Service.
	 *
	 * @param C_RevenueRecog_Service_ID Revenue Recognition Service
	 */

	public void setC_RevenueRecog_Service_ID(int C_RevenueRecog_Service_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecog_Service_ID(C_RevenueRecog_Service_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RevenueRecog_Service_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RevenueRecog_Service_UU();
	}

	/**
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition) {
		this.mC_RevenueRecognition = C_RevenueRecognition;
		MRevenueRecognition foreignEntity;
		if (get_ID() == 0 && C_RevenueRecognition != null &&
				(foreignEntity = new Query(getCtx(), "C_RevenueRecognition", "C_RevenueRecognition_UU=?", get_TrxName())
						.setParameters(C_RevenueRecognition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RevenueRecognition_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public ForeignEntityInput C_RevenueRecognition() {
		return mC_RevenueRecognition;
	}
}
