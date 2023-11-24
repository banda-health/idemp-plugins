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
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.compiere.util.Env.getCtx;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		if (!valueObject.getWarehouse().isBH_IsDefaultWarehouse()) {
			// See if any warehouse in the DB is default for this client
			List<MWarehouse_BH> clientWarehouses = new Query(valueObject.getContext(), MWarehouse_BH.Table_Name,
					MWarehouse_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MWarehouse_BH.COLUMNNAME_BH_DEFAULTWAREHOUSE + "=?",
					get_TrxName()).setParameters(valueObject.getClient().getAD_Client_ID(), "Y").setOnlyActiveRecords(true)
					.list();
			if (clientWarehouses.isEmpty()) {
				valueObject.getWarehouse().setBH_IsDefaultWarehouse(true);
				valueObject.getWarehouse().saveEx();
			} else {
				Env.setContext(getCtx(), Env.M_WAREHOUSE_ID, clientWarehouses.get(0).getM_Warehouse_ID());
			}
		}

		// Check the default serial number control
		List<MSerNoCtl_BH> serialNumberControls =
				new Query(valueObject.getContext(), MSerNoCtl_BH.Table_Name, MSerNoCtl_BH.COLUMNNAME_AD_Client_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getClient().getAD_Client_ID())
						.setOnlyActiveRecords(true).list();
		if (serialNumberControls.isEmpty()) {
			MSerNoCtl_BH serialNumberControl =
					new MSerNoCtl_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
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
				valueObject.getTransactionName()).setParameters(true, true).setClient_ID().setOnlyActiveRecords(true).first();
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
				valueObject.getTransactionName()).setParameters(true, false).setClient_ID().setOnlyActiveRecords(true).first();
		if (nonExpiringAttributeSet == null) {
			nonExpiringAttributeSet = new MAttributeSet_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			nonExpiringAttributeSet.setName("Without Expiry");
			nonExpiringAttributeSet.setIsGuaranteeDate(false);
			nonExpiringAttributeSet.setBH_Locked(true);
			nonExpiringAttributeSet.setM_SerNoCtl_ID(serialNumberControls.get(0).getM_SerNoCtl_ID());
			nonExpiringAttributeSet.saveEx();
		}

		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void errorsInDataStopsProcess() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create duplicate products");
		X_BH_I_Product_Quantity duplicateProduct1 =
				new X_BH_I_Product_Quantity(valueObject.getContext(), 0, valueObject.getTransactionName());
		duplicateProduct1.setName(valueObject.getScenarioName());
		duplicateProduct1.setCategoryName("Standard");
		duplicateProduct1.setBH_BuyPrice(new BigDecimal(5));
		duplicateProduct1.setBH_SellPrice(new BigDecimal(25));
		duplicateProduct1.saveEx();
		X_BH_I_Product_Quantity duplicateProduct2 =
				new X_BH_I_Product_Quantity(valueObject.getContext(), 0, valueObject.getTransactionName());
		duplicateProduct2.setName(valueObject.getScenarioName());
		duplicateProduct2.setCategoryName("Standard");
		duplicateProduct2.setBH_BuyPrice(new BigDecimal(5));
		duplicateProduct2.setBH_SellPrice(new BigDecimal(30));
		duplicateProduct2.saveEx();

		valueObject.setStepName("Create product that expires but has no expiration date");
		valueObject.setRandom();
		X_BH_I_Product_Quantity expiresWithoutExpiration =
				new X_BH_I_Product_Quantity(valueObject.getContext(), 0, valueObject.getTransactionName());
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
		X_BH_I_Product_Quantity normalProduct =
				new X_BH_I_Product_Quantity(valueObject.getContext(), 0, valueObject.getTransactionName());
		normalProduct.setName(valueObject.getScenarioName());
		normalProduct.setCategoryName("Standard");
		normalProduct.setBH_BuyPrice(new BigDecimal("63.875"));
		normalProduct.setBH_SellPrice(new BigDecimal(150));
		normalProduct.saveEx();

		commitEx();

		int numberOfProducts =
				new Query(valueObject.getContext(), MProduct_BH.Table_Name, null, valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null, null)
		));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport =
				new Query(valueObject.getContext(), MProduct_BH.Table_Name, null, valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts, numberOfProductsAfterImport, "No new products were imported");
		addAssertionSQL(
				"WITH products_to_import as (" +
						"	SELECT *" +
						"	FROM bh_i_product_quantity" +
						"	WHERE ad_client_id = " + valueObject.getClient().getAD_Client_ID() +
						") " +
						"SELECT " +
						"	'Assert all import records are still editable', " +
						"	(" +
						"		SELECT (SELECT COUNT(*) FROM products_to_import) = " +
						"     (SELECT COUNT(*) FROM products_to_import WHERE processing = 'N') " +
						"	)");

		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getContext(), valueObject.getTransactionName());
	}

	@IPopulateAnnotation.CanRun
	public void expirationDateFarIntoTheFutureIsOkay() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create product that expires with an expiration date too far into the future");
		valueObject.setRandom();
		X_BH_I_Product_Quantity tooFarExpirationProduct =
				new X_BH_I_Product_Quantity(valueObject.getContext(), 0, valueObject.getTransactionName());
		tooFarExpirationProduct.setName(valueObject.getScenarioName());
		tooFarExpirationProduct.setCategoryName("Standard");
		tooFarExpirationProduct.setBH_HasExpiration(true);
		tooFarExpirationProduct.setGuaranteeDate(ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), 476 * 365));
		tooFarExpirationProduct.setBH_BuyPrice(new BigDecimal(2000));
		tooFarExpirationProduct.setBH_SellPrice(new BigDecimal(2000));
		tooFarExpirationProduct.setBH_InitialQuantity(new BigDecimal(9999999));
		tooFarExpirationProduct.setbh_reorder_level(2500000);
		tooFarExpirationProduct.saveEx();

		commitEx();

		int numberOfProducts =
				new Query(valueObject.getContext(), MProduct_BH.Table_Name, null, valueObject.getTransactionName()).count();
		valueObject.setStepName("Run the product import process");
		valueObject.setProcessUuid(processUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_AD_CLIENT_ID,
						new BigDecimal(valueObject.getClient().getAD_Client_ID()), null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_HANDLE_EXISTING_PRODUCTS,
						ImportProductsProcess.HANDLE_EXISTING_PRODUCTS_ERROR, null, null, null),
				new ProcessInfoParameter(ImportProductsProcess.PARAMETERNAME_DELETE_OLD_IMPORTED, "Y", null, null, null)
		));
		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		int numberOfProductsAfterImport =
				new Query(valueObject.getContext(), MProduct_BH.Table_Name, null, valueObject.getTransactionName()).count();
		assertEquals(numberOfProducts + 1, numberOfProductsAfterImport, "No new products were imported");
	}

	@IPopulateAnnotation.CanRunAfter
	public void cleanImportProductsRecords() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		List<PO> productQuantityImportRecords =
				new Query(valueObject.getContext(), X_BH_I_Product_Quantity.Table_Name,
						X_BH_I_Product_Quantity.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName()).setParameters(
						valueObject.getClient().getAD_Client_ID()).list();
		productQuantityImportRecords.forEach(productQuantityImportRecord -> productQuantityImportRecord.deleteEx(true));
		commitEx();
	}
}
