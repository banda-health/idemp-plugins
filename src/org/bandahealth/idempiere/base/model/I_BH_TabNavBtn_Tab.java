/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_TabNavBtn_Tab
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_BH_TabNavBtn_Tab 
{

    /** TableName=BH_TabNavBtn_Tab */
    public static final String Table_Name = "BH_TabNavBtn_Tab";

    /** AD_Table_ID=1000008 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Tab_ID */
    public static final String COLUMNNAME_AD_Tab_ID = "AD_Tab_ID";

	/** Set Tab.
	  * Tab within a Window
	  */
	public void setAD_Tab_ID (int AD_Tab_ID);

	/** Get Tab.
	  * Tab within a Window
	  */
	public int getAD_Tab_ID();

	public org.compiere.model.I_AD_Tab getAD_Tab() throws RuntimeException;

    /** Column name BH_TabNavBtn_ID */
    public static final String COLUMNNAME_BH_TabNavBtn_ID = "BH_TabNavBtn_ID";

	/** Set Tab Navigation Button	  */
	public void setBH_TabNavBtn_ID (int BH_TabNavBtn_ID);

	/** Get Tab Navigation Button	  */
	public int getBH_TabNavBtn_ID();

	public I_BH_TabNavBtn getBH_TabNavBtn() throws RuntimeException;

    /** Column name BH_TabNavBtn_Tab_ID */
    public static final String COLUMNNAME_BH_TabNavBtn_Tab_ID = "BH_TabNavBtn_Tab_ID";

	/** Set BH_TabNavBtn_Tab	  */
	public void setBH_TabNavBtn_Tab_ID (int BH_TabNavBtn_Tab_ID);

	/** Get BH_TabNavBtn_Tab	  */
	public int getBH_TabNavBtn_Tab_ID();

    /** Column name BH_TabNavBtn_Tab_UU */
    public static final String COLUMNNAME_BH_TabNavBtn_Tab_UU = "BH_TabNavBtn_Tab_UU";

	/** Set BH_TabNavBtn_Tab_UU	  */
	public void setBH_TabNavBtn_Tab_UU (String BH_TabNavBtn_Tab_UU);

	/** Get BH_TabNavBtn_Tab_UU	  */
	public String getBH_TabNavBtn_Tab_UU();

    /** Column name ButtonClassName */
    public static final String COLUMNNAME_ButtonClassName = "ButtonClassName";

	/** Set Button Class Name.
	  * The class(es) the button will have
	  */
	public void setButtonClassName (String ButtonClassName);

	/** Get Button Class Name.
	  * The class(es) the button will have
	  */
	public String getButtonClassName();

    /** Column name ButtonHelpText */
    public static final String COLUMNNAME_ButtonHelpText = "ButtonHelpText";

	/** Set Button Help Text.
	  * The text displayed when a user hovers over the button
	  */
	public void setButtonHelpText (String ButtonHelpText);

	/** Get Button Help Text.
	  * The text displayed when a user hovers over the button
	  */
	public String getButtonHelpText();

    /** Column name ButtonLocation */
    public static final String COLUMNNAME_ButtonLocation = "ButtonLocation";

	/** Set Button Location.
	  * The position of this button on the screen
	  */
	public void setButtonLocation (String ButtonLocation);

	/** Get Button Location.
	  * The position of this button on the screen
	  */
	public String getButtonLocation();

    /** Column name ButtonText */
    public static final String COLUMNNAME_ButtonText = "ButtonText";

	/** Set Button Text.
	  * The text displayed in the button
	  */
	public void setButtonText (String ButtonText);

	/** Get Button Text.
	  * The text displayed in the button
	  */
	public String getButtonText();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DisplayLogic */
    public static final String COLUMNNAME_DisplayLogic = "DisplayLogic";

	/** Set Display Logic.
	  * If the Field is displayed, the result determines if the field is actually displayed
	  */
	public void setDisplayLogic (String DisplayLogic);

	/** Get Display Logic.
	  * If the Field is displayed, the result determines if the field is actually displayed
	  */
	public String getDisplayLogic();

    /** Column name IconClassName */
    public static final String COLUMNNAME_IconClassName = "IconClassName";

	/** Set Icon Class Name.
	  * The class(es) to display the correct Font Awesome icon
	  */
	public void setIconClassName (String IconClassName);

	/** Get Icon Class Name.
	  * The class(es) to display the correct Font Awesome icon
	  */
	public String getIconClassName();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
