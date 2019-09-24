/*
 Navicat Premium Data Transfer

 Source Server         : postgresql@localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 110002
 Source Host           : localhost:5432
 Source Catalog        : shorturl
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110002
 File Encoding         : 65001

 Date: 23/09/2019 17:50:15
*/


-- ----------------------------
-- Table structure for zd_shorturl
-- ----------------------------
DROP TABLE IF EXISTS "public"."zd_shorturl";
CREATE TABLE "public"."zd_shorturl" (
  "id" int4 NOT NULL DEFAULT nextval('"ZD_ShortUrl_id_seq"'::regclass),
  "short_code" varchar(50) COLLATE "pg_catalog"."default",
  "url" varchar(1000) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" date
)
;
COMMENT ON COLUMN "public"."zd_shorturl"."id" IS 'id';
COMMENT ON COLUMN "public"."zd_shorturl"."short_code" IS '短网址标记';
COMMENT ON COLUMN "public"."zd_shorturl"."url" IS '原始网址';
COMMENT ON COLUMN "public"."zd_shorturl"."create_time" IS '创建时间';

-- ----------------------------
-- Primary Key structure for table zd_shorturl
-- ----------------------------
ALTER TABLE "public"."zd_shorturl" ADD CONSTRAINT "ZD_ShortUrl_pkey" PRIMARY KEY ("id");
