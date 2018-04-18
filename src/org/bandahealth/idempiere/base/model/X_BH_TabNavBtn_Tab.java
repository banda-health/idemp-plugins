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
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_TabNavBtn_Tab
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_BH_TabNavBtn_Tab extends PO implements I_BH_TabNavBtn_Tab, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180418L;

    /** Standard Constructor */
    public X_BH_TabNavBtn_Tab (Properties ctx, int BH_TabNavBtn_Tab_ID, String trxName)
    {
      super (ctx, BH_TabNavBtn_Tab_ID, trxName);
      /** if (BH_TabNavBtn_Tab_ID == 0)
        {
			setAD_Tab_ID (0);
			setBH_TabNavBtn_ID (0);
			setBH_TabNavBtn_Tab_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_TabNavBtn_Tab (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_BH_TabNavBtn_Tab[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Tab getAD_Tab() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Tab)MTable.get(getCtx(), org.compiere.model.I_AD_Tab.Table_Name)
			.getPO(getAD_Tab_ID(), get_TrxName());	}

	/** Set Tab.
		@param AD_Tab_ID 
		Tab within a Window
	  */
	public void setAD_Tab_ID (int AD_Tab_ID)
	{
		if (AD_Tab_ID < 1) 
			set_Value (COLUMNNAME_AD_Tab_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Tab_ID, Integer.valueOf(AD_Tab_ID));
	}

	/** Get Tab.
		@return Tab within a Window
	  */
	public int getAD_Tab_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_BH_TabNavBtn getBH_TabNavBtn() throws RuntimeException
    {
		return (I_BH_TabNavBtn)MTable.get(getCtx(), I_BH_TabNavBtn.Table_Name)
			.getPO(getBH_TabNavBtn_ID(), get_TrxName());	}

	/** Set Tab Navigation Button.
		@param BH_TabNavBtn_ID Tab Navigation Button	  */
	public void setBH_TabNavBtn_ID (int BH_TabNavBtn_ID)
	{
		if (BH_TabNavBtn_ID < 1) 
			set_Value (COLUMNNAME_BH_TabNavBtn_ID, null);
		else 
			set_Value (COLUMNNAME_BH_TabNavBtn_ID, Integer.valueOf(BH_TabNavBtn_ID));
	}

	/** Get Tab Navigation Button.
		@return Tab Navigation Button	  */
	public int getBH_TabNavBtn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_TabNavBtn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_TabNavBtn_Tab.
		@param BH_TabNavBtn_Tab_ID BH_TabNavBtn_Tab	  */
	public void setBH_TabNavBtn_Tab_ID (int BH_TabNavBtn_Tab_ID)
	{
		if (BH_TabNavBtn_Tab_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_TabNavBtn_Tab_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_TabNavBtn_Tab_ID, Integer.valueOf(BH_TabNavBtn_Tab_ID));
	}

	/** Get BH_TabNavBtn_Tab.
		@return BH_TabNavBtn_Tab	  */
	public int getBH_TabNavBtn_Tab_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_TabNavBtn_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_TabNavBtn_Tab_UU.
		@param BH_TabNavBtn_Tab_UU BH_TabNavBtn_Tab_UU	  */
	public void setBH_TabNavBtn_Tab_UU (String BH_TabNavBtn_Tab_UU)
	{
		set_Value (COLUMNNAME_BH_TabNavBtn_Tab_UU, BH_TabNavBtn_Tab_UU);
	}

	/** Get BH_TabNavBtn_Tab_UU.
		@return BH_TabNavBtn_Tab_UU	  */
	public String getBH_TabNavBtn_Tab_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_TabNavBtn_Tab_UU);
	}

	/** Set Button Class Name.
		@param ButtonClassName 
		The class(es) the button will have
	  */
	public void setButtonClassName (String ButtonClassName)
	{
		set_Value (COLUMNNAME_ButtonClassName, ButtonClassName);
	}

	/** Get Button Class Name.
		@return The class(es) the button will have
	  */
	public String getButtonClassName () 
	{
		return (String)get_Value(COLUMNNAME_ButtonClassName);
	}

	/** Set Button Help Text.
		@param ButtonHelpText 
		The text displayed when a user hovers over the button
	  */
	public void setButtonHelpText (String ButtonHelpText)
	{
		set_Value (COLUMNNAME_ButtonHelpText, ButtonHelpText);
	}

	/** Get Button Help Text.
		@return The text displayed when a user hovers over the button
	  */
	public String getButtonHelpText () 
	{
		return (String)get_Value(COLUMNNAME_ButtonHelpText);
	}

	/** Left = L */
	public static final String BUTTONLOCATION_Left = "L";
	/** Middle = M */
	public static final String BUTTONLOCATION_Middle = "M";
	/** Right = R */
	public static final String BUTTONLOCATION_Right = "R";
	/** Full = F */
	public static final String BUTTONLOCATION_Full = "F";
	/** Set Button Location.
		@param ButtonLocation 
		The position of this button on the screen
	  */
	public void setButtonLocation (String ButtonLocation)
	{

		set_Value (COLUMNNAME_ButtonLocation, ButtonLocation);
	}

	/** Get Button Location.
		@return The position of this button on the screen
	  */
	public String getButtonLocation () 
	{
		return (String)get_Value(COLUMNNAME_ButtonLocation);
	}

	/** Set Button Text.
		@param ButtonText 
		The text displayed in the button
	  */
	public void setButtonText (String ButtonText)
	{
		set_Value (COLUMNNAME_ButtonText, ButtonText);
	}

	/** Get Button Text.
		@return The text displayed in the button
	  */
	public String getButtonText () 
	{
		return (String)get_Value(COLUMNNAME_ButtonText);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Display Logic.
		@param DisplayLogic 
		If the Field is displayed, the result determines if the field is actually displayed
	  */
	public void setDisplayLogic (String DisplayLogic)
	{
		set_Value (COLUMNNAME_DisplayLogic, DisplayLogic);
	}

	/** Get Display Logic.
		@return If the Field is displayed, the result determines if the field is actually displayed
	  */
	public String getDisplayLogic () 
	{
		return (String)get_Value(COLUMNNAME_DisplayLogic);
	}

	/** Set Icon Class Name.
		@param IconClassName 
		The class(es) to display the correct Font Awesome icon
	  */
	public void setIconClassName (String IconClassName)
	{
		set_Value (COLUMNNAME_IconClassName, IconClassName);
	}

	/** Get Icon Class Name.
		@return The class(es) to display the correct Font Awesome icon
	  */
	public String getIconClassName () 
	{
		return (String)get_Value(COLUMNNAME_IconClassName);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }
}