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

/** Generated Model for BH_Allergy
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Allergy")
public class X_BH_Allergy extends PO implements I_BH_Allergy, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250314L;

    /** Standard Constructor */
    public X_BH_Allergy (Properties ctx, int BH_Allergy_ID, String trxName)
    {
      super (ctx, BH_Allergy_ID, trxName);
      /** if (BH_Allergy_ID == 0)
        {
			setBH_Allergy_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy (Properties ctx, int BH_Allergy_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Allergy_ID, trxName, virtualColumns);
      /** if (BH_Allergy_ID == 0)
        {
			setBH_Allergy_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy (Properties ctx, String BH_Allergy_UU, String trxName)
    {
      super (ctx, BH_Allergy_UU, trxName);
      /** if (BH_Allergy_UU == null)
        {
			setBH_Allergy_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Allergy (Properties ctx, String BH_Allergy_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Allergy_UU, trxName, virtualColumns);
      /** if (BH_Allergy_UU == null)
        {
			setBH_Allergy_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Allergy (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Allergy[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Allergy Note.
		@param BH_Allergy_Note Allergy Note
	*/
	public void setBH_Allergy_Note (String BH_Allergy_Note)
	{
		set_Value (COLUMNNAME_BH_Allergy_Note, BH_Allergy_Note);
	}

	/** Get Allergy Note.
		@return Allergy Note	  */
	public String getBH_Allergy_Note()
	{
		return (String)get_Value(COLUMNNAME_BH_Allergy_Note);
	}

	/** Set BH_Allergy_UU.
		@param BH_Allergy_UU BH_Allergy_UU
	*/
	public void setBH_Allergy_UU (String BH_Allergy_UU)
	{
		set_Value (COLUMNNAME_BH_Allergy_UU, BH_Allergy_UU);
	}

	/** Get BH_Allergy_UU.
		@return BH_Allergy_UU	  */
	public String getBH_Allergy_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Allergy_UU);
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
			set_Value (COLUMNNAME_BH_Concept_ID, null);
		else
			set_Value (COLUMNNAME_BH_Concept_ID, Integer.valueOf(BH_Concept_ID));
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

	/** Set Uncoded Allergen.
		@param BH_Uncoded_Allergen Uncoded Allergen
	*/
	public void setBH_Uncoded_Allergen (String BH_Uncoded_Allergen)
	{
		set_Value (COLUMNNAME_BH_Uncoded_Allergen, BH_Uncoded_Allergen);
	}

	/** Get Uncoded Allergen.
		@return Uncoded Allergen	  */
	public String getBH_Uncoded_Allergen()
	{
		return (String)get_Value(COLUMNNAME_BH_Uncoded_Allergen);
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

	public I_BH_Concept getSeverity_Concept() throws RuntimeException
	{
		return (I_BH_Concept)MTable.get(getCtx(), I_BH_Concept.Table_ID)
			.getPO(getSeverity_Concept_ID(), get_TrxName());
	}

	/** Set Severity Concept ID.
		@param Severity_Concept_ID Severity Concept ID
	*/
	public void setSeverity_Concept_ID (int Severity_Concept_ID)
	{
		if (Severity_Concept_ID < 1)
			set_Value (COLUMNNAME_Severity_Concept_ID, null);
		else
			set_Value (COLUMNNAME_Severity_Concept_ID, Integer.valueOf(Severity_Concept_ID));
	}

	/** Get Severity Concept ID.
		@return Severity Concept ID	  */
	public int getSeverity_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Severity_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}