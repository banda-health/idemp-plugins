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

/** Generated Interface for BH_HmScrn_ButtonGroupLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_BH_HmScrn_ButtonGroupLine 
{

    /** TableName=BH_HmScrn_ButtonGroupLine */
    public static final String Table_Name = "BH_HmScrn_ButtonGroupLine";

    /** AD_Table_ID=1000003 */
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

    /** Column name AD_Form_ID */
    public static final String COLUMNNAME_AD_Form_ID = "AD_Form_ID";

	/** Set Special Form.
	  * Special Form
	  */
	public void setAD_Form_ID (int AD_Form_ID);

	/** Get Special Form.
	  * Special Form
	  */
	public int getAD_Form_ID();

	public org.compiere.model.I_AD_Form getAD_Form() throws RuntimeException;

    /** Column name AD_InfoWindow_ID */
    public static final String COLUMNNAME_AD_InfoWindow_ID = "AD_InfoWindow_ID";

	/** Set Info Window.
	  * Info and search/select Window
	  */
	public void setAD_InfoWindow_ID (int AD_InfoWindow_ID);

	/** Get Info Window.
	  * Info and search/select Window
	  */
	public int getAD_InfoWindow_ID();

	public org.compiere.model.I_AD_InfoWindow getAD_InfoWindow() throws RuntimeException;

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

    /** Column name AD_Process_ID */
    public static final String COLUMNNAME_AD_Process_ID = "AD_Process_ID";

	/** Set Process.
	  * Process or Report
	  */
	public void setAD_Process_ID (int AD_Process_ID);

	/** Get Process.
	  * Process or Report
	  */
	public int getAD_Process_ID();

	public org.compiere.model.I_AD_Process getAD_Process() throws RuntimeException;

    /** Column name AD_Window_ID */
    public static final String COLUMNNAME_AD_Window_ID = "AD_Window_ID";

	/** Set Window.
	  * Data entry or display window
	  */
	public void setAD_Window_ID (int AD_Window_ID);

	/** Get Window.
	  * Data entry or display window
	  */
	public int getAD_Window_ID();

	public org.compiere.model.I_AD_Window getAD_Window() throws RuntimeException;

    /** Column name BH_HmScrn_ButtonGroup_ID */
    public static final String COLUMNNAME_BH_HmScrn_ButtonGroup_ID = "BH_HmScrn_ButtonGroup_ID";

	/** Set BH_HmScrn_ButtonGroup	  */
	public void setBH_HmScrn_ButtonGroup_ID (int BH_HmScrn_ButtonGroup_ID);

	/** Get BH_HmScrn_ButtonGroup	  */
	public int getBH_HmScrn_ButtonGroup_ID();

	public I_BH_HmScrn_ButtonGroup getBH_HmScrn_ButtonGroup() throws RuntimeException;

    /** Column name BH_HmScrn_ButtonGroupLine_ID */
    public static final String COLUMNNAME_BH_HmScrn_ButtonGroupLine_ID = "BH_HmScrn_ButtonGroupLine_ID";

	/** Set BH_HmScrn_ButtonGroupLine	  */
	public void setBH_HmScrn_ButtonGroupLine_ID (int BH_HmScrn_ButtonGroupLine_ID);

	/** Get BH_HmScrn_ButtonGroupLine	  */
	public int getBH_HmScrn_ButtonGroupLine_ID();

    /** Column name BH_HmScrn_ButtonGroupLine_UU */
    public static final String COLUMNNAME_BH_HmScrn_ButtonGroupLine_UU = "BH_HmScrn_ButtonGroupLine_UU";

	/** Set BH_HmScrn_ButtonGroupLine_UU	  */
	public void setBH_HmScrn_ButtonGroupLine_UU (String BH_HmScrn_ButtonGroupLine_UU);

	/** Get BH_HmScrn_ButtonGroupLine_UU	  */
	public String getBH_HmScrn_ButtonGroupLine_UU();

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

    /** Column name LineNo */
    public static final String COLUMNNAME_LineNo = "LineNo";

	/** Set Line.
	  * Line No
	  */
	public void setLineNo (int LineNo);

	/** Get Line.
	  * Line No
	  */
	public int getLineNo();

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
