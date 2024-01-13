package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProductCostCalculationDataLoader;
import org.bandahealth.idempiere.graphql.model.ProductCostCalculation;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAttributeSetInstanceResolver extends X_M_AttributeSetInstanceResolver {
	public CompletableFuture<Timestamp> PurchaseDate(MAttributeSetInstance_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<ProductCostCalculation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(ProductCostCalculationDataLoader.DATALOADER_ProductCostCalculation_BY_AttributeSetInstance_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_AttributeSetInstance_ID()))
				.thenApply(this::getMostRecentCost).thenApply(ProductCostCalculation::getPurchaseDate);
	}

	public CompletableFuture<BigDecimal> PurchasePrice(MAttributeSetInstance_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<ProductCostCalculation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(ProductCostCalculationDataLoader.DATALOADER_ProductCostCalculation_BY_AttributeSetInstance_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_AttributeSetInstance_ID()))
				.thenApply(this::getMostRecentCost).thenApply(ProductCostCalculation::getPurchasePrice);
	}

	private ProductCostCalculation getMostRecentCost(List<ProductCostCalculation> productCostCalculations) {
		return productCostCalculations.stream().filter(
						productCostCalculation -> productCostCalculation.getPurchaseDate() != null &&
								productCostCalculation.getPurchasePrice() != null)
				.max(Comparator.comparing(ProductCostCalculation::getPurchaseDate)).orElse(new ProductCostCalculation());
	}
}
