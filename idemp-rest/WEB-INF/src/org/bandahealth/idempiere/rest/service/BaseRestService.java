package org.bandahealth.idempiere.rest.service;

import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.db.BaseDBService;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.lang.reflect.ParameterizedType;

/**
 * This is the base class for a rest service to extend from. Each child class should implement a {@link Path}
 * annotation to specify the base path that each of the method paths in this class will add to
 *
 * @param <RestModel>      The REST model to use in requests
 * @param <iDempiereModel> The iDempiere model this service interacts with
 * @param <DBService>      The DB Service that will interact with the DB on
 */
public abstract class BaseRestService<RestModel extends BaseMetadata, iDempiereModel extends PO,
		DBService extends BaseDBService<RestModel, iDempiereModel>> {
	protected final CLogger log;

	public BaseRestService() {
		Class<?> childClass =
				((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		log = CLogger.getCLogger(childClass);
	}

	/**
	 * This method should be implemented in an inheriting class to fetch the DB service specific to the entity
	 *
	 * @return the DB service to use in all requests
	 */
	protected abstract DBService getDBService();

	/**
	 * The base method to fetch all data in a paged format matching a specific filter and sort criteria
	 *
	 * @param page       The page to be fetched
	 * @param size       How many records can be on the page
	 * @param sortJson   Any sorting criteria, modeled after the form described in
	 *                   {@link org.bandahealth.idempiere.rest.utils.SortUtil}
	 * @param filterJson Any filter criteria, modeled after the form described in
	 *                   {@link org.bandahealth.idempiere.rest.utils.FilterUtil}
	 * @return A list of data matching the input information
	 */
	@GET
	public BaseListResponse<RestModel> get(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sorting") String sortJson, @QueryParam("filter") String filterJson) {
		return getDBService().getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	/**
	 * A specific call to fetch a single entity by its UUID
	 *
	 * @param uuid The entity's UUID
	 * @return An entity, if any was found
	 */
	@GET
	@Path("/{uuid}")
	public RestModel getByUuid(@PathParam("uuid") String uuid) {
		return getDBService().getEntity(uuid);
	}

	/**
	 * Save an entity
	 *
	 * @param entity The entity to save
	 * @return The saved entity
	 */
	@POST
	public RestModel save(RestModel entity) {
		return getDBService().saveEntity(entity);
	}

	@DELETE
	@Path("/{uuid}")
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		return getDBService().deleteEntity(uuid);
	}

	/**
	 * Convert requested page and size into a pagination object to be used in the DB service
	 *
	 * @param page The page to be fetched
	 * @param size How many records can be on the page
	 * @return A pagination object
	 */
	protected Paging getPagingInfo(int page, int size) {
		Paging paging = new Paging(page, size);
		if (!Paging.isValid(paging)) {
			paging = Paging.DEFAULT.getInstance();
		}

		return paging;
	}
}
