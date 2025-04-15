package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MStatus;
import org.compiere.model.MStatusCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_StatusInput extends MStatus implements I_R_StatusInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mNext_Status;
	private ForeignEntityInput mR_StatusCategory;
	private ForeignEntityInput mUpdate_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The R_Status_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_StatusInput(@JsonProperty("UU") String UU) {
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
	 * Set Next Status.
	 *
	 * @param Next_Status Move to next status automatically after timeout
	 */
	@JsonProperty("Next_Status")
	public void setNext_StatusInput(ForeignEntityInput Next_Status) {
		this.mNext_Status = Next_Status;
		if (Next_Status != null) {
			// Since an entity was passed, make sure it's in the DB
			MStatus foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
							.setParameters(Next_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setNext_Status_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Status with UU " + Next_Status.getUU());
			}
		} else {
			this.setNext_Status_ID(0);
		}
	}

	/**
	 * Get Next Status.
	 *
	 * @return Move to next status automatically after timeout
	 */
	@JsonProperty("Next_Status")
	public ForeignEntityInput Next_Status() {
		return mNext_Status;
	}
	/**
	 * Set Status.
	 *
	 * @param R_Status_ID Request Status
	 */
	@JsonProperty("R_Status_ID")
	public void setR_Status_IDFromJson(int R_Status_ID) {
		if (get_ID() == 0) {
			super.setR_Status_ID(R_Status_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setR_Status_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getR_Status_UU();
	}

	/**
	 * Set Status Category.
	 *
	 * @param R_StatusCategory Request Status Category
	 */
	@JsonProperty("R_StatusCategory")
	public void setR_StatusCategoryInput(ForeignEntityInput R_StatusCategory) {
		this.mR_StatusCategory = R_StatusCategory;
		if (R_StatusCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MStatusCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_StatusCategory", "R_StatusCategory_UU=?", get_TrxName())
							.setParameters(R_StatusCategory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_StatusCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_StatusCategory with UU " + R_StatusCategory.getUU());
			}
		} else {
			this.setR_StatusCategory_ID(0);
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

	/**
	 * Set Update Status.
	 *
	 * @param Update_Status Automatically change the status after entry from web
	 */
	@JsonProperty("Update_Status")
	public void setUpdate_StatusInput(ForeignEntityInput Update_Status) {
		this.mUpdate_Status = Update_Status;
		if (Update_Status != null) {
			// Since an entity was passed, make sure it's in the DB
			MStatus foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
							.setParameters(Update_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setUpdate_Status_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Status with UU " + Update_Status.getUU());
			}
		} else {
			this.setUpdate_Status_ID(0);
		}
	}

	/**
	 * Get Update Status.
	 *
	 * @return Automatically change the status after entry from web
	 */
	@JsonProperty("Update_Status")
	public ForeignEntityInput Update_Status() {
		return mUpdate_Status;
	}
}
