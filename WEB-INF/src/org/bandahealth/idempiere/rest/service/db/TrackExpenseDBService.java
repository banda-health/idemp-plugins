package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
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
public class TrackExpenseDBService extends BaseOrderDBService<TrackExpense> {

	private VendorDBService vendorDBService;

	public TrackExpenseDBService() {
		this.vendorDBService = new VendorDBService();
	}

	public BaseListResponse<TrackExpense> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");
		parameters.add("Y");

		String joinClause = null;
		if (sortColumn != null && sortColumn.contains(MBPartner_BH.Table_Name)) {
			joinClause = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name + "." +
					MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MOrder_BH.Table_Name + "." +
					MOrder_BH.COLUMNNAME_C_BPartner_ID;
		}

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_BH_IsExpense + "=?",
				parameters, pagingInfo, sortColumn, sortOrder, joinClause);
	}

	@Override
	protected void beforeSave(TrackExpense entity, MOrder_BH mOrder) {
		if (entity.getProvider() != null && entity.getProvider().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getProvider().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setIsSOTrx(false);
		mOrder.setBH_Isexpense(true);
	}

	@Override
	protected void afterSave(TrackExpense entity, MOrder_BH mOrder) {
	}

	@Override
	protected TrackExpense createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing provider");
				return null;
			}

			return new TrackExpense(
					instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(), instance.isActive(),
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
	protected TrackExpense createInstanceWithAllFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			return new TrackExpense(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Vendor(vendor.getName()), DateUtil.parseDateOnly(instance.getDateOrdered()),
					orderLineDBService.getOrderLinesByOrderId(instance.get_ID()), entityMetadataDBService
							.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()));

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected TrackExpense createInstanceWithSearchFields(MOrder_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}
}
