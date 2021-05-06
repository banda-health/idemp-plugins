package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.service.db.ReferenceListDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path(IRestConfigs.REFERENCE_LISTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReferenceListRestService {

	private final ReferenceListDBService dataService;

	public ReferenceListRestService() {
		dataService = new ReferenceListDBService();
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
										.collect(Collectors.toMap(refList -> refList.getKey().getValue(), Map.Entry::getValue))));
	}

	@GET
	@Path("/nonPatientPaymentSubTypes")
	public List<ReferenceList> getNonPatientPaymentSubTypes() {
		return dataService.getTypes(MReference_BH.NON_PATIENT_PAYMENT_AD_REFERENCE_UU, null).stream()
				.map(ReferenceList::new).collect(Collectors.toList());
	}

	@GET
	@Path("/chargeInfoDataTypes")
	public List<ReferenceList> getChargeInfoDataTypes() {
		return dataService.getTypes(MReference_BH.CHARGE_INFO_DATA_TYPE_AD_REFERENCE_UU, null).stream()
				.map(ReferenceList::new).collect(Collectors.toList());
	}
}
