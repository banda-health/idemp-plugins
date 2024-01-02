package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_DocumentStatus;

/**
 * Generated Interface for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_DocumentStatusInput extends I_PA_DocumentStatus {

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(I_AD_FormInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	I_AD_FormInput AD_Form();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(I_AD_RoleInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	I_AD_RoleInput AD_Role();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput AD_Table();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput AD_Window();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput C_Project();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

	/**
	 * Set Name_PrintColor.
	 *
	 * @param Name_PrintColor Name_PrintColor
	 */
	void setName_PrintColorInput(I_AD_PrintColorInput Name_PrintColor);

	/**
	 * Get Name_PrintColor.
	 *
	 * @return Name_PrintColor
	 */
	I_AD_PrintColorInput Name_PrintColor();

	/**
	 * Set Name_PrintFont.
	 *
	 * @param Name_PrintFont Name_PrintFont
	 */
	void setName_PrintFontInput(I_AD_PrintFontInput Name_PrintFont);

	/**
	 * Get Name_PrintFont.
	 *
	 * @return Name_PrintFont
	 */
	I_AD_PrintFontInput Name_PrintFont();

	/**
	 * Set Number_PrintColor.
	 *
	 * @param Number_PrintColor Number_PrintColor
	 */
	void setNumber_PrintColorInput(I_AD_PrintColorInput Number_PrintColor);

	/**
	 * Get Number_PrintColor.
	 *
	 * @return Number_PrintColor
	 */
	I_AD_PrintColorInput Number_PrintColor();

	/**
	 * Set Number_PrintFont.
	 *
	 * @param Number_PrintFont Number_PrintFont
	 */
	void setNumber_PrintFontInput(I_AD_PrintFontInput Number_PrintFont);

	/**
	 * Get Number_PrintFont.
	 *
	 * @return Number_PrintFont
	 */
	I_AD_PrintFontInput Number_PrintFont();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();
}
