package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MStatus;
import org.compiere.model.MStatusCategory;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_StatusInput extends MStatus implements I_R_StatusInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mNext_Status;
	private ForeignEntityInput mR_StatusCategory;
	private ForeignEntityInput mUpdate_Status;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_R_StatusInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MStatus(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Next Status.
	 *
	 * @param Next_Status Move to next status automatically after timeout
	 */
	@JsonProperty("Next_Status")
	public void setNext_StatusInput(ForeignEntityInput Next_Status) {
		this.mNext_Status = Next_Status;
		MStatus foreignEntity;
		if (Next_Status != null &&
				(foreignEntity = new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
						.setParameters(Next_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setNext_Status_ID(foreignEntity.get_ID());
		} else {
			super.setNext_Status_ID(0);
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

	public void setR_Status_ID(int R_Status_ID) {
		if (get_ID() == 0) {
			super.setR_Status_ID(R_Status_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setR_Status_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MStatusCategory foreignEntity;
		if (R_StatusCategory != null &&
				(foreignEntity = new Query(getCtx(), "R_StatusCategory", "R_StatusCategory_UU=?", get_TrxName())
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
		MStatus foreignEntity;
		if (Update_Status != null &&
				(foreignEntity = new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
						.setParameters(Update_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUpdate_Status_ID(foreignEntity.get_ID());
		} else {
			super.setUpdate_Status_ID(0);
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
