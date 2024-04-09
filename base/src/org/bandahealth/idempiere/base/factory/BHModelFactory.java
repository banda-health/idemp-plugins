package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IModelFactory;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.compiere.model.PO;
import org.compiere.util.Env;

import java.sql.ResultSet;

public class BHModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return MBPartner_BH.class;
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return MOrder_BH.class;
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return MInvoice_BH.class;
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return MPayment_BH.class;
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return MOrderLine_BH.class;
		} else if (tableName.equalsIgnoreCase(MInventory_BH.Table_Name)) {
			return MInventory_BH.class;
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return MInventoryLine_BH.class;
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return MProduct_BH.class;
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return MCharge_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return MBHPaymentRef.class;
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return MBHPaymentRefBankAccount.class;
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return MChargeType_BH.class;
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return MProductCategory_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return MBHProductCategoryDefault.class;
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return MBHDefaultIncludedRole.class;
		} else if (tableName.equalsIgnoreCase(MBPGroup_BH.Table_Name)) {
			return MBPGroup_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHDefaultDocActionAccess.Table_Name)) {
			return MBHDefaultDocActionAccess.class;
		} else if (tableName.equalsIgnoreCase(MReference_BH.Table_Name)) {
			return MReference_BH.class;
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return MUser_BH.class;
		} else if (tableName.equalsIgnoreCase(MWindowAccess_BH.Table_Name)) {
			return MWindowAccess_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFld.Table_Name)) {
			return MBHPayerInfoFld.class;
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldVal.Table_Name)) {
			return MBHPayerInfoFldVal.class;
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldSug.Table_Name)) {
			return MBHPayerInfoFldSug.class;
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldValSug.Table_Name)) {
			return MBHPayerInfoFldValSug.class;
		} else if (tableName.equalsIgnoreCase(MBHBPSpecificPayerInfo.Table_Name)) {
			return MBHBPSpecificPayerInfo.class;
		} else if (tableName.equalsIgnoreCase(MBHBPGeneralPayerInfo.Table_Name)) {
			return MBHBPGeneralPayerInfo.class;
		} else if (tableName.equalsIgnoreCase(MBHBPPayerInfo.Table_Name)) {
			return MBHBPPayerInfo.class;
		} else if (tableName.equalsIgnoreCase(MBHVoidedReason.Table_Name)) {
			return MBHVoidedReason.class;
		} else if (tableName.equalsIgnoreCase(MMovement_BH.Table_Name)) {
			return MMovement_BH.class;
		} else if (tableName.equalsIgnoreCase(MMovementLine_BH.Table_Name)) {
			return MMovementLine_BH.class;
		} else if (tableName.equalsIgnoreCase(MWarehouse_BH.Table_Name)) {
			return MWarehouse_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHRoleWarehouseAccess.Table_Name)) {
			return MBHRoleWarehouseAccess.class;
		} else if (tableName.equalsIgnoreCase(MAttributeSetInstance_BH.Table_Name)) {
			return MAttributeSetInstance_BH.class;
		} else if (tableName.equalsIgnoreCase(MMenu_BH.Table_Name)) {
			return MMenu_BH.class;
		} else if (tableName.equalsIgnoreCase(MInOut_BH.Table_Name)) {
			return MInOut_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHVisit.Table_Name)) {
			return MBHVisit.class;
		} else if (tableName.equalsIgnoreCase(MAttributeSet_BH.Table_Name)) {
			return MAttributeSet_BH.class;
		} else if (tableName.equalsIgnoreCase(MProcess_BH.Table_Name)) {
			return MProcess_BH.class;
		} else if (tableName.equalsIgnoreCase(MSysConfig_BH.Table_Name)) {
			return MSysConfig_BH.class;
		} else if (tableName.equalsIgnoreCase(MSerNoCtl_BH.Table_Name)) {
			return MSerNoCtl_BH.class;
		} else if (tableName.equalsIgnoreCase(MClient_BH.Table_Name)) {
			return MClient_BH.class;
		} else if (tableName.equalsIgnoreCase(MDocType_BH.Table_Name)) {
			return MDocType_BH.class;
		} else if (tableName.equalsIgnoreCase(MSequence_BH.Table_Name)) {
			return MSequence_BH.class;
		} else if (tableName.equalsIgnoreCase(MOrgInfo_BH.Table_Name)) {
			return MOrgInfo_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHEncounter.Table_Name)) {
			return MBHEncounter.class;
		} else if (tableName.equalsIgnoreCase(MBHObservation.Table_Name)) {
			return MBHObservation.class;
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnosis.Table_Name)) {
			return MBHEncounterDiagnosis.class;
		} else if (tableName.equalsIgnoreCase(MBHEncounterTypeWindow.Table_Name)) {
			return MBHEncounterTypeWindow.class;
		} else if (tableName.equalsIgnoreCase(MField_BH.Table_Name)) {
			return MField_BH.class;
		} else if (tableName.equalsIgnoreCase(MFieldGroup_BH.Table_Name)) {
			return MFieldGroup_BH.class;
		} else if (tableName.equalsIgnoreCase(MBHConcept.Table_Name)) {
			return MBHConcept.class;
		} else if (tableName.equalsIgnoreCase(MBHConceptMapping.Table_Name)) {
			return MBHConceptMapping.class;
		} else if (tableName.equalsIgnoreCase(MBHConceptName.Table_Name)) {
			return MBHConceptName.class;
		} else if (tableName.equalsIgnoreCase(MBHConceptDescription.Table_Name)) {
			return MBHConceptDescription.class;
		} else if (tableName.equalsIgnoreCase(MBHConceptExtra.Table_Name)) {
			return MBHConceptExtra.class;
		} else if (tableName.equalsIgnoreCase(MBHClientConcept.Table_Name)) {
			return MBHClientConcept.class;
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnostic.Table_Name)) {
			return MBHEncounterDiagnostic.class;
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return new MInvoice_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return new MPayment_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return new MOrderLine_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInventory_BH.Table_Name)) {
			return new MInventory_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return new MInventoryLine_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return new MProduct_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return new MCharge_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return new MBHPaymentRef(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return new MBHPaymentRefBankAccount(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return new MChargeType_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return new MProductCategory_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return new MBHProductCategoryDefault(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return new MBHDefaultIncludedRole(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBPGroup_BH.Table_Name)) {
			return new MBPGroup_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultDocActionAccess.Table_Name)) {
			return new MBHDefaultDocActionAccess(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MReference_BH.Table_Name)) {
			return new MReference_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return new MUser_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MWindowAccess_BH.Table_Name)) {
			return new MWindowAccess_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFld.Table_Name)) {
			return new MBHPayerInfoFld(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldVal.Table_Name)) {
			return new MBHPayerInfoFldVal(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldSug.Table_Name)) {
			return new MBHPayerInfoFldSug(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldValSug.Table_Name)) {
			return new MBHPayerInfoFldValSug(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPSpecificPayerInfo.Table_Name)) {
			return new MBHBPSpecificPayerInfo(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPGeneralPayerInfo.Table_Name)) {
			return new MBHBPGeneralPayerInfo(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPPayerInfo.Table_Name)) {
			return new MBHBPPayerInfo(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHVoidedReason.Table_Name)) {
			return new MBHVoidedReason(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MMovement_BH.Table_Name)) {
			return new MMovement_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MMovementLine_BH.Table_Name)) {
			return new MMovementLine_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MWarehouse_BH.Table_Name)) {
			return new MWarehouse_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHRoleWarehouseAccess.Table_Name)) {
			return new MBHRoleWarehouseAccess(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MAttributeSetInstance_BH.Table_Name)) {
			return new MAttributeSetInstance_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MMenu_BH.Table_Name)) {
			return new MMenu_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MInOut_BH.Table_Name)) {
			return new MInOut_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHVisit.Table_Name)) {
			return new MBHVisit(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MAttributeSet_BH.Table_Name)) {
			return new MAttributeSet_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MProcess_BH.Table_Name)) {
			return new MProcess_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MSysConfig_BH.Table_Name)) {
			return new MSysConfig_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MSerNoCtl_BH.Table_Name)) {
			return new MSerNoCtl_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MClient_BH.Table_Name)) {
			return new MClient_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MDocType_BH.Table_Name)) {
			return new MDocType_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MSequence_BH.Table_Name)) {
			return new MSequence_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounter.Table_Name)) {
			return new MBHEncounter(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHObservation.Table_Name)) {
			return new MBHObservation(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnosis.Table_Name)) {
			return new MBHEncounterDiagnosis(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterTypeWindow.Table_Name)) {
			return new MBHEncounterTypeWindow(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MField_BH.Table_Name)) {
			return new MField_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MFieldGroup_BH.Table_Name)) {
			return new MFieldGroup_BH(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConcept.Table_Name)) {
			return new MBHConcept(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptMapping.Table_Name)) {
			return new MBHConceptMapping(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptName.Table_Name)) {
			return new MBHConceptName(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptDescription.Table_Name)) {
			return new MBHConceptDescription(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptExtra.Table_Name)) {
			return new MBHConceptExtra(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHClientConcept.Table_Name)) {
			return new MBHClientConcept(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnostic.Table_Name)) {
			return new MBHEncounterDiagnostic(Env.getCtx(), Record_ID, trxName);
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			return new MOrder_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInvoice_BH.Table_Name)) {
			return new MInvoice_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			return new MPayment_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			return new MOrderLine_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInventory_BH.Table_Name)) {
			return new MInventory_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			return new MInventoryLine_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MProduct_BH.Table_Name)) {
			return new MProduct_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MCharge_BH.Table_Name)) {
			return new MCharge_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRef.Table_Name)) {
			return new MBHPaymentRef(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPaymentRefBankAccount.Table_Name)) {
			return new MBHPaymentRefBankAccount(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MChargeType_BH.Table_Name)) {
			return new MChargeType_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MProductCategory_BH.Table_Name)) {
			return new MProductCategory_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHProductCategoryDefault.Table_Name)) {
			return new MBHProductCategoryDefault(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultIncludedRole.Table_Name)) {
			return new MBHDefaultIncludedRole(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBPGroup_BH.Table_Name)) {
			return new MBPGroup_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHDefaultDocActionAccess.Table_Name)) {
			return new MBHDefaultDocActionAccess(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MReference_BH.Table_Name)) {
			return new MReference_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MUser_BH.Table_Name)) {
			return new MUser_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MWindowAccess_BH.Table_Name)) {
			return new MWindowAccess_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFld.Table_Name)) {
			return new MBHPayerInfoFld(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldVal.Table_Name)) {
			return new MBHPayerInfoFldVal(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldSug.Table_Name)) {
			return new MBHPayerInfoFldSug(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHPayerInfoFldValSug.Table_Name)) {
			return new MBHPayerInfoFldValSug(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPSpecificPayerInfo.Table_Name)) {
			return new MBHBPSpecificPayerInfo(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPGeneralPayerInfo.Table_Name)) {
			return new MBHBPGeneralPayerInfo(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHBPPayerInfo.Table_Name)) {
			return new MBHBPPayerInfo(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHVoidedReason.Table_Name)) {
			return new MBHVoidedReason(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MMovement_BH.Table_Name)) {
			return new MMovement_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MMovementLine_BH.Table_Name)) {
			return new MMovementLine_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MWarehouse_BH.Table_Name)) {
			return new MWarehouse_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHRoleWarehouseAccess.Table_Name)) {
			return new MBHRoleWarehouseAccess(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MAttributeSetInstance_BH.Table_Name)) {
			return new MAttributeSetInstance_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MMenu_BH.Table_Name)) {
			return new MMenu_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MInOut_BH.Table_Name)) {
			return new MInOut_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHVisit.Table_Name)) {
			return new MBHVisit(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MAttributeSet_BH.Table_Name)) {
			return new MAttributeSet_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MProcess_BH.Table_Name)) {
			return new MProcess_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MSysConfig_BH.Table_Name)) {
			return new MSysConfig_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MSerNoCtl_BH.Table_Name)) {
			return new MSerNoCtl_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MClient_BH.Table_Name)) {
			return new MClient_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MDocType_BH.Table_Name)) {
			return new MDocType_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MSequence_BH.Table_Name)) {
			return new MSequence_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MOrgInfo_BH.Table_Name)) {
			return new MOrgInfo_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounter.Table_Name)) {
			return new MBHEncounter(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHObservation.Table_Name)) {
			return new MBHObservation(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnosis.Table_Name)) {
			return new MBHEncounterDiagnosis(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterTypeWindow.Table_Name)) {
			return new MBHEncounterTypeWindow(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MField_BH.Table_Name)) {
			return new MField_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MFieldGroup_BH.Table_Name)) {
			return new MFieldGroup_BH(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConcept.Table_Name)) {
			return new MBHConcept(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptMapping.Table_Name)) {
			return new MBHConceptMapping(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptName.Table_Name)) {
			return new MBHConceptName(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptDescription.Table_Name)) {
			return new MBHConceptDescription(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHConceptExtra.Table_Name)) {
			return new MBHConceptExtra(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHClientConcept.Table_Name)) {
			return new MBHClientConcept(Env.getCtx(), rs, trxName);
		} else if (tableName.equalsIgnoreCase(MBHEncounterDiagnostic.Table_Name)) {
			return new MBHEncounterDiagnostic(Env.getCtx(), rs, trxName);
		}

		return null;
	}
}
