package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.util.List;
import java.util.Properties;

public class MBHPayrollRunMutation extends X_BH_Payroll_RunMutation {

	/** DocBaseType for the payroll run document (AD_Document_Action_Access keys off this). */
	private static final String DOCBASETYPE_PayrollRun = "BPR";

	/**
	 * Create the month's draft (or refresh the existing draft's lines). Errors if the period is
	 * already locked.
	 */
	public MBHPayrollRun BH_Payroll_RunDraft(int BH_PayrollMonth, int BH_PayrollYear,
			DataFetchingEnvironment environment) {
		Properties ctx = BandaGraphQLContext.getCtx(environment);
		int clientId = Env.getAD_Client_ID(ctx);
		Trx transaction = Trx.get(Trx.createTrxName("PayrollRunDraft"), true);
		try {
			MBHPayrollRun run = new Query(ctx, MBHPayrollRun.Table_Name,
					MBHPayrollRun.COLUMNNAME_AD_Client_ID + "=? AND " + MBHPayrollRun.COLUMNNAME_BH_PayrollYear
							+ "=? AND " + MBHPayrollRun.COLUMNNAME_BH_PayrollMonth + "=?", transaction.getTrxName())
					.setParameters(clientId, BH_PayrollYear, BH_PayrollMonth)
					.first();
			if (run != null && DocAction.STATUS_Completed.equals(run.getDocStatus())) {
				throw new AdempiereException("Period is locked");
			}
			if (run == null) {
				run = new MBHPayrollRun(ctx, 0, transaction.getTrxName());
				run.setBH_PayrollYear(BH_PayrollYear);
				run.setBH_PayrollMonth(BH_PayrollMonth);
				run.setDocStatus(DocAction.STATUS_Drafted);
				run.setDocAction(DocAction.ACTION_Complete);
				run.saveEx();
			}
			List<MBHPayrollComponent> catalogue = MBHPayrollComponent.getEffectiveAll(ctx, clientId,
					run.getPeriodEnd(), transaction.getTrxName());
			run.generateLines(catalogue);
			run.saveEx();
			if (!transaction.commit(true)) {
				throw new AdempiereException("Could not commit payroll run draft transaction");
			}
			return run;
		} catch (Exception exception) {
			transaction.rollback();
			throw exception instanceof AdempiereException ? (AdempiereException) exception
					: new AdempiereException(exception.getLocalizedMessage(), exception);
		} finally {
			transaction.close();
		}
	}

	/**
	 * Two-state document dispatch: CO = Finalize &amp; Lock, RE = Unlock. Access is checked against
	 * AD_Document_Action_Access (DocBaseType BPR) before dispatching to the run's own processIt.
	 */
	public MBHPayrollRun BH_Payroll_RunProcess(String UU, String DocumentAction, DataFetchingEnvironment environment)
			throws Exception {
		Properties ctx = BandaGraphQLContext.getCtx(environment);
		if (!DocumentUtil.isDocActionValidForUser(ctx, DOCBASETYPE_PayrollRun, DocumentAction)) {
			throw new AdempiereException("Unauthorized");
		}
		Trx transaction = Trx.get(Trx.createTrxName("PayrollRunProcess"), true);
		try {
			MBHPayrollRun run = Repository.getByUuid(ctx, MBHPayrollRun.Table_Name, transaction.getTrxName(), UU);
			if (run == null) {
				throw new AdempiereException("Payroll run not found");
			}
			if (!run.processIt(DocumentAction)) {
				throw new AdempiereException(run.getProcessMsg());
			}
			run.saveEx();
			if (!transaction.commit(true)) {
				throw new AdempiereException("Could not commit payroll run process transaction");
			}
			return run;
		} catch (Exception exception) {
			transaction.rollback();
			throw exception;
		} finally {
			transaction.close();
		}
	}
}
