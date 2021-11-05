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

/** Generated Interface for BH_Coded_Diagnosis_Mapping
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_BH_CodedDiagnosisMapping 
{

    /** TableName=BH_Coded_Diagnosis */
    public static final String Table_Name = "BH_Coded_Diagnosis_Mapping";

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

    /** Column name BH_Coded_Diagnosis_Mapping_ID */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID = "BH_Coded_Diagnosis_Mapping_ID";

	/** Set BH_CodedDiagnosis_Mapping	  */
	public void setBH_CodedDiagnosisMapping_ID (int BH_CodedDiagnosisMapping_ID);

	/** Get BH_CodedDiagnosis_Mapping	  */
	public int getBH_CodedDiagnosisMapping_ID();

    /** Column name BH_CodedDiagnosis_Mapping_UU */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_Mapping_UU = "BH_Coded_Diagnosis_Mapping_UU";

	/** Set BH_CodedDiagnosis_Mapping_UU	  */
	public void setBH_CodedDiagnosisMapping_UU (String BH_CodedDiagnosis_Mapping_UU);

	/** Get BH_CodedDiagnosis_Mapping_UU	  */
	public String getBH_CodedDiagnosisMapping_UU();

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

	/** Column name BH_Coded_Diagnosis_ID */
    public static final String COLUMNNAME_BH_Coded_Diagnosis_ID = "BH_Coded_Diagnosis_ID";

	/** Set BH_CodedDiagnosis	  */
	public void setBH_CodedDiagnosis_ID (int BH_CodedDiagnosis_ID);

	/** Get BH_CodedDiagnosis	  */
	public int getBH_CodedDiagnosis_ID();

    public static final String COLUMNNAME_BH_Source = "BH_Source";

	public void setBH_Source (String BH_Source);

	public String getBH_Source();
	
	public static final String COLUMNNAME_BH_ExternalId = "BH_External_ID";

	public void setBH_ExternalID (String BH_External_ID);

	public String getBH_ExternalID();
	
	public static final String COLUMNNAME_BH_MapType = "BH_Map_Type";

	public void setBH_MapType (String BH_MapType);

	public String getBH_MapType();
	
	public static final String COLUMNNAME_BH_Owner = "BH_Owner";

	public void setBH_Owner (String BH_Owner);

	public String getBH_Owner();
	
	public static final String COLUMNNAME_BH_ConceptCode = "BH_Concept_Code";

	public void setBH_ConceptCode (String BH_ConceptCode);

	public String getBH_ConceptCode();
	
	public static final String COLUMNNAME_BH_ConceptNameResolved = "BH_Concept_Name_Resolved";

	public void setBH_ConceptNameResolved (String BH_ConceptNameResolved);

	public String getBH_ConceptNameResolved();

	
}
