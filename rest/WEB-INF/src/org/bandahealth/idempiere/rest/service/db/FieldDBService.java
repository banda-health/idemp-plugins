package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MFieldGroup;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Column;
import org.bandahealth.idempiere.rest.model.Field;
import org.bandahealth.idempiere.rest.model.FieldGroup;
import org.compiere.model.MColumn;
import org.compiere.model.MField;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldDBService extends BaseDBService<Field, MField> {

	@Autowired
	private ColumnDBService columnDBService;

	@Autowired
	private FieldGroupDBService fieldGroupDBService;

	@Override
	public Field saveEntity(Field entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Field createInstanceWithDefaultFields(MField instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Field createInstanceWithAllFields(MField instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MField getModelInstance() {
		return new MField(Env.getCtx(), 0, null);
	}

	@Override
	public List<Field> transformData(List<MField> dbModels) {
		Map<Integer, MColumn> columnByFieldId = columnDBService
				.getByIds(dbModels.stream().map(MField::getAD_Column_ID).collect(Collectors.toSet()));

		Map<Integer, MFieldGroup> fieldGroupByFieldId = fieldGroupDBService
				.getByIds(dbModels.stream().map(MField::getAD_FieldGroup_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(field -> {

			Field result = new Field(field);
			if (columnByFieldId.containsKey(field.getAD_Column_ID())) {
				result.setColumn(columnDBService
						.transformData(Collections.singletonList(columnByFieldId.get(field.getAD_Column_ID()))).get(0));
			}

			if (fieldGroupByFieldId.containsKey(field.getAD_FieldGroup_ID())) {
				result.setFieldGroup(fieldGroupDBService
						.transformData(Collections.singletonList(fieldGroupByFieldId.get(field.getAD_FieldGroup_ID())))
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
