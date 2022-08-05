package org.bandahealth.idempiere.base.test.modelevent;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MProductPrice;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_M_Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void pricesOnTheProductGetUpdatedOnThePriceLists() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create default price lists");
		ChuBoeCreateEntity.createDefaultPriceLists(valueObject);
		commitEx();

		valueObject.setStepName("Create the product");
		MProduct_BH product = new MProduct_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		product.setAD_Org_ID(0);
		product.setDescription(valueObject.getStepMessageLong());
		product.setC_UOM_ID(MUOM.getDefault_UOM_ID(valueObject.getContext()));
		product.setM_Product_Category_ID(ChuBoeCreateEntity.getDefaultProductCategoryId(valueObject));
		product.setC_TaxCategory_ID(ChuBoeCreateEntity.getDefaultTaxCategoryId(valueObject));
		product.setName(valueObject.getRandomNumber() + valueObject.getScenarioName());
		product.setProductType(X_M_Product.PRODUCTTYPE_Item);
		product.setBH_BuyPrice(BigDecimal.TEN);
		product.setBH_SellPrice(BigDecimal.TEN.add(BigDecimal.TEN));
		product.saveEx();
		commitEx();

		assertEquals(1, product.getBH_BuyPrice().compareTo(BigDecimal.ZERO), "Should have a buying price");
		assertEquals(1, product.getBH_SellPrice().compareTo(BigDecimal.ZERO), "Should have a selling price");

		MProductPrice productPrice = new Query(valueObject.getContext(), MProductPrice.Table_Name,
				MProductPrice.COLUMNNAME_M_Product_ID + "=? AND " + MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "=?",
				valueObject.getTransactionName()).setParameters(product.get_ID(),
				valueObject.getSalesPriceList().getPriceListVersion(new Timestamp(System.currentTimeMillis())).get_ID()).first();

		assertNotNull(productPrice, "Should have a product price");
	}
}
