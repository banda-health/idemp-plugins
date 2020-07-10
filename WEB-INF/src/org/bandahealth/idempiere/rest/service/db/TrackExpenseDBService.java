package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.TrackExpense;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/**
 * Track Expenses logic
 * 
 * @author andrew
 *
 */
public class TrackExpenseDBService extends BaseInvoiceDBService<TrackExpense> {

	private VendorDBService vendorDBService;

	public TrackExpenseDBService() {
		this.vendorDBService = new VendorDBService();
	}

	public BaseListResponse<TrackExpense> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");
		parameters.add("Y");

		return super.getAll(MInvoice_BH.COLUMNNAME_IsSOTrx + "=? AND " + MInvoice_BH.COLUMNNAME_BH_IsExpense + "=?",
				parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public BaseListResponse<TrackExpense> search(String searchValue, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder()
				.append(MInvoice_BH.COLUMNNAME_IsSOTrx).append("=?").append(AND_OPERATOR)
				.append(MInvoice_BH.COLUMNNAME_BH_IsExpense).append("=?");
		parameters.add("N");
		parameters.add("Y");

		return super.search(searchValue, pagingInfo, sortColumn, sortOrder, whereClause.toString(), parameters);
	}

	@Override
	protected void beforeSave(TrackExpense entity, MInvoice_BH mOrder) {
		if (entity.getSupplier() != null && entity.getSupplier().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getSupplier().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setIsSOTrx(false);
		mOrder.setBH_IsExpense(true);
	}

	@Override
	protected void afterSave(TrackExpense entity, MInvoice_BH mOrder) {
	}

	@Override
	protected TrackExpense createInstanceWithDefaultFields(MInvoice_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing provider");
				return null;
			}

			return new TrackExpense(
					instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(), instance.isActive(),
					DateUtil.parse(instance.getCreated()), instance.getCreatedBy(), new Vendor(vendor.getName()),
					DateUtil.parseDateOnly(instance.getDateOrdered()), entityMetadataDBService
							.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()),
					instance.getGrandTotal());

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected TrackExpense createInstanceWithAllFields(MInvoice_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			return new TrackExpense(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Invoice_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Vendor(vendor.getName()), DateUtil.parseDateOnly(instance.getDateOrdered()),
					invoiceLineDBService.getInvoiceLinesByInvoiceId(instance.get_ID()), entityMetadataDBService
							.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()));

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected TrackExpense createInstanceWithSearchFields(MInvoice_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}
}
