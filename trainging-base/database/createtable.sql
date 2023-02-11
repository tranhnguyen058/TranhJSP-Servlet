use test2;
Create table role(
	id bigint NOT NULL primary key auto_increment,
    name	varchar(255) NOT NULL,
    code	varchar(255) Not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null

);
create table User(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    password varchar(255) not null,
    fullname varchar(255) not null,
	status int not null,
    roleid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null


);
Alter table user add constraint fk_user_role foreign key (roleid) references role(id);
create table news(
	id bigint not null primary key auto_increment,
	title varchar(255)  null,
    thumbnail varchar(255)  null,
    shortdescription text  null,
    categoryid bigint not null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null


);
create table category(
	id bigint not null primary key auto_increment,
	name	varchar(255) NOT NULL,
    code	varchar(255) NOT null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null


);
Alter table news add constraint fk_news_cat foreign key (categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
	content	text NOT NULL,
    user_id bigint not null,
    new_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null


);
Alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
Alter table comment add constraint fk_comment_news foreign key (new_id) references news(id);