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
	void setAD_Form(I_AD_FormInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	I_AD_FormInput getAD_Form();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_Role(I_AD_RoleInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	I_AD_RoleInput getAD_Role();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_Table(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput getAD_Table();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_Window(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput getAD_Window();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set Name_PrintColor.
	 *
	 * @param Name_PrintColor Name_PrintColor
	 */
	void setName_PrintColor(I_AD_PrintColorInput Name_PrintColor);

	/**
	 * Get Name_PrintColor.
	 *
	 * @return Name_PrintColor
	 */
	I_AD_PrintColorInput getName_PrintColor();

	/**
	 * Set Name_PrintFont.
	 *
	 * @param Name_PrintFont Name_PrintFont
	 */
	void setName_PrintFont(I_AD_PrintFontInput Name_PrintFont);

	/**
	 * Get Name_PrintFont.
	 *
	 * @return Name_PrintFont
	 */
	I_AD_PrintFontInput getName_PrintFont();

	/**
	 * Set Number_PrintColor.
	 *
	 * @param Number_PrintColor Number_PrintColor
	 */
	void setNumber_PrintColor(I_AD_PrintColorInput Number_PrintColor);

	/**
	 * Get Number_PrintColor.
	 *
	 * @return Number_PrintColor
	 */
	I_AD_PrintColorInput getNumber_PrintColor();

	/**
	 * Set Number_PrintFont.
	 *
	 * @param Number_PrintFont Number_PrintFont
	 */
	void setNumber_PrintFont(I_AD_PrintFontInput Number_PrintFont);

	/**
	 * Get Number_PrintFont.
	 *
	 * @return Number_PrintFont
	 */
	I_AD_PrintFontInput getNumber_PrintFont();

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
