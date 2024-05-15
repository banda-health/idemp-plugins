package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.X_AD_Attribute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttributeResolver extends POResolver<X_AD_Attribute> implements GraphQLResolver<X_AD_Attribute> {



	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}

	public Boolean IsEncrypted(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isEncrypted();
	}

	public Boolean IsFieldOnly(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isFieldOnly();
	}

	public Boolean IsHeading(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isHeading();
	}

	public Boolean IsMandatory(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}

	public Boolean IsReadOnly(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}

	public Boolean IsSameLine(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isSameLine();
	}

	public Boolean IsUpdateable(X_AD_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isUpdateable();
	}

}
