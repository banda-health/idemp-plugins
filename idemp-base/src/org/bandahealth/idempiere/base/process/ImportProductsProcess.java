package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCost;
import org.compiere.model.MCostElement;
import org.compiere.model.MSerNoCtl;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.process.ImportAccount;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class ImportProductsProcess extends SvrProcess {
	public static final String PARAMETERNAME_AD_CLIENT_ID = "AD_Client_ID";
	public static final String PARAMETERNAME_HANDLE_EXISTING_PRODUCTS = "BH_HandleExistingProducts";
	public static final String PARAMETERNAME_DELETE_OLD_IMPORTED = "DeleteOldImported";

	public static final String HANDLE_EXISTING_PRODUCTS_ERROR = "E";
	public static final String HANDLE_EXISTING_PRODUCTS_MERGE = "M";
	public static final String HANDLE_EXISTING_PRODUCTS_SKIP = "S";

	private int clientId = 0;
	private String handleExistingProducts = "S";
	private boolean deleteOldImported = false;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (ProcessInfoParameter processInfoParameter : para) {
			String name = processInfoParameter.getParameterName();
			if (processInfoParameter.getParameter() == null) {
				continue;
			}
			if (name.equals(PARAMETERNAME_AD_CLIENT_ID)) {
				clientId = ((BigDecimal) processInfoParameter.getParameter()).intValue();
			} else if (name.equals(PARAMETERNAME_HANDLE_EXISTING_PRODUCTS)) {
				handleExistingProducts = processInfoParameter.getParameter().toString();
			} else if (name.equals(PARAMETERNAME_DELETE_OLD_IMPORTED)) {
				deleteOldImported = "Y".equals(processInfoParameter.getParameter());
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
			}
		}
	}

	/**
	 * Import the products and quantities into the system. This was initially copied and modified from the iDempiere
	 * import account process, {@link ImportAccount#doIt()}
	 *
	 * @return A success message for this method.
	 * @throws Exception
	 */
	@Override
	protected String doIt() throws Exception {
		StringBuilder sql = null;
		int no = 0;
		StringBuilder clientCheck = new StringBuilder(" AND AD_Client_ID=").append(clientId);

		// Before doing anything, check if there is a warehouse set for quantities
		List<MWarehouse_BH> clientWarehouses = new Query(getCtx(), MWarehouse_BH.Table_Name,
				MWarehouse_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MWarehouse_BH.COLUMNNAME_BH_DEFAULTWAREHOUSE + "=?",
				get_TrxName()).setParameters(clientId, "Y").setOnlyActiveRecords(true).list();

		if (clientWarehouses.isEmpty()) {
			throw new AdempiereException("No default warehouse set");
		}

		//	****	Prepare	****

		//	Delete Old Imported
		if (deleteOldImported) {
			sql = new StringBuilder("DELETE FROM " + X_BH_I_Product_Quantity.Table_Name + " ")
					.append("WHERE I_IsImported='Y'").append(clientCheck);
			no = DB.executeUpdate(sql.toString(), get_TrxName());
			if (log.isLoggable(Level.FINE)) log.fine("Delete Old Impored =" + no);
		}

		//	Set Client, Org, IsActive, Created/Updated
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET AD_Client_ID = COALESCE (AD_Client_ID, ").append(clientId).append("),")
				.append(" AD_Org_ID = COALESCE (AD_Org_ID, 0),")
				.append(" IsActive = COALESCE (IsActive, 'Y'),")
				.append(" Created = COALESCE (Created, getDate()),")
				.append(" CreatedBy = COALESCE (CreatedBy, 0),")
				.append(" Updated = COALESCE (Updated, getDate()),")
				.append(" UpdatedBy = COALESCE (UpdatedBy, 0),")
				.append(" I_ErrorMsg = ' ',")
				.append(" Processed = 'N', ")
				.append(" Processing = 'Y', ")
				.append(" I_IsImported = 'N' ")
				.append("WHERE I_IsImported<>'Y' OR I_IsImported IS NULL");
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Reset=" + no);

		//	****	Prepare	****

		//	No Name
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=No Name, ' ")
				.append("WHERE (Name IS NULL)")
				.append(" AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.CONFIG)) log.config("Invalid Name=" + no);

		//	Set Product
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
				.append("SET M_Product_ID = (SELECT M_Product_ID FROM M_Product p")
				.append(" WHERE upper(i.Name)=upper(p.Name) AND i.AD_Client_ID=p.AD_Client_ID)")
				.append("WHERE M_Product_ID IS NULL")
				.append(" AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Product=" + no);
		//
		if (handleExistingProducts.equalsIgnoreCase(HANDLE_EXISTING_PRODUCTS_ERROR)) {
			sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
					.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Product Exists, ' ")
					.append("WHERE M_Product_ID IS NOT NULL")
					.append(" AND I_IsImported<>'Y'").append(clientCheck);
			no = DB.executeUpdate(sql.toString(), get_TrxName());
			if (log.isLoggable(Level.CONFIG)) log.config("ProductExists=" + no);
		}

		//	Set Lots
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot1 + " = 'N', ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot2 + " = 'N', ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot3 + " = 'N' ")
				.append("WHERE I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Lots reset=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot1 + " = 'Y'")
				.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot1 + " IS NULL")
				.append(" AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Lot 1=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot2 + " = 'Y'")
				.append("WHERE (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot2 + " IS NOT NULL OR ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot2 + " IS NOT NULL OR ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_BuyPrice_Lot2 + " IS NOT NULL")
				.append(") AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Lot 2=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot3 + " = 'Y'")
				.append("WHERE (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot3 + " IS NOT NULL OR ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot3 + " IS NOT NULL OR ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_BuyPrice_Lot3 + " IS NOT NULL")
				.append(") AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Lot 3=" + no);

		// More than one lot for a product that doesn't expire
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Too many lots, ' ")
				.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + "='N' AND (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot2 + "='Y' OR ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot3 + "='Y'")
				.append(") AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Duplicate Product Names=" + no);

		// Lot 2 & Lot 3 need initial quantities
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Lot without quantity, ' ")
				.append("WHERE ((")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot2 + "='Y' AND (" +
						X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot2 + " IS NULL OR " +
						X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot2 + "=0)) OR (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot3 + "='Y' AND (" +
						X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot3 + " IS NULL OR " +
						X_BH_I_Product_Quantity.COLUMNNAME_BH_InitialQuantity_Lot3 + "=0)")
				.append(")) AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Duplicate Product Names=" + no);

		//	Duplicate product names
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Duplicate Product Name, ' ")
				.append("WHERE lower(Name) IN (SELECT lower(Name) as name FROM (")
				.append("SELECT upper(Name) as name, count(*) as product_count FROM " + X_BH_I_Product_Quantity.Table_Name)
				.append(" WHERE I_IsImported<>'Y'" + clientCheck + " GROUP BY upper(Name)")
				.append(") p WHERE product_count > 1) AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Set Duplicate Product Names=" + no);

		//	Check Category Name
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid ProductCategory, ' ")
				.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_CategoryName + " NOT IN (")
				.append("SELECT name FROM " + MProductCategory_BH.Table_Name + " WHERE AD_Client_ID=").append(clientId)
				.append(") AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.CONFIG)) log.config("Invalid CategoryName=" + no);

		//	Check Expiration
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Expiration and dates lot 1, ' ")
				.append("WHERE ((" + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + "='Y' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_GuaranteeDate + " IS NULL) OR (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + " = 'N' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_GuaranteeDate + " IS NOT NULL")
				.append(")) AND I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.CONFIG)) log.config("Invalid Expiration Lot 1=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Expiration and dates lot 2, ' ")
				.append("WHERE ((" + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + "='Y' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot2 + " IS NULL) OR (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + " = 'N' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot2 + " IS NOT NULL")
				.append(")) AND " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot2 + "='Y' AND I_IsImported<>'Y'")
				.append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.CONFIG)) log.config("Invalid Expiration Lot 2=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Expiration and dates lot 3, ' ")
				.append("WHERE ((" + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + "='Y' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot3 + " IS NULL) OR (")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_HasExpiration + " = 'N' AND ")
				.append(X_BH_I_Product_Quantity.COLUMNNAME_BH_GuaranteeDate_Lot3 + " IS NOT NULL")
				.append(")) AND " + X_BH_I_Product_Quantity.COLUMNNAME_BH_HasLot3 + "='Y' AND I_IsImported<>'Y'")
				.append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.CONFIG)) log.config("Invalid Expiration Lot 3=" + no);

		commitEx();

		// get default uom (unit of measure).
		int uomId = 0;
		MUOM uom =
				new Query(Env.getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_Name + "=?", null).setParameters("Each").first();
		if (uom != null) {
			uomId = uom.get_ID();
		}

		// get product categories
		List<MProductCategory_BH> productCategoryList =
				new Query(Env.getCtx(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_AD_Client_ID + "=?",
						null).setParameters(clientId).setClient_ID().list();
		Map<String, MProductCategory_BH> productCategoriesByName = productCategoryList.stream()
				.collect(Collectors.toMap(MProductCategory_BH::getName, productCategory -> productCategory));

		// get tax category
		int taxCategoryId = 0;
		MTaxCategory taxCategory = new Query(Env.getCtx(), MTaxCategory.Table_Name,
				MTaxCategory.COLUMNNAME_Name + "=?" + clientCheck, null).setParameters("Standard").first();
		if (taxCategory != null) {
			taxCategoryId = taxCategory.get_ID();
		}

		//	-------------------------------------------------------------------
		int noInsert = 0;
		int noUpdate = 0;
		int noSkipped = 0;

		Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct = new HashMap<>();

		//	Go through Records
		sql = new StringBuilder("SELECT * ")
				.append("FROM " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("WHERE I_IsImported='N'").append(clientCheck);
		if (handleExistingProducts.equalsIgnoreCase(HANDLE_EXISTING_PRODUCTS_SKIP)) {
			sql.append(" AND M_Product_ID IS NULL");
			// Update products with product IDs to be imported
			noSkipped = DB.executeUpdate("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " " +
							"SET I_IsImported='Y', Updated=getDate() " +
							"WHERE I_IsImported='N' AND M_Product_ID IS NOT NULL" + clientCheck,
					get_TrxName());
		}
		// Get the two available attribute sets that will be assigned to products
		MAttributeSet_BH expiringAttributeSet = new Query(getCtx(), MAttributeSet_BH.Table_Name,
				MAttributeSet_BH.COLUMNNAME_BH_Locked + "=? AND " + MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=?",
				get_TrxName()).setParameters(true, true).setClient_ID().setOnlyActiveRecords(true).first();
		MAttributeSet_BH nonExpiringAttributeSet = new Query(getCtx(), MAttributeSet_BH.Table_Name,
				MAttributeSet_BH.COLUMNNAME_BH_Locked + "=? AND " + MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=?",
				get_TrxName()).setParameters(true, false).setClient_ID().setOnlyActiveRecords(true).first();

		// Get the next serial numbers for attribute sets
		Map<Integer, String> serialNumberBySerialNumberControlId = new HashMap<>() {{
			put(expiringAttributeSet.get_ID(), ((MSerNoCtl) expiringAttributeSet.getM_SerNoCtl()).createSerNo());
		}};
		if (expiringAttributeSet.getM_SerNoCtl_ID() != nonExpiringAttributeSet.getM_SerNoCtl_ID()) {
			serialNumberBySerialNumberControlId.put(nonExpiringAttributeSet.get_ID(),
					((MSerNoCtl) nonExpiringAttributeSet.getM_SerNoCtl()).createSerNo());
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql.toString(), get_TrxName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				X_BH_I_Product_Quantity importedProductQuantity = new X_BH_I_Product_Quantity(getCtx(), rs, get_TrxName());
				int productId = importedProductQuantity.getM_Product_ID();
				int importProductQuantityId = importedProductQuantity.getBH_I_Product_Quantity_ID();

				MProduct_BH product;
				boolean wasSaveSuccessful = true;
				MAttributeSet_BH attributeSetToUse =
						importedProductQuantity.isBH_HasExpiration() ? expiringAttributeSet : nonExpiringAttributeSet;

				//	****	Create/Update Product
				if (productId == 0) {    //	New
					product = new MProduct_BH(importedProductQuantity);
					product.setC_UOM_ID(uomId);
					product.setC_TaxCategory_ID(taxCategoryId);
					product.setM_Product_Category_ID(
							productCategoriesByName.get(importedProductQuantity.getCategoryName()).getM_Product_Category_ID());
					product.setM_AttributeSet_ID(attributeSetToUse.get_ID());
					if (product.save()) {
						noInsert++;
						importedProductQuantity.setM_Product_ID(product.getM_Product_ID());
						importedProductQuantity.setI_IsImported(true);
						importedProductQuantity.saveEx();
						inventoryByProduct.put(product, new ArrayList<>());
					} else {
						wasSaveSuccessful = false;
						sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
								.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Insert Product "))
								.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
								.append(importProductQuantityId);
						DB.executeUpdate(sql.toString(), get_TrxName());
					}
				} else {             //	Update existing
					product = new MProduct_BH(getCtx(), productId, get_TrxName());
					product.set(importedProductQuantity);
					product.setM_Product_Category_ID(
							productCategoriesByName.get(importedProductQuantity.getCategoryName()).getM_Product_Category_ID());
					product.setM_AttributeSet_ID(attributeSetToUse.get_ID());
					if (product.save()) {
						noUpdate++;
						importedProductQuantity.setI_IsImported(true);
						importedProductQuantity.saveEx();
						inventoryByProduct.put(product, new ArrayList<>());
					} else {
						wasSaveSuccessful = false;
						sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
								.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Update Product "))
								.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
								.append(importProductQuantityId);
						DB.executeUpdate(sql.toString(), get_TrxName());
					}
				}

				if (wasSaveSuccessful) {
					int costElementId = new Query(getCtx(), MCostElement.Table_Name, MCostElement.COLUMNNAME_CostingMethod +
							"=?", get_TrxName()).setParameters(MCostElement.COSTINGMETHOD_LastPOPrice).setOnlyActiveRecords(true)
							.setClient_ID().firstId();
					MAcctSchema accountSchema =
							new Query(getCtx(), MAcctSchema.Table_Name, "", get_TrxName()).setClient_ID().setOnlyActiveRecords(true)
									.first();
					// Add attribute set instances and costs for each lot, if this product expires
					if (importedProductQuantity.isBH_HasExpiration()) {
						// Lot 1
						if (importedProductQuantity.getBH_InitialQuantity().compareTo(BigDecimal.ZERO) != 0 &&
								!createLotAndCost(product, attributeSetToUse, inventoryByProduct.get(product),
										serialNumberBySerialNumberControlId.get(attributeSetToUse.get_ID()),
										importedProductQuantity.getBH_InitialQuantity(), importedProductQuantity.getGuaranteeDate(),
										importedProductQuantity.getBH_BuyPrice(), accountSchema, costElementId)) {
							sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
									.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Update Product "))
									.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
									.append(importProductQuantityId);
							DB.executeUpdate(sql.toString(), get_TrxName());
						}

						// Lot 2
						if (importedProductQuantity.isBH_HasLot2() &&
								!createLotAndCost(product, attributeSetToUse, inventoryByProduct.get(product),
										serialNumberBySerialNumberControlId.get(attributeSetToUse.get_ID()),
										importedProductQuantity.getBH_InitialQuantity_Lot2(),
										importedProductQuantity.getBH_GuaranteeDate_Lot2(), importedProductQuantity.getBH_BuyPrice_Lot2(),
										accountSchema, costElementId)) {
							sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
									.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Update Product "))
									.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
									.append(importProductQuantityId);
							DB.executeUpdate(sql.toString(), get_TrxName());
						}

						// Lot 3
						if (importedProductQuantity.isBH_HasLot3() &&
								!createLotAndCost(product, attributeSetToUse, inventoryByProduct.get(product),
										serialNumberBySerialNumberControlId.get(attributeSetToUse.get_ID()),
										importedProductQuantity.getBH_InitialQuantity_Lot3(),
										importedProductQuantity.getBH_GuaranteeDate_Lot3(), importedProductQuantity.getBH_BuyPrice_Lot3(),
										accountSchema, costElementId)) {
							sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
									.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Update Product "))
									.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
									.append(importProductQuantityId);
							DB.executeUpdate(sql.toString(), get_TrxName());
						}
					} else if (importedProductQuantity.getBH_InitialQuantity().compareTo(BigDecimal.ZERO) != 0) {
						if (!createLotAndCost(product, attributeSetToUse, inventoryByProduct.get(product),
								serialNumberBySerialNumberControlId.get(attributeSetToUse.get_ID()),
								importedProductQuantity.getBH_InitialQuantity(), null, importedProductQuantity.getBH_BuyPrice_Lot3(),
								accountSchema, costElementId)) {
							sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " i ")
									.append("SET I_IsImported='N', I_ErrorMsg=I_ErrorMsg||").append(DB.TO_STRING("Update Product "))
									.append("WHERE " + X_BH_I_Product_Quantity.COLUMNNAME_BH_I_Product_Quantity_ID + "=")
									.append(importProductQuantityId);
							DB.executeUpdate(sql.toString(), get_TrxName());
						}
					}
				}
			}  //	for all I_Product
		} catch (SQLException e) {
			throw new Exception("create", e);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		// We do all this and commit before setting initial quantities or else product data won't load (on 7.1)
		//	Set Error to indicator to not imported
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET I_IsImported='N', Updated=getDate() ")
				.append("WHERE I_IsImported<>'Y'").append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		addLog(0, null, new BigDecimal(no), "@Errors@");
		addLog(0, null, new BigDecimal(noInsert), "@M_Product_ID@: @Inserted@");
		addLog(0, null, new BigDecimal(noUpdate), "@M_Product_ID@: @Updated@");
		addLog(0, null, new BigDecimal(noSkipped), "@M_Product_ID@: @Skipped@");

		//	Reset Processing Flag
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET Processing='-'")
				.append("WHERE I_IsImported='Y' AND Processed='N' AND Processing='Y'")
				.append(" AND M_Product_ID IS NOT NULL")
				.append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Reset Processing Flag=" + no);
		//
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET Processing='N'")
				.append("WHERE I_IsImported<>'Y' AND Processing='Y'")
				.append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Reset Processing Flag=" + no);

		//	Done
		sql = new StringBuilder("UPDATE " + X_BH_I_Product_Quantity.Table_Name + " ")
				.append("SET Processing='N', Processed='Y'")
				.append("WHERE I_IsImported='Y'")
				.append(clientCheck);
		no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine("Processed=" + no);

		commitEx();

		// Start a new transaction
		Trx quantityTransaction = Trx.get(Trx.createTrxName("SvrProcess"), true);
		quantityTransaction.setDisplayName(getClass().getName() + "_startProcess");

		if (inventoryByProduct.keySet().size() > 0) {
			try {
				InitializeStock.createInitialStock(inventoryByProduct, getCtx(), quantityTransaction.getTrxName(),
						handleExistingProducts.equalsIgnoreCase(HANDLE_EXISTING_PRODUCTS_MERGE),
						clientWarehouses.get(0).getM_Warehouse_ID());
			} catch (Exception e) {
				addLog(0, null, BigDecimal.ONE, "@Errors@ " + e.getMessage());
			}
		}

		// If this throws an error, it's okay and the products just won't have any initial inventory
		quantityTransaction.commit(false);
		quantityTransaction.close();

		return "";
	}

	/**
	 * Create a new lot with quantity and cost, if possible, for the given product and associated information
	 *
	 * @param product              The product to create a lot for
	 * @param productsAttributeSet Attribute set assigned to the product (saves a DB query)
	 * @param productQuantities    The list of current storage on hand quantities, if any
	 * @param serialNumber         A serial number to give to the Attribute Set Instance if it needs one
	 * @param initialQuantity      The initial quantity
	 * @param expirationDate       The expiration date of the lot, if any
	 * @param buyPrice             The buying price
	 * @param accountSchema        The accounting schema for the cost record
	 * @param costElementId        The cost element ID to associate with the cost
	 * @return Whether the lot and cost were created successfully
	 */
	private boolean createLotAndCost(MProduct_BH product, MAttributeSet_BH productsAttributeSet,
			List<MStorageOnHand> productQuantities, String serialNumber, BigDecimal initialQuantity,
			Timestamp expirationDate, BigDecimal buyPrice, MAcctSchema accountSchema, int costElementId) {
		assert product != null;
		assert productsAttributeSet != null;
		assert productQuantities != null;
		assert accountSchema != null;

		if (initialQuantity == null) {
			initialQuantity = BigDecimal.ZERO;
		}
		if (buyPrice == null) {
			buyPrice = BigDecimal.ZERO;
		}

		int attributeSetInstanceId =
				QueryUtil.createAttributeSetInstance(productsAttributeSet, serialNumber, expirationDate, get_TrxName(),
						getCtx());

		// NB: This model is NOT intended to be saved to the DB, but is a DTO only!
		MStorageOnHand storageOnHand = new MStorageOnHand(getCtx(), 0, get_TrxName());
		storageOnHand.setQtyOnHand(initialQuantity);
		storageOnHand.setM_AttributeSetInstance_ID(attributeSetInstanceId);
		productQuantities.add(storageOnHand);

		// Create a new cost record
		MCost cost = MCost.get(product, attributeSetInstanceId, accountSchema, 0, costElementId, get_TrxName());
		if (cost == null) {
			// Make a new one, since that one doesn't exist
			cost = new MCost(product, attributeSetInstanceId, accountSchema, 0, costElementId);
		}
		cost.setCurrentCostPrice(buyPrice);
		cost.setCurrentQty(initialQuantity);
		cost.setCumulatedAmt(buyPrice.multiply(initialQuantity));
		cost.setCumulatedQty(initialQuantity);
		return cost.save();
	}
}
