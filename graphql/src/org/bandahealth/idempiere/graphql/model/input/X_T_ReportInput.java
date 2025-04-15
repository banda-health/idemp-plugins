package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MFactAcct;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.compiere.model.X_T_Report;
import org.compiere.report.MReportLine;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_ReportInput extends X_T_Report implements I_T_ReportInput {

	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mFact_Acct;
	private ForeignEntityInput mPA_ReportLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The T_Report_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_T_ReportInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		if (get_ID() != 0) {
			return;
		}
		if (AD_PInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MPInstance foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
							.setParameters(AD_PInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PInstance with UU " + AD_PInstance.getUU());
			}
		} else {
			this.setAD_PInstance_ID(0);
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
	 * Set Col_0.
	 *
	 * @param Col_0 Col_0
	 */
	@JsonProperty("Col_0")
	public void setCol_0FromJson(BigDecimal Col_0) {
		if (get_ID() == 0) {
			super.setCol_0(Col_0);
		}
	}
	/**
	 * Set Col_1.
	 *
	 * @param Col_1 Col_1
	 */
	@JsonProperty("Col_1")
	public void setCol_1FromJson(BigDecimal Col_1) {
		if (get_ID() == 0) {
			super.setCol_1(Col_1);
		}
	}
	/**
	 * Set Col_10.
	 *
	 * @param Col_10 Col_10
	 */
	@JsonProperty("Col_10")
	public void setCol_10FromJson(BigDecimal Col_10) {
		if (get_ID() == 0) {
			super.setCol_10(Col_10);
		}
	}
	/**
	 * Set Col_11.
	 *
	 * @param Col_11 Col_11
	 */
	@JsonProperty("Col_11")
	public void setCol_11FromJson(BigDecimal Col_11) {
		if (get_ID() == 0) {
			super.setCol_11(Col_11);
		}
	}
	/**
	 * Set Col_12.
	 *
	 * @param Col_12 Col_12
	 */
	@JsonProperty("Col_12")
	public void setCol_12FromJson(BigDecimal Col_12) {
		if (get_ID() == 0) {
			super.setCol_12(Col_12);
		}
	}
	/**
	 * Set Col_13.
	 *
	 * @param Col_13 Col_13
	 */
	@JsonProperty("Col_13")
	public void setCol_13FromJson(BigDecimal Col_13) {
		if (get_ID() == 0) {
			super.setCol_13(Col_13);
		}
	}
	/**
	 * Set Col_14.
	 *
	 * @param Col_14 Col_14
	 */
	@JsonProperty("Col_14")
	public void setCol_14FromJson(BigDecimal Col_14) {
		if (get_ID() == 0) {
			super.setCol_14(Col_14);
		}
	}
	/**
	 * Set Col_15.
	 *
	 * @param Col_15 Col_15
	 */
	@JsonProperty("Col_15")
	public void setCol_15FromJson(BigDecimal Col_15) {
		if (get_ID() == 0) {
			super.setCol_15(Col_15);
		}
	}
	/**
	 * Set Col_16.
	 *
	 * @param Col_16 Col_16
	 */
	@JsonProperty("Col_16")
	public void setCol_16FromJson(BigDecimal Col_16) {
		if (get_ID() == 0) {
			super.setCol_16(Col_16);
		}
	}
	/**
	 * Set Col_17.
	 *
	 * @param Col_17 Col_17
	 */
	@JsonProperty("Col_17")
	public void setCol_17FromJson(BigDecimal Col_17) {
		if (get_ID() == 0) {
			super.setCol_17(Col_17);
		}
	}
	/**
	 * Set Col_18.
	 *
	 * @param Col_18 Col_18
	 */
	@JsonProperty("Col_18")
	public void setCol_18FromJson(BigDecimal Col_18) {
		if (get_ID() == 0) {
			super.setCol_18(Col_18);
		}
	}
	/**
	 * Set Col_19.
	 *
	 * @param Col_19 Col_19
	 */
	@JsonProperty("Col_19")
	public void setCol_19FromJson(BigDecimal Col_19) {
		if (get_ID() == 0) {
			super.setCol_19(Col_19);
		}
	}
	/**
	 * Set Col_2.
	 *
	 * @param Col_2 Col_2
	 */
	@JsonProperty("Col_2")
	public void setCol_2FromJson(BigDecimal Col_2) {
		if (get_ID() == 0) {
			super.setCol_2(Col_2);
		}
	}
	/**
	 * Set Col_20.
	 *
	 * @param Col_20 Col_20
	 */
	@JsonProperty("Col_20")
	public void setCol_20FromJson(BigDecimal Col_20) {
		if (get_ID() == 0) {
			super.setCol_20(Col_20);
		}
	}
	/**
	 * Set Col_21.
	 *
	 * @param Col_21 Col_21
	 */
	@JsonProperty("Col_21")
	public void setCol_21FromJson(BigDecimal Col_21) {
		if (get_ID() == 0) {
			super.setCol_21(Col_21);
		}
	}
	/**
	 * Set Col_22.
	 *
	 * @param Col_22 Col_22
	 */
	@JsonProperty("Col_22")
	public void setCol_22FromJson(BigDecimal Col_22) {
		if (get_ID() == 0) {
			super.setCol_22(Col_22);
		}
	}
	/**
	 * Set Col_23.
	 *
	 * @param Col_23 Col_23
	 */
	@JsonProperty("Col_23")
	public void setCol_23FromJson(BigDecimal Col_23) {
		if (get_ID() == 0) {
			super.setCol_23(Col_23);
		}
	}
	/**
	 * Set Col_24.
	 *
	 * @param Col_24 Col_24
	 */
	@JsonProperty("Col_24")
	public void setCol_24FromJson(BigDecimal Col_24) {
		if (get_ID() == 0) {
			super.setCol_24(Col_24);
		}
	}
	/**
	 * Set Col_25.
	 *
	 * @param Col_25 Col_25
	 */
	@JsonProperty("Col_25")
	public void setCol_25FromJson(BigDecimal Col_25) {
		if (get_ID() == 0) {
			super.setCol_25(Col_25);
		}
	}
	/**
	 * Set Col_26.
	 *
	 * @param Col_26 Col_26
	 */
	@JsonProperty("Col_26")
	public void setCol_26FromJson(BigDecimal Col_26) {
		if (get_ID() == 0) {
			super.setCol_26(Col_26);
		}
	}
	/**
	 * Set Col_27.
	 *
	 * @param Col_27 Col_27
	 */
	@JsonProperty("Col_27")
	public void setCol_27FromJson(BigDecimal Col_27) {
		if (get_ID() == 0) {
			super.setCol_27(Col_27);
		}
	}
	/**
	 * Set Col_28.
	 *
	 * @param Col_28 Col_28
	 */
	@JsonProperty("Col_28")
	public void setCol_28FromJson(BigDecimal Col_28) {
		if (get_ID() == 0) {
			super.setCol_28(Col_28);
		}
	}
	/**
	 * Set Col_29.
	 *
	 * @param Col_29 Col_29
	 */
	@JsonProperty("Col_29")
	public void setCol_29FromJson(BigDecimal Col_29) {
		if (get_ID() == 0) {
			super.setCol_29(Col_29);
		}
	}
	/**
	 * Set Col_3.
	 *
	 * @param Col_3 Col_3
	 */
	@JsonProperty("Col_3")
	public void setCol_3FromJson(BigDecimal Col_3) {
		if (get_ID() == 0) {
			super.setCol_3(Col_3);
		}
	}
	/**
	 * Set Col_30.
	 *
	 * @param Col_30 Col_30
	 */
	@JsonProperty("Col_30")
	public void setCol_30FromJson(BigDecimal Col_30) {
		if (get_ID() == 0) {
			super.setCol_30(Col_30);
		}
	}
	/**
	 * Set Col_4.
	 *
	 * @param Col_4 Col_4
	 */
	@JsonProperty("Col_4")
	public void setCol_4FromJson(BigDecimal Col_4) {
		if (get_ID() == 0) {
			super.setCol_4(Col_4);
		}
	}
	/**
	 * Set Col_5.
	 *
	 * @param Col_5 Col_5
	 */
	@JsonProperty("Col_5")
	public void setCol_5FromJson(BigDecimal Col_5) {
		if (get_ID() == 0) {
			super.setCol_5(Col_5);
		}
	}
	/**
	 * Set Col_6.
	 *
	 * @param Col_6 Col_6
	 */
	@JsonProperty("Col_6")
	public void setCol_6FromJson(BigDecimal Col_6) {
		if (get_ID() == 0) {
			super.setCol_6(Col_6);
		}
	}
	/**
	 * Set Col_7.
	 *
	 * @param Col_7 Col_7
	 */
	@JsonProperty("Col_7")
	public void setCol_7FromJson(BigDecimal Col_7) {
		if (get_ID() == 0) {
			super.setCol_7(Col_7);
		}
	}
	/**
	 * Set Col_8.
	 *
	 * @param Col_8 Col_8
	 */
	@JsonProperty("Col_8")
	public void setCol_8FromJson(BigDecimal Col_8) {
		if (get_ID() == 0) {
			super.setCol_8(Col_8);
		}
	}
	/**
	 * Set Col_9.
	 *
	 * @param Col_9 Col_9
	 */
	@JsonProperty("Col_9")
	public void setCol_9FromJson(BigDecimal Col_9) {
		if (get_ID() == 0) {
			super.setCol_9(Col_9);
		}
	}
	/**
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */
	@JsonProperty("Description")
	public void setDescriptionFromJson(String Description) {
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
		if (get_ID() != 0) {
			return;
		}
		if (Fact_Acct != null) {
			// Since an entity was passed, make sure it's in the DB
			MFactAcct foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
							.setParameters(Fact_Acct.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFact_Acct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table Fact_Acct with UU " + Fact_Acct.getUU());
			}
		} else {
			this.setFact_Acct_ID(0);
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
	@JsonProperty("LevelNo")
	public void setLevelNoFromJson(int LevelNo) {
		if (get_ID() == 0) {
			super.setLevelNo(LevelNo);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */
	@JsonProperty("Name")
	public void setNameFromJson(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}

	/**
	 * Set Report Line.
	 *
	 * @param PA_ReportLine Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public void setPA_ReportLineInput(ForeignEntityInput PA_ReportLine) {
		this.mPA_ReportLine = PA_ReportLine;
		if (get_ID() != 0) {
			return;
		}
		if (PA_ReportLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
							.setParameters(PA_ReportLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_ReportLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLine with UU " + PA_ReportLine.getUU());
			}
		} else {
			this.setPA_ReportLine_ID(0);
		}
	}

	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public ForeignEntityInput PA_ReportLine() {
		return mPA_ReportLine;
	}
	/**
	 * Set Sequence.
	 *
	 * @param SeqNo Method of ordering records; lowest number comes first
	 */
	@JsonProperty("SeqNo")
	public void setSeqNoFromJson(int SeqNo) {
		if (get_ID() == 0) {
			super.setSeqNo(SeqNo);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setT_Report_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getT_Report_UU();
	}
}
