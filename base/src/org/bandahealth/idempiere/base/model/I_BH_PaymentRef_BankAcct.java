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

/** Generated Interface for BH_PaymentRef_BankAcct
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_BH_PaymentRef_BankAcct 
{

    /** TableName=BH_PaymentRef_BankAcct */
    public static final String Table_Name = "BH_PaymentRef_BankAcct";

    /** AD_Table_ID=1000017 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(2);

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

    /** Column name AD_Ref_List_ID */
    public static final String COLUMNNAME_AD_Ref_List_ID = "AD_Ref_List_ID";

	/** Set Reference List.
	  * Reference List based on Table
	  */
	public void setAD_Ref_List_ID (int AD_Ref_List_ID);

	/** Get Reference List.
	  * Reference List based on Table
	  */
	public int getAD_Ref_List_ID();

	public org.compiere.model.I_AD_Ref_List getAD_Ref_List() throws RuntimeException;

    /** Column name BH_PaymentRef_BankAcct_ID */
    public static final String COLUMNNAME_BH_PaymentRef_BankAcct_ID = "BH_PaymentRef_BankAcct_ID";

	/** Set BH_PaymentRef_BankAcct	  */
	public void setBH_PaymentRef_BankAcct_ID (int BH_PaymentRef_BankAcct_ID);

	/** Get BH_PaymentRef_BankAcct	  */
	public int getBH_PaymentRef_BankAcct_ID();

    /** Column name BH_PaymentRef_BankAcct_UU */
    public static final String COLUMNNAME_BH_PaymentRef_BankAcct_UU = "BH_PaymentRef_BankAcct_UU";

	/** Set BH_PaymentRef_BankAcct_UU	  */
	public void setBH_PaymentRef_BankAcct_UU (String BH_PaymentRef_BankAcct_UU);

	/** Get BH_PaymentRef_BankAcct_UU	  */
	public String getBH_PaymentRef_BankAcct_UU();

    /** Column name BH_PaymentRef_ID */
    public static final String COLUMNNAME_BH_PaymentRef_ID = "BH_PaymentRef_ID";

	/** Set BH_PaymentRef	  */
	public void setBH_PaymentRef_ID (int BH_PaymentRef_ID);

	/** Get BH_PaymentRef	  */
	public int getBH_PaymentRef_ID();

	public I_BH_PaymentRef getBH_PaymentRef() throws RuntimeException;

    /** Column name BH_PaymentRefList_Value */
    public static final String COLUMNNAME_BH_PaymentRefList_Value = "BH_PaymentRefList_Value";

	/** Set BH_PaymentRefList_Value.
	  * The value of the payment reference list entry
	  */
	public void setBH_PaymentRefList_Value (String BH_PaymentRefList_Value);

	/** Get BH_PaymentRefList_Value.
	  * The value of the payment reference list entry
	  */
	public String getBH_PaymentRefList_Value();

    /** Column name BH_ReferenceList_IsActive */
    public static final String COLUMNNAME_BH_ReferenceList_IsActive = "BH_ReferenceList_IsActive";

	/** Set BH_ReferenceList_IsActive	  */
	public void setBH_ReferenceList_IsActive (boolean BH_ReferenceList_IsActive);

	/** Get BH_ReferenceList_IsActive	  */
	public boolean isBH_ReferenceList_IsActive();

    /** Column name C_BankAccount_ID */
    public static final String COLUMNNAME_C_BankAccount_ID = "C_BankAccount_ID";

	/** Set Bank Account.
	  * Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID);

	/** Get Bank Account.
	  * Account at the Bank
	  */
	public int getC_BankAccount_ID();

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException;

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

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

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
