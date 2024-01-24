package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for BH_Coded_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Coded_DiagnosisResolver extends POResolver<MBHCodedDiagnosis> implements GraphQLResolver<MBHCodedDiagnosis> {


	public String bh_cielname(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_cielname();
	}

	public String bh_concept_class(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_concept_class();
	}

	public String bh_icd10who(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_icd10who();
	}

	public String bh_moh705a_lessthan5(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_moh705a_lessthan5();
	}

	public String bh_moh705b_greaterthan5(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_moh705b_greaterthan5();
	}

	public String bh_searchterms(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_searchterms();
	}

	public String bh_shortnames(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_shortnames();
	}

	public int bh_synomed_ct(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_synomed_ct();
	}

	public int bh_synomed_np(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_synomed_np();
	}

	public String bh_synonyms(MBHCodedDiagnosis entity, DataFetchingEnvironment environment) {
		return entity.getbh_synonyms();
	}

}
