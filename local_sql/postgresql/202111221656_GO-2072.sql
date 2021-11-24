-- Use uuid field to make updates to the table ad_process_para

UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = '0b922348-805b-4ea2-b5c9-8f8dc39e2d7e' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = '769960e6-cc8c-4ecb-839f-29d04ec061e5' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = 'f6b47abf-15a1-4e90-a9fc-fe460b92e179' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = '6e37f9e4-8007-4428-a272-b61fb38e7e03' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = '8e6060e3-245c-4bad-ba26-7d24e65f4367' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE ad_process_para_uu = 'dc5bffab-ca3d-400c-a8dd-c3b51644d489' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');

SELECT register_migration_script('202111221656_GO-2072.sql') FROM dual;