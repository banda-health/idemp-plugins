package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

/**
 * This process resets expired stocks to zero for a given client
 * 
 * @author clinton
 *
 */

public class UpdateExpiredStockProcess extends SvrProcess {

    private final String PROCESS_NAME = this.getClass().getName();
    private int AD_CLIENT_ID = 0;
    private int M_AttributeSetInstance_ID = 0;
    
    @Override
    protected void prepare() {
        //Read all parameters
        ProcessInfoParameter[] parameters = getParameter();
        for (int i = 0; i < parameters.length; i++) {
            String name = parameters[i].getParameterName(); 
            if (parameters[i].getParameter() == null) {
                
            }else if (name.equalsIgnoreCase("AD_CLIENT_ID")) {
                AD_CLIENT_ID = parameters[i].getParameterAsInt();
            } else if (name.equalsIgnoreCase("M_AttributeSetInstance_ID")) {
                M_AttributeSetInstance_ID = parameters[i].getParameterAsInt();
            }else {
                log.severe("Unknown parameter " + name);
            }
        }
        log.info("Process prepared with " + AD_CLIENT_ID + " - " + M_AttributeSetInstance_ID);
    }

    @Override
    protected String doIt() throws Exception {
        log.log(Level.INFO, "START " + PROCESS_NAME);

        int count = 0; 
        String whereClause = MStorageOnHand.COLUMNNAME_QtyOnHand + "> 0";
        List<MStorageOnHand> stocks = new Query(getCtx(), MStorageOnHand.Table_Name, whereClause, get_TrxName())
                .setClient_ID().setOnlyActiveRecords(true).list();
        for (MStorageOnHand stock : stocks) {
            //check if expired
            MAttributeSetInstance mAttributeSetInstance = new Query(getCtx(), MAttributeSetInstance.Table_Name, MAttributeSetInstance.COLUMNNAME_GuaranteeDate  + " < now() AND " + MAttributeSetInstance.COLUMNNAME_M_AttributeSetInstance_ID + " = " + stock.getM_AttributeSetInstance_ID(),
                    get_TrxName()).first();
            if(mAttributeSetInstance != null) {
                UpdateStock.updateStock(stock, BigDecimal.ZERO);
            }            
            count++;
        }

        String msg = "STOP " + PROCESS_NAME + ". Processed " + count + " records(s).";
        log.log(Level.INFO, msg);

        return msg;
    }

}
