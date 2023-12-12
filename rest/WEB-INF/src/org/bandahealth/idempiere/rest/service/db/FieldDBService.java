package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.Column;
import org.bandahealth.idempiere.rest.model.Field;
import org.bandahealth.idempiere.rest.model.FieldGroup;
import org.compiere.model.MField;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FieldDBService extends BaseDBService<Field, MField_BH> {

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
	protected Field createInstanceWithDefaultFields(MField_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Field createInstanceWithAllFields(MField_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MField_BH getModelInstance() {
		return new MField_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<Field> transformData(List<MField_BH> dbModels) {
		Map<Integer, Column> columnByFieldId = columnDBService.transformData(new ArrayList<>(
						columnDBService.getByIds(dbModels.stream().map(MField::getAD_Column_ID).collect(Collectors.toSet())).values()))
				.stream().collect(Collectors.toMap(Column::getId, column -> column));

		Map<Integer, FieldGroup> fieldGroupByFieldId = fieldGroupDBService.transformData(new ArrayList<>(
				fieldGroupDBService.getByIds(dbModels.stream().map(MField::getAD_FieldGroup_ID).collect(Collectors.toSet()))
						.values())).stream().collect(Collectors.toMap(FieldGroup::getId, fieldGroup -> fieldGroup));

		return dbModels.stream().map(field -> {

			Field result = new Field(field);
			if (columnByFieldId.containsKey(field.getAD_Column_ID())) {
				result.setColumn(columnByFieldId.get(field.getAD_Column_ID()));
			}

			if (fieldGroupByFieldId.containsKey(field.getAD_FieldGroup_ID())) {
				result.setFieldGroup(fieldGroupByFieldId.get(field.getAD_FieldGroup_ID()));
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

	@Override
	protected Map<String, Function<MField_BH, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {{
			put(MField_BH.COLUMNNAME_Name, entity -> entity::setName);
			put(MField_BH.COLUMNNAME_BH_Abbreviation, entity -> entity::setBH_Abbreviation);
		}};
	}
}
