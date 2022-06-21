package org.bandahealth.idempiere.base.modelevent;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void pricesOnTheProductGetUpdatedOnThePriceLists() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create the business partner for price lists");
		ChuBoeCreateEntity.createBP(valueObject);
		commitEx();

		valueObject.setStepName("Create the product");
		MProduct_BH product = new MProduct_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		product.setAD_Org_ID(0);
		product.setDescription(valueObject.getStepMsgLong());
		product.setC_UOM_ID(MUOM.getDefault_UOM_ID(valueObject.getCtx()));
		product.setM_Product_Category_ID(ChuBoeCreateEntity.getDefaultMProductCategoryID(valueObject));
		product.setC_TaxCategory_ID(ChuBoeCreateEntity.getDefaultMTaxCategoryID(valueObject));
		product.setName(valueObject.getScenarioName());
		product.setProductType(X_M_Product.PRODUCTTYPE_Item);
		product.setBH_BuyPrice(BigDecimal.TEN);
		product.setBH_BuyPrice(BigDecimal.TEN.add(BigDecimal.TEN));
		product.saveEx();
		commitEx();

		assertEquals("Should have a buying price", 1, product.getBH_BuyPrice().compareTo(BigDecimal.ZERO));
		assertEquals("Should have a selling price", 1, product.getBH_SellPrice().compareTo(BigDecimal.ZERO));

		MProductPrice productPrice =
				new Query(valueObject.getCtx(), MProductPrice.Table_Name,
						MProductPrice.COLUMNNAME_M_Product_ID + "=? AND " + MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "+?",
						valueObject.get_trxName()).setParameters(valueObject.getProduct().get_ID(),
								valueObject.getPriceListSO().getPriceListVersion(new Timestamp(System.currentTimeMillis())).get_ID())
						.first();

		assertNotNull("Should have a product price", productPrice);
	}
}
