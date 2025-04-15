package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_UserBPAccessResolver;
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
 * @version Release 12 - $Id$
 */
public class X_AD_UserBPAccessInput extends MUserBPAccess implements I_AD_UserBPAccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mBPAccessType;
	private ForeignEntityInput mDocBaseType;
	private ForeignEntityInput mR_RequestType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserBPAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserBPAccessInput(@JsonProperty("UU") String UU) {
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
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
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
	 * Set User BP Access.
	 *
	 * @param AD_UserBPAccess_ID User/contact access to Business Partner information and resources
	 */
	@JsonProperty("AD_UserBPAccess_ID")
	public void setAD_UserBPAccess_IDFromJson(int AD_UserBPAccess_ID) {
		if (get_ID() == 0) {
			super.setAD_UserBPAccess_ID(AD_UserBPAccess_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserBPAccess_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_UserBPAccess_UU();
	}

	/**
	 * Set Access Type.
	 *
	 * @param BPAccessType Type of Access of the user/contact to Business Partner information and resources
	 */
	@JsonProperty("BPAccessType")
	public void setBPAccessTypeInput(ForeignEntityInput BPAccessType) {
		this.mBPAccessType = BPAccessType;
		if (BPAccessType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserBPAccessResolver.BPACCESSTYPE_UUIDS_BY_VALUE.containsValue(BPAccessType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BPAccessType.getUU() +
						" is not in the list defined for the BPAccessType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BPAccessType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBPAccessType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BPAccessType.getUU());
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
	public ForeignEntityInput BPAccessType() {
		return mBPAccessType;
	}

	/**
	 * Set Document Base Type.
	 *
	 * @param DocBaseType Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public void setDocBaseTypeInput(ForeignEntityInput DocBaseType) {
		this.mDocBaseType = DocBaseType;
		if (DocBaseType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserBPAccessResolver.DOCBASETYPE_UUIDS_BY_VALUE.containsValue(DocBaseType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocBaseType.getUU() +
						" is not in the list defined for the DocBaseType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocBaseType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocBaseType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocBaseType.getUU());
			}
		} else {
			this.setDocBaseType(null);
		}
	}

	/**
	 * Get Document Base Type.
	 *
	 * @return Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public ForeignEntityInput DocBaseType() {
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
		if (R_RequestType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequestType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UU " + R_RequestType.getUU());
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
