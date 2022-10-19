package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MDocType;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
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
        
        MDocType materialMovementDocumentType = MDocType.getOfDocBaseType(Env.getCtx(), MDocType.DOCBASETYPE_MaterialMovement)[0];
        
        List<MStorageOnHand> expiredStocks = new Query(Env.getCtx(), MStorageOnHand.Table_Name,
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
        for (MStorageOnHand expiredStock : expiredStocks) {
            UpdateStock.updateStock(expiredStock, BigDecimal.ZERO);
            count++;
        }
        
        MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?",
                get_TrxName()).setOnlyActiveRecords(true).setParameters("8e270648-1d54-46d9-9161-2d0300dd80ff").first();

        MPInstance mpInstance = new MPInstance(mprocess, 0);

        ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
        processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
        processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

        processInfo.setParameter(new ProcessInfoParameter[]{
                new ProcessInfoParameter(PARAMETERNAME_C_DocType_ID, materialMovementDocumentType.getC_DocType_ID(), null, null, null)});

        ServerProcessCtl.process(processInfo, null);

        return processInfo.getSummary();
        
        // Kick off the storage cleanup process
        //StorageCleanup storageCleanupProcess = new StorageCleanup();
        //Get C_DocType_ID for this client before clearing parameters
        //String whereClause  = "DocBaseType=?";
       /** MDocType mDocType = new Query(getCtx(), MDocType.Table_Name, whereClause, null)
                .setClient_ID()
                .setParameters(MDocType.DOCBASETYPE_MaterialMovement)
                .setOnlyActiveRecords(true)
                .first();
        /**
         if (mDocType != null) {
         
            //Clear Parameters
            clearParameters();
            // Add Doc Type Parameter.
            addParameter(new ProcessInfoParameter(PARAMETERNAME_C_DocType_ID, mDocType.getC_DocType_ID(), null, null, null));
            storageCleanupProcess.startProcess(getCtx(), getProcessInfo(), null);
        }**/
        

        //String msg = "STOP " + PROCESS_NAME + ". Processed " + count + " records(s).";
        //log.log(Level.INFO, msg);

        //return msg;
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
