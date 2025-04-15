package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.compiere.model.MRule;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_PayrollConcept;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_PayrollConceptResolver extends POResolver<X_HR_PayrollConcept> implements GraphQLResolver<X_HR_PayrollConcept> {



	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.DATALOADER_AD_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	public CompletableFuture<X_HR_Concept> HR_Concept(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ConceptDataLoader.DATALOADER_HR_Concept_BY_ID);
		return dataLoader.load(entity.getHR_Concept_ID());
	}


	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}

	public Boolean IsDisplayed(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		return entity.isDisplayed();
	}

	public Boolean IsInclude(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		return entity.isInclude();
	}

	public Boolean IsPrinted(X_HR_PayrollConcept entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

}
