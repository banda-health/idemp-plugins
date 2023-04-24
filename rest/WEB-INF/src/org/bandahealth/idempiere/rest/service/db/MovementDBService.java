package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Movement;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovementDBService extends DocumentDBService<Movement, MMovement_BH> {

	private static final String MISSING_FROM_WAREHOUSE = "Missing From warehouse";
	private static final String MISSING_TO_WAREHOUSE = "Missing To warehouse";
	@Autowired
	private MovementLineDBService movementLineDBService;
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	private LocatorDBService locatorDBService;
	@Autowired
	private StorageOnHandDBService storageOnHandDBService;
	/**
	 * Document Type
	 */
	private int p_C_DocType_ID = 0;
	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MWarehouse.Table_Name,
					"LEFT JOIN " + MWarehouse.Table_Name + " ON " + MMovement_BH.Table_Name + "."
							+ MMovement_BH.COLUMNNAME_BH_FROM_WAREHOUSE_ID + " = " + MWarehouse.Table_Name + "."
							+ MWarehouse.COLUMNNAME_M_Warehouse_ID);
			put(MUser_BH.Table_Name,
					"LEFT JOIN " + MUser_BH.Table_Name + " ON " + MMovement_BH.Table_Name + "."
							+ MMovement_BH.COLUMNNAME_CreatedBy + " = " + MUser_BH.Table_Name + "."
							+ MUser_BH.COLUMNNAME_AD_User_ID);
		}
	};

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_MOVEMENT;
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_MOVEMENTS;
	}

	@Override
	public Movement saveEntity(Movement entity) {
		// From
		MWarehouse fromWarehouse = new Query(Env.getCtx(), MWarehouse.Table_Name,
				MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setParameters(entity.getFromWarehouse().getUuid())
				.first();
		if (fromWarehouse == null) {
			throw new AdempiereException(MISSING_FROM_WAREHOUSE);
		}

		// To
		MWarehouse toWarehouse = new Query(Env.getCtx(), MWarehouse.Table_Name,
				MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setParameters(entity.getToWarehouse().getUuid())
				.first();
		if (toWarehouse == null) {
			throw new AdempiereException(MISSING_TO_WAREHOUSE);
		}

		try {
			MMovement_BH mMovement = getEntityByUuidFromDB(entity.getUuid());
			if (mMovement == null) {
				mMovement = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					mMovement.setM_Movement_UU(entity.getUuid());
				}

				mMovement.setC_DocType_ID(p_C_DocType_ID);
			}

			mMovement.setAD_Org_ID(fromWarehouse.getAD_Org_ID());
			mMovement.setBH_FromWarehouseID(fromWarehouse.get_ID());
			mMovement.setBH_ToWarehouseID(toWarehouse.get_ID());

			if (StringUtil.isNotNullAndEmpty(entity.getMovementDate())) {
				Timestamp movementDate = DateUtil.getTimestamp(entity.getMovementDate());
				if (movementDate == null) {
					movementDate = new Timestamp(System.currentTimeMillis());
				}

				mMovement.setMovementDate(movementDate);
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mMovement.setDescription(entity.getDescription());
			}

			mMovement.setIsActive(entity.getIsActive());
			mMovement.setIsApproved(true);

			mMovement.saveEx();

			if (entity.getMovementLines() != null && !entity.getMovementLines().isEmpty()) {
				int locatorId = fromWarehouse.getDefaultLocator().getM_Locator_ID();
				int locatorToId = toWarehouse.getDefaultLocator().getM_Locator_ID();

				// Get the products in batch for the movement lines
				Map<String, MProduct_BH> productsByUuids = productDBService.getByUuids(
						entity.getMovementLines().stream().filter(movementLine -> movementLine.getProduct() != null)
								.map(movementLine -> movementLine.getProduct().getUuid()).collect(Collectors.toSet()));

				// Get the atributes in batch for the movement lines
				Map<String, Integer> attributeSetInstanceIdsByUuid = attributeSetInstanceDBService.getByUuids(
								entity.getMovementLines().stream().filter(movementLine -> movementLine.getAttributeSetInstance() != null)
										.map(movementLine -> movementLine.getAttributeSetInstance().getUuid()).collect(Collectors.toSet()))
						.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
								attributeSetInstanceByUuid -> attributeSetInstanceByUuid.getValue().get_ID()));

				List<MovementLine> savedMovementLines = new ArrayList<>();
				for (MovementLine movementLine : entity.getMovementLines()) {
					movementLine.setLocatorId(locatorId);
					movementLine.setLocatorToId(locatorToId);
					movementLine.setMovementId(mMovement.get_ID());

					if (movementLine.getProduct() != null) {
						movementLine.setProductId(productsByUuids.get(movementLine.getProduct().getUuid()).get_ID());
					}
					if (movementLine.getAttributeSetInstance() != null) {
						movementLine.setAttributeSetInstanceId(
								attributeSetInstanceIdsByUuid.get(movementLine.getAttributeSetInstance().getUuid()));
					}

					savedMovementLines.add(movementLineDBService.saveEntity(movementLine));
				}
				entity.setMovementLines(savedMovementLines);
			}

			// Delete movement lines not on the movement anymore
			List<MMovementLine_BH> movementsLines = movementLineDBService.getGroupsByIds(MMovementLine_BH::getM_Movement_ID,
					MMovementLine_BH.COLUMNNAME_M_Movement_ID, Collections.singleton(mMovement.get_ID())).get(mMovement.get_ID());
			Set<String> expectedMovementLineUuids =
					entity.getMovementLines().stream().map(MovementLine::getUuid).collect(Collectors.toSet());
			movementsLines.stream().filter(movementLine -> expectedMovementLineUuids.stream()
					.noneMatch(uuidToKeep -> uuidToKeep.equalsIgnoreCase(movementLine.getM_MovementLine_UU()))).forEach(
					movementLineToDelete -> movementLineToDelete.delete(false));

			return getEntity(mMovement.getM_Movement_UU());

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());

			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MMovement_BH movement = new Query(Env.getCtx(), MMovement_BH.Table_Name,
					MMovement_BH.COLUMNNAME_M_Movement_UU + "=?", null).setParameters(entityUuid).first();

			if (movement.isComplete()) {
				throw new AdempiereException("Transaction is already completed");
			} else {
				// movementLineDBService.deleteMovementLinesByMovement(movement);

				return movement.delete(false);
			}
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Movement createInstanceWithDefaultFields(MMovement_BH instance) {
		return new Movement(instance);
	}

	@Override
	protected Movement createInstanceWithAllFields(MMovement_BH instance) {
		return new Movement(instance);
	}

	@Override
	protected Movement createInstanceWithSearchFields(MMovement_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMovement_BH getModelInstance() {
		return new MMovement_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public Movement processEntity(String uuid, String docAction) throws Exception {
		super.processEntity(uuid, docAction);
		return getEntity(uuid);
	}

	@Override
	public Movement getEntity(String uuid) {
		Movement movement = transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);

		
		// We need more information for the storage on hand, so get those entities
		Set<Integer> productIds =
				movement.getMovementLines().stream().map(MovementLine::getProductId).collect(Collectors.toSet());
				
		// go-2331 Returning all this data is leading to serious performance issues. 
		// TODO: Work on an efficient way of returning all the data or just the totalQuantity field
		
		/* Map<Integer, List<StorageOnHand>> storageOnHandByProductId = storageOnHandDBService.transformData(
				storageOnHandDBService.getNonExpiredGroupsByIds(MStorageOnHand::getM_Product_ID,
								MStorageOnHand.COLUMNNAME_M_Product_ID, productIds).values().stream().flatMap(Collection::stream)
						.collect(Collectors.toList())).stream().collect(Collectors.groupingBy(StorageOnHand::getProductId));

		// Get the inventory for the product (can't be batched at the moment)
		movement.getMovementLines().forEach(movementLine -> {
			if (storageOnHandByProductId.containsKey(movementLine.getProductId())) {
				movementLine.getProduct().setStorageOnHandList(storageOnHandByProductId.get(movementLine.getProductId()));
			}
		});*/

		// Get the storage on hand stream for batches
		List<StorageOnHand> storageOnHandCollection =
				movement.getMovementLines().stream().map(MovementLine::getProduct).filter(Objects::nonNull)
						.map(Product::getStorageOnHandList).flatMap(Collection::stream).collect(Collectors.toList());

		// Batch the attribute set instance calls
		Set<Integer> attributeSetInstanceIds =
				storageOnHandCollection.stream().map(StorageOnHand::getAttributeSetInstanceId)
						.filter(attributeSetInstanceId -> attributeSetInstanceId > 0).collect(Collectors.toSet());
		Map<Integer, AttributeSetInstance> attributeSetInstancesById = attributeSetInstanceIds.isEmpty() ?
				new HashMap<>() :
				attributeSetInstanceDBService.getByIds(attributeSetInstanceIds).entrySet().stream().collect(
						Collectors.toMap(Map.Entry::getKey,
								attributeSetInstanceById -> new AttributeSetInstance(attributeSetInstanceById.getValue())));

		// Since ASI to product is a 1-to-1 relationship, we can just go set prices on ASIs
		productDBService.getProductCosts(productIds, attributeSetInstanceIds).forEach(productCostCalculation -> {
			if (attributeSetInstancesById.containsKey(productCostCalculation.getAttributeSetInstanceId())) {
				attributeSetInstancesById.get(productCostCalculation.getAttributeSetInstanceId())
						.setPurchasePrice(productCostCalculation.getPurchasePrice());
				attributeSetInstancesById.get(productCostCalculation.getAttributeSetInstanceId())
						.setPurchaseDate(productCostCalculation.getPurchaseDate());
			}
		});

		// Batch the locator calls
		Set<Integer> locatorIds =
				storageOnHandCollection.stream().map(StorageOnHand::getLocatorId).filter(locatorId -> locatorId > 0)
						.collect(Collectors.toSet());
		locatorIds.addAll(
				movement.getMovementLines().stream().map(MovementLine::getLocatorId).filter(locatorId -> locatorId > 0)
						.collect(Collectors.toSet()));
		locatorIds.addAll(
				movement.getMovementLines().stream().map(MovementLine::getLocatorToId).filter(locatorId -> locatorId > 0)
						.collect(Collectors.toSet()));
		Map<Integer, Locator> locatorsByIds = locatorIds.isEmpty() ? new HashMap<>() :
				locatorDBService.transformData(new ArrayList<>(locatorDBService.getByIds(locatorIds).values())).stream()
						.collect(Collectors.toMap(Locator::getId, locator -> locator));

		movement.getMovementLines().forEach(movementLine -> {
			if (movementLine.getProductId() == 0) {
				return;
			}
			movementLine.getProduct().getStorageOnHandList().forEach(storageOnHand -> {
				if (storageOnHand.getAttributeSetInstanceId() > 0) {
					storageOnHand.setAttributeSetInstance(
							attributeSetInstancesById.get(storageOnHand.getAttributeSetInstanceId()));
				}
				if (storageOnHand.getLocatorId() > 0) {
					storageOnHand.setLocator(locatorsByIds.get(storageOnHand.getLocatorId()));
				}
			});
			if (movementLine.getLocatorId() > 0) {
				movementLine.setLocator(locatorsByIds.get(movementLine.getLocatorId()));
			}
			if (movementLine.getLocatorToId() > 0) {
				movementLine.setLocatorTo(locatorsByIds.get(movementLine.getLocatorToId()));
			}
		});

		return movement;
	}

	@Override
	public List<Movement> transformData(List<MMovement_BH> dbModels) {
		List<Movement> results = new ArrayList<>();
		// get available warehouses
		List<MWarehouse> warehouses = Arrays.asList(MWarehouse.getForOrg(Env.getCtx(), Env.getAD_Org_ID(Env.getCtx())));

		// get list of users
		Set<Integer> userIds = dbModels.stream().map(MMovement_BH::getCreatedBy).collect(Collectors.toSet());
		List<Object> parameters = new ArrayList<>();

		// Get movement lines
		Set<Integer> movementIds = dbModels.stream().map(MMovement_BH::get_ID).collect(Collectors.toSet());
		Map<Integer, List<MovementLine>> movementLinesByMovementId = movementLineDBService.transformData(
				movementLineDBService.getGroupsByIds(MMovementLine_BH::getM_Movement_ID,
								MMovementLine_BH.COLUMNNAME_M_Movement_ID, movementIds).values().stream().flatMap(Collection::stream)
						.collect(Collectors.toList())).stream().collect(Collectors.groupingBy(MovementLine::getMovementId));

		List<MUser_BH> users = new Query(Env.getCtx(), MUser_BH.Table_Name,
				MUser_BH.COLUMNNAME_AD_User_ID + " IN ("
						+ QueryUtil.getWhereClauseAndSetParametersForSet(userIds, parameters) + ")",
				null).setParameters(parameters).list();
		dbModels.forEach((mMovement) -> {
			Movement movement = createInstanceWithAllFields(mMovement);
			if (movementLinesByMovementId.containsKey(movement.getId())) {
				movement.setMovementLines(movementLinesByMovementId.get(movement.getId()));
			}

			if (mMovement.getBH_FromWarehouseID() > 0) {
				warehouses.stream().filter(warehouse -> warehouse.get_ID() == mMovement.getBH_FromWarehouseID()).findFirst()
						.ifPresent(warehouse -> movement.setFromWarehouse(new Warehouse(warehouse)));
			}

			if (mMovement.getBH_ToWarehouseID() > 0) {
				warehouses.stream().filter(warehouse -> warehouse.get_ID() == mMovement.getBH_ToWarehouseID()).findFirst()
						.ifPresent(warehouse -> movement.setToWarehouse(new Warehouse(warehouse)));
			}

			users.stream().filter(user -> user.get_ID() == mMovement.getCreatedBy()).findFirst()
					.ifPresent(user -> movement.setUser(new User(user.getName(), user.getAD_User_UU())));

			results.add(movement);
		});

		return results;
	}
}
