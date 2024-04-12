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

/** Generated Model for BH_Client_Concept
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Client_Concept")
public class X_BH_Client_Concept extends PO implements I_BH_Client_Concept, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240412L;

    /** Standard Constructor */
    public X_BH_Client_Concept (Properties ctx, int BH_Client_Concept_ID, String trxName)
    {
      super (ctx, BH_Client_Concept_ID, trxName);
      /** if (BH_Client_Concept_ID == 0)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Client_Concept (Properties ctx, int BH_Client_Concept_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Client_Concept_ID, trxName, virtualColumns);
      /** if (BH_Client_Concept_ID == 0)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Client_Concept (Properties ctx, String BH_Client_Concept_UU, String trxName)
    {
      super (ctx, BH_Client_Concept_UU, trxName);
      /** if (BH_Client_Concept_UU == null)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Client_Concept (Properties ctx, String BH_Client_Concept_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Client_Concept_UU, trxName, virtualColumns);
      /** if (BH_Client_Concept_UU == null)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Client_Concept (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Client_Concept[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Client Concept.
		@param BH_Client_Concept_ID Client Concept
	*/
	public void setBH_Client_Concept_ID (int BH_Client_Concept_ID)
	{
		if (BH_Client_Concept_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Client_Concept_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Client_Concept_ID, Integer.valueOf(BH_Client_Concept_ID));
	}

	/** Get Client Concept.
		@return Client Concept	  */
	public int getBH_Client_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Client_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Client_Concept_UU.
		@param BH_Client_Concept_UU BH_Client_Concept_UU
	*/
	public void setBH_Client_Concept_UU (String BH_Client_Concept_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Client_Concept_UU, BH_Client_Concept_UU);
	}

	/** Get BH_Client_Concept_UU.
		@return BH_Client_Concept_UU	  */
	public String getBH_Client_Concept_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Client_Concept_UU);
	}

	/** Set Client Mapping ID.
		@param BH_Client_Mapping_ID Client Mapping ID
	*/
	public void setBH_Client_Mapping_ID (int BH_Client_Mapping_ID)
	{
		if (BH_Client_Mapping_ID < 1)
			set_Value (COLUMNNAME_BH_Client_Mapping_ID, null);
		else
			set_Value (COLUMNNAME_BH_Client_Mapping_ID, Integer.valueOf(BH_Client_Mapping_ID));
	}

	/** Get Client Mapping ID.
		@return Client Mapping ID	  */
	public int getBH_Client_Mapping_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Client_Mapping_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_BH_Concept getBH_Concept() throws RuntimeException
	{
		return (I_BH_Concept)MTable.get(getCtx(), I_BH_Concept.Table_ID)
			.getPO(getBH_Concept_ID(), get_TrxName());
	}

	/** Set Concept.
		@param BH_Concept_ID Concept
	*/
	public void setBH_Concept_ID (int BH_Concept_ID)
	{
		if (BH_Concept_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, Integer.valueOf(BH_Concept_ID));
	}

	/** Get Concept.
		@return Concept	  */
	public int getBH_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}
}