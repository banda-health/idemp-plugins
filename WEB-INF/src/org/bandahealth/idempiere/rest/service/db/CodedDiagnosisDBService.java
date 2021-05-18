package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class CodedDiagnosisDBService extends BaseDBService<CodedDiagnosis, MBHCodedDiagnosis> {

	public CodedDiagnosisDBService() {
	}

	public BaseListResponse<CodedDiagnosis> getAll(Paging pagingInfo, String sortColumn, String sortOrder,
			String filterJson) {
		return super.getAll(null, null, pagingInfo, sortColumn, sortOrder, filterJson);
	}

	@Override
	public CodedDiagnosis saveEntity(CodedDiagnosis entity) {
		MBHCodedDiagnosis mCodedDiagnosis = getEntityByUuidFromDB(entity.getUuid());
		if (mCodedDiagnosis == null) {
			mCodedDiagnosis = new MBHCodedDiagnosis(Env.getCtx(), 0, null);
			mCodedDiagnosis.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
		}

		if (StringUtil.isNotNullAndEmpty(entity.getCeilName())) {
			mCodedDiagnosis.setBH_CeilName(entity.getCeilName());
		}

		if (entity.getCeilId() > 0) {
			mCodedDiagnosis.setBH_CeilId(entity.getCeilId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getConceptClass())) {
			mCodedDiagnosis.setBH_ConceptClass(entity.getConceptClass());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getIcd10())) {
			mCodedDiagnosis.setBH_ICD10(entity.getIcd10());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getSearchTerms())) {
			mCodedDiagnosis.setBH_SearchTerms(entity.getSearchTerms());
		}

		if (entity.getSynomedCT() > 0) {
			mCodedDiagnosis.setBH_SynomedCT(entity.getSynomedCT());
		}

		if (entity.getSynomedNP() > 0) {
			mCodedDiagnosis.setBH_SynomedNP(entity.getSynomedNP());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getSynonyms())) {
			mCodedDiagnosis.setBH_Synonyms(entity.getSynonyms());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getShortNames())) {
			mCodedDiagnosis.setBH_ShortNames(entity.getShortNames());
		}
		
		if (StringUtil.isNotNullAndEmpty(entity.getMoh705aLessthan5())) {
			mCodedDiagnosis.setBH_MoH705ALessThan5(entity.getMoh705aLessthan5());
		}
		
		if (StringUtil.isNotNullAndEmpty(entity.getMoh705bGreaterthan5())) {
			mCodedDiagnosis.setBH_MoH705BGreaterThan5(entity.getMoh705bGreaterthan5());
		}

		mCodedDiagnosis.setIsActive(entity.getIsActive());

		mCodedDiagnosis.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mCodedDiagnosis.getBH_CodedDiagnosis_UU()));
	}

	@Override
	public BaseListResponse<CodedDiagnosis> search(String valueToSearch, Paging pagingInfo, String sortColumn,
			String sortOrder) {
		String searchValueParameter = constructSearchValue(valueToSearch);

		List<Object> parameters = new ArrayList<>();
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);

		String searchClause = "LOWER(" + MBHCodedDiagnosis.COLUMNNAME_BH_CeilName + ") " + LIKE_COMPARATOR + " ? OR "
				+ "LOWER(" + MBHCodedDiagnosis.COLUMNNAME_BH_ICD10 + ") " + LIKE_COMPARATOR + " ?  OR LOWER("
				+ MBHCodedDiagnosis.COLUMNNAME_BH_Synonyms + ") " + LIKE_COMPARATOR + " ? ";

		return this.search(searchClause, parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected CodedDiagnosis createInstanceWithDefaultFields(MBHCodedDiagnosis instance) {
		return new CodedDiagnosis(instance.getBH_CodedDiagnosis_UU(), instance.getBH_CeilName(),
				instance.getBH_ConceptClass(), instance.getDescription());
	}

	@Override
	protected CodedDiagnosis createInstanceWithAllFields(MBHCodedDiagnosis instance) {
		return new CodedDiagnosis(instance);
	}

	@Override
	protected CodedDiagnosis createInstanceWithSearchFields(MBHCodedDiagnosis instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHCodedDiagnosis getModelInstance() {
		return new MBHCodedDiagnosis(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
