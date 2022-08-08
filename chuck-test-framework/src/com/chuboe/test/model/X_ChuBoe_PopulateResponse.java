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
package com.chuboe.test.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for ChuBoe_PopulateResponse
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_ChuBoe_PopulateResponse extends PO implements I_ChuBoe_PopulateResponse, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220808L;

    /** Standard Constructor */
    public X_ChuBoe_PopulateResponse (Properties ctx, int ChuBoe_PopulateResponse_ID, String trxName)
    {
      super (ctx, ChuBoe_PopulateResponse_ID, trxName);
      /** if (ChuBoe_PopulateResponse_ID == 0)
        {
			setChuBoe_PopulateResponse_ID (0);
			setIsError (false);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_ChuBoe_PopulateResponse (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuilder sb = new StringBuilder ("X_ChuBoe_PopulateResponse[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException
    {
		return (org.compiere.model.I_AD_PInstance)MTable.get(getCtx(), org.compiere.model.I_AD_PInstance.Table_Name)
			.getPO(getAD_PInstance_ID(), get_TrxName());	}

	/** Set Process Instance.
		@param AD_PInstance_ID 
		Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID)
	{
		if (AD_PInstance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, Integer.valueOf(AD_PInstance_ID));
	}

	/** Get Process Instance.
		@return Instance of the process
	  */
	public int getAD_PInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_PInstance_ID);
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

	/** Set ChuBoe_PopulateResponse.
		@param ChuBoe_PopulateResponse_ID ChuBoe_PopulateResponse	  */
	public void setChuBoe_PopulateResponse_ID (int ChuBoe_PopulateResponse_ID)
	{
		if (ChuBoe_PopulateResponse_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_ChuBoe_PopulateResponse_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_ChuBoe_PopulateResponse_ID, Integer.valueOf(ChuBoe_PopulateResponse_ID));
	}

	/** Get ChuBoe_PopulateResponse.
		@return ChuBoe_PopulateResponse	  */
	public int getChuBoe_PopulateResponse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ChuBoe_PopulateResponse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ChuBoe_PopulateResponse_UU.
		@param ChuBoe_PopulateResponse_UU ChuBoe_PopulateResponse_UU	  */
	public void setChuBoe_PopulateResponse_UU (String ChuBoe_PopulateResponse_UU)
	{
		set_Value (COLUMNNAME_ChuBoe_PopulateResponse_UU, ChuBoe_PopulateResponse_UU);
	}

	/** Get ChuBoe_PopulateResponse_UU.
		@return ChuBoe_PopulateResponse_UU	  */
	public String getChuBoe_PopulateResponse_UU () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_PopulateResponse_UU);
	}

	/** Set Classname.
		@param Classname 
		Java Classname
	  */
	public void setClassname (String Classname)
	{
		set_Value (COLUMNNAME_Classname, Classname);
	}

	/** Get Classname.
		@return Java Classname
	  */
	public String getClassname () 
	{
		return (String)get_Value(COLUMNNAME_Classname);
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

	/** Set Execution Time.
		@param ExecutionTime Execution Time	  */
	public void setExecutionTime (BigDecimal ExecutionTime)
	{
		set_Value (COLUMNNAME_ExecutionTime, ExecutionTime);
	}

	/** Get Execution Time.
		@return Execution Time	  */
	public BigDecimal getExecutionTime () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ExecutionTime);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Error.
		@param IsError 
		An Error occurred in the execution
	  */
	public void setIsError (boolean IsError)
	{
		set_Value (COLUMNNAME_IsError, Boolean.valueOf(IsError));
	}

	/** Get Error.
		@return An Error occurred in the execution
	  */
	public boolean isError () 
	{
		Object oo = get_Value(COLUMNNAME_IsError);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Note.
		@param Note 
		Optional additional user defined information
	  */
	public void setNote (String Note)
	{
		set_Value (COLUMNNAME_Note, Note);
	}

	/** Get Note.
		@return Optional additional user defined information
	  */
	public String getNote () 
	{
		return (String)get_Value(COLUMNNAME_Note);
	}

	/** Set Transaction.
		@param TrxName 
		Name of the transaction
	  */
	public void setTrxName (String TrxName)
	{
		set_ValueNoCheck (COLUMNNAME_TrxName, TrxName);
	}

	/** Get Transaction.
		@return Name of the transaction
	  */
	public String getTrxName () 
	{
		return (String)get_Value(COLUMNNAME_TrxName);
	}
}