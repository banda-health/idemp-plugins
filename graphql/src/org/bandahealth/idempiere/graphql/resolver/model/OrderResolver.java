package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.BusinessPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ReferenceListDataLoader;
import org.bandahealth.idempiere.graphql.model.OrderStatus;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The Order resolver containing specific methods to fetch non-standard iDempiere properties for the consumer
 */
public class OrderResolver extends BaseResolver<MOrder_BH> implements GraphQLResolver<MOrder_BH> {
	public CompletableFuture<MBPartner_BH> businessPartner(MOrder_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MBPartner_BH> businessPartnerDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(BusinessPartnerDataLoader.BUSINESS_PARTNER_BY_ID_DATA_LOADER);
		return businessPartnerDataLoader.load(entity.getC_BPartner_ID());
	}

	public CompletableFuture<List<MOrderLine_BH>> orderLines(MOrder_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MOrderLine_BH>> orderLineDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(OrderLineDataLoader.ORDER_LINE_BY_ORDER_DATA_LOADER);
		return orderLineDataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MPayment_BH>> payments(MOrder_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MPayment_BH>> paymentDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(PaymentDataLoader.PAYMENT_BY_ORDER_DATA_LOADER);
		return paymentDataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public boolean isSalesTransaction(MOrder_BH entity) {
		return entity.isSOTrx();
	}
}
