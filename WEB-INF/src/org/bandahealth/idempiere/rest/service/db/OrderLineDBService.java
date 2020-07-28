package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MCharge;
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
	private ExpenseCategoryDBService expenseCategoryDBService;
	private AccountDBService accountDBService;

	public OrderLineDBService() {
		this.productDBService = new ProductDBService();
		this.expenseCategoryDBService = new ExpenseCategoryDBService();
		this.accountDBService = new AccountDBService();
	}

	@Override
	public OrderLine saveEntity(OrderLine entity) {
		MOrderLine_BH mOrderLine = getEntityByUuidFromDB(entity.getUuid());
		if (mOrderLine == null) {
			mOrderLine = new MOrderLine_BH(Env.getCtx(), 0, null);
			mOrderLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
		}

		if (entity.getOrderId() != null) {
			mOrderLine.setC_Order_ID(entity.getOrderId());
		}

		if (entity.getExpenseCategory() != null) {
			MCharge charge = expenseCategoryDBService.getEntityByUuidFromDB(entity.getExpenseCategory().getUuid());

			if (charge != null) {
				mOrderLine.setC_Charge_ID(charge.get_ID());
			}
		}

		if (entity.getProduct() != null) {
			MProduct_BH product = productDBService.getEntityByUuidFromDB(entity.getProduct().getUuid());

			if (product != null) {
				mOrderLine.setM_Product_ID(product.get_ID());
			}
		}

		if (entity.getPrice() != null) {
			mOrderLine.setPrice(entity.getPrice());
		}

		if (entity.getQuantity() != null) {
			mOrderLine.setQty(entity.getQuantity());
		}

		// only save for receive products
		if (entity.getLineNetAmount() != null) {
			mOrderLine.setLineNetAmt(entity.getLineNetAmount());
		}

		if (entity.getAttributeSetInstanceId() != null) {
			mOrderLine.setM_AttributeSetInstance_ID(entity.getAttributeSetInstanceId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getExpiration())) {
			mOrderLine.setBH_Expiration(DateUtil.getTimestamp(entity.getExpiration()));
		}

		mOrderLine.setIsActive(entity.isIsActive());

		mOrderLine.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mOrderLine.getC_OrderLine_UU()));
	}

	@Override
	protected OrderLine createInstanceWithDefaultFields(MOrderLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrderLine createInstanceWithAllFields(MOrderLine_BH instance) {
		try {
			MProduct product = productDBService.getProductByID(instance.getM_Product_ID());
			if (product != null) {
				return new OrderLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_OrderLine_UU(),
						instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
						instance.getC_Order_ID(),
						new Product(product.getName(), product.getM_Product_UU(), product.getProductType()),
						instance.getPriceActual(), instance.getQtyOrdered(), instance.getLineNetAmt(),
						DateUtil.parse(instance.getBH_Expiration()));
			} else {
				// check charge
				MCharge_BH charge = expenseCategoryDBService.getEntityByIdFromDB(instance.getC_Charge_ID());
				if (charge != null) {
					ExpenseCategory expenseCategory = new ExpenseCategory(charge.getC_Charge_UU(), charge.getName(),
							charge.getBH_Locked(), charge.getC_ElementValue_ID());
					return new OrderLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
							instance.getC_OrderLine_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
							instance.getCreatedBy(), expenseCategory,
							instance.getC_Order_ID(), instance.getPriceActual(), instance.getQtyOrdered(),
							instance.getLineNetAmt());
				}
			}
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
				MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?", null).setParameters(orderId).setOnlyActiveRecords(true)
						.setClient_ID().list();
		for (MOrderLine_BH mOrderLine : mOrderLines) {
			orderLines.add(createInstanceWithDefaultFields(mOrderLine));
		}

		return orderLines;
	}

	/**
	 * Delete orderlines for a given order and not in given subset orderlines
	 * 
	 * @param orderId
	 */
	public void deleteOrderLinesByOrder(int orderId, String orderLineUuids) {
		String whereClause = MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?";
		if (StringUtil.isNotNullAndEmpty(orderLineUuids)) {
			whereClause += " AND " + MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + " NOT IN(" + orderLineUuids + ")";
		}

		List<MOrderLine_BH> mOrderLines = new Query(Env.getCtx(), MOrderLine_BH.Table_Name, whereClause, null)
				.setParameters(orderId).setClient_ID().list();
		for (MOrderLine_BH mOrderLine : mOrderLines) {
			mOrderLine.deleteEx(false);
		}
	}

	/**
	 * Check if an orderline exists with the given order id
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean checkOrderLinesExist(int orderId) {
		return new Query(Env.getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_Order_ID + " =?", null)
				.setParameters(orderId).setOnlyActiveRecords(true).setClient_ID().match();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
