package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Language;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LanguageDBService extends BaseDBService<Language, MLanguage> {
	@Override
	public Language saveEntity(Language entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Language createInstanceWithDefaultFields(MLanguage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Language createInstanceWithAllFields(MLanguage instance) {
		return new Language(instance);
	}

	@Override
	protected Language createInstanceWithSearchFields(MLanguage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MLanguage getModelInstance() {
		return new MLanguage(Env.getCtx(), 0, null);
	}
}
