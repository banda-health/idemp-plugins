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

/** Generated Interface for BH_Visit
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_BH_Visit 
{

    /** TableName=BH_Visit */
    public static final String Table_Name = "BH_Visit";

    /** AD_Table_ID=1000040 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name BH_Clinician_User_ID */
    public static final String COLUMNNAME_BH_Clinician_User_ID = "BH_Clinician_User_ID";

	/** Set BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public void setBH_Clinician_User_ID (int BH_Clinician_User_ID);

	/** Get BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public int getBH_Clinician_User_ID();

    /** Column name BH_NewVisit */
    public static final String COLUMNNAME_BH_NewVisit = "BH_NewVisit";

	/** Set New Visit	  */
	public void setBH_NewVisit (boolean BH_NewVisit);

	/** Get New Visit	  */
	public boolean isBH_NewVisit();

    /** Column name BH_PatientType */
    public static final String COLUMNNAME_BH_PatientType = "BH_PatientType";

	/** Set Patient Type	  */
	public void setBH_PatientType (String BH_PatientType);

	/** Get Patient Type	  */
	public String getBH_PatientType();

    /** Column name BH_Process_Stage */
    public static final String COLUMNNAME_BH_Process_Stage = "BH_Process_Stage";

	/** Set BH_Process_Stage.
	  * Drop down field in visits for users to define the process stage
	  */
	public void setBH_Process_Stage (String BH_Process_Stage);

	/** Get BH_Process_Stage.
	  * Drop down field in visits for users to define the process stage
	  */
	public String getBH_Process_Stage();

    /** Column name bh_referral */
    public static final String COLUMNNAME_bh_referral = "bh_referral";

	/** Set Referral	  */
	public void setbh_referral (String bh_referral);

	/** Get Referral	  */
	public String getbh_referral();

    /** Column name BH_ReferredFromTo */
    public static final String COLUMNNAME_BH_ReferredFromTo = "BH_ReferredFromTo";

	/** Set Referred From/To	  */
	public void setBH_ReferredFromTo (String BH_ReferredFromTo);

	/** Get Referred From/To	  */
	public String getBH_ReferredFromTo();

    /** Column name BH_Visit_ID */
    public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/** Set Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID);

	/** Get Visit	  */
	public int getBH_Visit_ID();

    /** Column name BH_Visit_UU */
    public static final String COLUMNNAME_BH_Visit_UU = "BH_Visit_UU";

	/** Set BH_Visit_UU	  */
	public void setBH_Visit_UU (String BH_Visit_UU);

	/** Get BH_Visit_UU	  */
	public String getBH_Visit_UU();

    /** Column name BH_VisitDate */
    public static final String COLUMNNAME_BH_VisitDate = "BH_VisitDate";

	/** Set Visit Date	  */
	public void setBH_VisitDate (Timestamp BH_VisitDate);

	/** Get Visit Date	  */
	public Timestamp getBH_VisitDate();

    /** Column name BH_Voided_Reason_ID */
    public static final String COLUMNNAME_BH_Voided_Reason_ID = "BH_Voided_Reason_ID";

	/** Set BH_Voided_Reason_ID	  */
	public void setBH_Voided_Reason_ID (int BH_Voided_Reason_ID);

	/** Get BH_Voided_Reason_ID	  */
	public int getBH_Voided_Reason_ID();

	public I_BH_Voided_Reason getBH_Voided_Reason() throws RuntimeException;

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

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

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

    /** Column name Patient_ID */
    public static final String COLUMNNAME_Patient_ID = "Patient_ID";

	/** Set Patient.
	  * The Patient must be a valid business partner.
	  */
	public void setPatient_ID (int Patient_ID);

	/** Get Patient.
	  * The Patient must be a valid business partner.
	  */
	public int getPatient_ID();

	public org.compiere.model.I_C_BPartner getPatient() throws RuntimeException;

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
