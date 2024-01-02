package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDocumentStatus;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

/**
 * Generated Model for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DocumentStatusInput extends MDocumentStatus implements I_PA_DocumentStatusInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_FormInput mAD_Form;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintColorInput mName_PrintColor;
	 private I_AD_PrintColorInput mNumber_PrintColor;
	 private I_AD_PrintFontInput mName_PrintFont;
	 private I_AD_PrintFontInput mNumber_PrintFont;
	 private I_AD_RoleInput mAD_Role;
	 private I_AD_TableInput mAD_Table;
	 private I_AD_UserInput mAD_User;
	 private I_AD_WindowInput mAD_Window;
	 private I_C_ProjectInput mC_Project;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_DocumentStatusInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	@JsonProperty("AD_Form")
	public void setAD_FormInput(I_AD_FormInput AD_Form) {
		this.mAD_Form = AD_Form;
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), MForm.Table_Name, MForm.COLUMNNAME_AD_Form_UU + "=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	@JsonProperty("AD_Form")
	public I_AD_FormInput AD_Form() {
		return mAD_Form;
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(I_AD_RoleInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public I_AD_RoleInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(I_AD_TableInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public I_AD_TableInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
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
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(I_AD_WindowInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public I_AD_WindowInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(I_C_ProjectInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public I_C_ProjectInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Print Color for Name.
	 *
	 * @param Name_PrintColor Print Color for Name
	 */
	@JsonProperty("Name_PrintColor")
	public void setName_PrintColorInput(I_AD_PrintColorInput Name_PrintColor) {
		this.mName_PrintColor = Name_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Name_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(Name_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setName_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setName_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color for Name.
	 *
	 * @return Print Color for Name
	 */
	@JsonProperty("Name_PrintColor")
	public I_AD_PrintColorInput Name_PrintColor() {
		return mName_PrintColor;
	}

	/**
	 * Set Print Font for Name.
	 *
	 * @param Name_PrintFont Print Font for Name
	 */
	@JsonProperty("Name_PrintFont")
	public void setName_PrintFontInput(I_AD_PrintFontInput Name_PrintFont) {
		this.mName_PrintFont = Name_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Name_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Name_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setName_PrintFont_ID(foreignEntity.get_ID());
		} else {
			super.setName_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font for Name.
	 *
	 * @return Print Font for Name
	 */
	@JsonProperty("Name_PrintFont")
	public I_AD_PrintFontInput Name_PrintFont() {
		return mName_PrintFont;
	}

	/**
	 * Set Print Color for Number.
	 *
	 * @param Number_PrintColor Print Color for Number
	 */
	@JsonProperty("Number_PrintColor")
	public void setNumber_PrintColorInput(I_AD_PrintColorInput Number_PrintColor) {
		this.mNumber_PrintColor = Number_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Number_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(Number_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setNumber_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setNumber_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color for Number.
	 *
	 * @return Print Color for Number
	 */
	@JsonProperty("Number_PrintColor")
	public I_AD_PrintColorInput Number_PrintColor() {
		return mNumber_PrintColor;
	}

	/**
	 * Set Print Font for Number.
	 *
	 * @param Number_PrintFont Print Font for Number
	 */
	@JsonProperty("Number_PrintFont")
	public void setNumber_PrintFontInput(I_AD_PrintFontInput Number_PrintFont) {
		this.mNumber_PrintFont = Number_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Number_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Number_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setNumber_PrintFont_ID(foreignEntity.get_ID());
		} else {
			super.setNumber_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font for Number.
	 *
	 * @return Print Font for Number
	 */
	@JsonProperty("Number_PrintFont")
	public I_AD_PrintFontInput Number_PrintFont() {
		return mNumber_PrintFont;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_DocumentStatus_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_DocumentStatus_UU();
	}
}
