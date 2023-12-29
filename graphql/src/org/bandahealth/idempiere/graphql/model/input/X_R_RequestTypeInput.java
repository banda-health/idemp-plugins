package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ConfidentialType_RL;
	 private I_R_StatusCategoryInput R_StatusCategory;

	/**
	 * Standard constructor
	 */
	public X_R_RequestTypeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType_RL Type of Confidentiality
	 */
	public void setConfidentialType_RL(I_AD_Ref_ListInput ConfidentialType_RL) {
		this.ConfidentialType_RL = ConfidentialType_RL;
		MRefList foreignEntity;
		if (ConfidentialType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ConfidentialType_RL.getID())
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
	public I_AD_Ref_ListInput getConfidentialType_RL() {
		return ConfidentialType_RL;
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
	public void setR_StatusCategory(I_R_StatusCategoryInput R_StatusCategory) {
		this.R_StatusCategory = R_StatusCategory;
		MStatusCategory foreignEntity;
		if (R_StatusCategory != null &&
				(foreignEntity = new Query(getCtx(), MStatusCategory.Table_Name, MStatusCategory.COLUMNNAME_R_StatusCategory_UU + "=?", get_TrxName())
						.setParameters(R_StatusCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_StatusCategory_ID(foreignEntity.get_ID());
		} else {
			this.setR_StatusCategory_ID(0);
		}
	}

	/**
	 * Get Status Category.
	 *
	 * @return Request Status Category
	 */
	public I_R_StatusCategoryInput getR_StatusCategory() {
		return R_StatusCategory;
	}
}
