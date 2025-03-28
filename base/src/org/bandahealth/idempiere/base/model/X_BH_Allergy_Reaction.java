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

/** Generated Model for BH_Allergy_Reaction
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Allergy_Reaction")
public class X_BH_Allergy_Reaction extends PO implements I_BH_Allergy_Reaction, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250314L;

    /** Standard Constructor */
    public X_BH_Allergy_Reaction (Properties ctx, int BH_Allergy_Reaction_ID, String trxName)
    {
      super (ctx, BH_Allergy_Reaction_ID, trxName);
      /** if (BH_Allergy_Reaction_ID == 0)
        {
			setBH_Allergy_Reaction_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy_Reaction (Properties ctx, int BH_Allergy_Reaction_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Allergy_Reaction_ID, trxName, virtualColumns);
      /** if (BH_Allergy_Reaction_ID == 0)
        {
			setBH_Allergy_Reaction_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy_Reaction (Properties ctx, String BH_Allergy_Reaction_UU, String trxName)
    {
      super (ctx, BH_Allergy_Reaction_UU, trxName);
      /** if (BH_Allergy_Reaction_UU == null)
        {
			setBH_Allergy_Reaction_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy_Reaction (Properties ctx, String BH_Allergy_Reaction_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Allergy_Reaction_UU, trxName, virtualColumns);
      /** if (BH_Allergy_Reaction_UU == null)
        {
			setBH_Allergy_Reaction_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Allergy_Reaction (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Allergy_Reaction[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_BH_Allergy getBH_Allergy() throws RuntimeException
	{
		return (I_BH_Allergy)MTable.get(getCtx(), I_BH_Allergy.Table_ID)
			.getPO(getBH_Allergy_ID(), get_TrxName());
	}

	/** Set Allergy.
		@param BH_Allergy_ID Allergy
	*/
	public void setBH_Allergy_ID (int BH_Allergy_ID)
	{
		if (BH_Allergy_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Allergy_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Allergy_ID, Integer.valueOf(BH_Allergy_ID));
	}

	/** Get Allergy.
		@return Allergy	  */
	public int getBH_Allergy_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Allergy_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Allergy Reaction.
		@param BH_Allergy_Reaction_ID Allergy Reaction
	*/
	public void setBH_Allergy_Reaction_ID (int BH_Allergy_Reaction_ID)
	{
		if (BH_Allergy_Reaction_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Allergy_Reaction_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Allergy_Reaction_ID, Integer.valueOf(BH_Allergy_Reaction_ID));
	}

	/** Get Allergy Reaction.
		@return Allergy Reaction	  */
	public int getBH_Allergy_Reaction_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Allergy_Reaction_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Allergy_Reaction_UU.
		@param BH_Allergy_Reaction_UU BH_Allergy_Reaction_UU
	*/
	public void setBH_Allergy_Reaction_UU (String BH_Allergy_Reaction_UU)
	{
		set_Value (COLUMNNAME_BH_Allergy_Reaction_UU, BH_Allergy_Reaction_UU);
	}

	/** Get BH_Allergy_Reaction_UU.
		@return BH_Allergy_Reaction_UU	  */
	public String getBH_Allergy_Reaction_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Allergy_Reaction_UU);
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

	/** Set Uncoded Allergy Reaction.
		@param BH_Uncoded_Allergy_Reaction Uncoded Allergy Reaction
	*/
	public void setBH_Uncoded_Allergy_Reaction (String BH_Uncoded_Allergy_Reaction)
	{
		set_Value (COLUMNNAME_BH_Uncoded_Allergy_Reaction, BH_Uncoded_Allergy_Reaction);
	}

	/** Get Uncoded Allergy Reaction.
		@return Uncoded Allergy Reaction	  */
	public String getBH_Uncoded_Allergy_Reaction()
	{
		return (String)get_Value(COLUMNNAME_BH_Uncoded_Allergy_Reaction);
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
}