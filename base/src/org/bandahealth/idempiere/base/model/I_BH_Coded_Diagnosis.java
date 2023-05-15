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
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_Coded_Diagnosis
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_BH_Coded_Diagnosis 
{

    /** TableName=BH_Coded_Diagnosis */
    public static final String Table_Name = "BH_Coded_Diagnosis";

    /** AD_Table_ID=1000035 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name BH_CielID */
    public static final String COLUMNNAME_BH_CielID = "BH_CielID";

	/** Set BH_CielID	  */
	public void setBH_CielID (int BH_CielID);

	/** Get BH_CielID	  */
	public int getBH_CielID();

    /** Column name bh_cielname */
    public static final String COLUMNNAME_bh_cielname = "bh_cielname";

	/** Set bh_cielname	  */
	public void setbh_cielname (String bh_cielname);

	/** Get bh_cielname	  */
	public String getbh_cielname();

    /** Column name BH_Coded_Diagnosis_ID */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_ID = "BH_Coded_Diagnosis_ID";

	/** Set Coded Diagnosis	  */
	public void setBH_Coded_Diagnosis_ID (int BH_Coded_Diagnosis_ID);

	/** Get Coded Diagnosis	  */
	public int getBH_Coded_Diagnosis_ID();

    /** Column name BH_Coded_Diagnosis_UU */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_UU = "BH_Coded_Diagnosis_UU";

	/** Set BH_Coded_Diagnosis_UU	  */
	public void setBH_Coded_Diagnosis_UU (String BH_Coded_Diagnosis_UU);

	/** Get BH_Coded_Diagnosis_UU	  */
	public String getBH_Coded_Diagnosis_UU();

    /** Column name bh_concept_class */
    public static final String COLUMNNAME_bh_concept_class = "bh_concept_class";

	/** Set bh_concept_class	  */
	public void setbh_concept_class (String bh_concept_class);

	/** Get bh_concept_class	  */
	public String getbh_concept_class();

    /** Column name bh_icd10who */
    public static final String COLUMNNAME_bh_icd10who = "bh_icd10who";

	/** Set bh_icd10who	  */
	public void setbh_icd10who (String bh_icd10who);

	/** Get bh_icd10who	  */
	public String getbh_icd10who();

    /** Column name bh_moh705a_lessthan5 */
    public static final String COLUMNNAME_bh_moh705a_lessthan5 = "bh_moh705a_lessthan5";

	/** Set bh_moh705a_lessthan5	  */
	public void setbh_moh705a_lessthan5 (String bh_moh705a_lessthan5);

	/** Get bh_moh705a_lessthan5	  */
	public String getbh_moh705a_lessthan5();

    /** Column name bh_moh705b_greaterthan5 */
    public static final String COLUMNNAME_bh_moh705b_greaterthan5 = "bh_moh705b_greaterthan5";

	/** Set bh_moh705b_greaterthan5	  */
	public void setbh_moh705b_greaterthan5 (String bh_moh705b_greaterthan5);

	/** Get bh_moh705b_greaterthan5	  */
	public String getbh_moh705b_greaterthan5();

    /** Column name bh_searchterms */
    public static final String COLUMNNAME_bh_searchterms = "bh_searchterms";

	/** Set bh_searchterms	  */
	public void setbh_searchterms (String bh_searchterms);

	/** Get bh_searchterms	  */
	public String getbh_searchterms();

    /** Column name bh_shortnames */
    public static final String COLUMNNAME_bh_shortnames = "bh_shortnames";

	/** Set bh_shortnames	  */
	public void setbh_shortnames (String bh_shortnames);

	/** Get bh_shortnames	  */
	public String getbh_shortnames();

    /** Column name bh_synomed_ct */
    public static final String COLUMNNAME_bh_synomed_ct = "bh_synomed_ct";

	/** Set bh_synomed_ct	  */
	public void setbh_synomed_ct (int bh_synomed_ct);

	/** Get bh_synomed_ct	  */
	public int getbh_synomed_ct();

    /** Column name bh_synomed_np */
    public static final String COLUMNNAME_bh_synomed_np = "bh_synomed_np";

	/** Set bh_synomed_np	  */
	public void setbh_synomed_np (int bh_synomed_np);

	/** Get bh_synomed_np	  */
	public int getbh_synomed_np();

    /** Column name bh_synonyms */
    public static final String COLUMNNAME_bh_synonyms = "bh_synonyms";

	/** Set bh_synonyms	  */
	public void setbh_synonyms (String bh_synonyms);

	/** Get bh_synonyms	  */
	public String getbh_synonyms();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
