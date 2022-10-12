package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MDocType;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.StorageCleanup;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

/**
 * This process resets expired stocks to zero for a given client
 * 
 * @author clinton
 *
 */

public class UpdateExpiredStockProcess extends SvrProcess {

    private final String PROCESS_NAME = this.getClass().getName();
    public static final String PARAMETERNAME_C_DocType_ID = "C_DocType_ID";
    
    @Override
    protected void prepare() {
    }

    @Override
    protected String doIt() throws Exception {
        log.log(Level.INFO, "START " + PROCESS_NAME);
        
        List<MStorageOnHand> expiredStock = new Query(Env.getCtx(), MStorageOnHand.Table_Name,
                MAttributeSetInstance.Table_Name + "." + MAttributeSetInstance.COLUMNNAME_GuaranteeDate +
                        " < now()", get_TrxName()).addJoinClause(
                "JOIN " + MAttributeSetInstance.Table_Name + " ON " + MAttributeSetInstance.Table_Name + "." +
                        MAttributeSetInstance.COLUMNNAME_M_AttributeSetInstance_ID + "=" + MStorageOnHand.Table_Name + "." +
                        MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
                        "WHERE " + MStorageOnHand.COLUMNNAME_QtyOnHand + " NOT IN (0)")
                .setClient_ID()
                .setOnlyActiveRecords(true)
                .list();

        int count = 0;
        //Get all Attribute Set Instance that are expired for this client
        String attributeWhereClause = MAttributeSetInstance.COLUMNNAME_GuaranteeDate  + " < now()";
        List<MAttributeSetInstance> expiredAttributes = new Query(getCtx(), MAttributeSetInstance.Table_Name, attributeWhereClause, get_TrxName())
                .setClient_ID()
                .setOnlyActiveRecords(true)
                .list();
        for (MAttributeSetInstance expiredAttribute : expiredAttributes) {
            //Get all stocks that have this expired attribute
            String whereClause = MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?";
            List<MStorageOnHand> stocks = new Query(getCtx(), MStorageOnHand.Table_Name, whereClause, get_TrxName())
                    .setClient_ID()
                    .setParameters(expiredAttribute.getM_AttributeSetInstance_ID())
                    .setOnlyActiveRecords(true)
                    .list();
            for (MStorageOnHand stock : stocks) {
                UpdateStock.updateStock(stock, BigDecimal.ZERO);
                count++;
            }
        }
        
        // Kick off the storage cleanup process
        StorageCleanup storageCleanupProcess = new StorageCleanup();
        //Get C_DocType_ID for this client before clearing parameters
        String whereClause  = "DocBaseType=?";
        MDocType mDocType = new Query(getCtx(), MDocType.Table_Name, whereClause, null)
                .setClient_ID()
                .setParameters(MDocType.DOCBASETYPE_MaterialMovement)
                .setOnlyActiveRecords(true)
                .first();
        if (mDocType != null) {
            //Clear Parameters
            clearParameters();
            // Add Doc Type Parameter.
            addParameter(new ProcessInfoParameter(PARAMETERNAME_C_DocType_ID, mDocType.getC_DocType_ID(), null, null, null));
            storageCleanupProcess.startProcess(getCtx(), getProcessInfo(), null);
        }
        

        String msg = "STOP " + PROCESS_NAME + ". Processed " + count + " records(s).";
        log.log(Level.INFO, msg);

        return msg;
    }
    
    private void clearParameters() {
        List<ProcessInfoParameter> parameters = new ArrayList<ProcessInfoParameter>(Arrays.asList(getParameter()));
        parameters.clear();
        // Set the parameters so they can be accessed by everyone
        getProcessInfo().setParameter(parameters.toArray(ProcessInfoParameter[]::new));
    }
    
    private void addParameter(ProcessInfoParameter parameter) {
        List<ProcessInfoParameter> parameters = new ArrayList<ProcessInfoParameter>(Arrays.asList(getParameter()));
        parameters.add(parameter);
        // Set the parameters so they can be accessed by everyone
        getProcessInfo().setParameter(parameters.toArray(ProcessInfoParameter[]::new));
    }

}
