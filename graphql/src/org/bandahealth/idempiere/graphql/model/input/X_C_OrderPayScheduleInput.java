package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderPaySchedule;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySchedule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderPayScheduleInput extends MOrderPaySchedule implements I_C_OrderPayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_PaySchedule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderPaySchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderPayScheduleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MOrderPaySchedule(null, (ResultSet) null, null),
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_OrderPaySchedule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_PaySchedule != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySchedule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySchedule", "C_PaySchedule_UU=?", get_TrxName())
							.setParameters(C_PaySchedule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaySchedule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySchedule with UUID " + C_PaySchedule.getUUID());
			}
		} else {
			this.setC_PaySchedule_ID(0);
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
