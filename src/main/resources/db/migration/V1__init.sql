drop table if exists year_balance cascade;

drop table if exists month_balance;
create table year_balance (
                              expenses numeric(38,2),
                              incomes numeric(38,2),
                              salary numeric(38,2),
                              year integer not null,
                              id uuid not null,
                              primary key (id)
);

create table month_balance (
                               expenses numeric(38,2),
                               incomes numeric(38,2),
                               month smallint not null check (month between 0 and 11),
                               salary numeric(38,2),
                               id uuid not null,
                               year_balance_id uuid,
                               primary key (id)
)