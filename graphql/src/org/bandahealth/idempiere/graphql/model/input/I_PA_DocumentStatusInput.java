package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_DocumentStatus;

/**
 * Generated Interface for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_DocumentStatusInput extends I_PA_DocumentStatus {

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(ForeignEntityInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	ForeignEntityInput AD_Form();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set Name_PrintColor.
	 *
	 * @param Name_PrintColor Name_PrintColor
	 */
	void setName_PrintColorInput(ForeignEntityInput Name_PrintColor);

	/**
	 * Get Name_PrintColor.
	 *
	 * @return Name_PrintColor
	 */
	ForeignEntityInput Name_PrintColor();

	/**
	 * Set Name_PrintFont.
	 *
	 * @param Name_PrintFont Name_PrintFont
	 */
	void setName_PrintFontInput(ForeignEntityInput Name_PrintFont);

	/**
	 * Get Name_PrintFont.
	 *
	 * @return Name_PrintFont
	 */
	ForeignEntityInput Name_PrintFont();

	/**
	 * Set Number_PrintColor.
	 *
	 * @param Number_PrintColor Number_PrintColor
	 */
	void setNumber_PrintColorInput(ForeignEntityInput Number_PrintColor);

	/**
	 * Get Number_PrintColor.
	 *
	 * @return Number_PrintColor
	 */
	ForeignEntityInput Number_PrintColor();

	/**
	 * Set Number_PrintFont.
	 *
	 * @param Number_PrintFont Number_PrintFont
	 */
	void setNumber_PrintFontInput(ForeignEntityInput Number_PrintFont);

	/**
	 * Get Number_PrintFont.
	 *
	 * @return Number_PrintFont
	 */
	ForeignEntityInput Number_PrintFont();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();
}
