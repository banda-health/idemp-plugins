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

	private VendorDBService vendorDbService;

	public TrackExpenseDBService() {
		this.vendorDbService = new VendorDBService();
	}

	public BaseListResponse<TrackExpense> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");
		parameters.add("Y");

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_BH_IsExpense + "=?",
				parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	protected void populateExtraFields(TrackExpense entity, MOrder_BH mOrder) {
	}

	@Override
	protected TrackExpense createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDbService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
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
			MBPartner_BH vendor = vendorDbService.getEntityByIdFromDB(instance.getC_BPartner_ID());
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
