package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Column;
import org.compiere.model.MColumn;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ColumnDBService extends BaseDBService<Column, MColumn> {

	@Autowired
	private ReferenceDBService referenceDBService;

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
		Map<Integer, MReference_BH> referenceByColumn = referenceDBService
				.getByIds(dbModels.stream().map(MColumn::getAD_Reference_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(column -> {
			Column result = new Column(column);
			if (referenceByColumn.containsKey(column.getAD_Reference_ID())) {
				result.setReference(referenceDBService
						.transformData(Collections.singletonList(referenceByColumn.get(column.getAD_Reference_ID())))
						.get(0));
			}
			return result;
		}).collect(Collectors.toList());
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {
			{
				setShouldUseContextClientId(false);
				setShouldFetchFromSystemClient(true);
			}
		};
	}
}
