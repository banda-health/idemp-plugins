package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosisMapping;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Coded_Diagnosis_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Coded_Diagnosis_MappingQuery extends POQuery<MBHCodedDiagnosisMapping> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHCodedDiagnosisMapping.Table_Name;
	}

	public Connection<MBHCodedDiagnosisMapping> BH_Coded_Diagnosis_MappingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
