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

/** Generated Model for BH_BPartner_Tags
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_BPartner_Tags")
public class X_BH_BPartner_Tags extends PO implements I_BH_BPartner_Tags, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250508L;

    /** Standard Constructor */
    public X_BH_BPartner_Tags (Properties ctx, int BH_BPartner_Tags_ID, String trxName)
    {
      super (ctx, BH_BPartner_Tags_ID, trxName);
      /** if (BH_BPartner_Tags_ID == 0)
        {
			setBH_Tag_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BPartner_Tags (Properties ctx, int BH_BPartner_Tags_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_BPartner_Tags_ID, trxName, virtualColumns);
      /** if (BH_BPartner_Tags_ID == 0)
        {
			setBH_Tag_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BPartner_Tags (Properties ctx, String BH_BPartner_Tags_UU, String trxName)
    {
      super (ctx, BH_BPartner_Tags_UU, trxName);
      /** if (BH_BPartner_Tags_UU == null)
        {
			setBH_Tag_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BPartner_Tags (Properties ctx, String BH_BPartner_Tags_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_BPartner_Tags_UU, trxName, virtualColumns);
      /** if (BH_BPartner_Tags_UU == null)
        {
			setBH_Tag_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_BPartner_Tags (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_BPartner_Tags[")
        .append(get_UUID()).append("]");
      return sb.toString();
    }

	/** Set BH_BPartner_Tags_UU.
		@param BH_BPartner_Tags_UU BH_BPartner_Tags_UU
	*/
	public void setBH_BPartner_Tags_UU (String BH_BPartner_Tags_UU)
	{
		set_Value (COLUMNNAME_BH_BPartner_Tags_UU, BH_BPartner_Tags_UU);
	}

	/** Get BH_BPartner_Tags_UU.
		@return BH_BPartner_Tags_UU	  */
	public String getBH_BPartner_Tags_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_BPartner_Tags_UU);
	}

	public I_BH_Tag getBH_Tag() throws RuntimeException
	{
		return (I_BH_Tag)MTable.get(getCtx(), I_BH_Tag.Table_ID)
			.getPO(getBH_Tag_ID(), get_TrxName());
	}

	/** Set BH Tag.
		@param BH_Tag_ID BH Tag
	*/
	public void setBH_Tag_ID (int BH_Tag_ID)
	{
		if (BH_Tag_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Tag_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Tag_ID, Integer.valueOf(BH_Tag_ID));
	}

	/** Get BH Tag.
		@return BH Tag	  */
	public int getBH_Tag_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Tag_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}