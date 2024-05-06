package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.dataloader.DataLoaderRegisterer;
import org.bandahealth.idempiere.graphql.model.ProductCostCalculation;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ProductCostCalculationDataLoader implements DataLoaderRegisterer {
	private static final CLogger log = CLogger.getCLogger(ProductCostCalculationDataLoader.class);
	public static String DATALOADER_ProductCostCalculation_BY_Product_ID =
			"ProductCostCalculationsByProductIDDataLoader";
	public static String DATALOADER_ProductCostCalculation_BY_AttributeSetInstance_ID =
			"ProductCostCalculationsByAttributeSetInstanceIDDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		registry.register(DATALOADER_ProductCostCalculation_BY_Product_ID,
				DataLoader.newMappedDataLoader(getByProductIdBatchLoader(),
						DataLoaderOptions.newOptions().setBatchLoaderContextProvider(() -> idempiereContext)));
		registry.register(DATALOADER_ProductCostCalculation_BY_AttributeSetInstance_ID,
				DataLoader.newMappedDataLoader(getByAttributeSetInstanceIdBatchLoader(),
						DataLoaderOptions.newOptions().setBatchLoaderContextProvider(() -> idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<ProductCostCalculation>> getByProductIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			return getProductCosts(batchLoaderEnvironment.getContext(),
					keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet()), null).stream().collect(
					Collectors.groupingBy(
							productCostCalculation -> ModelUtil.getModelKey(modelName, productCostCalculation.getM_Product_ID())));
		});
	}

	private MappedBatchLoaderWithContext<String, List<ProductCostCalculation>> getByAttributeSetInstanceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			return getProductCosts(batchLoaderEnvironment.getContext(), null,
					keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet())).stream().collect(
					Collectors.groupingBy(productCostCalculation -> ModelUtil.getModelKey(modelName,
							productCostCalculation.getM_AttributeSetInstance_ID())));
		});
	}

	/**
	 * Gets the costs associated with products
	 *
	 * @param idempiereContext        The context since Env.getCtx() isn't thread-safe
	 * @param productIds              The products ids to get the costs for
	 * @param attributeSetInstanceIds The attribute set instance ids to get the costs for
	 * @return A map of product ids, each of which holds a map of attribute set instance ids to their costs
	 */
	private List<ProductCostCalculation> getProductCosts(Properties idempiereContext, Set<Integer> productIds,
			Set<Integer> attributeSetInstanceIds) {
		if (productIds == null) {
			productIds = new HashSet<>();
		}
		if (attributeSetInstanceIds == null) {
			attributeSetInstanceIds = new HashSet<>();
		}
		List<Object> parameters = new ArrayList<>();
		StringBuilder costSql = new StringBuilder(
				"SELECT m_product_id, m_attributesetinstance_id, purchase_price, purchase_date FROM get_product_costs(?)");
		parameters.add(Env.getAD_Client_ID(idempiereContext));
		if (!productIds.isEmpty() || !attributeSetInstanceIds.isEmpty()) {
			costSql.append(" WHERE ");
			if (!productIds.isEmpty()) {
				String productWhereClause =
						QueryUtil.getWhereClauseAndSetParametersForSet(productIds, parameters);
				costSql.append("m_product_id IN (").append(productWhereClause).append(")");
				if (!attributeSetInstanceIds.isEmpty()) {
					costSql.append(" AND ");
				}
			}
			if (!attributeSetInstanceIds.isEmpty()) {
				String attributeSetInstanceWhereClause =
						QueryUtil.getWhereClauseAndSetParametersForSet(attributeSetInstanceIds, parameters);
				costSql.append("m_attributesetinstance_id IN (").append(attributeSetInstanceWhereClause).append(")");
			}
		}
		List<ProductCostCalculation> productCostCalculations = new ArrayList<>();
		SqlUtil.executeQuery(costSql.toString(), parameters, null, data -> {
			try {
				int productId = data.getInt(1);
				int attributeSetInstanceId = data.getInt(2);
				BigDecimal purchasePrice = data.getBigDecimal(3);
				Timestamp purchaseDate = data.getTimestamp(4);
				productCostCalculations.add(
						new ProductCostCalculation(productId, attributeSetInstanceId, purchasePrice, purchaseDate));
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
		});
		return productCostCalculations;
	}
}
