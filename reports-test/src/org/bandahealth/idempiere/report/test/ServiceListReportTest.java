package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.Query;
import org.compiere.model.X_M_DiscountSchema;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceListReportTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void correctProductsDisplayed() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		ChuBoeCreateEntity.createDefaultPriceLists(valueObject);
		valueObject.getBusinessPartner().setPO_PriceList_ID(valueObject.getPurchasePriceList().get_ID());
		valueObject.getBusinessPartner().setM_PriceList_ID(valueObject.getSalesPriceList().get_ID());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product category 1");
		var productCategory1 = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		productCategory1.setBH_Product_Category_Type(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);
		productCategory1.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		productCategory1.saveEx();
		commitEx();

		valueObject.setStepName("Create product 1");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setM_Product_Category_ID(productCategory1.getM_Product_Category_ID());
		valueObject.getProduct().saveEx();
		var product1 = valueObject.getProduct();
		commitEx();

		valueObject.setStepName("Create product category 2");
		var productCategory2 = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		productCategory2.setBH_Product_Category_Type(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);
		productCategory2.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		productCategory2.saveEx();
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.clearProduct();
		valueObject.setSalesStandardPrice(new BigDecimal(75));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setIsActive(false);
		valueObject.getProduct().setM_Product_Category_ID(productCategory2.getM_Product_Category_ID());
		valueObject.getProduct().saveEx();
		var product2 = valueObject.getProduct();
		commitEx();

		valueObject.setStepName("Create product category 3");
		var productCategory3 = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		productCategory3.setBH_Product_Category_Type(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);
		productCategory3.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		productCategory3.saveEx();
		commitEx();

		valueObject.setStepName("Create product 3");
		valueObject.clearProduct();
		valueObject.setSalesStandardPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_Product_Category_ID(productCategory3.getM_Product_Category_ID());
		valueObject.getProduct().saveEx();
		var product3 = valueObject.getProduct();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("fd5b6538-760c-4c8f-b943-115c1f3d2287");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int nameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int categoryColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Category");
			int chargeColumnIndex = TableUtils.getColumnIndex(headerRow, "Charge");

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue().contains(product1.getName())).findFirst();

			assertTrue(productRow.isPresent(), "Service row exists");
			assertThat("Category is correct", productRow.get().getCell(categoryColumnIndex).getStringCellValue(),
					is(productCategory1.getName()));
			assertThat("Charge is correct", productRow.get().getCell(chargeColumnIndex).getNumericCellValue(), is(50D));

			productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue().contains(product2.getName())).findFirst();
			assertTrue(productRow.isEmpty(), "Service 2 does not exist");

			productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue().contains(product3.getName())).findFirst();
			assertTrue(productRow.isEmpty(), "Service 3 does not exist");
		}
	}

	@IPopulateAnnotation.CanRun
	public void productOnMultiplePriceListsOnlyAppearsOnce() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create first business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();
		var firstPriceList = valueObject.getSalesPriceList();

		valueObject.setStepName("Create second business partner");
		valueObject.clearBusinessPartner();
		valueObject.clearPriceLists();
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product category");
		var productCategory = new MProductCategory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		productCategory.setBH_Product_Category_Type(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service);
		productCategory.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		productCategory.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().setM_Product_Category_ID(productCategory.getM_Product_Category_ID());
		valueObject.getProduct().saveEx();
		var product1 = valueObject.getProduct();
		commitEx();

		valueObject.setStepName("Create default prices");
		ChuBoeCreateEntity.createDefaultPriceLists(valueObject);
		String sqlWhere = "M_PriceList_ID = ?";
		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, sqlWhere,
						valueObject.getTransactionName())
						.setClient_ID()
						.setParameters(valueObject.getSalesPriceList().get_ID()).setOrderBy("validfrom desc")
						.first();
		MProductPrice productSalesPrice = new MProductPrice(valueObject.getContext(), salesPriceListVersion.get_ID(),
				valueObject.getProduct().get_ID(), valueObject.getTransactionName());
		productSalesPrice.setPriceLimit(valueObject.getSalesLimitPrice());
		productSalesPrice.setPriceStd(valueObject.getSalesStandardPrice());
		productSalesPrice.setPriceList(valueObject.getSalesListPrice());
		productSalesPrice.saveEx();
		commitEx();

		valueObject.setStepName("Create first price list version");
		MDiscountSchema schema = new Query(valueObject.getContext(),
				X_M_DiscountSchema.Table_Name,
				"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
				valueObject.getTransactionName())
				.setClient_ID()
				.first();
		salesPriceListVersion = new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
		salesPriceListVersion.setValidFrom(ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365));
		salesPriceListVersion.setAD_Org_ID(0);
		salesPriceListVersion.setName(ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365) + "; IsSOTrx=N; " +
				valueObject.getRandomNumber());
		salesPriceListVersion.setDescription(valueObject.getStepMessageLong());
		salesPriceListVersion.setM_PriceList_ID(firstPriceList.get_ID());
		salesPriceListVersion.setValidFrom(ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365));
		salesPriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
		salesPriceListVersion.saveEx();

		valueObject.setStepName("Create first prices");
		productSalesPrice = new MProductPrice(valueObject.getContext(), salesPriceListVersion.get_ID(),
				valueObject.getProduct().get_ID(), valueObject.getTransactionName());
		productSalesPrice.setPriceLimit(valueObject.getSalesLimitPrice());
		productSalesPrice.setPriceStd(valueObject.getSalesStandardPrice());
		productSalesPrice.setPriceList(valueObject.getSalesListPrice());
		productSalesPrice.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("fd5b6538-760c-4c8f-b943-115c1f3d2287");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			int nameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");

			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(nameColumnIndex) != null &&
									row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(nameColumnIndex).getStringCellValue().contains(product1.getName()))
					.collect(Collectors.toUnmodifiableList());

			assertEquals(1, productRows.size(), "Service only appears once");
		}
	}
}
