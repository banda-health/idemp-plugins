package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.repository.ReferenceListRepository;
import org.bandahealth.idempiere.rest.service.db.ReferenceListDBService;
import org.compiere.model.MRefList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Path(IRestConfigs.REFERENCE_LISTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReferenceListRestService {

	private static ReferenceListRepository referenceListRepository;
	private final ReferenceListDBService dataService;

	public ReferenceListRestService() {
		referenceListRepository = new ReferenceListRepository();
		dataService = new ReferenceListDBService();
	}

	@GET
	@Path("/orderpaymenttypes")
	public Map<String, MRefList> getOrderPaymentType(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getOrderPaymentType(referenceListValues);
	}

	@GET
	@Path("/patienttypes")
	public Map<String, MRefList> getPatientType(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getPatientType(referenceListValues);
	}

	@GET
	@Path("/referrals")
	public Map<String, MRefList> getReferral(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getReferral(referenceListValues);
	}

	@GET
	@Path("/invoicepaymenttypes")
	public Map<String, MRefList> getInvoicePaymentType(
			@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getInvoicePaymentType(referenceListValues);
	}

	@GET
	@Path("/nhiftypes")
	public Map<String, MRefList> getNhifType(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getNhifType(referenceListValues);
	}

	@GET
	@Path("/nhifrelationships")
	public Map<String, MRefList> getNhifRelationship(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getNhifRelationship(referenceListValues);
	}

	@GET
	@Path("/documentstatuses")
	public Map<String, MRefList> getDocumentStatus(@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getDocumentStatus(referenceListValues);
	}

	@GET
	@Path("/productcategorytypes")
	public Map<String, MRefList> getProductCategoryType(
			@QueryParam("referenceListValues") Set<String> referenceListValues) {
		return referenceListRepository.getProductCategoryType(referenceListValues);
	}

	@GET
	@Path("/{uuid}")
	public MRefList getByUuid(@PathParam("uuid") String uuid) {
		return referenceListRepository.getByUuid(uuid);
	}

	@GET
	@Path("/references")
	public Map<Integer, List<MRefList>> getByReferenceIds(@QueryParam("ids") Set<Integer> ids) {
		return referenceListRepository
				.getGroupsByIds(MRefList::getAD_Reference_ID, MRefList.COLUMNNAME_AD_Reference_ID, ids);
	}

	@GET
	@Path("/documentActionAccess")
	public Map<String, List<ReferenceList>> getDocumentActionAccessByDocumentType() {
		return dataService.getDocumentActionAccessByDocumentType().entrySet()
				.stream().collect(Collectors.toMap(
						documentActionAccessByDocumentTypeEntry -> documentActionAccessByDocumentTypeEntry.getKey()
								.getDocBaseType(),
						documentActionAccessByDocumentTypeEntry -> documentActionAccessByDocumentTypeEntry.getValue().stream()
								.map(ReferenceList::new).collect(Collectors.toList())));
	}

	@GET
	@Path("/documentStatusActionMap")
	public Map<String, Map<String, List<String>>> getDocumentStatusActionMap() {
		return dataService.getDocumentStatusActionMap().entrySet()
				.stream().collect(
						Collectors.toMap(documentStatusActionMapEntry -> documentStatusActionMapEntry.getKey().getDocBaseType(),
								documentStatusActionMapEntry -> documentStatusActionMapEntry.getValue().entrySet().stream()
										.collect(Collectors.toMap(refList -> refList.getKey().getValue(), Map.Entry::getValue)),
								(existingStatusActionMap, newStatusActionMap) -> {
									// This is what happens when there's a merge
									newStatusActionMap.forEach((newDocumentStatus, newActionList) -> {
										// If the document status doesn't exist already, so add it and move on
										if (!existingStatusActionMap.containsKey(newDocumentStatus)) {
											existingStatusActionMap.put(newDocumentStatus, newActionList);
											return;
										}
										// The document type does exist, so we need to merge action lists
										List<String> existingActionList = existingStatusActionMap.get(newDocumentStatus);
										existingActionList.addAll(newActionList);
										existingStatusActionMap.replace(newDocumentStatus,
												existingActionList.stream().distinct().collect(Collectors.toList()));
									});
									return existingStatusActionMap;
								}));
	}

	@GET
	@Path("/nonPatientPaymentSubTypes")
	public List<ReferenceList> getNonPatientPaymentSubTypes() {
		return dataService.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU, null).stream()
				.map(ReferenceList::new).collect(Collectors.toList());
	}

	@GET
	@Path("/chargeInformationDataTypes")
	public List<ReferenceList> getChargeInformationDataTypes() {
		return dataService.getTypes(MReference_BH.CHARGE_INFORMATION_DATA_TYPE_AD_REFERENCE_UU, null).stream()
				.map(ReferenceList::new).collect(Collectors.toList());
	}
}
