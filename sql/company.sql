DROP SEQUENCE IF EXISTS company_seq;
CREATE SEQUENCE company_seq AS integer;
drop table IF EXISTS company;
create table company (
    company_cd varchar(8) primary key,
    password varchar(16) not null,
    company_name varchar(64)  not null,
    auth char(1)  not null,
    company_url varchar(64),
    special_sales_url varchar(64),
    purapori_url varchar(64),
    email varchar(64),
    tel varchar(24),
    created_at timestamp,
    updated_at timestamp
);
COMMENT ON TABLE company is '会社';
COMMENT ON COLUMN company.company_cd is '会社CD';
COMMENT ON COLUMN company.password is 'パスワード';
COMMENT ON COLUMN company.company_name is '会社名';
COMMENT ON COLUMN company.auth is '権限';
COMMENT ON COLUMN company.company_url is '企業URL';
COMMENT ON COLUMN company.special_sales_url is '特商URL';
COMMENT ON COLUMN company.purapori_url is 'プラポリURL';
COMMENT ON COLUMN company.email is '連絡先メールアドレス';
COMMENT ON COLUMN company.tel is '連絡先電話番号';
COMMENT ON COLUMN company.created_at is '作成日';
COMMENT ON COLUMN company.updated_at is '更新日';