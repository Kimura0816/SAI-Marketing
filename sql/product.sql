drop table IF EXISTS product;
create TABLE product (
    product_cd serial primary key,
    product_nm varchar(80),
    sales_company_cd varchar(8),
    price integer,
    payment_period integer,
    surl varchar(64),
    agreement_url varchar(64),
    cooling_off_period_explanation varchar(256),
    cooling_off_period_url varchar(64),
    disp_address char default '0',
    disp_nm char default '0',
    disp_age char default '0',
    disp_job char default '0',
    disp_tel char default '0',
    disp_email char default '0',
    created_at timestamp,
    updated_at timestamp
);

COMMENT ON TABLE product is '商材';
COMMENT ON COLUMN product.product_cd is '商材CD';
COMMENT ON COLUMN product.product_nm is '商材名';
COMMENT ON COLUMN product.sales_company_cd is '販売会社コード';
COMMENT ON COLUMN product.price is '販売価格';
COMMENT ON COLUMN product.payment_period is '支払期間（日）';
COMMENT ON COLUMN product.surl is 'SLURL（セールスレター）';
COMMENT ON COLUMN product.agreement_url is '規約URL';
COMMENT ON COLUMN product.cooling_off_period_explanation is 'クーリングオフ説明';
COMMENT ON COLUMN product.cooling_off_period_url is 'クーリングオフページURL';
COMMENT ON COLUMN product.disp_address is '住所確認';
COMMENT ON COLUMN product.disp_nm is '氏名確認';
COMMENT ON COLUMN product.disp_age is '年齢確認';
COMMENT ON COLUMN product.disp_job is '職業確認';
COMMENT ON COLUMN product.disp_tel is '電話番号確認';
COMMENT ON COLUMN product.disp_email is 'メール確認';
COMMENT ON COLUMN product.created_at is '作成日';
COMMENT ON COLUMN product.updated_at is '更新日';