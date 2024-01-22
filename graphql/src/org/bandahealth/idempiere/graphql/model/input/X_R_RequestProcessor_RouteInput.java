package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestProcessorRoute;
import org.compiere.model.MRequestType;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestProcessor_RouteInput extends MRequestProcessorRoute implements I_R_RequestProcessor_RouteInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_RequestProcessor;
	private ForeignEntityInput mR_RequestType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_R_RequestProcessor_RouteInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRequestProcessorRoute(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Request Processor.
	 *
	 * @param R_RequestProcessor Processor for Requests
	 */
	@JsonProperty("R_RequestProcessor")
	public void setR_RequestProcessorInput(ForeignEntityInput R_RequestProcessor) {
		this.mR_RequestProcessor = R_RequestProcessor;
		MRequestProcessor foreignEntity;
		if (get_ID() == 0 && R_RequestProcessor != null &&
				(foreignEntity = new Query(getCtx(), "R_RequestProcessor", "R_RequestProcessor_UU=?", get_TrxName())
						.setParameters(R_RequestProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_RequestProcessor_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Request Processor.
	 *
	 * @return Processor for Requests
	 */
	@JsonProperty("R_RequestProcessor")
	public ForeignEntityInput R_RequestProcessor() {
		return mR_RequestProcessor;
	}
	/**
	 * Set Request Routing.
	 *
	 * @param R_RequestProcessor_Route_ID Automatic routing of requests
	 */

	public void setR_RequestProcessor_Route_ID(int R_RequestProcessor_Route_ID) {
		if (get_ID() == 0) {
			super.setR_RequestProcessor_Route_ID(R_RequestProcessor_Route_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setR_RequestProcessor_Route_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getR_RequestProcessor_Route_UU();
	}

	/**
	 * Set Request Type.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public void setR_RequestTypeInput(ForeignEntityInput R_RequestType) {
		this.mR_RequestType = R_RequestType;
		MRequestType foreignEntity;
		if (R_RequestType != null &&
				(foreignEntity = new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
						.setParameters(R_RequestType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_RequestType_ID(foreignEntity.get_ID());
		} else {
			super.setR_RequestType_ID(0);
		}
	}

	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public ForeignEntityInput R_RequestType() {
		return mR_RequestType;
	}
}
