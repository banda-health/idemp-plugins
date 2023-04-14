package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MDocType_BH;

public class DocumentType extends BaseEntity {

	private String printName;
	private String documentBaseType;
	@JsonProperty("isSalesTransaction")
	private boolean isSalesTransaction;
	private String documentSalesSubType;
	@JsonProperty("hasProforma")
	private boolean hasProforma;
	@JsonIgnore
	private int documentTypeProformaId;
	@JsonIgnore
	private int documentTypeShipmentId;
	@JsonIgnore
	private int documentTypeInvoiceId;
	@JsonProperty("isDocumentNumberControlled")
	private boolean isDocumentNumberControlled;
	@JsonIgnore
	private int documentNumberSequenceId;
	@JsonIgnore
	private int generalLedgerCategoryId;
	@JsonProperty("hasCharges")
	private boolean hasCharges;
	private String documentNote;
	@JsonProperty("isDefault")
	private boolean isDefault;
	private int documentCopies;
	@JsonIgnore
	private int printFormatId;
	@JsonProperty("isDefaultCounterDocument")
	private boolean isDefaultCounterDocument;
	@JsonProperty("isShipmentConfirm")
	private boolean isShipmentConfirm;
	@JsonProperty("isPickQAConfirm")
	private boolean isPickQAConfirm;
	@JsonProperty("isInTransit")
	private boolean isInTransit;
	@JsonProperty("isSplitWhenDifference")
	private boolean isSplitWhenDifference;
	@JsonIgnore
	private int documentTypeDifferenceId;
	@JsonProperty("isCreateCounter")
	private boolean isCreateCounter;
	@JsonProperty("isIndexed")
	private boolean isIndexed;
	@JsonProperty("isOverwriteSequenceOnComplete")
	private boolean isOverwriteSequenceOnComplete;
	@JsonIgnore
	private int definiteSequenceId;
	@JsonProperty("isOverwriteDateOnComplete")
	private boolean isOverwriteDateOnComplete;
	@JsonProperty("isPrepareSplitDocument")
	private boolean isPrepareSplitDocument;
	@JsonProperty("isChargeOrProductMandatory")
	private boolean isChargeOrProductMandatory;
	private String documentInvoiceSubType;

	public DocumentType() {}

