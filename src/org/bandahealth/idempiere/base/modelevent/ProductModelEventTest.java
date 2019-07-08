package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;

import org.bandahealth.idempiere.base.MAttributeSetTemplate;
import org.bandahealth.idempiere.base.MProductPriceTemplate;
import org.bandahealth.idempiere.base.MProductTemplate;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.util.Env;

import test.AdempiereTestCase;

public class ProductModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		new MAttributeSetTemplate(getTrxName(), getCtx()).getInstance();
	}

	public void testProductHasExpiration() throws Exception {
		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx())).getInstance();

		assertEquals("Should have an expiration", true, product.isBH_HasExpiration());
		assertNotNull("Should have the bh expiration attribute set", product.getM_AttributeSet_ID());
	}

	public void testProductPrice() throws Exception {
		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx())).getInstance();

		assertEquals("Should have a buying price", 1, product.getBH_BuyPrice().compareTo(BigDecimal.ZERO));
		assertEquals("Should have a selling price", 1, product.getBH_SellPrice().compareTo(BigDecimal.ZERO));
		assertNotNull("Should have a product price",
				new MProductPriceTemplate(getTrxName(), getCtx(), product.get_ID()).getInstance());
	}
}
