package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCurrency;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.model.X_I_Product;
import org.junit.Test;

import test.AdempiereTestCase;

public class OrderLineModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());
	}

	@Test(expected = RuntimeException.class)
	public void testReceiveProductsCheckExpiration() throws Exception {
		MOrder_BH receiveProductOrder = new MOrder_BH(getCtx(), 0, getTrxName());

		Integer orgId;

		// set organization
		MOrg organization = new Query(getCtx(), MOrg.Table_Name, "name = 'Test Organization'", getTrxName()).first();
		if (organization == null) {
			organization = new MOrg(getCtx(), 0, getTrxName());
			organization.setName("Test Organization");
			organization.saveEx();
			commit();
		}
		orgId = organization.get_ID();

		receiveProductOrder.setAD_Org_ID(orgId);

		// set location
		MLocation location = new Query(getCtx(), MLocation.Table_Name, "address1 = 'Test Address 1'", getTrxName())
				.first();
		if (location == null) {
			location = new MLocation(getCtx(), 0, getTrxName());
			location.setAD_Org_ID(orgId);
			location.setAddress1("Test Address 1");
			location.saveEx();
			commit();
		}

		// set warehouse/ storeroom
		MWarehouse storeRoom = new Query(getCtx(), MWarehouse.Table_Name, "name = 'Test Store room'", getTrxName())
				.first();
		if (storeRoom == null) {
			storeRoom = new MWarehouse(getCtx(), 0, getTrxName());
			storeRoom.setName("Test Store room");
			storeRoom.setAD_Org_ID(orgId);
			storeRoom.setC_Location_ID(location.get_ID());
			storeRoom.saveEx();
			commit();
		}

		receiveProductOrder.setM_Warehouse_ID(storeRoom.get_ID());

		// set vendor
		MBPartner vendor = new Query(getCtx(), MBPartner.Table_Name, "name = 'Test vendor'", getTrxName()).first();
		if (vendor == null) {
			vendor = new MBPartner(getCtx(), 0, getTrxName());
			vendor.setName("Test Vendor");
			vendor.setAD_Org_ID(orgId);
			vendor.saveEx();
			commit();
		}

		// set shipping location
		MBPartnerLocation vendorLocation = new Query(getCtx(), MBPartnerLocation.Table_Name,
				"name = 'Test Shipping Address'", getTrxName()).first();
		if (vendorLocation == null) {
			vendorLocation = new MBPartnerLocation(getCtx(), 0, getTrxName());
			vendorLocation.setName("Test Shipping Address");
			vendorLocation.setC_BPartner_ID(vendor.get_ID());
			vendorLocation.setC_Location_ID(location.get_ID());
			vendorLocation.setAD_Org_ID(orgId);
			vendorLocation.saveEx();
			commit();
		}

		receiveProductOrder.setC_BPartner_Location_ID(vendorLocation.get_ID());
		receiveProductOrder.setC_BPartner_ID(vendor.get_ID());

		// set vendor
		MUser salesRep = new Query(getCtx(), MBPartner.Table_Name, "name = 'Test Sales Rep'", getTrxName()).first();
		if (salesRep == null) {
			salesRep = new MUser(getCtx(), 0, getTrxName());
			salesRep.setName("Test Sales Rep");
			salesRep.setAD_Org_ID(orgId);
			salesRep.saveEx();
			commit();
		}

		receiveProductOrder.setSalesRep_ID(salesRep.get_ID());

		// price list
		MPriceList priceList = new Query(getCtx(), MPriceList.Table_Name, "name = 'Test Price list'", getTrxName())
				.first();
		if (priceList == null) {
			priceList = new MPriceList(getCtx(), 0, getTrxName());
			priceList.setName("Test Price list");
			priceList.setAD_Org_ID(orgId);
			priceList.setIsDefault(true);

			MCurrency currency = new Query(getCtx(), MCurrency.Table_Name, "iso_code = 'KE'", getTrxName()).first();
			if (currency == null) {
				currency = new MCurrency(getCtx(), 0, getTrxName());
				currency.setISO_Code("KE");
				currency.setDescription("KE");
				currency.setAD_Org_ID(orgId);
				currency.saveEx();
				commit();
			}

			priceList.setC_Currency_ID(currency.get_ID());

			priceList.saveEx();
			commit();
		}

		receiveProductOrder.setM_PriceList_ID(priceList.get_ID());

		receiveProductOrder.saveEx();

		MProduct_BH product = new Query(getCtx(), MProduct_BH.Table_Name, "name = 'Test Product'", getTrxName())
				.first();
		if (product == null) {
			product = new MProduct_BH(getCtx(), 0, getTrxName());
			product.setName("Test Product");

			// set uom - unit of measure
			MUOM uom = new Query(getCtx(), MUOM.Table_Name, "name = 'Each'", getTrxName()).first();
			if (uom == null) {
				uom = new MUOM(getCtx(), 0, getTrxName());
				uom.setName("Each");
				uom.setAD_Org_ID(orgId);
				uom.saveEx();
				commit();
			}

			product.setC_UOM_ID(uom.get_ID());

			product.setProductType(X_I_Product.PRODUCTTYPE_Item);

			// product category
			MProductCategory category = new Query(getCtx(), MProductCategory.Table_Name, "name = 'Test Category'",
					getTrxName()).first();
			if (category == null) {
				category = new MProductCategory(getCtx(), 0, getTrxName());
				category.setName("Test Category");
				category.setAD_Org_ID(orgId);
				category.saveEx();
				commit();
			}

			product.setM_Product_Category_ID(category.get_ID());

			// tax category
			MTaxCategory taxCategory = new Query(getCtx(), MTaxCategory.Table_Name, "name = 'Test Tax Category'",
					getTrxName()).first();
			if (taxCategory == null) {
				taxCategory = new MTaxCategory(getCtx(), 0, getTrxName());
				taxCategory.setName("Test Tax Category");
				taxCategory.setAD_Org_ID(orgId);
				taxCategory.saveEx();
				commit();
			}

			product.setC_TaxCategory_ID(taxCategory.get_ID());
			product.saveEx();
			commit();
		}

		MOrderLine_BH orderLine = new MOrderLine_BH(receiveProductOrder);
		orderLine.setM_Product_ID(product.getM_Product_ID());
		orderLine.saveEx();

		assertNotNull("Should have an attribute set: ", orderLine.getM_AttributeSetInstance_ID());
	}
}