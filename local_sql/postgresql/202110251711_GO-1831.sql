-- Rename some parameters (they're somehow already in PROD...)
UPDATE ad_process_para SET name = 'Coded Diagnosis', description = 'Coded Diagnosis' WHERE ad_process_para_uu = '250d4efb-e958-4ef6-95cf-4d23b10f0972';
UPDATE ad_process_para SET name = 'Uncoded Diagnosis', description = 'Uncoded Diagnosis' WHERE ad_process_para_uu = '3b9e7e1e-cb86-4835-89ae-0c14e6f1b1b7';

SELECT register_migration_script('202110251711_GO-1831.sql') FROM dual;
