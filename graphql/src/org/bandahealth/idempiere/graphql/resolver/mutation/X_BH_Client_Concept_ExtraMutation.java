package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Client_Concept_ExtraInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Client_Concept_ExtraInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Client_Concept_ExtraMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Client_Concept_ExtraInput.Table_Name;
	}

	public MBHClientConceptExtra BH_Client_Concept_ExtraSave(I_BH_Client_Concept_ExtraInput Entity, DataFetchingEnvironment environment) {
		return (MBHClientConceptExtra) super.save((X_BH_Client_Concept_ExtraInput) Entity, environment);
	}

	public List<MBHClientConceptExtra> BH_Client_Concept_ExtraSaveMany(List<I_BH_Client_Concept_ExtraInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Client_Concept_ExtraInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHClientConceptExtra) entity).collect(Collectors.toList());
	}

	public boolean BH_Client_Concept_ExtraDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
