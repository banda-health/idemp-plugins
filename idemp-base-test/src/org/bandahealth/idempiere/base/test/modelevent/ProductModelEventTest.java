package org.bandahealth.idempiere.base.test.modelevent;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
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
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create default price lists");
		BandaCreateEntity.createDefaultPriceLists(valueObject);
		commitEx();

		valueObject.setStepName("Create the product");
		MProduct_BH product = new MProduct_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		product.setAD_Org_ID(0);
		product.setDescription(valueObject.getStepMsgLong());
		product.setC_UOM_ID(MUOM.getDefault_UOM_ID(valueObject.getCtx()));
		product.setM_Product_Category_ID(BandaCreateEntity.getDefaultMProductCategoryID(valueObject));
		product.setC_TaxCategory_ID(BandaCreateEntity.getDefaultMTaxCategoryID(valueObject));
		product.setName(valueObject.getRandom() + valueObject.getScenarioName());
		product.setProductType(X_M_Product.PRODUCTTYPE_Item);
		product.setBH_BuyPrice(BigDecimal.TEN);
		product.setBH_SellPrice(BigDecimal.TEN.add(BigDecimal.TEN));
		product.saveEx();
		commitEx();

		assertEquals(1, product.getBH_BuyPrice().compareTo(BigDecimal.ZERO), "Should have a buying price");
		assertEquals(1, product.getBH_SellPrice().compareTo(BigDecimal.ZERO), "Should have a selling price");

		MProductPrice productPrice = new Query(valueObject.getCtx(), MProductPrice.Table_Name,
				MProductPrice.COLUMNNAME_M_Product_ID + "=? AND " + MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "=?",
				valueObject.get_trxName()).setParameters(product.get_ID(),
				valueObject.getPriceListSO().getPriceListVersion(new Timestamp(System.currentTimeMillis())).get_ID()).first();

		assertNotNull(productPrice, "Should have a product price");
	}
}
