package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosisMapping;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodedDiagnosisDBService extends BaseDBService<CodedDiagnosis, MBHCodedDiagnosis> {

	public CodedDiagnosisDBService() {
	}

	public BaseListResponse<CodedDiagnosis> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		return super.getAll(null, null, pagingInfo, sortJson, filterJson);
	}

	@Override
	public CodedDiagnosis saveEntity(CodedDiagnosis entity) {
		MBHCodedDiagnosis mCodedDiagnosis = getEntityByUuidFromDB(entity.getUuid());
		if (mCodedDiagnosis == null) {
			mCodedDiagnosis = new MBHCodedDiagnosis(Env.getCtx(), 0, null);
			mCodedDiagnosis.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			mCodedDiagnosis.setBH_CodedDiagnosis_UU(entity.getUuid());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getCielName())) {
			mCodedDiagnosis.setBH_CielName(entity.getCielName());
		}

		if (entity.getCielId() > 0) {
			mCodedDiagnosis.setBH_CielId(entity.getCielId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getConceptClass())) {
			mCodedDiagnosis.setBH_ConceptClass(entity.getConceptClass());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getIcd10())) {
			mCodedDiagnosis.setBH_ICD10(entity.getIcd10());
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

		if (StringUtil.isNotNullAndEmpty(entity.getMoh705aLessthan5())) {
			mCodedDiagnosis.setBH_MoH705ALessThan5(entity.getMoh705aLessthan5());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getMoh705bGreaterThan5())) {
			mCodedDiagnosis.setBH_MoH705BGreaterThan5(entity.getMoh705bGreaterThan5());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getSearchTerms())) {
			mCodedDiagnosis.setBH_SearchTerms(entity.getSearchTerms());
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
		parameters.add("Y");
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);
		parameters.add(searchValueParameter);

		String searchClause = MBHCodedDiagnosis.COLUMNNAME_IsActive + " = ? AND ("
				+ MBHCodedDiagnosis.COLUMNNAME_BH_Coded_Diagnosis_ID + " IN (SELECT "
				+ MBHCodedDiagnosisMapping.COLUMNNAME_BH_Coded_Diagnosis_ID + " FROM "
				+ MBHCodedDiagnosisMapping.Table_Name + " WHERE " + MBHCodedDiagnosisMapping.COLUMNNAME_BH_ConceptCode
				+ " = ? OR LOWER(" + MBHCodedDiagnosisMapping.COLUMNNAME_BH_ConceptNameResolved + ") LIKE ? ) OR "
				+ "LOWER(" + MBHCodedDiagnosis.COLUMNNAME_BH_CielName + ") " + LIKE_COMPARATOR + " ? OR " + "LOWER("
				+ MBHCodedDiagnosis.COLUMNNAME_BH_ICD10 + ") " + LIKE_COMPARATOR + " ?  OR LOWER("
				+ MBHCodedDiagnosis.COLUMNNAME_BH_Synonyms + ") " + LIKE_COMPARATOR + " ? OR LOWER("
				+ MBHCodedDiagnosis.COLUMNNAME_BH_SEARCHTERMS + ") LIKE ? ";

		try {
			int cielId = Integer.valueOf(valueToSearch);
			searchClause += " OR " + MBHCodedDiagnosis.Table_Name + "." + MBHCodedDiagnosis.COLUMNNAME_BH_CielId
					+ " = ?";
			parameters.add(cielId);
		} catch (NumberFormatException ex) {
			// do nothing
		}

		searchClause += ")";

		return this.search(searchClause, parameters, pagingInfo, sortColumn, sortOrder, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected CodedDiagnosis createInstanceWithDefaultFields(MBHCodedDiagnosis instance) {
		return createInstanceWithAllFields(instance);
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
