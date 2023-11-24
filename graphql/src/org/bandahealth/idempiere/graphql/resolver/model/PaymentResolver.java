package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.BusinessPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ReferenceListDataLoader;
import org.bandahealth.idempiere.graphql.repository.ReferenceListRepository;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.concurrent.CompletableFuture;

/**
 * The Payment resolver containing specific methods to fetch non-standard iDempiere properties for the consumer
 */
public class PaymentResolver extends BaseResolver<MPayment_BH> implements GraphQLResolver<MPayment_BH> {

	private final ReferenceListRepository referenceListRepository;

	public PaymentResolver() {
		referenceListRepository = new ReferenceListRepository();
	}

	public CompletableFuture<MBPartner_BH> businessPartner(MPayment_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MBPartner_BH> businessPartnerDataLoader =
				environment.getDataLoaderRegistry()
						.getDataLoader(BusinessPartnerDataLoader.BUSINESS_PARTNER_BY_ID_DATA_LOADER);
		return businessPartnerDataLoader.load(entity.getC_BPartner_ID());
	}

	public BigDecimal payAmount(MPayment_BH entity) {
		return entity.getPayAmt();
	}

	public CompletableFuture<MRefList> paymentType(MPayment_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<String, MRefList> paymentTypeDataLoader =
				environment.getDataLoaderRegistry()
						.getDataLoader(ReferenceListDataLoader.ORDER_PAYMENT_TYPE_DATA_LOADER);
		return paymentTypeDataLoader.load(entity.getTenderType());
	}

	public Timestamp transactionDate(MPayment_BH entity) {
		return entity.getDateTrx();
	}

	public BigDecimal tenderAmount(MPayment_BH entity) {
		return entity.getBH_TenderAmount();
	}

	public CompletableFuture<MCharge_BH> charge(MPayment_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MCharge_BH> chargeDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(ChargeDataLoader.CHARGE_BY_ID_DATA_LOADER);
		return chargeDataLoader.load(entity.getC_Charge_ID());
	}
}
