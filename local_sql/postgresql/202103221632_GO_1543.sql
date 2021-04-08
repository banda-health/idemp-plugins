UPDATE ad_val_rule 
set code = 'AD_Ref_List.Value IN (''X'',''M'', ''B'',''N'',''F'',''i'',''G'',''H'',''O'',''P'',''U'',''V'',''C'',''D'',''K'')'
WHERE ad_val_rule_uu = '3b0ea575-a6c7-44aa-a559-9c738400de63';

SELECT register_migration_script('202103221632_GO_1543.sql') FROM dual;
