package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Acct;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_Concept_AcctResolver extends POResolver<X_HR_Concept_Acct> implements GraphQLResolver<X_HR_Concept_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	public CompletableFuture<X_HR_Concept> HR_Concept(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ConceptDataLoader.DATALOADER_HR_Concept_BY_ID);
		return dataLoader.load(entity.getHR_Concept_ID());
	}


	/**
	 * Get Payroll Expense Account.
	 *
	 * @return Payroll Expense Account
	 */
	public CompletableFuture<MAccount> HR_Expense_A(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getHR_Expense_Acct());
	}


	/**
	 * Get Payroll Revenue Account.
	 *
	 * @return Payroll Revenue Account
	 */
	public CompletableFuture<MAccount> HR_Revenue_A(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getHR_Revenue_Acct());
	}

	public Boolean IsBalancing(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		return entity.isBalancing();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MAccount> User2(X_HR_Concept_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
