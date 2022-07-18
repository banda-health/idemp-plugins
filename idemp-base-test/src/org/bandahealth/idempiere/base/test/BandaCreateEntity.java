package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateVO;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPInstance;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProcess;
import org.compiere.model.MSession;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Process;
import org.compiere.model.X_C_Order;
import org.compiere.model.X_M_DiscountSchema;
import org.compiere.model.X_M_InOut;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BandaCreateEntity extends ChuBoeCreateEntity {

	/**
	 * An override of Chuck's createBP to add some additional steps we need, such as making the price list default
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createBusinessPartner(BandaValueObjectWrapper valueObject) {
		BandaCreateEntity.createDefaultPriceLists(valueObject);

		ChuBoeCreateEntity.createBP(valueObject);
		valueObject.getBusinessPartnerBH().setIsCustomer(true);
		valueObject.getBusinessPartnerBH().setBH_IsPatient(true); // the BP model event currently uses this
		valueObject.getBusinessPartnerBH().saveEx();
	}

	/**
	 * This creates and/or sets the default purchase and sales price lists on the value object
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createDefaultPriceLists(BandaValueObjectWrapper valueObject) {
		MPriceList defaultSalesPriceList = new Query(valueObject.getCtx(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.get_trxName()).setParameters("Y", "Y").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		MPriceList defaultPurchasePriceList = new Query(valueObject.getCtx(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.get_trxName()).setParameters("Y", "N").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		// We'll temporarily override the step name
		String originalStepName = valueObject.getStepName();
		valueObject.setStepName("Create Default Price Lists");

		if (defaultSalesPriceList == null) {
			defaultSalesPriceList = new MPriceList(valueObject.getCtx(), 0, valueObject.get_trxName());
			defaultSalesPriceList.setName("SO_During: " + valueObject.getStepName() + valueObject.getRandom());
			defaultSalesPriceList.setDescription(valueObject.getStepMsgLong());
			defaultSalesPriceList.setAD_Org_ID(0);
			defaultSalesPriceList.setIsSOPriceList(true);
			defaultSalesPriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultSalesPriceList.setIsDefault(true);
			defaultSalesPriceList.saveEx();
		}
		valueObject.setPriceListSO(defaultSalesPriceList);

		if (defaultPurchasePriceList == null) {
			defaultPurchasePriceList = new MPriceList(valueObject.getCtx(), 0, valueObject.get_trxName());
			defaultPurchasePriceList.setName("PO_During: " + valueObject.getStepName() + valueObject.getRandom());
			defaultPurchasePriceList.setDescription(valueObject.getStepMsgLong());
			defaultPurchasePriceList.setAD_Org_ID(0);
			defaultPurchasePriceList.setIsSOPriceList(false);
			defaultPurchasePriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultPurchasePriceList.setIsDefault(true);
			defaultPurchasePriceList.saveEx();
			defaultSalesPriceList.saveEx();
		}
		valueObject.setPriceListPO(defaultPurchasePriceList);

		// Now handle the price list versions, if need be
		Timestamp datePL = valueObject.getDatePriceList();
		if (datePL == null)
			datePL = ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365);

		//see if price list version already exists
		String sqlWhere = "M_PriceList_ID = ? and ValidFrom = ?";

		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getCtx(), MPriceListVersion.Table_Name, sqlWhere, valueObject.get_trxName())
						.setClient_ID()
						.setParameters(defaultSalesPriceList.get_ID(), datePL)
						.first();

		MPriceListVersion purchasePriceListVersion =
				new Query(valueObject.getCtx(), MPriceListVersion.Table_Name, sqlWhere, valueObject.get_trxName())
						.setClient_ID()
						.setParameters(defaultPurchasePriceList.get_ID(), datePL)
						.first();

		if (purchasePriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getCtx(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.get_trxName())
					.setClient_ID()
					.first();

			purchasePriceListVersion = new MPriceListVersion(valueObject.getCtx(), 0, valueObject.get_trxName());
			purchasePriceListVersion.setAD_Org_ID(0);
			purchasePriceListVersion.setName(datePL + "; IsSOTrx=N; " + valueObject.getRandom());
			purchasePriceListVersion.setDescription(valueObject.getStepMsgLong());
			purchasePriceListVersion.setM_PriceList_ID(defaultPurchasePriceList.get_ID());
			purchasePriceListVersion.setValidFrom(datePL);
			purchasePriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			purchasePriceListVersion.saveEx();
		}

		if (salesPriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getCtx(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.get_trxName())
					.setClient_ID()
					.first();

			salesPriceListVersion = new MPriceListVersion(valueObject.getCtx(), 0, valueObject.get_trxName());
			salesPriceListVersion.setAD_Org_ID(0);
			salesPriceListVersion.setName(datePL + "; IsSOTrx=Y; " + valueObject.getRandom());
			salesPriceListVersion.setDescription(valueObject.getStepMsgLong());
			salesPriceListVersion.setM_PriceList_ID(defaultSalesPriceList.get_ID());
			salesPriceListVersion.setValidFrom(datePL);
			salesPriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			salesPriceListVersion.saveEx();
		}

		valueObject.setStepName(originalStepName);
	}

	/**
	 * Some methods need to be run as the System user, even though that may not be what the user is signed in as. This
	 * method allows that to happen and ensure the context will be reset after execution.
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void runProcessAsSystem(BandaValueObjectWrapper valueObject) {
		String sessionContextKey = "#AD_Session_ID"; // TODO: Replace with sessionContextKey when iDempiere 8.2+
		// We also have to update the session, so get it first before the context changes
		// Update the client & org
		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		int currentOrgId = Env.getAD_Org_ID(Env.getCtx());
		int currentRoleId = Env.getAD_Role_ID(Env.getCtx());
		int currentSessionId = Env.getContextAsInt(Env.getCtx(), sessionContextKey);
		Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, 0);
		Env.setContext(Env.getCtx(), Env.AD_ORG_ID, 0);
		Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, 0);

		int currentValueObjectClientId = Env.getAD_Client_ID(valueObject.getCtx());
		int currentValueObjectOrgId = Env.getAD_Org_ID(valueObject.getCtx());
		int currentValueObjectRoleId = Env.getAD_Role_ID(valueObject.getCtx());
		int currentValueObjectSessionId = Env.getContextAsInt(valueObject.getCtx(), sessionContextKey);
		Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, 0);
		Env.setContext(valueObject.getCtx(), Env.AD_ORG_ID, 0);
		Env.setContext(valueObject.getCtx(), Env.AD_ROLE_ID, 0);

		// Handle the session
		Env.setContext(valueObject.getCtx(), sessionContextKey, 0);
		MSession session = MSession.get(Env.getCtx(), true);
		session.saveEx();
		Env.setContext(Env.getCtx(), sessionContextKey, session.get_ID());
		Env.setContext(valueObject.getCtx(), sessionContextKey, session.get_ID());

		try {
			BandaCreateEntity.runProcess(valueObject);
		} finally {
			// Logout before resetting the context
			session.logout();

			// First, reset the value object's context (avoids overwriting the Env.getCtx() sometimes)
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, currentValueObjectClientId);
			Env.setContext(valueObject.getCtx(), Env.AD_ORG_ID, currentValueObjectOrgId);
			Env.setContext(valueObject.getCtx(), Env.AD_ROLE_ID, currentValueObjectRoleId);
			Env.setContext(valueObject.getCtx(), sessionContextKey, currentValueObjectSessionId);

			// Now reset the actual environment
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, currentClientId);
			Env.setContext(Env.getCtx(), Env.AD_ORG_ID, currentOrgId);
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, currentRoleId);
			// Now restore the old session
			Env.setContext(Env.getCtx(), sessionContextKey, currentSessionId);
			session = MSession.get(Env.getCtx(), true);
			session.save();

		}
	}

	/**
	 * This is the same as the {@link #runProcess(ChuBoePopulateVO)}, except that it sets a file to the value object
	 * and doesn't clear the process. You must run {@link #clearReport(BandaValueObjectWrapper)} after retrieving the
	 * generated report file.
	 * <br/><br/>
	 * Instructions:
	 * <ul>
	 *   <li>Step 1: setProcess_UU</li>
	 *   <li>Step 2: setProcessTable_ID and setProcessRecord_ID if needed used when running a process against a given
	 *   record - as opposed to 0,0 from the menu.</li>
	 *   <li>Step 3: addProcessInfoParam see example below</li>
	 * </ul>
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void runReport(BandaValueObjectWrapper valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//further validation
		if (valueObject.getProcessInfoParams() == null)
			valueObject.appendErrorMsg("Parameter List is null - It should at least be an empty List");
		else if (valueObject.getProcess_UU() == null)
			valueObject.appendErrorMsg("Process UU is null - cannot look up process");
		if (valueObject.isError())
			return;

		MProcess process = new Query(Env.getCtx(), X_AD_Process.Table_Name,
				"AD_Process_UU=?", valueObject.get_trxName()).setParameters(valueObject.getProcess_UU()).first();

		// Create a process info instance. This is a composite class containing the parameters.
		ProcessInfo processInfo =
				new ProcessInfo("", process.get_ID(), valueObject.getProcessTable_ID(), valueObject.getProcessRecord_ID());
		processInfo.setIsBatch(true);
		processInfo.setExport(true);
		String reportTypeToUse = valueObject.getReportType() == null ? "pdf" : valueObject.getReportType();
		processInfo.setReportType(reportTypeToUse.toUpperCase());
		processInfo.setExportFileExtension(reportTypeToUse.toLowerCase());

		List<ProcessInfoParameter> params = valueObject.getProcessInfoParams();
		if (!params.isEmpty()) {
			processInfo.setParameter(valueObject.getProcessInfoParams().toArray(new ProcessInfoParameter[params.size()]));
		}

		// Create process instance (mainly for logging/sync purpose)
		MPInstance mpi = new MPInstance(Env.getCtx(), process.get_ID(), valueObject.getProcessRecord_ID());
		mpi.saveEx();

		// Connect the process to the process instance.
		processInfo.setAD_PInstance_ID(mpi.get_ID());

		ServerProcessCtl.process(processInfo, null);

		if (processInfo.getExportFile() == null) {
			valueObject.appendErrorMsg("Report Generation Failed: " + process.getClassname());
		}

		valueObject.setReport(processInfo.getExportFile());
	}

	public static void clearReport(BandaValueObjectWrapper valueObject) {
		valueObject.setProcess_UU(null);
		valueObject.setProcessInfoParams(new ArrayList<>());
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setReport(null);
	}

	/**
	 * Create an inventory record
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createInventory(BandaValueObjectWrapper valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		// perform further validation if needed based on business logic
		if (valueObject.getDocType() == null) {
			valueObject.appendErrorMsg("DocType is Null");
			return;
		} else if (valueObject.getBP() == null) {
			valueObject.appendErrorMsg("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMsg("Warehouse is Null");
			return;
		}

		// create inventory header
		MInventory_BH inventory = new MInventory_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		inventory.setAD_Org_ID(valueObject.getOrg().get_ID());
		inventory.setDescription(valueObject.getStepMsgLong());
		inventory.setC_DocType_ID(valueObject.getDocType().get_ID());
		inventory.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		inventory.saveEx();
		valueObject.setInventory(inventory);

		// create inventory line
		MInventoryLine_BH inventoryLine = new MInventoryLine_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		inventoryLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		inventoryLine.setDescription(valueObject.getStepMsgLong());
		inventoryLine.setM_Inventory_ID(inventory.get_ID());
		inventoryLine.setM_Product_ID(valueObject.getProduct().get_ID());
		inventoryLine.setM_AttributeSetInstance_ID(0);
		inventoryLine.setM_Locator_ID(valueObject.getWarehouse().getDefaultLocator().get_ID());
		if (valueObject.getQty() == null || valueObject.getQty().compareTo(Env.ZERO) == 0) {
			inventoryLine.setQtyCount(Env.ONE);
		} else {
			inventoryLine.setQtyCount(valueObject.getQty());
		}

		// Set the quantity on the book from m_storageonhand
		inventoryLine.setQtyBook(new Query(valueObject.getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
						"=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?", valueObject.get_trxName()).setOnlyActiveRecords(
						true).setParameters(valueObject.getProduct().get_ID(), 0, inventoryLine.getM_Locator_ID())
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand));

		inventoryLine.saveEx();
		valueObject.setInventoryLine(inventoryLine);

		if (valueObject.getDocAction() != null) {
			if (valueObject.getLog() != null) {
				valueObject.getLog().fine("Starting DocAction: " + valueObject.getDocAction());
			}
			inventory.setDocAction(valueObject.getDocAction());
			inventory.processIt(valueObject.getDocAction());
		}
		if (valueObject.getLog() != null) {
			valueObject.getLog().fine("Saving inventory after completion. Doc Status: " + inventory.getDocStatus());
		}
		inventory.saveEx();
	}

	/**
	 * This creates an InOut record based on the order. This will not call
	 * {@link BandaValueObjectWrapper#setInOutLine(MInOutLine)} since an order might have several lines
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createInOutFromOrder(BandaValueObjectWrapper valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getDocType() == null) {
			valueObject.appendErrorMsg("DocType is Null");
			return;
		} else if (valueObject.getBP() == null) {
			valueObject.appendErrorMsg("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMsg("Warehouse is Null");
			return;
		} else if (!valueObject.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)) {
			valueObject.appendErrorMsg("Order Not Completed");
			return;
		}

		MInOut inOut = new MInOut(valueObject.getOrder(), valueObject.getDocType().get_ID(), valueObject.getDate());

		inOut.setMovementType(valueObject.getDocType().isSOTrx() ? X_M_InOut.MOVEMENTTYPE_CustomerShipment :
				X_M_InOut.MOVEMENTTYPE_VendorReceipts);
		inOut.saveEx();
		valueObject.setInOut(inOut);

		// add lines if any
		MOrderLine[] orderLines = valueObject.getOrder().getLines(true, "M_Product_ID");
		if (orderLines.length > 0) {
			for (MOrderLine orderLine : orderLines) {
				MInOutLine line = new MInOutLine(inOut);
				line.setOrderLine(orderLine, valueObject.getWarehouse().getDefaultLocator().get_ID(), Env.ZERO);
				line.setQty(orderLine.getQtyOrdered());
				line.saveEx(valueObject.get_trxName());
			}
		}

		if (valueObject.getDocAction() != null) {
			inOut.setDocAction(valueObject.getDocAction());
			inOut.processIt(valueObject.getDocAction());
		}
		inOut.saveEx();
	}
}
