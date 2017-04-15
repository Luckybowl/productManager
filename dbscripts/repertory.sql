/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/14 15:39:49                           */
/*==============================================================*/
drop database repertory exists repertory;

CREATE DATABASE repertory DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; 

drop table if exists Product;

drop table if exists ProductTagRelation;

drop table if exists Tag;

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   productId            bigint not null,
   productName          varchar(64) not null,
   productDesc          varchar(256),
   productPrice         float not null,
   productTotal         int,
   productRest          int,
   productRebate        float,
   productClickCounts   bigint,
   productPicturePath   varchar(64),
   primary key (productId)
);

/*==============================================================*/
/* Table: ProductTagRelation                                    */
/*==============================================================*/
create table ProductTagRelation
(
   productId            bigint not null,
   categoryIdId                bigint not null,
   primary key (productId, categoryId)
);

/*==============================================================*/
/* Table: Tag                                                   */
/*==============================================================*/
create table Category
(
   categoryId                bigint not null,
   categoryName              varchar(64) not null,
   categoryParentId          bigint,
   primary key (tagId)
);

