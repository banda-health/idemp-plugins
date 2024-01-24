package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQ;
import org.compiere.model.MRfQLine;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineInput extends MRfQLine implements I_C_RfQLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQ;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RfQLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRfQLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set RfQ.
	 *
	 * @param C_RfQ Request for Quotation
	 */
	@JsonProperty("C_RfQ")
	public void setC_RfQInput(ForeignEntityInput C_RfQ) {
		this.mC_RfQ = C_RfQ;
		MRfQ foreignEntity;
		if (get_ID() == 0 && C_RfQ != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQ", "C_RfQ_UU=?", get_TrxName())
						.setParameters(C_RfQ.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQ_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RfQ.
	 *
	 * @return Request for Quotation
	 */
	@JsonProperty("C_RfQ")
	public ForeignEntityInput C_RfQ() {
		return mC_RfQ;
	}
	/**
	 * Set RfQ Line.
	 *
	 * @param C_RfQLine_ID Request for Quotation Line
	 */

	public void setC_RfQLine_ID(int C_RfQLine_ID) {
		if (get_ID() == 0) {
			super.setC_RfQLine_ID(C_RfQLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RfQLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RfQLine_UU();
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			super.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
