package org.bandahealth.idempiere.rest.repository;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class OrderLineRepository extends BaseRepository<MOrderLine_BH> {

	private final ProductRepository productRepository;
	private final ChargeRepository chargeRepository;

	public OrderLineRepository() {
		productRepository = new ProductRepository();
		chargeRepository = new ChargeRepository();
	}

	@Override
	protected MOrderLine_BH createModelInstance() {
		return new MOrderLine_BH(Env.getCtx(), 0, null);
	}

	public void deleteByOrder(int orderId, List<String> orderLineUuidsToKeep, Properties idempiereContext) {
		String whereClause = MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?";
		if (orderLineUuidsToKeep != null && !orderLineUuidsToKeep.isEmpty()) {
			whereClause += " AND " + MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + " NOT IN(" +
					orderLineUuidsToKeep.stream().map(orderLineUuidToKeep -> "'" + orderLineUuidToKeep + "'")
							.collect(Collectors.joining(",")) + ")";
		}

		List<MOrderLine_BH> orderLines = new Query(idempiereContext, MOrderLine_BH.Table_Name, whereClause, null)
				.setParameters(orderId).setClient_ID().list();
		orderLines.forEach(orderLine -> {
			orderLine.deleteEx(false);
		});
	}

	@Override
	public MOrderLine_BH mapInputModelToModel(MOrderLine_BH entity) {
		MOrderLine_BH orderLine = getByUuid(entity.getC_OrderLine_UU());
		if (orderLine == null) {
			orderLine = new MOrderLine_BH(Env.getCtx(), 0, null);
			orderLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
		}

		ModelUtil.setPropertyIfPresent(entity.getC_Order_ID(), orderLine::setC_Order_ID);

		if (entity.getC_Charge_ID() > 0) {
			MCharge_BH charge = chargeRepository.getById(entity.getC_Charge_ID());

			if (charge != null) {
				orderLine.setC_Charge_ID(entity.getC_Charge_ID());
			}
		}

		if (entity.getM_Product_ID() > 0) {
			MProduct_BH product = productRepository.getById(entity.getM_Product_ID());

			if (product != null) {
				orderLine.setM_Product_ID(product.getM_Product_ID());
			}
		}

		ModelUtil.setPropertyIfPresent(entity.getPriceActual(), orderLine::setPriceActual);
		ModelUtil.setPropertyIfPresent(entity.getQtyOrdered(), orderLine::setQtyOrdered);
		// only save for receive products
		ModelUtil.setPropertyIfPresent(entity.getLineNetAmt(), orderLine::setLineNetAmt);
		ModelUtil.setPropertyIfPresent(entity.getM_AttributeSetInstance_ID(), orderLine::setM_AttributeSetInstance_ID);
		ModelUtil.setPropertyIfPresent(entity.getBH_Expiration(), orderLine::setBH_Expiration);
		ModelUtil.setPropertyIfPresent(entity.getBH_Instructions(), orderLine::setBH_Instructions);
		ModelUtil.setPropertyIfPresent(entity.isActive(), orderLine::setIsActive);

		return orderLine;
	}
}
