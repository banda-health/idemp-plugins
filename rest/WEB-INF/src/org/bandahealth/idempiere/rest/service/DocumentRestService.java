package org.bandahealth.idempiere.rest.service;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.service.db.DocumentDBService;
import org.compiere.model.PO;
import org.compiere.process.DocAction;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * This class adds methods that endpoints of documents may need to call
 *
 * @param <RestModel>      The REST model to use in requests
 * @param <iDempiereModel> The iDempiere model this service interacts with
 * @param <DBService>      The DB Service that will interact with the DB on
 */
public abstract class DocumentRestService<RestModel extends BaseMetadata, iDempiereModel extends PO & DocAction,
		DBService extends DocumentDBService<RestModel, iDempiereModel>>
		extends BaseRestService<RestModel, iDempiereModel, DBService> {

	/**
	 * A process method to allow certain entities to be processed by iDempiere, such as completed or voided
	 *
	 * @param uuid           The UUID of the entity to process
	 * @param documentAction The process action to be executed
	 * @return The entity after it's been processed
	 * @throws Exception An error that occurred in processing
	 */
	@POST
	@Path("/{uuid}/process/{processType}")
	public RestModel process(@PathParam("uuid") String uuid, @PathParam("processType") String documentAction)
			throws Exception {
		return getDBService().processEntity(uuid, documentAction);
	}

	/**
	 * A sugar method to first save the entity to process, then process the entity
	 *
	 * @param entity         The entity to save and process
	 * @param documentAction The process action to be executed
	 * @return The saved and processed entity
	 * @throws Exception An error that occurred in processing
	 */
	@POST
	@Path("/process/{processType}")
	public RestModel saveAndProcess(RestModel entity, @PathParam("processType") String documentAction) throws Exception {
		return getDBService().saveAndProcessEntity(entity, documentAction);
	}
}
