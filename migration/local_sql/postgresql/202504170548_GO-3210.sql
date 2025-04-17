-- Try to speed up order line deletes with an index on a new(er) column
CREATE INDEX c_orderline_ref_idx ON c_orderline (ref_orderline_id);
CREATE INDEX corderline_mcostdetail_idx ON m_costdetail (c_orderline_id);
CREATE INDEX adwfactivity_table_record_idx ON ad_wf_activity (ad_table_id, record_id);
CREATE INDEX adwfeventaudit_table_record_idx ON ad_wf_eventaudit (ad_table_id, record_id);
CREATE INDEX adwfprocess_table_record_idx ON ad_wf_process (ad_table_id, record_id);
CREATE INDEX cpayment_adclient_idx ON c_payment (ad_client_id);
CREATE INDEX cinvoice_adclient_idx ON c_invoice (ad_client_id);
CREATE INDEX minout_adclient_idx ON m_inout (ad_client_id);
CREATE INDEX corder_adclient_idx ON c_order (ad_client_id);
-- Deleting payments
CREATE INDEX reversal_cpayment_idx ON c_payment (reversal_id);
CREATE INDEX refpayment_cpayment_idx ON c_payment (ref_payment_id);
CREATE INDEX cpayment_corder_idx ON c_order (c_payment_id);
CREATE INDEX cpayment_cinvoice_idx ON c_invoice (c_payment_id);
-- Invoice lines
CREATE INDEX mcostdetail_cinvoiceline_idx ON m_costdetail (c_invoiceline_id);
CREATE INDEX cinvoiceline_ref_idx ON c_invoiceline (ref_invoiceline_id);

SELECT
	register_migration_script('202504170548_GO-3210.sql')
FROM
	dual;
