package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.X_C_BPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Expenses logic
 *
 * @author andrew
 */
@Component
public class ExpenseDBService extends BaseInvoiceDBService<Expense> {

	private Map<String, String> dynamicJoins = new HashMap<>() {{
		put(X_C_BPartner.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MInvoice_BH.Table_Name + "." +
				MInvoice_BH.COLUMNNAME_C_BPartner_ID + " = "
				+ MBPartner_BH.Table_Name + "." + MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	@Autowired
	private VendorDBService vendorDBService;

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_EXPENSES;
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	public BaseListResponse<Expense> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder()
				.append(MInvoice_BH.COLUMNNAME_IsSOTrx).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_BH_IsExpense).append("=?");
		parameters.add("N");
		parameters.add("Y");
		return super.getAll(whereClause.toString(), parameters, pagingInfo, sortJson, filterJson, null);
	}

	@Override
	public BaseListResponse<Expense> search(String searchValue, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder()
				.append(MInvoice_BH.COLUMNNAME_IsSOTrx).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_BH_IsExpense).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_DocStatus).append("!=?");
		parameters.add("N");
		parameters.add("Y");
		parameters.add(MInvoice_BH.DOCSTATUS_Reversed);

		return super.search(searchValue, pagingInfo, sortColumn, sortOrder, whereClause.toString(), parameters);
	}

	@Override
	protected void beforeSave(Expense entity, MInvoice_BH invoice) {
		if (entity.getSupplier() != null && entity.getSupplier().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getSupplier().getUuid());
			invoice.setC_BPartner_ID(vendor.get_ID());
		}

		invoice.setTotalLines(invoice.getGrandTotal());
		invoice.setIsSOTrx(false);
		invoice.setBH_IsExpense(true);
	}

	@Override
	protected void afterSave(Expense entity, MInvoice_BH invoice) {
	}

	@Override
	protected Expense createInstanceWithDefaultFields(MInvoice_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing provider");
				return null;
			}

			return new Expense(
					instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(), instance.isActive(),
					DateUtil.parse(instance.getCreated()), instance.getCreatedBy(), new Vendor(vendor.getName()),
					DateUtil.parseDateOnly(instance.getDateInvoiced()), instance.getDocStatus(),
					instance.getGrandTotal(), instance.getPaymentRule());

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected Expense createInstanceWithAllFields(MInvoice_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			return new Expense(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Vendor(vendor.getC_BPartner_UU(), vendor.getName()), DateUtil.parseDateOnly(instance.getDateInvoiced()),
					invoiceLineDBService.getInvoiceLinesByInvoiceId(instance.get_ID()), instance.getDocStatus(),
					instance.getGrandTotal(), instance.getPaymentRule());

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Expense createInstanceWithSearchFields(MInvoice_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}
}
