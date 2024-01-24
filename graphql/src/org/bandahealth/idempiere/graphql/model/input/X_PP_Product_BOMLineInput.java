package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOMLineInput extends MPPProductBOMLine implements I_PP_Product_BOMLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mPP_Product_BOM;
	private I_AD_Ref_ListInput mComponentType;
	private I_AD_Ref_ListInput mIssueMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_Product_BOMLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPPProductBOMLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
	}

	/**
	 * Set Component Type.
	 *
	 * @param ComponentType Component Type for a Bill of Material or Formula
	 */
	@JsonProperty("ComponentType")
	public void setComponentTypeInput(I_AD_Ref_ListInput ComponentType) {
		this.mComponentType = ComponentType;
		MRefList_BH foreignEntity;
		if (ComponentType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ComponentType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setComponentType(foreignEntity.getValue());
		} else {
			this.setComponentType(null);
		}
	}

	/**
	 * Get Component Type.
	 *
	 * @return Component Type for a Bill of Material or Formula
	 */
	@JsonProperty("ComponentType")
	public I_AD_Ref_ListInput ComponentType() {
		return mComponentType;
	}

	/**
	 * Set Issue Method.
	 *
	 * @param IssueMethod There are two methods for issue the components to Manufacturing Order
	 */
	@JsonProperty("IssueMethod")
	public void setIssueMethodInput(I_AD_Ref_ListInput IssueMethod) {
		this.mIssueMethod = IssueMethod;
		MRefList_BH foreignEntity;
		if (IssueMethod != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IssueMethod.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIssueMethod(foreignEntity.getValue());
		} else {
			this.setIssueMethod(null);
		}
	}

	/**
	 * Get Issue Method.
	 *
	 * @return There are two methods for issue the components to Manufacturing Order
	 */
	@JsonProperty("IssueMethod")
	public I_AD_Ref_ListInput IssueMethod() {
		return mIssueMethod;
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
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		MChangeNotice foreignEntity;
		if (M_ChangeNotice != null &&
				(foreignEntity = new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
						.setParameters(M_ChangeNotice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ChangeNotice_ID(foreignEntity.get_ID());
		} else {
			super.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public ForeignEntityInput M_ChangeNotice() {
		return mM_ChangeNotice;
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

	/**
	 * Set BOM & Formula.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM) {
		this.mPP_Product_BOM = PP_Product_BOM;
		MPPProductBOM foreignEntity;
		if (get_ID() == 0 && PP_Product_BOM != null &&
				(foreignEntity = new Query(getCtx(), "PP_Product_BOM", "PP_Product_BOM_UU=?", get_TrxName())
						.setParameters(PP_Product_BOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Product_BOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public ForeignEntityInput PP_Product_BOM() {
		return mPP_Product_BOM;
	}
	/**
	 * Set BOM Line.
	 *
	 * @param PP_Product_BOMLine_ID BOM Line
	 */

	public void setPP_Product_BOMLine_ID(int PP_Product_BOMLine_ID) {
		if (get_ID() == 0) {
			super.setPP_Product_BOMLine_ID(PP_Product_BOMLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Product_BOMLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Product_BOMLine_UU();
	}
}
