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

/** Generated Interface for BH_I_Product_Quantity
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_BH_I_Product_Quantity 
{

    /** TableName=BH_I_Product_Quantity */
    public static final String Table_Name = "BH_I_Product_Quantity";

    /** AD_Table_ID=1000037 */
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

    /** Column name BH_BuyPrice */
    public static final String COLUMNNAME_BH_BuyPrice = "BH_BuyPrice";

	/** Set BH_BuyPrice.
	  * Purchase price of product
	  */
	public void setBH_BuyPrice (BigDecimal BH_BuyPrice);

	/** Get BH_BuyPrice.
	  * Purchase price of product
	  */
	public BigDecimal getBH_BuyPrice();

    /** Column name BH_BuyPrice_Lot2 */
    public static final String COLUMNNAME_BH_BuyPrice_Lot2 = "BH_BuyPrice_Lot2";

	/** Set Lot 2 Buying Price	  */
	public void setBH_BuyPrice_Lot2 (BigDecimal BH_BuyPrice_Lot2);

	/** Get Lot 2 Buying Price	  */
	public BigDecimal getBH_BuyPrice_Lot2();

    /** Column name BH_BuyPrice_Lot3 */
    public static final String COLUMNNAME_BH_BuyPrice_Lot3 = "BH_BuyPrice_Lot3";

	/** Set Lot 3 Buying Price	  */
	public void setBH_BuyPrice_Lot3 (BigDecimal BH_BuyPrice_Lot3);

	/** Get Lot 3 Buying Price	  */
	public BigDecimal getBH_BuyPrice_Lot3();

    /** Column name BH_GuaranteeDate_Lot2 */
    public static final String COLUMNNAME_BH_GuaranteeDate_Lot2 = "BH_GuaranteeDate_Lot2";

	/** Set Lot 2 Guarantee Date	  */
	public void setBH_GuaranteeDate_Lot2 (Timestamp BH_GuaranteeDate_Lot2);

	/** Get Lot 2 Guarantee Date	  */
	public Timestamp getBH_GuaranteeDate_Lot2();

    /** Column name BH_GuaranteeDate_Lot3 */
    public static final String COLUMNNAME_BH_GuaranteeDate_Lot3 = "BH_GuaranteeDate_Lot3";

	/** Set Lot 3 Guarantee Date	  */
	public void setBH_GuaranteeDate_Lot3 (Timestamp BH_GuaranteeDate_Lot3);

	/** Get Lot 3 Guarantee Date	  */
	public Timestamp getBH_GuaranteeDate_Lot3();

    /** Column name BH_HasExpiration */
    public static final String COLUMNNAME_BH_HasExpiration = "BH_HasExpiration";

	/** Set Has Expiration	  */
	public void setBH_HasExpiration (boolean BH_HasExpiration);

	/** Get Has Expiration	  */
	public boolean isBH_HasExpiration();

    /** Column name BH_HasLot1 */
    public static final String COLUMNNAME_BH_HasLot1 = "BH_HasLot1";

	/** Set Has Lot 1	  */
	public void setBH_HasLot1 (boolean BH_HasLot1);

	/** Get Has Lot 1	  */
	public boolean isBH_HasLot1();

    /** Column name BH_HasLot2 */
    public static final String COLUMNNAME_BH_HasLot2 = "BH_HasLot2";

	/** Set Has Lot 2	  */
	public void setBH_HasLot2 (boolean BH_HasLot2);

	/** Get Has Lot 2	  */
	public boolean isBH_HasLot2();

    /** Column name BH_HasLot3 */
    public static final String COLUMNNAME_BH_HasLot3 = "BH_HasLot3";

	/** Set Has Lot 3	  */
	public void setBH_HasLot3 (boolean BH_HasLot3);

	/** Get Has Lot 3	  */
	public boolean isBH_HasLot3();

    /** Column name BH_I_Product_Quantity_ID */
    public static final String COLUMNNAME_BH_I_Product_Quantity_ID = "BH_I_Product_Quantity_ID";

	/** Set Import Products with Quantities	  */
	public void setBH_I_Product_Quantity_ID (int BH_I_Product_Quantity_ID);

	/** Get Import Products with Quantities	  */
	public int getBH_I_Product_Quantity_ID();

    /** Column name BH_I_Product_Quantity_UU */
    public static final String COLUMNNAME_BH_I_Product_Quantity_UU = "BH_I_Product_Quantity_UU";

	/** Set BH_I_Product_Quantity_UU	  */
	public void setBH_I_Product_Quantity_UU (String BH_I_Product_Quantity_UU);

	/** Get BH_I_Product_Quantity_UU	  */
	public String getBH_I_Product_Quantity_UU();

    /** Column name BH_InitialQuantity */
    public static final String COLUMNNAME_BH_InitialQuantity = "BH_InitialQuantity";

	/** Set Initial Quantity.
	  * The initial quantity of a product
	  */
	public void setBH_InitialQuantity (BigDecimal BH_InitialQuantity);

	/** Get Initial Quantity.
	  * The initial quantity of a product
	  */
	public BigDecimal getBH_InitialQuantity();

    /** Column name BH_InitialQuantity_Lot2 */
    public static final String COLUMNNAME_BH_InitialQuantity_Lot2 = "BH_InitialQuantity_Lot2";

	/** Set Lot 2 Initial Quantity	  */
	public void setBH_InitialQuantity_Lot2 (BigDecimal BH_InitialQuantity_Lot2);

	/** Get Lot 2 Initial Quantity	  */
	public BigDecimal getBH_InitialQuantity_Lot2();

    /** Column name BH_InitialQuantity_Lot3 */
    public static final String COLUMNNAME_BH_InitialQuantity_Lot3 = "BH_InitialQuantity_Lot3";

	/** Set Lot 3 Initial Quantity	  */
	public void setBH_InitialQuantity_Lot3 (BigDecimal BH_InitialQuantity_Lot3);

	/** Get Lot 3 Initial Quantity	  */
	public BigDecimal getBH_InitialQuantity_Lot3();

    /** Column name bh_reorder_level */
    public static final String COLUMNNAME_bh_reorder_level = "bh_reorder_level";

	/** Set Re-order Level	  */
	public void setbh_reorder_level (int bh_reorder_level);

	/** Get Re-order Level	  */
	public int getbh_reorder_level();

    /** Column name BH_SellPrice */
    public static final String COLUMNNAME_BH_SellPrice = "BH_SellPrice";

	/** Set BH_SellPrice.
	  * Selling price of BandaGo product
	  */
	public void setBH_SellPrice (BigDecimal BH_SellPrice);

	/** Get BH_SellPrice.
	  * Selling price of BandaGo product
	  */
	public BigDecimal getBH_SellPrice();

    /** Column name CategoryName */
    public static final String COLUMNNAME_CategoryName = "CategoryName";

	/** Set Category Name.
	  * Name of the Category
	  */
	public void setCategoryName (String CategoryName);

	/** Get Category Name.
	  * Name of the Category
	  */
	public String getCategoryName();

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

    /** Column name GuaranteeDate */
    public static final String COLUMNNAME_GuaranteeDate = "GuaranteeDate";

	/** Set Guarantee Date.
	  * Date when guarantee expires
	  */
	public void setGuaranteeDate (Timestamp GuaranteeDate);

	/** Get Guarantee Date.
	  * Date when guarantee expires
	  */
	public Timestamp getGuaranteeDate();

    /** Column name I_ErrorMsg */
    public static final String COLUMNNAME_I_ErrorMsg = "I_ErrorMsg";

	/** Set Import Error Message.
	  * Messages generated from import process
	  */
	public void setI_ErrorMsg (String I_ErrorMsg);

	/** Get Import Error Message.
	  * Messages generated from import process
	  */
	public String getI_ErrorMsg();

    /** Column name I_IsImported */
    public static final String COLUMNNAME_I_IsImported = "I_IsImported";

	/** Set Imported.
	  * Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported);

	/** Get Imported.
	  * Has this import been processed
	  */
	public boolean isI_IsImported();

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

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

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
