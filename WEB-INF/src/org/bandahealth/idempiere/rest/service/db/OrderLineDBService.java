package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * OrderLine (product/service/charge) db service
 * 
 * @author andrew
 *
 */
public class OrderLineDBService extends BaseDBService<OrderLine, MOrderLine_BH> {

	private ProductDBService productDBService;

	public OrderLineDBService() {
		this.productDBService = new ProductDBService();
	}

	@Override
	public OrderLine saveEntity(OrderLine entity) {
		MOrderLine_BH mOrderLine = getEntityFromDB(entity.getUuid());
		if (mOrderLine == null) {
			mOrderLine = new MOrderLine_BH(Env.getCtx(), 0, null);
		}

		if (entity.getOrderId() > 0) {
			mOrderLine.setC_Order_ID(entity.getOrderId());
		}

		if (entity.getChargeId() > 0) {
			mOrderLine.setC_Charge_ID(entity.getChargeId());
		}

		if (entity.getProduct() != null) {
			MProduct_BH product = productDBService.getEntityFromDB(entity.getProduct().getUuid());

			if (product != null) {
				mOrderLine.setM_Product_ID(product.get_ID());
			}
		}

		if (entity.getPrice().compareTo(BigDecimal.ZERO) > 0) {
			mOrderLine.setPrice(entity.getPrice());
		}

		if (entity.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
			mOrderLine.setQty(entity.getQuantity());
		}

		mOrderLine.setIsActive(entity.isIsActive());
		mOrderLine.saveEx();

		return createInstanceWithAllFields(getEntityFromDB(mOrderLine.getC_OrderLine_UU()));
	}

	@Override
	protected OrderLine createInstanceWithDefaultFields(MOrderLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrderLine createInstanceWithAllFields(MOrderLine_BH instance) {
		try {

			MProduct product = productDBService.getProductByID(instance.getM_Product_ID());

			if (product == null) {
				return null;
			}

			return new OrderLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_OrderLine_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getC_Charge_ID(), instance.getC_Order_ID(),
					new Product(product.getName(), product.getM_Product_UU()), instance.getPriceActual(),
					instance.getQtyOrdered());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected OrderLine createInstanceWithSearchFields(MOrderLine_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MOrderLine_BH getModelInstance() {
		return new MOrderLine_BH(Env.getCtx(), 0, null);
	}

	public List<OrderLine> getOrderLinesByOrderId(int orderId) {
		List<OrderLine> orderLines = new ArrayList<>();

		List<MOrderLine_BH> mOrderLines = new Query(Env.getCtx(), MOrderLine_BH.Table_Name,
				MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?", null).setParameters(orderId).list();
		for (MOrderLine_BH mOrderLine : mOrderLines) {
			orderLines.add(createInstanceWithDefaultFields(mOrderLine));
		}

		return orderLines;
	}
}
