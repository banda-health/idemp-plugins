package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestType;
import org.compiere.model.MStatusCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestTypeInput extends MRequestType implements I_R_RequestTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mR_StatusCategory;
	private I_AD_Ref_ListInput mConfidentialType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRequestType(null, (ResultSet) null, null),
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
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		MRefList_BH foreignEntity;
		if (ConfidentialType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setConfidentialType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialType.getUUID());
			}
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
	 * Set Request Type.
	 *
	 * @param R_RequestType_ID Type of request (e.g. Inquiry, Complaint, ..)
	 */

	public void setR_RequestType_ID(int R_RequestType_ID) {
		if (get_ID() == 0) {
			super.setR_RequestType_ID(R_RequestType_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_RequestType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_RequestType_UU();
	}

	/**
	 * Set Status Category.
	 *
	 * @param R_StatusCategory Request Status Category
	 */
	@JsonProperty("R_StatusCategory")
	public void setR_StatusCategoryInput(ForeignEntityInput R_StatusCategory) {
		this.mR_StatusCategory = R_StatusCategory;
		MStatusCategory foreignEntity;
		if (R_StatusCategory != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_StatusCategory", "R_StatusCategory_UU=?", get_TrxName())
							.setParameters(R_StatusCategory.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_StatusCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_StatusCategory with UUID " + R_StatusCategory.getUUID());
			}
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
	public ForeignEntityInput R_StatusCategory() {
		return mR_StatusCategory;
	}
}
