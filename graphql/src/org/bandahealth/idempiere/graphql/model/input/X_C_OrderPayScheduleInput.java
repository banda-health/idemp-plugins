package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderPaySchedule;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySchedule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderPayScheduleInput extends MOrderPaySchedule implements I_C_OrderPayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_PaySchedule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_OrderPayScheduleInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MOrderPaySchedule(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
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
	 * Set Order Payment Schedule.
	 *
	 * @param C_OrderPaySchedule_ID Order Payment Schedule
	 */

	public void setC_OrderPaySchedule_ID(int C_OrderPaySchedule_ID) {
		if (get_ID() == 0) {
			super.setC_OrderPaySchedule_ID(C_OrderPaySchedule_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_OrderPaySchedule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_OrderPaySchedule_UU();
	}

	/**
	 * Set Payment Schedule.
	 *
	 * @param C_PaySchedule Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public void setC_PayScheduleInput(ForeignEntityInput C_PaySchedule) {
		this.mC_PaySchedule = C_PaySchedule;
		MPaySchedule foreignEntity;
		if (get_ID() == 0 && C_PaySchedule != null &&
				(foreignEntity = new Query(getCtx(), "C_PaySchedule", "C_PaySchedule_UU=?", get_TrxName())
						.setParameters(C_PaySchedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaySchedule_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payment Schedule.
	 *
	 * @return Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public ForeignEntityInput C_PaySchedule() {
		return mC_PaySchedule;
	}
}
