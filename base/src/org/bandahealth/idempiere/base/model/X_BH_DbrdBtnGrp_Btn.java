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

/** Generated Model for BH_DbrdBtnGrp_Btn
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_DbrdBtnGrp_Btn extends PO implements I_BH_DbrdBtnGrp_Btn, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20201120L;

    /** Standard Constructor */
    public X_BH_DbrdBtnGrp_Btn (Properties ctx, int BH_DbrdBtnGrp_Btn_ID, String trxName)
    {
      super (ctx, BH_DbrdBtnGrp_Btn_ID, trxName);
      /** if (BH_DbrdBtnGrp_Btn_ID == 0)
        {
			setBH_DbrdBtnGrp_Btn_ID (0);
			setBH_DbrdBtnGrp_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_DbrdBtnGrp_Btn (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_DbrdBtnGrp_Btn[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Form getAD_Form() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Form)MTable.get(getCtx(), org.compiere.model.I_AD_Form.Table_Name)
			.getPO(getAD_Form_ID(), get_TrxName());	}

	/** Set Special Form.
		@param AD_Form_ID 
		Special Form
	  */
	public void setAD_Form_ID (int AD_Form_ID)
	{
		if (AD_Form_ID < 1) 
			set_Value (COLUMNNAME_AD_Form_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Form_ID, Integer.valueOf(AD_Form_ID));
	}

	/** Get Special Form.
		@return Special Form
	  */
	public int getAD_Form_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Form_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_InfoWindow getAD_InfoWindow() throws RuntimeException
    {
		return (org.compiere.model.I_AD_InfoWindow)MTable.get(getCtx(), org.compiere.model.I_AD_InfoWindow.Table_Name)
			.getPO(getAD_InfoWindow_ID(), get_TrxName());	}

	/** Set Info Window.
		@param AD_InfoWindow_ID 
		Info and search/select Window
	  */
	public void setAD_InfoWindow_ID (int AD_InfoWindow_ID)
	{
		if (AD_InfoWindow_ID < 1) 
			set_Value (COLUMNNAME_AD_InfoWindow_ID, null);
		else 
			set_Value (COLUMNNAME_AD_InfoWindow_ID, Integer.valueOf(AD_InfoWindow_ID));
	}

	/** Get Info Window.
		@return Info and search/select Window
	  */
	public int getAD_InfoWindow_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_InfoWindow_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Process getAD_Process() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Process)MTable.get(getCtx(), org.compiere.model.I_AD_Process.Table_Name)
			.getPO(getAD_Process_ID(), get_TrxName());	}

	/** Set Process.
		@param AD_Process_ID 
		Process or Report
	  */
	public void setAD_Process_ID (int AD_Process_ID)
	{
		if (AD_Process_ID < 1) 
			set_Value (COLUMNNAME_AD_Process_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Process_ID, Integer.valueOf(AD_Process_ID));
	}

	/** Get Process.
		@return Process or Report
	  */
	public int getAD_Process_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Window getAD_Window() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Window)MTable.get(getCtx(), org.compiere.model.I_AD_Window.Table_Name)
			.getPO(getAD_Window_ID(), get_TrxName());	}

	/** Set Window.
		@param AD_Window_ID 
		Data entry or display window
	  */
	public void setAD_Window_ID (int AD_Window_ID)
	{
		if (AD_Window_ID < 1) 
			set_Value (COLUMNNAME_AD_Window_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Window_ID, Integer.valueOf(AD_Window_ID));
	}

	/** Get Window.
		@return Data entry or display window
	  */
	public int getAD_Window_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_DbrdBtnGrp_Btn_ID.
		@param BH_DbrdBtnGrp_Btn_ID BH_DbrdBtnGrp_Btn_ID	  */
	public void setBH_DbrdBtnGrp_Btn_ID (int BH_DbrdBtnGrp_Btn_ID)
	{
		if (BH_DbrdBtnGrp_Btn_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_DbrdBtnGrp_Btn_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_DbrdBtnGrp_Btn_ID, Integer.valueOf(BH_DbrdBtnGrp_Btn_ID));
	}

	/** Get BH_DbrdBtnGrp_Btn_ID.
		@return BH_DbrdBtnGrp_Btn_ID	  */
	public int getBH_DbrdBtnGrp_Btn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_DbrdBtnGrp_Btn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_DbrdBtnGrp_Btn_UU.
		@param BH_DbrdBtnGrp_Btn_UU BH_DbrdBtnGrp_Btn_UU	  */
	public void setBH_DbrdBtnGrp_Btn_UU (String BH_DbrdBtnGrp_Btn_UU)
	{
		set_Value (COLUMNNAME_BH_DbrdBtnGrp_Btn_UU, BH_DbrdBtnGrp_Btn_UU);
	}

	/** Get BH_DbrdBtnGrp_Btn_UU.
		@return BH_DbrdBtnGrp_Btn_UU	  */
	public String getBH_DbrdBtnGrp_Btn_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_DbrdBtnGrp_Btn_UU);
	}

	public I_BH_DbrdBtnGrp getBH_DbrdBtnGrp() throws RuntimeException
    {
		return (I_BH_DbrdBtnGrp)MTable.get(getCtx(), I_BH_DbrdBtnGrp.Table_Name)
			.getPO(getBH_DbrdBtnGrp_ID(), get_TrxName());	}

	/** Set BH_DbrdBtnGrp_ID.
		@param BH_DbrdBtnGrp_ID BH_DbrdBtnGrp_ID	  */
	public void setBH_DbrdBtnGrp_ID (int BH_DbrdBtnGrp_ID)
	{
		if (BH_DbrdBtnGrp_ID < 1) 
			set_Value (COLUMNNAME_BH_DbrdBtnGrp_ID, null);
		else 
			set_Value (COLUMNNAME_BH_DbrdBtnGrp_ID, Integer.valueOf(BH_DbrdBtnGrp_ID));
	}

	/** Get BH_DbrdBtnGrp_ID.
		@return BH_DbrdBtnGrp_ID	  */
	public int getBH_DbrdBtnGrp_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_DbrdBtnGrp_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_AD_Role getIncluded_Role() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_Name)
			.getPO(getIncluded_Role_ID(), get_TrxName());	}

	/** Set Included Role.
		@param Included_Role_ID Included Role	  */
	public void setIncluded_Role_ID (int Included_Role_ID)
	{
		if (Included_Role_ID < 1) 
			set_Value (COLUMNNAME_Included_Role_ID, null);
		else 
			set_Value (COLUMNNAME_Included_Role_ID, Integer.valueOf(Included_Role_ID));
	}

	/** Get Included Role.
		@return Included Role	  */
	public int getIncluded_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Included_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
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