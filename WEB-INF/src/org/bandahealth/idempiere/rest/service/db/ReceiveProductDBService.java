package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/**
 * Receive products logic
 * 
 * @author andrew
 *
 */
public class ReceiveProductDBService extends BaseOrderDBService<ReceiveProduct> {

	private VendorDBService vendorDBService;

	public ReceiveProductDBService() {
		this.vendorDBService = new VendorDBService();
	}

	public BaseListResponse<ReceiveProduct> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	protected void populateExtraFields(ReceiveProduct entity, MOrder_BH mOrder) {
		if (entity.getVendor() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getVendor().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setIsSOTrx(false);
	}

	@Override
	protected ReceiveProduct createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			return new ReceiveProduct(
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
	protected ReceiveProduct createInstanceWithAllFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			return new ReceiveProduct(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
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
	protected ReceiveProduct createInstanceWithSearchFields(MOrder_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}
}
