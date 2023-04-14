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

/** Generated Interface for BH_Stocktake_v
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_BH_Stocktake_v 
{

    /** TableName=BH_Stocktake_v */
    public static final String Table_Name = "BH_Stocktake_v";

    /** AD_Table_ID=1000006 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

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

    /** Column name BH_DocAction */
    public static final String COLUMNNAME_BH_DocAction = "BH_DocAction";

	/** Set BH Document Action.
	  * The targeted status of the document
	  */
	public void setBH_DocAction (String BH_DocAction);

	/** Get BH Document Action.
	  * The targeted status of the document
	  */
	public String getBH_DocAction();

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

    /** Column name expirationdate */
    public static final String COLUMNNAME_expirationdate = "expirationdate";

	/** Set expirationdate	  */
	public void setexpirationdate (Timestamp expirationdate);

	/** Get expirationdate	  */
	public Timestamp getexpirationdate();

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

    /** Column name IsInstanceAttribute */
    public static final String COLUMNNAME_IsInstanceAttribute = "IsInstanceAttribute";

	/** Set Instance Attribute.
	  * The product attribute is specific to the instance (like Serial No, Lot or Guarantee Date)
	  */
	public void setIsInstanceAttribute (boolean IsInstanceAttribute);

	/** Get Instance Attribute.
	  * The product attribute is specific to the instance (like Serial No, Lot or Guarantee Date)
	  */
	public boolean isInstanceAttribute();

    /** Column name location */
    public static final String COLUMNNAME_location = "location";

	/** Set location	  */
	public void setlocation (String location);

	/** Get location	  */
	public String getlocation();

    /** Column name M_AttributeSet_ID */
    public static final String COLUMNNAME_M_AttributeSet_ID = "M_AttributeSet_ID";

	/** Set Attribute Set.
	  * Product Attribute Set
	  */
	public void setM_AttributeSet_ID (int M_AttributeSet_ID);

	/** Get Attribute Set.
	  * Product Attribute Set
	  */
	public int getM_AttributeSet_ID();

	public org.compiere.model.I_M_AttributeSet getM_AttributeSet() throws RuntimeException;

    /** Column name M_AttributeSetInstance_ID */
    public static final String COLUMNNAME_M_AttributeSetInstance_ID = "M_AttributeSetInstance_ID";

	/** Set Attribute Set Instance.
	  * Product Attribute Set Instance
	  */
	public void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID);

	/** Get Attribute Set Instance.
	  * Product Attribute Set Instance
	  */
	public int getM_AttributeSetInstance_ID();

	public I_M_AttributeSetInstance getM_AttributeSetInstance() throws RuntimeException;

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

    /** Column name M_Storage_UU */
    public static final String COLUMNNAME_M_Storage_UU = "M_Storage_UU";

	/** Set M_Storage_UU	  */
	public void setM_Storage_UU (String M_Storage_UU);

	/** Get M_Storage_UU	  */
	public String getM_Storage_UU();

    /** Column name M_Warehouse_ID */
    public static final String COLUMNNAME_M_Warehouse_ID = "M_Warehouse_ID";

	/** Set Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID);

	/** Get Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID();

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException;

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Product */
    public static final String COLUMNNAME_Product = "Product";

	/** Set Product	  */
	public void setProduct (String Product);

	/** Get Product	  */
	public String getProduct();

    /** Column name quantity */
    public static final String COLUMNNAME_quantity = "quantity";

	/** Set quantity	  */
	public void setquantity (int quantity);

	/** Get quantity	  */
	public int getquantity();

    /** Column name ShelfLifeDays */
    public static final String COLUMNNAME_ShelfLifeDays = "ShelfLifeDays";

	/** Set Shelf Life Days.
	  * Shelf Life in days based on Product Instance Guarantee Date
	  */
	public void setShelfLifeDays (int ShelfLifeDays);

	/** Get Shelf Life Days.
	  * Shelf Life in days based on Product Instance Guarantee Date
	  */
	public int getShelfLifeDays();

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
