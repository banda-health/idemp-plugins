package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;

import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MAttributeSetTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.MProductPriceTemplate;
import org.bandahealth.idempiere.base.MProductTemplate;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MPriceList;
import org.compiere.util.Env;

public class ProductModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		new MAttributeSetTemplate(getTrxName(), getCtx()).getInstance();
	}

	public void testProductHasExpiration() throws Exception {
		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				"Test product expiration", null, null).getInstance();

		assertEquals("Should have an expiration", true, product.isBH_HasExpiration());
		assertNotNull("Should have the bh expiration attribute set", product.getM_AttributeSet_ID());
	}

	public void testProductPrice() throws Exception {
		MPriceList poPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), false, "Test Product Buy Price List").getInstance();
		MPriceList soPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), true, "Test Product Sales Price List").getInstance();

		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				"Test product price", soPriceList, poPriceList).getInstance();

		assertEquals("Should have a buying price", 1, product.getBH_BuyPrice().compareTo(BigDecimal.ZERO));
		assertEquals("Should have a selling price", 1, product.getBH_SellPrice().compareTo(BigDecimal.ZERO));
		assertNotNull("Should have a product price", new MProductPriceTemplate(getTrxName(), getCtx(), product.get_ID(),
				BigDecimal.ZERO, poPriceList.get_ID()).getInstance());
	}
}
