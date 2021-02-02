package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
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
	@Path("/access")
	public Map<String, Map<String, List<String>>> getAccessMapByDocumentType() {
		return dataService.getValidActionMapByDocumentTypeAndReferenceList(dataService.getAccessByDocumentType()).entrySet()
				.stream().collect(Collectors.toMap(k -> k.getKey().getDocBaseType(),
						refListMap -> refListMap.getValue().entrySet().stream()
								.collect(Collectors.toMap(refList -> refList.getKey().getValue(), Map.Entry::getValue))));
	}
}