	public DocumentType(MDocType_BH entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		setPrintName(entity.getPrintName());
		setDocumentBaseType(entity.getDocBaseType());
		setSalesTransaction(entity.isSOTrx());
		setDocumentSalesSubType(entity.getDocSubTypeSO());
		setHasProforma(entity.isHasProforma());
		setDocumentTypeProformaId(entity.getC_DocTypeProforma_ID());
		setDocumentTypeShipmentId(entity.getC_DocTypeShipment_ID());
		setDocumentTypeInvoiceId(entity.getC_DocTypeInvoice_ID());
		setDocumentNumberControlled(entity.isDocNoControlled());
		setDocumentNumberSequenceId(entity.getDocNoSequence_ID());
		setGeneralLedgerCategoryId(entity.getGL_Category_ID());
		setHasCharges(entity.isHasCharges());
		setDocumentNote(entity.getDocumentNote());
		setDefault(entity.isDefault());
		setDocumentCopies(entity.getDocumentCopies());
		setPrintFormatId(entity.getAD_PrintFormat_ID());
		setDefaultCounterDocument(entity.isDefaultCounterDoc());
		setShipmentConfirm(entity.isShipConfirm());
		setPickQAConfirm(entity.isPickQAConfirm());
		setInTransit(entity.isInTransit());
		setSplitWhenDifference(entity.isSplitWhenDifference());
		setDocumentTypeDifferenceId(entity.getC_DocTypeDifference_ID());
		setCreateCounter(entity.isCreateCounter());
		setIndexed(entity.isIndexed());
		setOverwriteSequenceOnComplete(entity.isOverwriteSeqOnComplete());
		setDefiniteSequenceId(entity.getDefiniteSequence_ID());
		setOverwriteDateOnComplete(entity.isOverwriteDateOnComplete());
		setPrepareSplitDocument(entity.isPrepareSplitDocument());
		setChargeOrProductMandatory(entity.isChargeOrProductMandatory());
		setDocumentInvoiceSubType(entity.getDocSubTypeInv());
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public String getDocumentBaseType() {
		return documentBaseType;
	}

	public void setDocumentBaseType(String documentBaseType) {
		this.documentBaseType = documentBaseType;
	}

	public boolean isSalesTransaction() {
		return isSalesTransaction;
	}

	public void setSalesTransaction(boolean salesTransaction) {
		isSalesTransaction = salesTransaction;
	}

	public String getDocumentSalesSubType() {
		return documentSalesSubType;
	}

	public void setDocumentSalesSubType(String documentSalesSubType) {
		this.documentSalesSubType = documentSalesSubType;
	}

	public boolean isHasProforma() {
		return hasProforma;
	}

	public void setHasProforma(boolean hasProforma) {
		this.hasProforma = hasProforma;
	}

	public int getDocumentTypeProformaId() {
		return documentTypeProformaId;
	}

	public void setDocumentTypeProformaId(int documentTypeProformaId) {
		this.documentTypeProformaId = documentTypeProformaId;
	}

	public int getDocumentTypeShipmentId() {
		return documentTypeShipmentId;
	}

	public void setDocumentTypeShipmentId(int documentTypeShipmentId) {
		this.documentTypeShipmentId = documentTypeShipmentId;
	}

	public int getDocumentTypeInvoiceId() {
		return documentTypeInvoiceId;
	}

	public void setDocumentTypeInvoiceId(int documentTypeInvoiceId) {
		this.documentTypeInvoiceId = documentTypeInvoiceId;
	}

	public boolean isDocumentNumberControlled() {
		return isDocumentNumberControlled;
	}

	public void setDocumentNumberControlled(boolean documentNumberControlled) {
		isDocumentNumberControlled = documentNumberControlled;
	}

	public int getDocumentNumberSequenceId() {
		return documentNumberSequenceId;
	}

	public void setDocumentNumberSequenceId(int documentNumberSequenceId) {
		this.documentNumberSequenceId = documentNumberSequenceId;
	}

	public int getGeneralLedgerCategoryId() {
		return generalLedgerCategoryId;
	}

	public void setGeneralLedgerCategoryId(int generalLedgerCategoryId) {
		this.generalLedgerCategoryId = generalLedgerCategoryId;
	}

	public boolean isHasCharges() {
		return hasCharges;
	}

	public void setHasCharges(boolean hasCharges) {
		this.hasCharges = hasCharges;
	}

	public String getDocumentNote() {
		return documentNote;
	}

	public void setDocumentNote(String documentNote) {
		this.documentNote = documentNote;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean aDefault) {
		isDefault = aDefault;
	}

	public int getDocumentCopies() {
		return documentCopies;
	}

	public void setDocumentCopies(int documentCopies) {
		this.documentCopies = documentCopies;
	}

	public int getPrintFormatId() {
		return printFormatId;
	}

	public void setPrintFormatId(int printFormatId) {
		this.printFormatId = printFormatId;
	}

	public boolean isDefaultCounterDocument() {
		return isDefaultCounterDocument;
	}

	public void setDefaultCounterDocument(boolean defaultCounterDocument) {
		isDefaultCounterDocument = defaultCounterDocument;
	}

	public boolean isShipmentConfirm() {
		return isShipmentConfirm;
	}

	public void setShipmentConfirm(boolean shipmentConfirm) {
		isShipmentConfirm = shipmentConfirm;
	}

	public boolean isPickQAConfirm() {
		return isPickQAConfirm;
	}

	public void setPickQAConfirm(boolean pickQAConfirm) {
		isPickQAConfirm = pickQAConfirm;
	}

	public boolean isInTransit() {
		return isInTransit;
	}

	public void setInTransit(boolean inTransit) {
		isInTransit = inTransit;
	}

	public boolean isSplitWhenDifference() {
		return isSplitWhenDifference;
	}

	public void setSplitWhenDifference(boolean splitWhenDifference) {
		isSplitWhenDifference = splitWhenDifference;
	}

	public int getDocumentTypeDifferenceId() {
		return documentTypeDifferenceId;
	}

	public void setDocumentTypeDifferenceId(int documentTypeDifferenceId) {
		this.documentTypeDifferenceId = documentTypeDifferenceId;
	}

	public boolean isCreateCounter() {
		return isCreateCounter;
	}

	public void setCreateCounter(boolean createCounter) {
		isCreateCounter = createCounter;
	}

	public boolean isIndexed() {
		return isIndexed;
	}

	public void setIndexed(boolean indexed) {
		isIndexed = indexed;
	}

	public boolean isOverwriteSequenceOnComplete() {
		return isOverwriteSequenceOnComplete;
	}

	public void setOverwriteSequenceOnComplete(boolean overwriteSequenceOnComplete) {
		isOverwriteSequenceOnComplete = overwriteSequenceOnComplete;
	}

	public int getDefiniteSequenceId() {
		return definiteSequenceId;
	}

	public void setDefiniteSequenceId(int definiteSequenceId) {
		this.definiteSequenceId = definiteSequenceId;
	}

	public boolean isOverwriteDateOnComplete() {
		return isOverwriteDateOnComplete;
	}

	public void setOverwriteDateOnComplete(boolean overwriteDateOnComplete) {
		isOverwriteDateOnComplete = overwriteDateOnComplete;
	}

	public boolean isPrepareSplitDocument() {
		return isPrepareSplitDocument;
	}

	public void setPrepareSplitDocument(boolean prepareSplitDocument) {
		isPrepareSplitDocument = prepareSplitDocument;
	}

	public boolean isChargeOrProductMandatory() {
		return isChargeOrProductMandatory;
	}

	public void setChargeOrProductMandatory(boolean chargeOrProductMandatory) {
		isChargeOrProductMandatory = chargeOrProductMandatory;
	}

	public String getDocumentInvoiceSubType() {
		return documentInvoiceSubType;
	}

	public void setDocumentInvoiceSubType(String documentInvoiceSubType) {
		this.documentInvoiceSubType = documentInvoiceSubType;
	}
}
