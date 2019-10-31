package org.bandahealth.idempiere.rest.service;

import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;

public interface IEntityRestService<T extends BaseMetadata> {

	public BaseListResponse<T> getAll(int page, int size);

	public T getEntity(String uuid);

	public T updateEntity(T entity);

	public T createEntity(T entity);
}
