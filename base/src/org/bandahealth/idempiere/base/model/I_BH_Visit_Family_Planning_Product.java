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

/** Generated Interface for BH_Visit_Family_Planning_Product
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Visit_Family_Planning_Product 
{

    /** TableName=BH_Visit_Family_Planning_Product */
    public static final String Table_Name = "BH_Visit_Family_Planning_Product";

    /** AD_Table_ID=1000072 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

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

    /** Column name BH_Fp_Method */
    public static final String COLUMNNAME_BH_Fp_Method = "BH_Fp_Method";

	/** Set FP Method	  */
	public void setBH_Fp_Method (String BH_Fp_Method);

	/** Get FP Method	  */
	public String getBH_Fp_Method();

    /** Column name BH_Line_Role */
    public static final String COLUMNNAME_BH_Line_Role = "BH_Line_Role";

	/** Set Line Role	  */
	public void setBH_Line_Role (String BH_Line_Role);

	/** Get Line Role	  */
	public String getBH_Line_Role();

    /** Column name BH_Visit_Family_Planning_ID */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_ID = "BH_Visit_Family_Planning_ID";

	/** Set Visit Family Planning	  */
	public void setBH_Visit_Family_Planning_ID (int BH_Visit_Family_Planning_ID);

	/** Get Visit Family Planning	  */
	public int getBH_Visit_Family_Planning_ID();

	public I_BH_Visit_Family_Planning getBH_Visit_Family_Planning() throws RuntimeException;

    /** Column name BH_Visit_Family_Planning_Product_ID */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_Product_ID = "BH_Visit_Family_Planning_Product_ID";

	/** Set Visit Family Planning Product	  */
	public void setBH_Visit_Family_Planning_Product_ID (int BH_Visit_Family_Planning_Product_ID);

	/** Get Visit Family Planning Product	  */
	public int getBH_Visit_Family_Planning_Product_ID();

    /** Column name BH_Visit_Family_Planning_Product_UU */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_Product_UU = "BH_Visit_Family_Planning_Product_UU";

	/** Set BH_Visit_Family_Planning_Product_UU	  */
	public void setBH_Visit_Family_Planning_Product_UU (String BH_Visit_Family_Planning_Product_UU);

	/** Get BH_Visit_Family_Planning_Product_UU	  */
	public String getBH_Visit_Family_Planning_Product_UU();

    /** Column name C_OrderLine_ID */
    public static final String COLUMNNAME_C_OrderLine_ID = "C_OrderLine_ID";

	/** Set Sales Order Line.
	  * Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID);

	/** Get Sales Order Line.
	  * Sales Order Line
	  */
	public int getC_OrderLine_ID();

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException;

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

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product/Service.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product/Service.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name QtyEntered */
    public static final String COLUMNNAME_QtyEntered = "QtyEntered";

	/** Set Quantity Entered	  */
	public void setQtyEntered (BigDecimal QtyEntered);

	/** Get Quantity Entered	  */
	public BigDecimal getQtyEntered();

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
