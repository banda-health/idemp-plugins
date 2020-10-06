package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/**
 * Expenses logic
 *
 * @author andrew
 */
public class ExpenseDBService extends BaseInvoiceDBService<Expense> {

	private VendorDBService vendorDBService;

	public ExpenseDBService() {
		this.vendorDBService = new VendorDBService();
	}

	public BaseListResponse<Expense> getAll(Paging pagingInfo, String sortColumn, String sortOrder, String filterJson) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder()
				.append(MInvoice_BH.COLUMNNAME_IsSOTrx).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_BH_IsExpense).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_DocStatus).append("!=?");
		parameters.add("N");
		parameters.add("Y");
		parameters.add(MInvoice_BH.DOCSTATUS_Reversed);

		String join = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name + "." +
				MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MInvoice_BH.Table_Name + "." + MInvoice_BH.COLUMNNAME_C_BPartner_ID;

		return super.getAll(whereClause.toString(), parameters, pagingInfo, sortColumn, sortOrder, filterJson, join);
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
					DateUtil.parseDateOnly(instance.getDateInvoiced()), entityMetadataDBService
					.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()),
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
					new Vendor(vendor.getName()), DateUtil.parseDateOnly(instance.getDateInvoiced()),
					invoiceLineDBService.getInvoiceLinesByInvoiceId(instance.get_ID()), entityMetadataDBService
					.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()),
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

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
