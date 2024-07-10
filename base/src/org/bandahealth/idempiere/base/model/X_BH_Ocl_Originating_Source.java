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

/** Generated Model for BH_Ocl_Originating_Source
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Ocl_Originating_Source")
public class X_BH_Ocl_Originating_Source extends PO implements I_BH_Ocl_Originating_Source, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240710L;

    /** Standard Constructor */
    public X_BH_Ocl_Originating_Source (Properties ctx, int BH_Ocl_Originating_Source_ID, String trxName)
    {
      super (ctx, BH_Ocl_Originating_Source_ID, trxName);
      /** if (BH_Ocl_Originating_Source_ID == 0)
        {
			setBH_Concept_ID (0);
			setBH_Ocl_Originating_Source_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Ocl_Originating_Source (Properties ctx, int BH_Ocl_Originating_Source_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Ocl_Originating_Source_ID, trxName, virtualColumns);
      /** if (BH_Ocl_Originating_Source_ID == 0)
        {
			setBH_Concept_ID (0);
			setBH_Ocl_Originating_Source_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Ocl_Originating_Source (Properties ctx, String BH_Ocl_Originating_Source_UU, String trxName)
    {
      super (ctx, BH_Ocl_Originating_Source_UU, trxName);
      /** if (BH_Ocl_Originating_Source_UU == null)
        {
			setBH_Concept_ID (0);
			setBH_Ocl_Originating_Source_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Ocl_Originating_Source (Properties ctx, String BH_Ocl_Originating_Source_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Ocl_Originating_Source_UU, trxName, virtualColumns);
      /** if (BH_Ocl_Originating_Source_UU == null)
        {
			setBH_Concept_ID (0);
			setBH_Ocl_Originating_Source_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Ocl_Originating_Source (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Ocl_Originating_Source[")
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

	/** Set OCL Originating Source.
		@param BH_Ocl_Originating_Source_ID OCL Originating Source
	*/
	public void setBH_Ocl_Originating_Source_ID (int BH_Ocl_Originating_Source_ID)
	{
		if (BH_Ocl_Originating_Source_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Ocl_Originating_Source_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Ocl_Originating_Source_ID, Integer.valueOf(BH_Ocl_Originating_Source_ID));
	}

	/** Get OCL Originating Source.
		@return OCL Originating Source	  */
	public int getBH_Ocl_Originating_Source_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Ocl_Originating_Source_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Ocl_Originating_Source_UU.
		@param BH_Ocl_Originating_Source_UU BH_Ocl_Originating_Source_UU
	*/
	public void setBH_Ocl_Originating_Source_UU (String BH_Ocl_Originating_Source_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Ocl_Originating_Source_UU, BH_Ocl_Originating_Source_UU);
	}

	/** Get BH_Ocl_Originating_Source_UU.
		@return BH_Ocl_Originating_Source_UU	  */
	public String getBH_Ocl_Originating_Source_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Ocl_Originating_Source_UU);
	}

	/** BHGO - Coded diagnoses = BHGO */
	public static final String BH_OCL_SOURCE_BHGO_CodedDiagnoses = "BHGO";
	/** BHLabs - Lab tests = BHLabs */
	public static final String BH_OCL_SOURCE_BHLabs_LabTests = "BHLabs";
	/** Set BH Ocl Source.
		@param BH_Ocl_Source BH Ocl Source
	*/
	public void setBH_Ocl_Source (String BH_Ocl_Source)
	{

		set_ValueNoCheck (COLUMNNAME_BH_Ocl_Source, BH_Ocl_Source);
	}

	/** Get BH Ocl Source.
		@return BH Ocl Source	  */
	public String getBH_Ocl_Source()
	{
		return (String)get_Value(COLUMNNAME_BH_Ocl_Source);
	}
}