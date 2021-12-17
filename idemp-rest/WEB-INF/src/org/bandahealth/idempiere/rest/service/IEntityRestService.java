package org.bandahealth.idempiere.rest.service;

import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;

public interface IEntityRestService<T extends BaseMetadata> {

	public BaseListResponse<T> getAll(int page, int size, String sortJson, String filterJson);

	public BaseListResponse<T> search(String value, int page, int size, String sortColumn, String sortOrder);

	public T getEntity(String uuid);

	public T saveEntity(T entity);
}
