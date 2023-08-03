package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Column;
import org.compiere.model.MColumn;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ColumnDBService extends BaseDBService<Column, MColumn> {

	@Override
	public Column saveEntity(Column entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Column createInstanceWithDefaultFields(MColumn instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Column createInstanceWithAllFields(MColumn instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MColumn getModelInstance() {
		return new MColumn(Env.getCtx(), 0, null);
	}

	@Override
	public List<Column> transformData(List<MColumn> dbModels) {
		return dbModels.stream().map(column -> {
			Column result = new Column(column);
			return result;
		}).collect(Collectors.toList());
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {
			{
				setShouldUseContextClientId(true);
				setShouldFetchFromSystemClient(true);
			}
		};
	}
}
