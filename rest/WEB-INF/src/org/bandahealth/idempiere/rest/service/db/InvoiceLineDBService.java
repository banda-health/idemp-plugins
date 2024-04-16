package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartnerSpecificPayerInformation;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.InvoiceLine;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * InvoiceLine (product/service/charge) db service
 */
public class InvoiceLineDBService extends BaseDBService<InvoiceLine, MInvoiceLine> {

	private final ProductDBService productDBService = new ProductDBService();
	private final AccountDBService accountDBService = new AccountDBService();
	private final ChargeDBService chargeDBService = new ChargeDBService();
	private final OrderLineDBService orderLineDBService = new OrderLineDBService();
	private final BusinessPartnerSpecificPayerInformationDBService businessPartnerSpecificPayerInformationDBService =
			new BusinessPartnerSpecificPayerInformationDBService();
	private final PayerInformationFieldDBService payerInformationFieldDBService = new PayerInformationFieldDBService();

	@Override
	public InvoiceLine saveEntity(InvoiceLine entity) {
		return createInstanceWithAllFields(getEntityByUuidFromDB(saveOnlyWithoutChildDataFetch(entity).getUuid()));
	}

	/**
	 * This method is implemented to speed up processing by avoiding an unnecessary data fetch.
	 * TODO: Remove this when we have GraphQL
	 *
	 * @param entity The invoice line to save
	 * @return A somewhat updated invoice line (has the new UUID & ID on it for other use)
	 */
	public InvoiceLine saveOnlyWithoutChildDataFetch(InvoiceLine entity) {
		MInvoiceLine invoiceLine = getEntityByUuidFromDB(entity.getUuid());
		if (invoiceLine == null) {
			invoiceLine = new MInvoiceLine(Env.getCtx(), 0, null);
			invoiceLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
		}

		if (entity.getInvoiceId() != null) {
			invoiceLine.setC_Invoice_ID(entity.getInvoiceId());
		}

		if (entity.getOrderLineId() > 0) {
			invoiceLine.setOrderLine(orderLineDBService.getEntityByIdFromDB(entity.getOrderLineId()));
		} else if (entity.getOrderLine() != null && !StringUtil.isNullOrEmpty(entity.getOrderLine().getUuid())) {
			invoiceLine.setOrderLine(orderLineDBService.getEntityByUuidFromDB(entity.getOrderLine().getUuid()));
		}

		if (entity.getCharge() != null && !StringUtil.isNullOrEmpty(entity.getCharge().getUuid())) {
			MCharge_BH charge = chargeDBService.getEntityByUuidFromDB(entity.getCharge().getUuid());
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

		// All invoice lines need at least a charge or product, so error if nothing is
		// there
		if (invoiceLine.getC_Charge_ID() == 0 && invoiceLine.getM_Product_ID() == 0) {
			throw new AdempiereException("Invoice Line missing a charge or product");
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

		invoiceLine.setIsActive(entity.getIsActive());
		invoiceLine.setDescription(entity.getDescription());

		invoiceLine.saveEx();
		entity.setId(invoiceLine.get_ID());

		// If there is any information to save with this line, save it
		if (entity.getBusinessPartnerSpecificPayerInformationList() != null) {
			entity.setBusinessPartnerSpecificPayerInformationList(
					entity.getBusinessPartnerSpecificPayerInformationList().stream().map(
							businessPartnerSpecificPayerInformation -> {
								businessPartnerSpecificPayerInformation.setInvoiceLineId(entity.getId());
								return businessPartnerSpecificPayerInformationDBService.saveEntity(
										businessPartnerSpecificPayerInformation);
							}).collect(Collectors.toList()));
		} else {
			entity.setBusinessPartnerSpecificPayerInformationList(new ArrayList<>());
		}
		// Delete what is no longer there
		List<MBHBPSpecificPayerInfo> businessPartnerSpecificPayerInformationList =
				businessPartnerSpecificPayerInformationDBService.getGroupsByIds(MBHBPSpecificPayerInfo::getC_InvoiceLine_ID,
								MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID, Collections.singleton(entity.getId()))
						.get(entity.getId());
		if (businessPartnerSpecificPayerInformationList != null) {
			businessPartnerSpecificPayerInformationList.stream()
					.filter(
							existingBusinessPartnerSpecificPayerInformation -> entity.getBusinessPartnerSpecificPayerInformationList()
									.stream()
									.noneMatch(
											newBusinessPartnerSpecificPayerInformation -> newBusinessPartnerSpecificPayerInformation.getUuid()
													.equals(existingBusinessPartnerSpecificPayerInformation.getBH_BP_Specific_Payer_Info_UU())))
					.forEach(orderLineChargeInformation -> businessPartnerSpecificPayerInformationDBService
							.deleteEntity(orderLineChargeInformation.getBH_BP_Specific_Payer_Info_UU()));
		}

		return new InvoiceLine(invoiceLine);
	}

	@Override
	protected InvoiceLine createInstanceWithDefaultFields(MInvoiceLine instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InvoiceLine createInstanceWithAllFields(MInvoiceLine instance) {
		try {
			MProduct_BH product = productDBService.getEntityByIdFromDB(instance.getM_Product_ID());
			InvoiceLine invoiceLine = new InvoiceLine(instance);
			if (product != null) {
				invoiceLine.setProduct(new Product(product));
			}
			return invoiceLine;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<InvoiceLine> transformData(List<MInvoiceLine> dbModels) {
		// Batch call to get products
		Set<Integer> productIds = dbModels.stream().map(MInvoiceLine::getM_Product_ID).collect(Collectors.toSet());
		Map<Integer, MProduct_BH> products = productDBService.getByIds(productIds);

		// Batch call to get charges
		Set<Integer> chargeIds = dbModels.stream().map(MInvoiceLine::getC_Charge_ID).collect(Collectors.toSet());
		Map<Integer, Charge> chargesById =
				chargeDBService.transformData(new ArrayList<>(chargeDBService.getByIds(chargeIds).values())).stream()
						.collect(Collectors.toMap(Charge::getId, charge -> charge));

		// Batch call to get any order lines
		Map<Integer, MOrderLine_BH> orderLinesById = orderLineDBService.getByIds(
				dbModels.stream().map(MInvoiceLine::getC_OrderLine_ID).filter(orderLineId -> orderLineId > 0)
						.collect(Collectors.toSet()));

		// Batch call for insurance and donor payer information
		Set<Integer> invoiceLineIds = dbModels.stream().map(MInvoiceLine::get_ID).collect(Collectors.toSet());
		Map<Integer, List<MBHBPSpecificPayerInfo>> businessPartnerSpecificPayerInformationByInvoiceLineId =
				businessPartnerSpecificPayerInformationDBService
						.getGroupsByIds(MBHBPSpecificPayerInfo::getC_InvoiceLine_ID,
								MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID, invoiceLineIds);
		Map<Integer, MBHPayerInfoFld> payerInformationFieldsById = payerInformationFieldDBService.getByIds(
				businessPartnerSpecificPayerInformationByInvoiceLineId.values().stream().flatMap(
						businessPartnerSpecificPayerInformation -> businessPartnerSpecificPayerInformation.stream()
								.map(MBHBPSpecificPayerInfo::getBH_Payer_Info_Fld_ID)).collect(Collectors.toSet()));

		return dbModels.stream().map(invoiceLine -> {
			InvoiceLine result = new InvoiceLine(invoiceLine);

			if (products.containsKey(invoiceLine.getC_Invoice_ID())) {
				result.setProduct(new Product(products.get(invoiceLine.getC_Invoice_ID())));
			}
			if (orderLinesById.containsKey(invoiceLine.getC_OrderLine_ID())) {
				result.setOrderLine(new OrderLine(orderLinesById.get(invoiceLine.getC_OrderLine_ID())));
			}

			if (chargesById.containsKey(invoiceLine.getC_Charge_ID())) {
				result.setCharge(chargesById.get(invoiceLine.getC_Charge_ID()));
			}
			if (businessPartnerSpecificPayerInformationByInvoiceLineId.containsKey(result.getId())) {
				result.setBusinessPartnerSpecificPayerInformationList(
						businessPartnerSpecificPayerInformationByInvoiceLineId.get(result.getId()).stream()
								.map(BusinessPartnerSpecificPayerInformation::new).peek(
										businessPartnerSpecificPayerInformation -> businessPartnerSpecificPayerInformation.setPayerInformationFieldUuid(
												payerInformationFieldsById.get(businessPartnerSpecificPayerInformation.getPayerInformationFieldId())
														.getBH_Payer_Info_Fld_UU())).collect(Collectors.toList()));
			}

			return result;

		}).collect(Collectors.toList());
	}

	@Override
	protected MInvoiceLine getModelInstance() {
		return new MInvoiceLine(Env.getCtx(), 0, null);
	}

	public List<InvoiceLine> getInvoiceLinesByInvoiceId(int invoiceId) {
		List<MInvoiceLine> invoiceLines = new Query(Env.getCtx(), MInvoiceLine.Table_Name,
				MInvoiceLine.COLUMNNAME_C_Invoice_ID + "=?", null).setParameters(invoiceId).setOnlyActiveRecords(true)
				.setClient_ID().list();
		return invoiceLines.stream().map(this::createInstanceWithDefaultFields).collect(Collectors.toList());
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

		// Get the associated order line charge information and delete it
		Set<Integer> invoiceLineIds = invoiceLines.stream().map(MInvoiceLine::getC_InvoiceLine_ID)
				.collect(Collectors.toSet());
		boolean wereChildrenDeletesSuccessful = businessPartnerSpecificPayerInformationDBService
				.getGroupsByIds(MBHBPSpecificPayerInfo::getC_InvoiceLine_ID,
						MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID, invoiceLineIds)
				.values().stream().flatMap(Collection::stream)
				.allMatch(businessPartnerChargeInformation -> businessPartnerSpecificPayerInformationDBService
						.deleteEntity(businessPartnerChargeInformation.getBH_BP_Specific_Payer_Info_UU()));
		if (!wereChildrenDeletesSuccessful) {
			throw new AdempiereException("There was an error deleting information");
		}

		for (MInvoiceLine invoiceLine : invoiceLines) {
			invoiceLine.deleteEx(false);
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
