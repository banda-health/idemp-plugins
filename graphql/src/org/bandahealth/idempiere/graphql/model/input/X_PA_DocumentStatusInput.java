package org.bandahealth.idempiere.graphql.model.input;

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

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_FormInput AD_Form;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput Name_PrintColor;
	 private I_AD_PrintColorInput Number_PrintColor;
	 private I_AD_PrintFontInput Name_PrintFont;
	 private I_AD_PrintFontInput Number_PrintFont;
	 private I_AD_RoleInput AD_Role;
	 private I_AD_TableInput AD_Table;
	 private I_AD_UserInput AD_User;
	 private I_AD_WindowInput AD_Window;
	 private I_C_ProjectInput C_Project;

	/**
	 * Standard constructor
	 */
	public X_PA_DocumentStatusInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	public void setAD_Form(I_AD_FormInput AD_Form) {
		this.AD_Form = AD_Form;
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), MForm.Table_Name, MForm.COLUMNNAME_AD_Form_UU + "=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public I_AD_FormInput getAD_Form() {
		return AD_Form;
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	public void setAD_Role(I_AD_RoleInput AD_Role) {
		this.AD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public I_AD_RoleInput getAD_Role() {
		return AD_Role;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	public void setAD_Table(I_AD_TableInput AD_Table) {
		this.AD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public I_AD_TableInput getAD_Table() {
		return AD_Table;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	public void setAD_Window(I_AD_WindowInput AD_Window) {
		this.AD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public I_AD_WindowInput getAD_Window() {
		return AD_Window;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}

	/**
	 * Set Print Color for Name.
	 *
	 * @param Name_PrintColor Print Color for Name
	 */
	public void setName_PrintColor(I_AD_PrintColorInput Name_PrintColor) {
		this.Name_PrintColor = Name_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Name_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(Name_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setName_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setName_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color for Name.
	 *
	 * @return Print Color for Name
	 */
	public I_AD_PrintColorInput getName_PrintColor() {
		return Name_PrintColor;
	}

	/**
	 * Set Print Font for Name.
	 *
	 * @param Name_PrintFont Print Font for Name
	 */
	public void setName_PrintFont(I_AD_PrintFontInput Name_PrintFont) {
		this.Name_PrintFont = Name_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Name_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Name_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setName_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setName_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font for Name.
	 *
	 * @return Print Font for Name
	 */
	public I_AD_PrintFontInput getName_PrintFont() {
		return Name_PrintFont;
	}

	/**
	 * Set Print Color for Number.
	 *
	 * @param Number_PrintColor Print Color for Number
	 */
	public void setNumber_PrintColor(I_AD_PrintColorInput Number_PrintColor) {
		this.Number_PrintColor = Number_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Number_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(Number_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setNumber_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setNumber_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color for Number.
	 *
	 * @return Print Color for Number
	 */
	public I_AD_PrintColorInput getNumber_PrintColor() {
		return Number_PrintColor;
	}

	/**
	 * Set Print Font for Number.
	 *
	 * @param Number_PrintFont Print Font for Number
	 */
	public void setNumber_PrintFont(I_AD_PrintFontInput Number_PrintFont) {
		this.Number_PrintFont = Number_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Number_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Number_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setNumber_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setNumber_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font for Number.
	 *
	 * @return Print Font for Number
	 */
	public I_AD_PrintFontInput getNumber_PrintFont() {
		return Number_PrintFont;
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
