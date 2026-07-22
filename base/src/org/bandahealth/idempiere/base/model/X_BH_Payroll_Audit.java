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

/** Generated Model for BH_Payroll_Audit
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Audit")
public class X_BH_Payroll_Audit extends PO implements I_BH_Payroll_Audit, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Audit (Properties ctx, int BH_Payroll_Audit_ID, String trxName)
    {
      super (ctx, BH_Payroll_Audit_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Audit (Properties ctx, int BH_Payroll_Audit_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Audit_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Audit (Properties ctx, String BH_Payroll_Audit_UU, String trxName)
    {
      super (ctx, BH_Payroll_Audit_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Audit (Properties ctx, String BH_Payroll_Audit_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Audit_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Audit (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Audit[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Role.
		@param AD_Role_ID Responsibility Role
	*/
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 1)
			set_Value (COLUMNNAME_AD_Role_ID, null);
		else
			set_Value (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Period locked = PERIOD_LOCK */
	public static final String BH_ACTIONTYPE_PeriodLock = "PERIOD_LOCK";
	/** Period unlocked = PERIOD_UNLOCK */
	public static final String BH_ACTIONTYPE_PeriodUnlock = "PERIOD_UNLOCK";
	/** Component changed = COMPONENT_CHANGE */
	public static final String BH_ACTIONTYPE_ComponentChange = "COMPONENT_CHANGE";
	/** Employee added = EMPLOYEE_ADD */
	public static final String BH_ACTIONTYPE_EmployeeAdd = "EMPLOYEE_ADD";
	/** Employee edited = EMPLOYEE_EDIT */
	public static final String BH_ACTIONTYPE_EmployeeEdit = "EMPLOYEE_EDIT";
	/** Employee deactivated = EMPLOYEE_DEACTIVATE */
	public static final String BH_ACTIONTYPE_EmployeeDeactivate = "EMPLOYEE_DEACTIVATE";
	/** Employee reactivated = EMPLOYEE_REACTIVATE */
	public static final String BH_ACTIONTYPE_EmployeeReactivate = "EMPLOYEE_REACTIVATE";
	/** Filing paid = FILING_PAID */
	public static final String BH_ACTIONTYPE_FilingPaid = "FILING_PAID";
	/** Filing payment reversed = FILING_REVERSED */
	public static final String BH_ACTIONTYPE_FilingReversed = "FILING_REVERSED";
	/** Settings changed = SETTINGS_CHANGE */
	public static final String BH_ACTIONTYPE_SettingsChange = "SETTINGS_CHANGE";
	/** Set Action Type.
		@param BH_ActionType Action Type
	*/
	public void setBH_ActionType (String BH_ActionType)
	{
		set_Value (COLUMNNAME_BH_ActionType, BH_ActionType);
	}

	/** Get Action Type.
		@return Action Type	  */
	public String getBH_ActionType()
	{
		return (String)get_Value(COLUMNNAME_BH_ActionType);
	}

	/** Set Detail.
		@param BH_Detail Detail
	*/
	public void setBH_Detail (String BH_Detail)
	{
		set_Value (COLUMNNAME_BH_Detail, BH_Detail);
	}

	/** Get Detail.
		@return Detail	  */
	public String getBH_Detail()
	{
		return (String)get_Value(COLUMNNAME_BH_Detail);
	}

	/** Set Payroll Audit.
		@param BH_Payroll_Audit_ID Payroll Audit
	*/
	public void setBH_Payroll_Audit_ID (int BH_Payroll_Audit_ID)
	{
		if (BH_Payroll_Audit_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Audit_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Audit_ID, Integer.valueOf(BH_Payroll_Audit_ID));
	}

	/** Get Payroll Audit.
		@return Payroll Audit	  */
	public int getBH_Payroll_Audit_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Audit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Audit_UU.
		@param BH_Payroll_Audit_UU BH_Payroll_Audit_UU
	*/
	public void setBH_Payroll_Audit_UU (String BH_Payroll_Audit_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Audit_UU, BH_Payroll_Audit_UU);
	}

	/** Get BH_Payroll_Audit_UU.
		@return BH_Payroll_Audit_UU	  */
	public String getBH_Payroll_Audit_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Audit_UU);
	}

	/** Set Payroll Run.
		@param BH_Payroll_Run_ID Payroll Run
	*/
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID)
	{
		if (BH_Payroll_Run_ID < 1)
			set_Value (COLUMNNAME_BH_Payroll_Run_ID, null);
		else
			set_Value (COLUMNNAME_BH_Payroll_Run_ID, Integer.valueOf(BH_Payroll_Run_ID));
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

	/** Set Payroll Employee.
		@param HR_Employee_ID Payroll Employee
	*/
	public void setHR_Employee_ID (int HR_Employee_ID)
	{
		if (HR_Employee_ID < 1)
			set_Value (COLUMNNAME_HR_Employee_ID, null);
		else
			set_Value (COLUMNNAME_HR_Employee_ID, Integer.valueOf(HR_Employee_ID));
	}

	/** Get Payroll Employee.
		@return Payroll Employee	  */
	public int getHR_Employee_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Employee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

}
