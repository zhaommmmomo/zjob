create database if not exists `zjob` default character set utf8mb4 collate utf8mb4_unicode_ci;

use `zjob`;

create table if not exists `z_job`(
    id bigint primary key auto_increment,
    type varchar(16),
    state tinyint(1)
) engine=InnoDB default charset=utf8mb4;