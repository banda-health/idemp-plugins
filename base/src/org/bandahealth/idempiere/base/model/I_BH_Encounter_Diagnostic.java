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

/** Generated Interface for BH_Encounter_Diagnostic
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_BH_Encounter_Diagnostic 
{

    /** TableName=BH_Encounter_Diagnostic */
    public static final String Table_Name = "BH_Encounter_Diagnostic";

    /** AD_Table_ID=1000058 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

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

    /** Column name BH_Concept_ID */
    public static final String COLUMNNAME_BH_Concept_ID = "BH_Concept_ID";

	/** Set Concept	  */
	public void setBH_Concept_ID (int BH_Concept_ID);

	/** Get Concept	  */
	public int getBH_Concept_ID();

	public I_BH_Concept getBH_Concept() throws RuntimeException;

    /** Column name BH_Diagnostics_Notes */
    public static final String COLUMNNAME_BH_Diagnostics_Notes = "BH_Diagnostics_Notes";

	/** Set Notes.
	  * Notes about the results
	  */
	public void setBH_Diagnostics_Notes (String BH_Diagnostics_Notes);

	/** Get Notes.
	  * Notes about the results
	  */
	public String getBH_Diagnostics_Notes();

    /** Column name BH_Diagnostic_Status */
    public static final String COLUMNNAME_BH_Diagnostic_Status = "BH_Diagnostic_Status";

	/** Set Diagnostic Status	  */
	public void setBH_Diagnostic_Status (String BH_Diagnostic_Status);

	/** Get Diagnostic Status	  */
	public String getBH_Diagnostic_Status();

    /** Column name BH_Encounter_Diagnostic_ID */
    public static final String COLUMNNAME_BH_Encounter_Diagnostic_ID = "BH_Encounter_Diagnostic_ID";

	/** Set Encounter Diagnostic	  */
	public void setBH_Encounter_Diagnostic_ID (int BH_Encounter_Diagnostic_ID);

	/** Get Encounter Diagnostic	  */
	public int getBH_Encounter_Diagnostic_ID();

    /** Column name BH_Encounter_Diagnostic_UU */
    public static final String COLUMNNAME_BH_Encounter_Diagnostic_UU = "BH_Encounter_Diagnostic_UU";

	/** Set BH_Encounter_Diagnostic_UU	  */
	public void setBH_Encounter_Diagnostic_UU (String BH_Encounter_Diagnostic_UU);

	/** Get BH_Encounter_Diagnostic_UU	  */
	public String getBH_Encounter_Diagnostic_UU();

    /** Column name BH_Encounter_ID */
    public static final String COLUMNNAME_BH_Encounter_ID = "BH_Encounter_ID";

	/** Set Encounter	  */
	public void setBH_Encounter_ID (int BH_Encounter_ID);

	/** Get Encounter	  */
	public int getBH_Encounter_ID();

	public I_BH_Encounter getBH_Encounter() throws RuntimeException;

    /** Column name BH_Value */
    public static final String COLUMNNAME_BH_Value = "BH_Value";

	/** Set BH_Value.
	  * BH_Value
	  */
	public void setBH_Value (String BH_Value);

	/** Get BH_Value.
	  * BH_Value
	  */
	public String getBH_Value();

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

    /** Column name LineNo */
    public static final String COLUMNNAME_LineNo = "LineNo";

	/** Set Line.
	  * Line No
	  */
	public void setLineNo (int LineNo);

	/** Get Line.
	  * Line No
	  */
	public int getLineNo();

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
