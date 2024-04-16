package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovementLineDBService extends BaseDBService<MovementLine, MMovementLine_BH> {

	private final ProductDBService productDBService = new ProductDBService();
	private final AttributeSetInstanceDBService attributeSetInstanceDBService = new AttributeSetInstanceDBService();
	private final LocatorDBService locatorDBService = new LocatorDBService();

	public MovementLineDBService() {
	}

	@Override
	public MovementLine saveEntity(MovementLine entity) {
		MMovementLine_BH mMovementLine = getEntityByUuidFromDB(entity.getUuid());
		if (mMovementLine == null) {
			mMovementLine = new MMovementLine_BH(Env.getCtx(), 0, null);
			mMovementLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mMovementLine.setM_MovementLine_UU(entity.getUuid());
			}
		}

		mMovementLine.setM_Movement_ID(entity.getMovementId());
		mMovementLine.setM_Product_ID(entity.getProductId());
		mMovementLine.setMovementQty(entity.getMovementQuantity());
		mMovementLine.setDescription("Total: " + entity.getMovementQuantity());

		mMovementLine.setM_Locator_ID(entity.getLocatorId()); // from
		mMovementLine.setM_AttributeSetInstance_ID(entity.getAttributeSetInstanceId());
		mMovementLine.setM_LocatorTo_ID(entity.getLocatorToId()); // to
		mMovementLine.setM_AttributeSetInstanceTo_ID(entity.getAttributeSetInstanceId());
		mMovementLine.saveEx();

		return createInstanceWithAllFields(mMovementLine);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MMovementLine_BH movementLine = new Query(Env.getCtx(), MMovementLine_BH.Table_Name,
				MMovementLine_BH.COLUMNNAME_M_MovementLine_UU + "=?", null).setParameters(entityUuid).setClient_ID()
				.first();
		if (movementLine != null) {
			movementLine.deleteEx(false);

			return true;
		}

		return false;
	}

	@Override
	protected MovementLine createInstanceWithDefaultFields(MMovementLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MovementLine createInstanceWithAllFields(MMovementLine_BH instance) {
		return new MovementLine(instance);
	}

	@Override
	protected MMovementLine_BH getModelInstance() {
		return new MMovementLine_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<MovementLine> transformData(List<MMovementLine_BH> dbModels) {
		// get list of products
		Set<Integer> productIds = dbModels.stream().map(MMovementLine_BH::getM_Product_ID)
				.filter(m_product_id -> m_product_id > 0).collect(Collectors.toSet());
		Map<Integer, Product> productsByIds = productDBService
				.transformData(new ArrayList<>(productDBService.getByIds(productIds).values())).stream()
				.collect(Collectors.toMap(Product::getId, product -> product));

		// Get a list of attribute sets
		Set<Integer> attributeSetInstanceIds = dbModels.stream().map(MMovementLine_BH::getM_AttributeSetInstance_ID)
				.filter(m_attributeSetInstance_id -> m_attributeSetInstance_id > 0).collect(Collectors.toSet());
		Map<Integer, AttributeSetInstance> attributeSetInstancesById = productIds.isEmpty() ? new HashMap<>()
				: attributeSetInstanceDBService.getByIds(attributeSetInstanceIds).entrySet().stream().collect(
				Collectors.toMap(Map.Entry::getKey, attributeSetInstanceEntry -> new AttributeSetInstance(
						attributeSetInstanceEntry.getValue())));

		productDBService.getProductCosts(productIds, attributeSetInstanceIds).forEach(productCostCalculation -> {
			if (attributeSetInstancesById.containsKey(productCostCalculation.getAttributeSetInstanceId())) {
				attributeSetInstancesById.get(productCostCalculation.getAttributeSetInstanceId())
						.setPurchasePrice(productCostCalculation.getPurchasePrice());
				attributeSetInstancesById.get(productCostCalculation.getAttributeSetInstanceId())
						.setPurchaseDate(productCostCalculation.getPurchaseDate());
			}
		});

		// get locators
		Map<Integer, Locator> locatorsById = locatorDBService
				.transformData(
						new ArrayList<>(locatorDBService.getByIds(Stream
								.concat(dbModels.stream().map(MMovementLine_BH::getM_Locator_ID),
										dbModels.stream().map(MMovementLine_BH::getM_LocatorTo_ID))
								.collect(Collectors.toSet())).values()))
				.stream().collect(Collectors.toMap(Locator::getId, line -> line));

		return dbModels.stream().map((line) -> {
			MovementLine movementLine = createInstanceWithAllFields(line);

			if (line.getM_Product_ID() > 0) {
				movementLine.setProduct(productsByIds.get(line.getM_Product_ID()));
			}
			if (line.getM_AttributeSetInstance_ID() > 0) {
				movementLine
						.setAttributeSetInstance(attributeSetInstancesById.get(line.getM_AttributeSetInstance_ID()));
			}

			if (locatorsById.containsKey(movementLine.getLocatorId())) {
				movementLine.setLocator(locatorsById.get(movementLine.getLocatorId()));
			}

			if (locatorsById.containsKey(movementLine.getLocatorToId())) {
				movementLine.setLocatorTo(locatorsById.get(movementLine.getLocatorToId()));
			}

			return movementLine;
		}).collect(Collectors.toList());
	}
}
