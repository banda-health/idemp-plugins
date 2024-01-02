package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestType;
import org.compiere.model.MStatusCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestTypeInput extends MRequestType implements I_R_RequestTypeInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mConfidentialType;
	 private I_R_StatusCategoryInput mR_StatusCategory;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_R_RequestTypeInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		MRefList_BH foreignEntity;
		if (ConfidentialType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ConfidentialType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setConfidentialType(foreignEntity.getValue());
		} else {
			this.setConfidentialType(null);
		}
	}

	/**
	 * Get Confidentiality.
	 *
	 * @return Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public I_AD_Ref_ListInput ConfidentialType() {
		return mConfidentialType;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setR_RequestType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getR_RequestType_UU();
	}

	/**
	 * Set Status Category.
	 *
	 * @param R_StatusCategory Request Status Category
	 */
	@JsonProperty("R_StatusCategory")
	public void setR_StatusCategoryInput(I_R_StatusCategoryInput R_StatusCategory) {
		this.mR_StatusCategory = R_StatusCategory;
		MStatusCategory foreignEntity;
		if (R_StatusCategory != null &&
				(foreignEntity = new Query(getCtx(), MStatusCategory.Table_Name, MStatusCategory.COLUMNNAME_R_StatusCategory_UU + "=?", get_TrxName())
						.setParameters(R_StatusCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_StatusCategory_ID(foreignEntity.get_ID());
		} else {
			super.setR_StatusCategory_ID(0);
		}
	}

	/**
	 * Get Status Category.
	 *
	 * @return Request Status Category
	 */
	@JsonProperty("R_StatusCategory")
	public I_R_StatusCategoryInput R_StatusCategory() {
		return mR_StatusCategory;
	}
}
