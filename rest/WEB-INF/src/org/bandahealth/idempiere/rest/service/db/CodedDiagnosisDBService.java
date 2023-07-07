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

	@Override
	public CodedDiagnosis saveEntity(CodedDiagnosis entity) {
		MBHCodedDiagnosis mCodedDiagnosis = getEntityByUuidFromDB(entity.getUuid());
		if (mCodedDiagnosis == null) {
			mCodedDiagnosis = new MBHCodedDiagnosis(Env.getCtx(), 0, null);
			mCodedDiagnosis.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			mCodedDiagnosis.setBH_Coded_Diagnosis_UU(entity.getUuid());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getCielName())) {
			mCodedDiagnosis.setbh_cielname(entity.getCielName());
		}

		if (entity.getCielId() > 0) {
			mCodedDiagnosis.setBH_CielID(entity.getCielId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getConceptClass())) {
			mCodedDiagnosis.setbh_concept_class(entity.getConceptClass());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getIcd10())) {
			mCodedDiagnosis.setbh_icd10who(entity.getIcd10());
		}

		if (entity.getSynomedCT() > 0) {
			mCodedDiagnosis.setbh_synomed_ct(entity.getSynomedCT());
		}

		if (entity.getSynomedNP() > 0) {
			mCodedDiagnosis.setbh_synomed_np(entity.getSynomedNP());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getSynonyms())) {
			mCodedDiagnosis.setbh_synonyms(entity.getSynonyms());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getMoh705aLessthan5())) {
			mCodedDiagnosis.setbh_moh705a_lessthan5(entity.getMoh705aLessthan5());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getMoh705bGreaterThan5())) {
			mCodedDiagnosis.setbh_moh705b_greaterthan5(entity.getMoh705bGreaterThan5());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getSearchTerms())) {
			mCodedDiagnosis.setbh_searchterms(entity.getSearchTerms());
		}

		mCodedDiagnosis.setIsActive(entity.getIsActive());

		mCodedDiagnosis.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mCodedDiagnosis.getBH_Coded_Diagnosis_UU()));
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
	protected MBHCodedDiagnosis getModelInstance() {
		return new MBHCodedDiagnosis(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
