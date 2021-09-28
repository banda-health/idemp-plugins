-- Deactivate fields already automated fields for new client setup

UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Organization Name' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Administrative User Name' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Org Key' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Administrative User Email' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Normal User Name' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');
UPDATE ad_process_para SET isactive = 'N' WHERE name = 'Normal User Email' AND ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b6ad401a-b8e0-465e-8ffb-1d5485b96efd');

SELECT register_migration_script('202109071653_GO-1789.sql') FROM dual;