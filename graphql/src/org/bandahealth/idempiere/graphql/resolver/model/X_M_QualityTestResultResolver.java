package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_QualityTestDataLoader;
import org.compiere.model.MQualityTest;
import org.compiere.model.MQualityTestResult;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestResultResolver extends POResolver<MQualityTestResult> implements GraphQLResolver<MQualityTestResult> {


	public Boolean IsQCPass(MQualityTestResult entity, DataFetchingEnvironment environment) {
		return entity.isQCPass();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MQualityTestResult entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Quality Test.
	 *
	 * @return Quality Test
	 */
	public CompletableFuture<MQualityTest> M_QualityTest(MQualityTestResult entity, DataFetchingEnvironment environment) {
		if (entity.getM_QualityTest_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MQualityTest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_QualityTestDataLoader.DATALOADER_M_QualityTest_BY_ID);
		return dataLoader.load(entity.getM_QualityTest_ID());
	}

	public Boolean Processed(MQualityTestResult entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
