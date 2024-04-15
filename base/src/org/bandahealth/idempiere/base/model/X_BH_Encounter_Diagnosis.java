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

/** Generated Model for BH_Encounter_Diagnosis
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Encounter_Diagnosis")
public class X_BH_Encounter_Diagnosis extends PO implements I_BH_Encounter_Diagnosis, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240415L;

    /** Standard Constructor */
    public X_BH_Encounter_Diagnosis (Properties ctx, int BH_Encounter_Diagnosis_ID, String trxName)
    {
      super (ctx, BH_Encounter_Diagnosis_ID, trxName);
      /** if (BH_Encounter_Diagnosis_ID == 0)
        {
			setBH_Encounter_Diagnosis_ID (0);
			setBH_Encounter_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Diagnosis (Properties ctx, int BH_Encounter_Diagnosis_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_Diagnosis_ID, trxName, virtualColumns);
      /** if (BH_Encounter_Diagnosis_ID == 0)
        {
			setBH_Encounter_Diagnosis_ID (0);
			setBH_Encounter_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Diagnosis (Properties ctx, String BH_Encounter_Diagnosis_UU, String trxName)
    {
      super (ctx, BH_Encounter_Diagnosis_UU, trxName);
      /** if (BH_Encounter_Diagnosis_UU == null)
        {
			setBH_Encounter_Diagnosis_ID (0);
			setBH_Encounter_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Diagnosis (Properties ctx, String BH_Encounter_Diagnosis_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_Diagnosis_UU, trxName, virtualColumns);
      /** if (BH_Encounter_Diagnosis_UU == null)
        {
			setBH_Encounter_Diagnosis_ID (0);
			setBH_Encounter_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Encounter_Diagnosis (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Encounter_Diagnosis[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Encounter Diagnosis.
		@param BH_Encounter_Diagnosis_ID Encounter Diagnosis
	*/
	public void setBH_Encounter_Diagnosis_ID (int BH_Encounter_Diagnosis_ID)
	{
		if (BH_Encounter_Diagnosis_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_Diagnosis_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_Diagnosis_ID, Integer.valueOf(BH_Encounter_Diagnosis_ID));
	}

	/** Get Encounter Diagnosis.
		@return Encounter Diagnosis	  */
	public int getBH_Encounter_Diagnosis_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Encounter_Diagnosis_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Encounter_Diagnosis_UU.
		@param BH_Encounter_Diagnosis_UU BH_Encounter_Diagnosis_UU
	*/
	public void setBH_Encounter_Diagnosis_UU (String BH_Encounter_Diagnosis_UU)
	{
		set_Value (COLUMNNAME_BH_Encounter_Diagnosis_UU, BH_Encounter_Diagnosis_UU);
	}

	/** Get BH_Encounter_Diagnosis_UU.
		@return BH_Encounter_Diagnosis_UU	  */
	public String getBH_Encounter_Diagnosis_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_Diagnosis_UU);
	}

	public I_BH_Encounter getBH_Encounter() throws RuntimeException
	{
		return (I_BH_Encounter)MTable.get(getCtx(), I_BH_Encounter.Table_ID)
			.getPO(getBH_Encounter_ID(), get_TrxName());
	}

	/** Set Encounter.
		@param BH_Encounter_ID Encounter
	*/
	public void setBH_Encounter_ID (int BH_Encounter_ID)
	{
		if (BH_Encounter_ID < 1)
			set_Value (COLUMNNAME_BH_Encounter_ID, null);
		else
			set_Value (COLUMNNAME_BH_Encounter_ID, Integer.valueOf(BH_Encounter_ID));
	}

	/** Get Encounter.
		@return Encounter	  */
	public int getBH_Encounter_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Encounter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Uncoded Diagnosis.
		@param BH_Uncoded_Diagnosis uncoded diagnosis
	*/
	public void setBH_Uncoded_Diagnosis (String BH_Uncoded_Diagnosis)
	{
		set_Value (COLUMNNAME_BH_Uncoded_Diagnosis, BH_Uncoded_Diagnosis);
	}

	/** Get Uncoded Diagnosis.
		@return uncoded diagnosis
	  */
	public String getBH_Uncoded_Diagnosis()
	{
		return (String)get_Value(COLUMNNAME_BH_Uncoded_Diagnosis);
	}

	/** Set Line.
		@param LineNo Line No
	*/
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}