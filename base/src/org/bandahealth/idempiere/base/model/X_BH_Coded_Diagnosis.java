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

/** Generated Model for BH_Coded_Diagnosis
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_Coded_Diagnosis extends PO implements I_BH_Coded_Diagnosis, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230425L;

    /** Standard Constructor */
    public X_BH_Coded_Diagnosis (Properties ctx, int BH_Coded_Diagnosis_ID, String trxName)
    {
      super (ctx, BH_Coded_Diagnosis_ID, trxName);
      /** if (BH_Coded_Diagnosis_ID == 0)
        {
			setBH_Coded_Diagnosis_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Coded_Diagnosis (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Coded_Diagnosis[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BH_CielID.
		@param BH_CielID BH_CielID	  */
	public void setBH_CielID (int BH_CielID)
	{
		set_Value (COLUMNNAME_BH_CielID, Integer.valueOf(BH_CielID));
	}

	/** Get BH_CielID.
		@return BH_CielID	  */
	public int getBH_CielID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_CielID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_cielname.
		@param bh_cielname bh_cielname	  */
	public void setbh_cielname (String bh_cielname)
	{
		set_Value (COLUMNNAME_bh_cielname, bh_cielname);
	}

	/** Get bh_cielname.
		@return bh_cielname	  */
	public String getbh_cielname () 
	{
		return (String)get_Value(COLUMNNAME_bh_cielname);
	}

	/** Set Coded Diagnosis.
		@param BH_Coded_Diagnosis_ID Coded Diagnosis	  */
	public void setBH_Coded_Diagnosis_ID (int BH_Coded_Diagnosis_ID)
	{
		if (BH_Coded_Diagnosis_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_ID, Integer.valueOf(BH_Coded_Diagnosis_ID));
	}

	/** Get Coded Diagnosis.
		@return Coded Diagnosis	  */
	public int getBH_Coded_Diagnosis_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Coded_Diagnosis_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Coded_Diagnosis_UU.
		@param BH_Coded_Diagnosis_UU BH_Coded_Diagnosis_UU	  */
	public void setBH_Coded_Diagnosis_UU (String BH_Coded_Diagnosis_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_UU, BH_Coded_Diagnosis_UU);
	}

	/** Get BH_Coded_Diagnosis_UU.
		@return BH_Coded_Diagnosis_UU	  */
	public String getBH_Coded_Diagnosis_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Coded_Diagnosis_UU);
	}

	/** Set bh_concept_class.
		@param bh_concept_class bh_concept_class	  */
	public void setbh_concept_class (String bh_concept_class)
	{
		set_Value (COLUMNNAME_bh_concept_class, bh_concept_class);
	}

	/** Get bh_concept_class.
		@return bh_concept_class	  */
	public String getbh_concept_class () 
	{
		return (String)get_Value(COLUMNNAME_bh_concept_class);
	}

	/** Set bh_icd10who.
		@param bh_icd10who bh_icd10who	  */
	public void setbh_icd10who (String bh_icd10who)
	{
		set_Value (COLUMNNAME_bh_icd10who, bh_icd10who);
	}

	/** Get bh_icd10who.
		@return bh_icd10who	  */
	public String getbh_icd10who () 
	{
		return (String)get_Value(COLUMNNAME_bh_icd10who);
	}

	/** Set bh_moh705a_lessthan5.
		@param bh_moh705a_lessthan5 bh_moh705a_lessthan5	  */
	public void setbh_moh705a_lessthan5 (String bh_moh705a_lessthan5)
	{
		set_Value (COLUMNNAME_bh_moh705a_lessthan5, bh_moh705a_lessthan5);
	}

	/** Get bh_moh705a_lessthan5.
		@return bh_moh705a_lessthan5	  */
	public String getbh_moh705a_lessthan5 () 
	{
		return (String)get_Value(COLUMNNAME_bh_moh705a_lessthan5);
	}

	/** Set bh_moh705b_greaterthan5.
		@param bh_moh705b_greaterthan5 bh_moh705b_greaterthan5	  */
	public void setbh_moh705b_greaterthan5 (String bh_moh705b_greaterthan5)
	{
		set_Value (COLUMNNAME_bh_moh705b_greaterthan5, bh_moh705b_greaterthan5);
	}

	/** Get bh_moh705b_greaterthan5.
		@return bh_moh705b_greaterthan5	  */
	public String getbh_moh705b_greaterthan5 () 
	{
		return (String)get_Value(COLUMNNAME_bh_moh705b_greaterthan5);
	}

	/** Set bh_searchterms.
		@param bh_searchterms bh_searchterms	  */
	public void setbh_searchterms (String bh_searchterms)
	{
		set_Value (COLUMNNAME_bh_searchterms, bh_searchterms);
	}

	/** Get bh_searchterms.
		@return bh_searchterms	  */
	public String getbh_searchterms () 
	{
		return (String)get_Value(COLUMNNAME_bh_searchterms);
	}

	/** Set bh_shortnames.
		@param bh_shortnames bh_shortnames	  */
	public void setbh_shortnames (String bh_shortnames)
	{
		set_Value (COLUMNNAME_bh_shortnames, bh_shortnames);
	}

	/** Get bh_shortnames.
		@return bh_shortnames	  */
	public String getbh_shortnames () 
	{
		return (String)get_Value(COLUMNNAME_bh_shortnames);
	}

	/** Set bh_synomed_ct.
		@param bh_synomed_ct bh_synomed_ct	  */
	public void setbh_synomed_ct (int bh_synomed_ct)
	{
		set_Value (COLUMNNAME_bh_synomed_ct, Integer.valueOf(bh_synomed_ct));
	}

	/** Get bh_synomed_ct.
		@return bh_synomed_ct	  */
	public int getbh_synomed_ct () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_synomed_ct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_synomed_np.
		@param bh_synomed_np bh_synomed_np	  */
	public void setbh_synomed_np (int bh_synomed_np)
	{
		set_Value (COLUMNNAME_bh_synomed_np, Integer.valueOf(bh_synomed_np));
	}

	/** Get bh_synomed_np.
		@return bh_synomed_np	  */
	public int getbh_synomed_np () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_synomed_np);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_synonyms.
		@param bh_synonyms bh_synonyms	  */
	public void setbh_synonyms (String bh_synonyms)
	{
		set_Value (COLUMNNAME_bh_synonyms, bh_synonyms);
	}

	/** Get bh_synonyms.
		@return bh_synonyms	  */
	public String getbh_synonyms () 
	{
		return (String)get_Value(COLUMNNAME_bh_synonyms);
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
}