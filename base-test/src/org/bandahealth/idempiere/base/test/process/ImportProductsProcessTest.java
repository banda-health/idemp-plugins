package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.assertion.ChuBoeAssert;
import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;
import org.bandahealth.idempiere.base.process.ImportProductsProcess;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.X_M_DiscountSchema;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.compiere.util.Env.getCtx;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportProductsProcessTest extends ChuBoePopulateFactoryVO {
	private static final String processUuid = "be3382f2-09ad-476b-992b-e30c4a629d55";

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();

		// Make sure a warehouse is defaulted
		if (!valueObject.getWarehouse().isBH_DefaultWarehouse()) {
			// See if any warehouse in the DB is default for this client
			List<MWarehouse_BH> clientWarehouses = new Query(valueObject.getContext(), MWarehouse_BH.Table_Name,
					MWarehouse_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MWarehouse_BH.COLUMNNAME_BH_DefaultWarehouse
							+ "=?",
					get_TrxName()).setParameters(valueObject.getClient().getAD_Client_ID(), "Y")
					.setOnlyActiveRecords(true).list();
			if (clientWarehouses.isEmpty()) {
				valueObject.getWarehouse().setBH_DefaultWarehouse(true);
				valueObject.getWarehouse().saveEx();
			} else {
				Env.setContext(getCtx(), Env.M_WAREHOUSE_ID, clientWarehouses.get(0).getM_Warehouse_ID());
			}
		}

		// Check the default serial number control
		List<MSerNoCtl_BH> serialNumberControls = new Query(valueObject.getContext(), MSerNoCtl_BH.Table_Name,
				MSerNoCtl_BH.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName())
				.setParameters(valueObject.getClient().getAD_Client_ID()).setOnlyActiveRecords(true).list();
		if (serialNumberControls.isEmpty()) {
			MSerNoCtl_BH serialNumberControl = new MSerNoCtl_BH(valueObject.getContext(), 0,
					valueObject.getTransactionName());
			serialNumberControl.setName("Default Serial Counter");
			serialNumberControl.setStartNo(100);
			serialNumberControl.setIncrementNo(1);
			serialNumberControl.setBH_Locked(true);
			serialNumberControl.saveEx();
			serialNumberControls.add(serialNumberControl);
		}

		// Ensure the attribute sets exist
		MAttributeSet_BH expiringAttributeSet = new Query(valueObject.getContext(), MAttributeSet_BH.Table_Name,
				MAttributeSet_BH.COLUMNNAME_BH_Locked + "=? AND " + MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=?",
				valueObject.getTransactionName()).setParameters(true, true).setClient_ID().setOnlyActiveRecords(true)
				.first();
		if (expiringAttributeSet == null) {
			expiringAttributeSet = new MAttributeSet_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			expiringAttributeSet.setName("With Expiry");
			expiringAttributeSet.setIsGuaranteeDate(true);
			expiringAttributeSet.setBH_Locked(true);
			expiringAttributeSet.setM_SerNoCtl_ID(serialNumberControls.get(0).getM_SerNoCtl_ID());
			expiringAttributeSet.saveEx();
		}
		MAttributeSet_BH nonExpiringAttributeSet = new Query(valueObject.getContext(), MAttributeSet_BH.Table_Name,
				MAttributeSet_BH.COLUMNNAME_BH_Locked + "=? AND " + MAttributeSet_BH.COLUMNNAME_IsGuaranteeDate + "=?",
				valueObject.getTransactionName()).setParameters(true, false).setClient_ID().setOnlyActiveRecords(true)
				.first();
		if (nonExpiringAttributeSet == null) {
			nonExpiringAttributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
					valueObject.getTransactionName());
			nonExpiringAttributeSet.setName("Without Expiry");
			nonExpiringAttributeSet.setIsGuaranteeDate(false);
			nonExpiringAttributeSet.setBH_Locked(true);
			nonExpiringAttributeSet.setM_SerNoCtl_ID(serialNumberControls.get(0).getM_SerNoCtl_ID());
			nonExpiringAttributeSet.saveEx();
		}

		commitEx();
	}

	@IPopulateAnnotation.CanRunBefore
	public void prepareItAgain() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		// Remove anything in the import table
		DB.executeUpdate(
				"DELETE FROM bh_i_product_quantity	WHERE ad_client_id = " + valueObject.getClient().getAD_Client_ID(),
				valueObject.getTransactionName());

		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void errorsInDataStopsProcess() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create duplicate products");
		X_BH_I_Product_Quantity duplicateProduct1 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		duplicateProduct1.setName(valueObject.getScenarioName());
		duplicateProduct1.setCategoryName("Standard");
		duplicateProduct1.setBH_BuyPrice(new BigDecimal(5));
		duplicateProduct1.setBH_SellPrice(new BigDecimal(25));
		duplicateProduct1.saveEx();
		X_BH_I_Product_Quantity duplicateProduct2 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		duplicateProduct2.setName(valueObject.getScenarioName());
		duplicateProduct2.setCategoryName("Standard");
		duplicateProduct2.setBH_BuyPrice(new BigDecimal(5));
		duplicateProduct2.setBH_SellPrice(new BigDecimal(30));
		duplicateProduct2.saveEx();

		valueObject.setStepName("Create product that expires but has no expiration date");
		valueObject.setRandom();
		X_BH_I_Product_Quantity expiresWithoutExpiration = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		expiresWithoutExpiration.setName(valueObject.getScenarioName());
		expiresWithoutExpiration.setCategoryName("Standard");
		expiresWithoutExpiration.setBH_HasExpiration(true);
		expiresWithoutExpiration.setBH_BuyPrice(new BigDecimal(2000));
		expiresWithoutExpiration.setBH_SellPrice(new BigDecimal(2500));
		expiresWithoutExpiration.setBH_InitialQuantity(new BigDecimal(300));
		expiresWithoutExpiration.setbh_reorder_level(75);
		expiresWithoutExpiration.saveEx();

		valueObject.setStepName("Create normal product");
		valueObject.setRandom();
		X_BH_I_Product_Quantity normalProduct = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		normalProduct.setName(valueObject.getScenarioName());
		normalProduct.setCategoryName("Standard");
		normalProduct.setBH_BuyPrice(new BigDecimal("63.875"));
		normalProduct.setBH_SellPrice(new BigDecimal(150));
		normalProduct.saveEx();

		commitEx();

		int numberOfProducts = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null,
						null)));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts, numberOfProductsAfterImport, "No new products were imported");
		addAssertionSQL("WITH products_to_import as (" + "	SELECT *" + "	FROM bh_i_product_quantity"
				+ "	WHERE ad_client_id = " + valueObject.getClient().getAD_Client_ID() + ") " + "SELECT "
				+ "	'Assert all import records are still editable', " + "	("
				+ "		SELECT (SELECT COUNT(*) FROM products_to_import) = "
				+ "     (SELECT COUNT(*) FROM products_to_import WHERE processing = 'N') " + "	)");

		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getContext(), valueObject.getTransactionName());
	}

	@IPopulateAnnotation.CanRun
	public void expirationDateFarIntoTheFutureIsOkay() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create product that expires with an expiration date too far into the future");
		valueObject.setRandom();
		X_BH_I_Product_Quantity tooFarExpirationProduct = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		tooFarExpirationProduct.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		tooFarExpirationProduct.setCategoryName("Standard");
		tooFarExpirationProduct.setBH_HasExpiration(true);
		tooFarExpirationProduct.setGuaranteeDate(ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), 476 * 365));
		tooFarExpirationProduct.setBH_BuyPrice(new BigDecimal(2000));
		tooFarExpirationProduct.setBH_SellPrice(new BigDecimal(2000));
		tooFarExpirationProduct.setBH_InitialQuantity(new BigDecimal(9999999));
		tooFarExpirationProduct.setbh_reorder_level(2500000);
		tooFarExpirationProduct.saveEx();

		commitEx();

		int numberOfProducts = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null,
						null)));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts + 1, numberOfProductsAfterImport, "Product was imported");
	}

	@IPopulateAnnotation.CanRunAfter
	public void cleanImportProductsRecords() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		List<PO> productQuantityImportRecords = new Query(valueObject.getContext(), X_BH_I_Product_Quantity.Table_Name,
				X_BH_I_Product_Quantity.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName())
				.setParameters(valueObject.getClient().getAD_Client_ID()).list();
		productQuantityImportRecords.forEach(productQuantityImportRecord -> productQuantityImportRecord.deleteEx(true));
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void canImportProductsWithDifferentPriceLists() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create price list 1");
		MPriceList priceList1 = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
		priceList1.setName(valueObject.getScenarioName());
		priceList1.setIsSOPriceList(true);
		priceList1.saveEx();

		MDiscountSchema schema = new Query(valueObject.getContext(),
				X_M_DiscountSchema.Table_Name,
				"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
				valueObject.getTransactionName())
				.setClient_ID()
				.first();

		valueObject.setStepName("Create price list version 1");
		MPriceListVersion priceListVersion1 =
				new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
		priceListVersion1.setAD_Org_ID(0);
		priceListVersion1.setName(valueObject.getDate() + "; IsSOTrx=Y; " + valueObject.getRandomNumber());
		priceListVersion1.setDescription(valueObject.getStepMessageLong());
		priceListVersion1.setM_PriceList_ID(priceList1.get_ID());
		priceListVersion1.setValidFrom(valueObject.getDate());
		priceListVersion1.setM_DiscountSchema_ID(schema.get_ID());
		priceListVersion1.saveEx();

		valueObject.setStepName("Create price list 2");
		MPriceList priceList2 = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
		priceList2.setName(valueObject.getScenarioName());
		priceList2.setIsSOPriceList(true);
		priceList2.saveEx();

		valueObject.setStepName("Create price list version 2");
		MPriceListVersion priceListVersion2 =
				new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
		priceListVersion2.setAD_Org_ID(0);
		priceListVersion2.setName(valueObject.getDate() + "; IsSOTrx=Y; " + valueObject.getRandomNumber());
		priceListVersion2.setDescription(valueObject.getStepMessageLong());
		priceListVersion2.setM_PriceList_ID(priceListVersion2.get_ID());
		priceListVersion2.setValidFrom(valueObject.getDate());
		priceListVersion2.setM_DiscountSchema_ID(schema.get_ID());
		priceListVersion2.saveEx();

		valueObject.setStepName("Insert imported product 1");
		X_BH_I_Product_Quantity productQuantity1 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		productQuantity1.setName(valueObject.getScenarioName());
		productQuantity1.setCategoryName("Pharmacy");
		productQuantity1.setBH_BuyPrice(new BigDecimal(5));
		productQuantity1.setBH_SellPrice(new BigDecimal(25));
		productQuantity1.setBH_PriceList2_Name(priceList1.getName());
		productQuantity1.setBH_PriceList2_SellPrice(new BigDecimal(26));
		productQuantity1.saveEx();

		valueObject.setStepName("Insert imported product 2");
		X_BH_I_Product_Quantity productQuantity2 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		productQuantity2.setName(valueObject.getScenarioName());
		productQuantity1.setCategoryName("Pharmacy");
		productQuantity2.setBH_BuyPrice(new BigDecimal(5));
		productQuantity2.setBH_SellPrice(new BigDecimal(30));
		productQuantity1.setBH_PriceList2_Name(priceList2.getName());
		productQuantity1.setBH_PriceList2_SellPrice(new BigDecimal(31));
		productQuantity2.saveEx();

		int numberOfProducts = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null,
						null)));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts + 2, numberOfProductsAfterImport, "2 products were imported");

		MProduct_BH product1 = new Query(valueObject.getContext(), MProduct_BH.Table_Name, "Name=?",
				valueObject.getTransactionName()).setParameters(productQuantity1.getName()).first();
		MProduct_BH product2 = new Query(valueObject.getContext(), MProduct_BH.Table_Name, "Name=?",
				valueObject.getTransactionName()).setParameters(productQuantity2.getName()).first();
		List<MProductPrice> productPrices =
				new Query(valueObject.getContext(), MProductPrice.Table_Name, "M_Product_ID IN (?,?)",
						valueObject.getTransactionName()).setParameters(product1.get_ID(), product2.get_ID()).list();

		MPriceList defaultPriceList =
				new Query(valueObject.getContext(), MPriceList.Table_Name, "IsDefault=? AND IsSOPriceList=?",
						valueObject.getTransactionName()).setParameters("Y", "Y").setOrderBy("Created DESC").first();
		MPriceListVersion defaultPriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, "M_PriceList_ID=? AND TRUNC(ValidFrom)<=?",
						valueObject.getTransactionName()).setParameters(defaultPriceList.getM_PriceList_ID(),
								valueObject.getDate())
						.setOrderBy("ValidFrom DESC").first();

		List<MProductPrice> product1Prices =
				productPrices.stream().filter(productPrice -> productPrice.getM_Product_ID() == product1.get_ID())
						.collect(Collectors.toList());
		List<MProductPrice> product2Prices =
				productPrices.stream().filter(productPrice -> productPrice.getM_Product_ID() == product2.get_ID())
						.collect(Collectors.toList());
		Optional<MProductPrice> productPriceToCheck = product1Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == defaultPriceListVersion.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 1 price added to default price list");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on default price list");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on default price list");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on default price list");

		productPriceToCheck = product1Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == priceListVersion1.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 1 price added to price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(26)),
				"Product 1 standard price is correct on price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(26)),
				"Product 1 standard price is correct on price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(26)),
				"Product 1 standard price is correct on price list 1");

		productPriceToCheck = product1Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == priceListVersion2.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 1 price added to price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(25)),
				"Product 1 standard price is correct on price list 2");

		productPriceToCheck = product2Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == defaultPriceListVersion.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 2 price added to default price list");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on default price list");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on default price list");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on default price list");

		productPriceToCheck = product2Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == priceListVersion1.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 2 price added to price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on price list 1");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(30)),
				"Product 2 standard price is correct on price list 1");

		productPriceToCheck = product2Prices.stream()
				.filter(productPrice -> productPrice.getM_PriceList_Version_ID() == priceListVersion2.get_ID())
				.findFirst();
		assertTrue(productPriceToCheck.isPresent(), "Product 2 price added to price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceStd().compareTo(new BigDecimal(31)),
				"Product 2 standard price is correct on price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceList().compareTo(new BigDecimal(31)),
				"Product 2 standard price is correct on price list 2");
		assertEquals(0, productPriceToCheck.get().getPriceLimit().compareTo(new BigDecimal(31)),
				"Product 2 standard price is correct on price list 2");
	}

	@IPopulateAnnotation.CanRun
	public void canNotImportProductsWithInvalidPriceLists() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create bad product 1");
		X_BH_I_Product_Quantity badProduct1 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		badProduct1.setName(valueObject.getScenarioName());
		badProduct1.setCategoryName("Pharmacy");
		badProduct1.setBH_BuyPrice(new BigDecimal(5));
		badProduct1.setBH_SellPrice(new BigDecimal(25));
		badProduct1.setBH_PriceList2_Name("wrong");
		badProduct1.saveEx();

		valueObject.setStepName("Create bad product 2");
		X_BH_I_Product_Quantity badProduct2 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		badProduct2.setName(valueObject.getScenarioName());
		badProduct2.setCategoryName("Standard");
		badProduct2.setBH_BuyPrice(new BigDecimal(5));
		badProduct2.setBH_SellPrice(new BigDecimal(25));
		badProduct2.setBH_PriceList2_SellPrice(new BigDecimal(30));
		badProduct2.saveEx();

		valueObject.setStepName("Create bad product 3");
		X_BH_I_Product_Quantity badProduct3 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		badProduct1.setName(valueObject.getScenarioName());
		badProduct1.setCategoryName("Pharmacy");
		badProduct1.setBH_BuyPrice(new BigDecimal(5));
		badProduct1.setBH_SellPrice(new BigDecimal(25));
		badProduct1.setBH_PriceList3_Name("wrong");
		badProduct1.saveEx();

		valueObject.setStepName("Create bad product 4");
		X_BH_I_Product_Quantity badProduct4 = new X_BH_I_Product_Quantity(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		badProduct2.setName(valueObject.getScenarioName());
		badProduct2.setCategoryName("Standard");
		badProduct2.setBH_BuyPrice(new BigDecimal(5));
		badProduct2.setBH_SellPrice(new BigDecimal(25));
		badProduct2.setBH_PriceList3_SellPrice(new BigDecimal(30));
		badProduct2.saveEx();

		commitEx();

		int numberOfProducts = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null,
						null)));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport = new Query(valueObject.getContext(), MProduct_BH.Table_Name, null,
				valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts, numberOfProductsAfterImport, "No new products were imported");
	}
}
