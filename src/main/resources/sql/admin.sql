-- 用户表
create table admin_user (
  id int(11) unsigned not null auto_increment comment '主键',
  user_name varchar(30) not null default '' comment '用户名',
  password varchar(100) not null default '' comment '密码',
  email varchar(100) not null default '' comment '邮箱',
  mobile char(11) not null default '' comment '手机号',
  status tinyint not null default 0 comment '状态（0：新建，1：正常，2：无效)',
  operator_id int(11) unsigned not null auto_increment comment '操作人',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default '0000-00-00 00:00:00' comment '更新时间',
  primary key (id),
  unique key uidx_user_name (user_name)
) engine=innodb default charset=utf8 comment='用户表';

-- 角色组
create table role_group(
	id int(11) unsigned not null auto_increment comment '主键',
	group_name varchar(50) not null default '' comment '角色组名称',
	group_desc varchar(200) not null default '' comment '角色组描述',
	primary key(id),
)engine=innodb default charset=utf8 comment='权限表';

insert into role_group (group_code,group_name,group_desc,create_time) values(1,'超级管理员','超级管理员');

-- 角色表
create table role(
	id int(11) unsigned not null auto_increment comment '主键',
	group_id int(11) unsigned not null default 0 comment '角色组ID',
	role_name varchar(50) not null default '' comment '角色名称',
	role_desc varchar(200) not null default '' comment '角色描述',
	primary key(id),
	index idx_groupcode(group_code)
)engine=innodb default charset=utf8 comment='角色表';


-- 权限表
create table auth(
	id int(11) unsigned not null auto_increment comment '主键',
	auth_name varchar(50) not null default '' comment '权限名称',
	auth_url varchar(200) not null default '' comment '可执行url',
	auth_desc varchar(200) not null default '' comment '权限描述',
	primary key(id),
	index idx_url(auth_url)
)engine=innodb default charset=utf8 comment='权限表';

-- 角色权限表
create table role_auth(
	id int(11) unsigned not null auto_increment comment '主键',
	role_id int(11) unsigned not null default 0 comment '角色ID',
	auth_id int(11) unsigned not null default 0 comment '权限ID',
	primary key (id),
	index idx_roleid_authid(role_id,auth_id)
)engine=innodb default charset=utf8 comment='角色权限表';

-- 用户角色
create table user_role(
	id int(11) unsigned not null auto_increment comment '主键',
	user_id int(11) unsigned not null auto_increment comment '用户ID',
	group_id int(11) unsigned not null default 0 comment '角色组ID',
	role_id int(11) unsigned not null default 0 comment '角色ID',
	operator_id timestamp not null default 0 comment '操作人',
	create_time timestamp not null default current_timestamp comment '创建时间',
	primary key (id),
	index idx_userid_roleid(user_id,role_id)
)engine=innodb default charset=utf8 comment='用户角色表';



