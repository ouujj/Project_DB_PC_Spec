CREATE TABLE  "CASE" 
   (	"C_BRAND" VARCHAR2(100) NOT NULL ENABLE, 
	"C_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"SUPPORT" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"C_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(100), 
	 CONSTRAINT "CASE_PK" PRIMARY KEY ("C_NAME") ENABLE
   ) ;
CREATE TABLE  "COOLER" 
   (	"CO_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"CO_TYPE" VARCHAR2(100) NOT NULL ENABLE, 
	"CO_SUPPORT" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "COOLER_PK" PRIMARY KEY ("CO_NAME") ENABLE
   ) ;
CREATE TABLE  "CPU" 
   (	"CPU_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"CPU_DATA" VARCHAR2(150), 
	"CPU_SOCKET" VARCHAR2(100) NOT NULL ENABLE, 
	"SPEED" VARCHAR2(50), 
	"CORE/THREAD" VARCHAR2(50), 
	"IMAGE" VARCHAR2(100), 
	 CONSTRAINT "CPU_PK" PRIMARY KEY ("CPU_NAME") ENABLE
   ) ;
CREATE TABLE  "HDD" 
   (	"HDD_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"CAPACITY" VARCHAR2(100) NOT NULL ENABLE, 
	"HDD_BARN" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"HDD_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "HDD_PK" PRIMARY KEY ("HDD_NAME") ENABLE
   ) ;
CREATE TABLE  "HDD" 
   (	"HDD_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"CAPACITY" VARCHAR2(100) NOT NULL ENABLE, 
	"HDD_BARN" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"HDD_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "HDD_PK" PRIMARY KEY ("HDD_NAME") ENABLE
   ) ;
CREATE TABLE  "MB" 
   (	"MB_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"CHIPSET" VARCHAR2(25) NOT NULL ENABLE, 
	"MB_TYPE" VARCHAR2(25) NOT NULL ENABLE, 
	"MB_BRAND" VARCHAR2(25) NOT NULL ENABLE, 
	"MB_SOCKET" VARCHAR2(25) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"MB_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "MB_PK" PRIMARY KEY ("MB_NAME") ENABLE
   ) ;
CREATE TABLE  "MONITOR" 
   (	"MO_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"MO_SIZE" NUMBER NOT NULL ENABLE, 
	"MO_PA_TYPE" VARCHAR2(100) NOT NULL ENABLE, 
	"MO_RESO" VARCHAR2(25) NOT NULL ENABLE, 
	"MO_DATA" VARCHAR2(150), 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "MONITOR_PK" PRIMARY KEY ("MO_NAME") ENABLE
   ) ;
CREATE TABLE  "PSU" 
   (	"STANDARD" VARCHAR2(100) NOT NULL ENABLE, 
	"PSU_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"MAX_POW" VARCHAR2(20) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"PSU_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "PSU_PK" PRIMARY KEY ("PSU_NAME") ENABLE
   ) ;
CREATE TABLE  "RAM" 
   (	"RAM_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"RAM_TYPE" VARCHAR2(25) NOT NULL ENABLE, 
	"RAM_CAPA" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"RAM_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "RAM_PK" PRIMARY KEY ("RAM_NAME") ENABLE
   ) ;
CREATE TABLE  "SSD" 
   (	"SSD_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"SSD_CAPA" VARCHAR2(100) NOT NULL ENABLE, 
	"SPEED" VARCHAR2(100) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"SSD_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(100), 
	 CONSTRAINT "SSD_PK" PRIMARY KEY ("SSD_NAME") ENABLE
   ) ;
CREATE TABLE  "VGA" 
   (	"VGA_NAME" VARCHAR2(250) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"VGA_DATA" VARCHAR2(150), 
	"IMAGE" VARCHAR2(250), 
	 CONSTRAINT "VGA_PK" PRIMARY KEY ("VGA_NAME") ENABLE
   ) ;
CREATE TABLE  "USER_SPEC" 
   (	"USER_ID" VARCHAR2(15) NOT NULL ENABLE, 
	"USER_NAME" VARCHAR2(30) NOT NULL ENABLE, 
	"USER_PASS" VARCHAR2(15) NOT NULL ENABLE, 
	 CONSTRAINT "USER_PK" PRIMARY KEY ("USER_ID") ENABLE
   ) ;
CREATE TABLE  "SPEC" 
   (	"USER_ID" VARCHAR2(15) NOT NULL ENABLE, 
	"SPEC_ID" VARCHAR2(15) NOT NULL ENABLE, 
	"TIME" VARCHAR2(50) NOT NULL ENABLE, 
	"PRICE" NUMBER, 
	"CPU" VARCHAR2(200), 
	"VGA" VARCHAR2(250), 
	"RAM" VARCHAR2(250), 
	"MB" VARCHAR2(250), 
	"CASE" VARCHAR2(250), 
	"HDD" VARCHAR2(250), 
	"SSD" VARCHAR2(250), 
	"M2" VARCHAR2(250), 
	"PSU" VARCHAR2(250), 
	"COOLER" VARCHAR2(250), 
	"MONITOR" VARCHAR2(250), 
	 CONSTRAINT "SPEC_PK" PRIMARY KEY ("SPEC_ID") ENABLE
   ) ;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES  "USER_SPEC" ("USER_ID") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK10" FOREIGN KEY ("COOLER")
	  REFERENCES  "COOLER" ("CO_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK11" FOREIGN KEY ("PSU")
	  REFERENCES  "PSU" ("PSU_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK12" FOREIGN KEY ("MONITOR")
	  REFERENCES  "MONITOR" ("MO_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK2" FOREIGN KEY ("CPU")
	  REFERENCES  "CPU" ("CPU_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK3" FOREIGN KEY ("VGA")
	  REFERENCES  "VGA" ("VGA_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK4" FOREIGN KEY ("RAM")
	  REFERENCES  "RAM" ("RAM_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK5" FOREIGN KEY ("MB")
	  REFERENCES  "MB" ("MB_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK6" FOREIGN KEY ("CASE")
	  REFERENCES  "CASE" ("C_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK7" FOREIGN KEY ("HDD")
	  REFERENCES  "HDD" ("HDD_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK8" FOREIGN KEY ("SSD")
	  REFERENCES  "SSD" ("SSD_NAME") ENABLE;ALTER TABLE  "SPEC" ADD CONSTRAINT "SPEC_FK9" FOREIGN KEY ("M2")
	  REFERENCES  "M2" ("M2_NAME") ENABLE;