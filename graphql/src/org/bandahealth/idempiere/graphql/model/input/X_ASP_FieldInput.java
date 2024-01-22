package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Field;
import org.compiere.model.X_ASP_Tab;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_FieldInput extends X_ASP_Field implements I_ASP_FieldInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mASP_Tab;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_ASP_FieldInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_ASP_Field(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		MField_BH foreignEntity;
		if (get_ID() == 0 && AD_Field != null &&
				(foreignEntity = new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
						.setParameters(AD_Field.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Field_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	@JsonProperty("AD_Field")
	public ForeignEntityInput AD_Field() {
		return mAD_Field;
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
	 * Set ASP Field.
	 *
	 * @param ASP_Field_ID ASP Field
	 */

	public void setASP_Field_ID(int ASP_Field_ID) {
		if (get_ID() == 0) {
			super.setASP_Field_ID(ASP_Field_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setASP_Field_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getASP_Field_UU();
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		MRefList_BH foreignEntity;
		if (ASP_Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ASP_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setASP_Status(foreignEntity.getValue());
		} else {
			this.setASP_Status(null);
		}
	}

	/**
	 * Get ASP Status.
	 *
	 * @return ASP Status
	 */
	@JsonProperty("ASP_Status")
	public I_AD_Ref_ListInput ASP_Status() {
		return mASP_Status;
	}

	/**
	 * Set ASP Tab.
	 *
	 * @param ASP_Tab ASP Tab
	 */
	@JsonProperty("ASP_Tab")
	public void setASP_TabInput(ForeignEntityInput ASP_Tab) {
		this.mASP_Tab = ASP_Tab;
		X_ASP_Tab foreignEntity;
		if (get_ID() == 0 && ASP_Tab != null &&
				(foreignEntity = new Query(getCtx(), "ASP_Tab", "ASP_Tab_UU=?", get_TrxName())
						.setParameters(ASP_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setASP_Tab_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get ASP Tab.
	 *
	 * @return ASP Tab
	 */
	@JsonProperty("ASP_Tab")
	public ForeignEntityInput ASP_Tab() {
		return mASP_Tab;
	}
}
