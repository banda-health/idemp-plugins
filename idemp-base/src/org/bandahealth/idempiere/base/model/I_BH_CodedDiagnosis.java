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

import org.compiere.model.MTable;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_Coded_Diagnosis
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_BH_CodedDiagnosis 
{

    /** TableName=BH_Coded_Diagnosis */
    public static final String Table_Name = "BH_Coded_Diagnosis";

    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

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

    /** Column name BH_Coded_Diagnosis_ID */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_ID = "BH_Coded_Diagnosis_ID";

	/** Set BH_CodedDiagnosis	  */
	public void setBH_CodedDiagnosis_ID (int BH_CodedDiagnosis_ID);

	/** Get BH_CodedDiagnosis	  */
	public int getBH_CodedDiagnosis_ID();

    /** Column name BH_CodedDiagnosis_UU */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_UU = "BH_Coded_Diagnosis_UU";

	/** Set BH_CodedDiagnosis_UU	  */
	public void setBH_CodedDiagnosis_UU (String BH_CodedDiagnosis_UU);

	/** Get BH_CodedDiagnosis_UU	  */
	public String getBH_CodedDiagnosis_UU();

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

	/** Column name bh_cielname */
    public static final String COLUMNNAME_BH_CielName = "bh_cielname";

	/** Set bh_cielname.
	  * Alphanumeric identifier of the entity
	  */
	public void setBH_CielName (String bh_cielname);

	/** Get bh_cielname.
	  * Alphanumeric identifier of the entity
	  */
	public String getBH_CielName();
	
	public static final String COLUMNNAME_BH_CielId = "bh_ciel_id";

	public void setBH_CielId (int bh_cielId);

	public int getBH_CielId();
	
	public static final String COLUMNNAME_BH_ConceptClass = "bh_concept_class";

	public void setBH_ConceptClass (String bh_conceptClass);

	public String getBH_ConceptClass();

	public static final String COLUMNNAME_BH_ICD10 = "bh_icd10who";

	public void setBH_ICD10 (String bh_icd10who);

	public String getBH_ICD10();

	public static final String COLUMNNAME_BH_SynomedCT = "bh_synomed_ct";

	public void setBH_SynomedCT (int bh_synomed_ct);

	public int getBH_SynomedCT();

	public static final String COLUMNNAME_BH_SynomedNP = "bh_synomed_np";

	public void setBH_SynomedNP (int bh_synomed_np);

	public int getBH_SynomedNP();

	public static final String COLUMNNAME_BH_Synonyms = "bh_synonyms";

	public void setBH_Synonyms (String bh_synonyms);

	public String getBH_Synonyms();

	public static final String COLUMNNAME_BH_MoH705A_LessThan5 = "bh_moh705a_lessthan5";

	public void setBH_MoH705ALessThan5 (String bh_moh705a_lessthan5);

	public String getBH_MoH705ALessThan5();

	public static final String COLUMNNAME_BH_MoH705B_GreaterThan5 = "bh_moh705b_greaterthan5";

	public void setBH_MoH705BGreaterThan5 (String bh_moh705b_greaterthan5);

	public String getBH_MoH705BGreaterThan5();

	public static final String COLUMNNAME_BH_SEARCHTERMS = "bh_searchterms";

	public void setBH_SearchTerms (String bh_searchterms);

	public String getBH_SearchTerms();

}
