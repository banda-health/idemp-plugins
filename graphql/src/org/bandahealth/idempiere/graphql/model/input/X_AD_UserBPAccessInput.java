package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestType;
import org.compiere.model.MUserBPAccess;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserBPAccessInput extends MUserBPAccess implements I_AD_UserBPAccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_RequestType;
	private I_AD_Ref_ListInput mBPAccessType;
	private I_AD_Ref_ListInput mDocBaseType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserBPAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserBPAccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MUserBPAccess(null, (ResultSet) null, null),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
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
	 * Set User BP Access.
	 *
	 * @param AD_UserBPAccess_ID User/contact access to Business Partner information and resources
	 */

	public void setAD_UserBPAccess_ID(int AD_UserBPAccess_ID) {
		if (get_ID() == 0) {
			super.setAD_UserBPAccess_ID(AD_UserBPAccess_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_UserBPAccess_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_UserBPAccess_UU();
	}

	/**
	 * Set Access Type.
	 *
	 * @param BPAccessType Type of Access of the user/contact to Business Partner information and resources
	 */
	@JsonProperty("BPAccessType")
	public void setBPAccessTypeInput(I_AD_Ref_ListInput BPAccessType) {
		this.mBPAccessType = BPAccessType;
		MRefList_BH foreignEntity;
		if (BPAccessType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BPAccessType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBPAccessType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BPAccessType.getUUID());
			}
		} else {
			this.setBPAccessType(null);
		}
	}

	/**
	 * Get Access Type.
	 *
	 * @return Type of Access of the user/contact to Business Partner information and resources
	 */
	@JsonProperty("BPAccessType")
	public I_AD_Ref_ListInput BPAccessType() {
		return mBPAccessType;
	}

	/**
	 * Set Document BaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType) {
		this.mDocBaseType = DocBaseType;
		MRefList_BH foreignEntity;
		if (DocBaseType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocBaseType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocBaseType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocBaseType.getUUID());
			}
		} else {
			this.setDocBaseType(null);
		}
	}

	/**
	 * Get Document BaseType.
	 *
	 * @return Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public I_AD_Ref_ListInput DocBaseType() {
		return mDocBaseType;
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
		if (R_RequestType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UUID " + R_RequestType.getUUID());
			}
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
