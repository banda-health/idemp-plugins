package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_QM_SpecificationLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_QM_SpecificationLineInput;
import org.eevolution.model.X_QM_SpecificationLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_QM_SpecificationLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationLineInput.Table_Name;
	}

	public X_QM_SpecificationLine QM_SpecificationLineSave(I_QM_SpecificationLineInput Entity, DataFetchingEnvironment environment) {
		return (X_QM_SpecificationLine) super.save((X_QM_SpecificationLineInput) Entity, environment);
	}

	public List<X_QM_SpecificationLine> QM_SpecificationLineSaveMany(List<I_QM_SpecificationLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_QM_SpecificationLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_QM_SpecificationLine) entity).collect(Collectors.toList());
	}

	public boolean QM_SpecificationLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
