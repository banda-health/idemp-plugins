package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestProcessorRoute;
import org.compiere.model.MRequestType;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessor_RouteInput extends MRequestProcessorRoute implements I_R_RequestProcessor_RouteInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_RequestProcessor;
	private ForeignEntityInput mR_RequestType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestProcessor_Route_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestProcessor_RouteInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			this.setAD_User_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (R_RequestProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequestProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestProcessor", "R_RequestProcessor_UU=?", get_TrxName())
							.setParameters(R_RequestProcessor.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_RequestProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestProcessor with UUID " + R_RequestProcessor.getUUID());
			}
		} else {
			this.setR_RequestProcessor_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_RequestProcessor_Route_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (R_RequestType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequestType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UUID " + R_RequestType.getUUID());
			}
		} else {
			this.setR_RequestType_ID(0);
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
