--temp function to create required tables for exporting config client

DO
$$
    declare
        res_count            integer     := 0;
        records              integer     := 0;
        current_rec          record;
        current_table        varchar(40);
        current_col  varchar(40);
        total_processed      integer     := 0;
        temp_table_name varchar(100);
    begin
        set search_path to adempiere, public, migration;
        for current_rec in select distinct lower(tablename) as tbl, ac.columnname as colname
                           from ad_table t
                                    join ad_column ac on ac.ad_table_id = t.ad_table_id
                           where isview = 'N'
                             and t.isactive = 'Y'
                             and t.ad_client_id is not null
                             and ac.columnname = 'AD_Client_ID'
            loop
                total_processed = total_processed + 1;
                current_table = current_rec.tbl;
                current_col = lower(current_rec.colname);
                execute format('select count(*) from %I where %I = $1', current_table,
                               current_col) into records using 2;
                raise info 'current table: %   current column: %', current_table, current_col;
                if records > 0 then
                    res_count = res_count + 1;
                    execute format('create table migration.%I as select * from %I where %I = $1',current_table, current_table, current_col) using 2;
                end if;
            end loop;
        raise info 'Total tables processed: %', total_processed;
        raise info 'Total tables with target records: %', res_count;
    end;
$$



--config client data






