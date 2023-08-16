package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.X_C_BPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Expenses logic
 *
 * @author andrew
 */
@Component
public class ExpenseDBService extends BaseInvoiceDBService<Expense> {

	private final Map<String, String> dynamicJoins = new HashMap<>() {{
		put(X_C_BPartner.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MInvoice_BH.Table_Name + "." +
				MInvoice_BH.COLUMNNAME_C_BPartner_ID + " = "
				+ MBPartner_BH.Table_Name + "." + MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

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
		parameters.add("N");

		return super.getAll(MInvoice_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortJson, filterJson, null);
	}

	@Override
	protected void beforeSave(Expense entity, MInvoice_BH invoice) {
		if (entity.getBusinessPartner() != null && entity.getBusinessPartner().getUuid() != null) {
			MBPartner_BH vendor = businessPartnerDBService.getEntityByUuidFromDB(entity.getBusinessPartner().getUuid());
			invoice.setC_BPartner_ID(vendor.get_ID());
		}

		invoice.setTotalLines(invoice.getGrandTotal());
		invoice.setIsSOTrx(false);
	}

	@Override
	protected void afterSave(Expense entity, MInvoice_BH invoice) {
	}

	@Override
	protected Expense createInstanceWithDefaultFields(MInvoice_BH instance) {
		try {
			MBPartner_BH businessPartner = businessPartnerDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (businessPartner == null) {
				log.severe("Missing provider");
				return null;
			}

			return new Expense(
					instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(), instance.isActive(),
					DateUtil.parse(instance.getCreated()), instance.getCreatedBy(), new BusinessPartner(businessPartner),
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
			MBPartner_BH businessPartner = businessPartnerDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (businessPartner == null) {
				log.severe("Missing businessPartner");
				return null;
			}

			return new Expense(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new BusinessPartner(businessPartner), DateUtil.parseDateOnly(instance.getDateInvoiced()),
					invoiceLineDBService.getInvoiceLinesByInvoiceId(instance.get_ID()), instance.getDocStatus(),
					instance.getGrandTotal(), instance.getPaymentRule());

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}
