package org.bandahealth.idempiere.rest.service;

import java.util.List;

import org.bandahealth.idempiere.rest.model.BaseMetadata;

public interface IEntityRestService<T extends BaseMetadata> {

	public List<T> getAll();

	public T getEntity(String uuid);

	public T updateEntity(T entity);

	public T createEntity(T entity);
}
