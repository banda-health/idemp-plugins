package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.StorageOnHandRepository;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageOnHand;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.STORAGE_ON_HAND_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StorageOnHandRestService {

	private final StorageOnHandRepository storageOnHandRepository;

	public StorageOnHandRestService() {
		storageOnHandRepository = new StorageOnHandRepository();
	}

	@GET
	@Path("/products")
	public Map<Integer, List<MStorageOnHand>> getByClientIds(@QueryParam("ids") Set<Integer> productIds) {
		return storageOnHandRepository.getGroupsByIds(MStorageOnHand::getM_Product_ID,
				MStorageOnHand.COLUMNNAME_M_Product_ID, productIds);
	}
}
