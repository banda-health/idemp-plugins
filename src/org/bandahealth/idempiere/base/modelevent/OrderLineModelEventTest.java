package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.util.Calendar;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MAttributeSetTemplate;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MInOutTemplate;
import org.bandahealth.idempiere.base.MOrderLineTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.MProductTemplate;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MInOut;
import org.compiere.model.MPriceList;
import org.compiere.util.Env;

public class OrderLineModelEventTest extends AdempiereTestCase {

	private MOrder_BH order;
	private String PRODUCT_NAME = "Test Orderline Product";
	private MProduct_BH product;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());

		MPriceList poPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), false, "Test Orderline Buy Price List").getInstance();
		MPriceList soPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), true, "Test Orderline Sales Price List").getInstance();

		int bPartner = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				"Test Vendor 1", true, 0, soPriceList.get_ID(), poPriceList.get_ID(), true).getInstance().get_ID();

		order = new MOrderTemplate(getTrxName(), getCtx(), false, Env.getAD_Client_ID(getCtx()), poPriceList.get_ID(),
				bPartner).getInstance();
		new MAttributeSetTemplate(getTrxName(), getCtx()).getInstance();

		product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), PRODUCT_NAME, soPriceList,
				poPriceList).getInstance();
	}

	public void testReceiveProductHasExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));
		orderLine.saveEx();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertNotNull("Attribute Set instance should not be null", orderLine.getM_AttributeSetInstance_ID());
	}

	public void testReceiveProductHasNoExpiration() throws Exception {
		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();
		orderLine.saveEx();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertNull("Expiration date should be null", orderLine.getBH_Expiration());
	}

	public void testReceiveProductInvalidExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);

		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));

		try {
			orderLine.saveEx();
		} catch (AdempiereException ex) {
			return;
		}

		fail("Expiration should be a future date");
	}

	public void testCreateMaterialReceipt() throws Exception {
		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();

		assertNotNull("Receive Product Order Line should not be null", orderLine);

		order.setDocAction(MOrder_BH.DOCACTION_Complete);
		String status = order.completeIt();
		assertEquals("Should process order successfully", MOrder_BH.DOCACTION_Complete, status);

		MInOut inOut = new MInOutTemplate(getTrxName(), getCtx(), order.get_ID()).getInstance();
		assertNotNull("MInOut should not be null", inOut);

		assertEquals(MInOut.MOVEMENTTYPE_VendorReceipts, inOut.getMovementType());
		assertEquals("CO", inOut.getDocStatus());
	}
}