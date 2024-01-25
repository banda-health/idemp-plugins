package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_POSPayment;
import org.compiere.model.X_C_POSTenderType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSPaymentInput extends X_C_POSPayment implements I_C_POSPaymentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_POSTenderType;
	private ForeignEntityInput mC_Payment;
	private I_AD_Ref_ListInput mCheckStatus;
	private I_AD_Ref_ListInput mCreditCardType;
	private I_AD_Ref_ListInput mTenderType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_POSPayment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_POSPaymentInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_POSPayment(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		if (get_ID() != 0) {
			return;
		}
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		} else {
			this.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
	}
	/**
	 * Set POS Payment.
	 *
	 * @param C_POSPayment_ID POS Payment
	 */

	public void setC_POSPayment_ID(int C_POSPayment_ID) {
		if (get_ID() == 0) {
			super.setC_POSPayment_ID(C_POSPayment_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_POSPayment_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_POSPayment_UU();
	}

	/**
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public void setC_POSTenderTypeInput(ForeignEntityInput C_POSTenderType) {
		this.mC_POSTenderType = C_POSTenderType;
		if (C_POSTenderType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_POSTenderType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_POSTenderType", "C_POSTenderType_UU=?", get_TrxName())
							.setParameters(C_POSTenderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_POSTenderType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POSTenderType with UUID " + C_POSTenderType.getUUID());
			}
		} else {
			this.setC_POSTenderType_ID(0);
		}
	}

	/**
	 * Get POS Tender Type.
	 *
	 * @return POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public ForeignEntityInput C_POSTenderType() {
		return mC_POSTenderType;
	}

	/**
	 * Set Check Status.
	 *
	 * @param CheckStatus Check Status
	 */
	@JsonProperty("CheckStatus")
	public void setCheckStatusInput(I_AD_Ref_ListInput CheckStatus) {
		this.mCheckStatus = CheckStatus;
		if (CheckStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CheckStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCheckStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CheckStatus.getUUID());
			}
		} else {
			this.setCheckStatus(null);
		}
	}

	/**
	 * Get Check Status.
	 *
	 * @return Check Status
	 */
	@JsonProperty("CheckStatus")
	public I_AD_Ref_ListInput CheckStatus() {
		return mCheckStatus;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public void setCreditCardTypeInput(I_AD_Ref_ListInput CreditCardType) {
		this.mCreditCardType = CreditCardType;
		if (CreditCardType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CreditCardType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCreditCardType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CreditCardType.getUUID());
			}
		} else {
			this.setCreditCardType(null);
		}
	}

	/**
	 * Get Credit Card.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public I_AD_Ref_ListInput CreditCardType() {
		return mCreditCardType;
	}

	/**
	 * Set Tender type.
	 *
	 * @param TenderType Method of Payment
	 */
	@JsonProperty("TenderType")
	public void setTenderTypeInput(I_AD_Ref_ListInput TenderType) {
		this.mTenderType = TenderType;
		if (TenderType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TenderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TenderType.getUUID());
			}
		} else {
			this.setTenderType(null);
		}
	}

	/**
	 * Get Tender type.
	 *
	 * @return Method of Payment
	 */
	@JsonProperty("TenderType")
	public I_AD_Ref_ListInput TenderType() {
		return mTenderType;
	}
}
