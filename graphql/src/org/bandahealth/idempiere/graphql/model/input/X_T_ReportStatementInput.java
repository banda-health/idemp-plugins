package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MFactAcct;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.compiere.model.X_T_ReportStatement;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReportStatementInput extends X_T_ReportStatement implements I_T_ReportStatementInput {

	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mFact_Acct;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_T_ReportStatementInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_T_ReportStatement(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		MPInstance foreignEntity;
		if (get_ID() == 0 && AD_PInstance != null &&
				(foreignEntity = new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
						.setParameters(AD_PInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
	}
	/**
	 * Set Accounted Credit.
	 *
	 * @param AmtAcctCr Accounted Credit Amount
	 */

	public void setAmtAcctCr(BigDecimal AmtAcctCr) {
		if (get_ID() == 0) {
			super.setAmtAcctCr(AmtAcctCr);
		}
	}
	/**
	 * Set Accounted Debit.
	 *
	 * @param AmtAcctDr Accounted Debit Amount
	 */

	public void setAmtAcctDr(BigDecimal AmtAcctDr) {
		if (get_ID() == 0) {
			super.setAmtAcctDr(AmtAcctDr);
		}
	}
	/**
	 * Set Balance.
	 *
	 * @param Balance Balance
	 */

	public void setBalance(BigDecimal Balance) {
		if (get_ID() == 0) {
			super.setBalance(Balance);
		}
	}
	/**
	 * Set Account Date.
	 *
	 * @param DateAcct Accounting Date
	 */

	public void setDateAcct(Timestamp DateAcct) {
		if (get_ID() == 0) {
			super.setDateAcct(DateAcct);
		}
	}
	/**
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */

	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}

	/**
	 * Set Accounting Fact.
	 *
	 * @param Fact_Acct Accounting Fact
	 */
	@JsonProperty("Fact_Acct")
	public void setFact_AcctInput(ForeignEntityInput Fact_Acct) {
		this.mFact_Acct = Fact_Acct;
		MFactAcct foreignEntity;
		if (get_ID() == 0 && Fact_Acct != null &&
				(foreignEntity = new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
						.setParameters(Fact_Acct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setFact_Acct_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Fact.
	 *
	 * @return Accounting Fact
	 */
	@JsonProperty("Fact_Acct")
	public ForeignEntityInput Fact_Acct() {
		return mFact_Acct;
	}
	/**
	 * Set Level no.
	 *
	 * @param LevelNo Level no
	 */

	public void setLevelNo(int LevelNo) {
		if (get_ID() == 0) {
			super.setLevelNo(LevelNo);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param Qty Quantity
	 */

	public void setQty(BigDecimal Qty) {
		if (get_ID() == 0) {
			super.setQty(Qty);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setT_ReportStatement_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getT_ReportStatement_UU();
	}
}
