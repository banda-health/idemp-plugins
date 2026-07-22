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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_Payroll_Run
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Run")
public class X_BH_Payroll_Run extends PO implements I_BH_Payroll_Run, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Run (Properties ctx, int BH_Payroll_Run_ID, String trxName)
    {
      super (ctx, BH_Payroll_Run_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run (Properties ctx, int BH_Payroll_Run_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run (Properties ctx, String BH_Payroll_Run_UU, String trxName)
    {
      super (ctx, BH_Payroll_Run_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run (Properties ctx, String BH_Payroll_Run_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Run (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Run[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Components Snapshot.
		@param BH_Components_Snapshot Components Snapshot
	*/
	public void setBH_Components_Snapshot (String BH_Components_Snapshot)
	{
		set_Value (COLUMNNAME_BH_Components_Snapshot, BH_Components_Snapshot);
	}

	/** Get Components Snapshot.
		@return Components Snapshot	  */
	public String getBH_Components_Snapshot()
	{
		return (String)get_Value(COLUMNNAME_BH_Components_Snapshot);
	}

	/** Set Pay Date.
		@param BH_PayDate Pay Date
	*/
	public void setBH_PayDate (Timestamp BH_PayDate)
	{
		set_Value (COLUMNNAME_BH_PayDate, BH_PayDate);
	}

	/** Get Pay Date.
		@return Pay Date	  */
	public Timestamp getBH_PayDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_PayDate);
	}

	/** Set Payroll Month.
		@param BH_PayrollMonth Payroll Month
	*/
	public void setBH_PayrollMonth (int BH_PayrollMonth)
	{
		set_Value (COLUMNNAME_BH_PayrollMonth, Integer.valueOf(BH_PayrollMonth));
	}

	/** Get Payroll Month.
		@return Payroll Month	  */
	public int getBH_PayrollMonth()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PayrollMonth);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Year.
		@param BH_PayrollYear Payroll Year
	*/
	public void setBH_PayrollYear (int BH_PayrollYear)
	{
		set_Value (COLUMNNAME_BH_PayrollYear, Integer.valueOf(BH_PayrollYear));
	}

	/** Get Payroll Year.
		@return Payroll Year	  */
	public int getBH_PayrollYear()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PayrollYear);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Run.
		@param BH_Payroll_Run_ID Payroll Run
	*/
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID)
	{
		if (BH_Payroll_Run_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_ID, Integer.valueOf(BH_Payroll_Run_ID));
	}

	/** Get Payroll Run.
		@return Payroll Run	  */
	public int getBH_Payroll_Run_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Run_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Run_UU.
		@param BH_Payroll_Run_UU BH_Payroll_Run_UU
	*/
	public void setBH_Payroll_Run_UU (String BH_Payroll_Run_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Run_UU, BH_Payroll_Run_UU);
	}

	/** Get BH_Payroll_Run_UU.
		@return BH_Payroll_Run_UU	  */
	public String getBH_Payroll_Run_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Run_UU);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document Action.
		@param DocAction The targeted status of the document
	*/
	public void setDocAction (String DocAction)
	{
		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction()
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** Set Document Status.
		@param DocStatus The current status of the document
	*/
	public void setDocStatus (String DocStatus)
	{
		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus()
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

}
