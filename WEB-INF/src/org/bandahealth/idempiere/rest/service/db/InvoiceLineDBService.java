package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.model.InvoiceLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MCharge;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * InvoiceLine (product/service/charge) db service
 *
 */
public class InvoiceLineDBService extends BaseDBService<InvoiceLine, MInvoiceLine> {

	private ProductDBService productDBService;
	private ExpenseCategoryDBService expenseCategoryDBService;

	public InvoiceLineDBService() {
		this.productDBService = new ProductDBService();
		this.expenseCategoryDBService = new ExpenseCategoryDBService();
	}

	@Override
	public InvoiceLine saveEntity(InvoiceLine entity) {
		MInvoiceLine invoiceLine = getEntityByUuidFromDB(entity.getUuid());
		if (invoiceLine == null) {
			invoiceLine = new MInvoiceLine(Env.getCtx(), 0, null);
			invoiceLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
		}

		if (entity.getInvoiceId() != null) {
			invoiceLine.setC_Invoice_ID(entity.getInvoiceId());
		}

		if (entity.getExpenseCategory() != null) {
			MCharge charge = expenseCategoryDBService.getEntityByUuidFromDB(entity.getExpenseCategory().getUuid());

			if (charge != null) {
				invoiceLine.setC_Charge_ID(charge.get_ID());
			}
		}

		if (entity.getProduct() != null) {
			MProduct_BH product = productDBService.getEntityByUuidFromDB(entity.getProduct().getUuid());

			if (product != null) {
				invoiceLine.setM_Product_ID(product.get_ID());
			}
		}

		if (entity.getPrice() != null) {
			invoiceLine.setPrice(entity.getPrice());
		}

		if (entity.getQuantity() != null) {
			invoiceLine.setQty(entity.getQuantity());
		}

		if (entity.getLineNetAmount() != null) {
			invoiceLine.setLineNetAmt(entity.getLineNetAmount());
		}

		if (entity.getAttributeSetInstanceId() != null) {
			invoiceLine.setM_AttributeSetInstance_ID(entity.getAttributeSetInstanceId());
		}

		invoiceLine.setIsActive(entity.isIsActive());
		invoiceLine.setDescription(entity.getDescription());

		invoiceLine.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(invoiceLine.getC_InvoiceLine_UU()));
	}

	@Override
	protected InvoiceLine createInstanceWithDefaultFields(MInvoiceLine instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InvoiceLine createInstanceWithAllFields(MInvoiceLine instance) {
		try {
			MProduct product = productDBService.getProductByID(instance.getM_Product_ID());
			if (product != null) {
				return new InvoiceLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_InvoiceLine_UU(),
						instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
						instance.getC_Invoice_ID(),
						new Product(product.getName(), product.getM_Product_UU(), product.getProductType()),
						instance.getPriceActual(), instance.getQtyInvoiced(), instance.getLineNetAmt(), instance.getDescription());
			} else {
				// check charge
				MCharge_BH charge = expenseCategoryDBService.getEntityByIdFromDB(instance.getC_Charge_ID());
				if (charge != null) {
					ExpenseCategory expenseCategory = new ExpenseCategory(charge.getC_Charge_UU(), charge.getName(),
							charge.getBH_Locked(), charge.getC_ElementValue_ID());
					return new InvoiceLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
							instance.getC_InvoiceLine_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
							instance.getCreatedBy(), expenseCategory,
							instance.getC_Invoice_ID(), instance.getPriceActual(), instance.getQtyInvoiced(),
							instance.getLineNetAmt(), instance.getDescription());
				}
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected InvoiceLine createInstanceWithSearchFields(MInvoiceLine instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MInvoiceLine getModelInstance() {
		return new MInvoiceLine(Env.getCtx(), 0, null);
	}

	public List<InvoiceLine> getInvoiceLinesByInvoiceId(int invoiceId) {
		List<MInvoiceLine> invoiceLines = new Query(
				Env.getCtx(),
				MInvoiceLine.Table_Name,
				MInvoiceLine.COLUMNNAME_C_Invoice_ID + "=?",
				null
		)
				.setParameters(invoiceId)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.list();
		return invoiceLines.stream()
				.map(this::createInstanceWithDefaultFields)
				.collect(Collectors.toList());
	}

	/**
	 * Delete invoiceLines for a given order and not in given subset invoiceLines
	 * 
	 * @param invoiceId
	 */
	public void deleteInvoiceLinesByInvoice(int invoiceId, String invoiceLineUuids) {
		String whereClause = MInvoiceLine.COLUMNNAME_C_Invoice_ID + "=?";
		if (StringUtil.isNotNullAndEmpty(invoiceLineUuids)) {
			whereClause += " AND " + MInvoiceLine.COLUMNNAME_C_InvoiceLine_UU + " NOT IN(" + invoiceLineUuids + ")";
		}

		List<MInvoiceLine> invoiceLines = new Query(Env.getCtx(), MInvoiceLine.Table_Name, whereClause, null)
				.setParameters(invoiceId).setClient_ID().list();
		for (MInvoiceLine invoiceLine : invoiceLines) {
			invoiceLine.deleteEx(false);
		}
	}

	/**
	 * Check if an invoiceLine exists with the given invoice id
	 * 
	 * @param invoiceId
	 * @return
	 */
	public boolean checkInvoiceLinesExist(int invoiceId) {
		return new Query(Env.getCtx(), MInvoiceLine.Table_Name, MInvoiceLine.COLUMNNAME_C_Invoice_ID + " =?", null)
				.setParameters(invoiceId).setOnlyActiveRecords(true).setClient_ID().match();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
