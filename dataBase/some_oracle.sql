-- 设置数据库表的唯一主键 可以使用函数sys_guid()
-- 在oracle8i以后提供了一个生成不重复的数据的一个函数sys_guid()一共32位，生成的依据主要是时间和机器码，具有世界唯一性，类似于java中的UUID（都是世界唯一的）
create table GXDS_SBZS_PDF
(
  pdfid       VARCHAR2(32) default sys_guid() not null, -- 主键
  ...
)

-- 删除表 查询表
drop table NF_ECM.YDBS_SBZS_PDF
select * from all_tables where table_name like '%xxxx'

-- 生成表的同义词的语句(表名1和表名2保持一致)
create public synonym 表名1 for 用户.表名2