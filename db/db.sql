CREATE TABLE account (
  ACCOUNT_ID bigint(20) NOT NULL AUTO_INCREMENT,
  PASSWORD varchar(45) NOT NULL,
  NAME varchar(45) NOT NULL,
  EMAIL varchar(150) NULL,
  CREATED_DATE datetime NULL,
  UPDATE_DATE datetime NULL,
  PRIMARY KEY (ACCOUNT_ID),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE product (
  PRODUCT_ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(45) NOT NULL,
  DESCRIPTION varchar(9000) NULL,
  PRICE bigint(12) NULL,
  PROVINCE_ID bigint(10) NOT NULL,
  CAT_ID bigint(20) NOT NULL,
  ACCOUNT_ID bigint(20) NOT NULL,
  CREATED_DATE datetime NOT NULL,
  UPDATE_DATE datetime NULL,
  INDEX CAT_IDX (CAT_ID),
  NDEX IDX_TAG (ACCOUNT_ID),
  CONSTRAINT CATPROD FOREIGN KEY (CAT_ID) REFERENCES category(CAT_ID) ON DELETE CASCADE ON UPDATE CASCADE
  CONSTRAINT CS_TAG FOREIGN KEY (ACCOUNT_ID) REFERENCES account(ACCOUNT_ID) ON DELETE CASCADE ON UPDATE CASCADE
  PRIMARY KEY (PRODUCT_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE category (
  CAT_ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(45) NOT NULL,
  CREATED_DATE datetime NOT NULL,
  UPDATE_DATE datetime NULL,
  PRIMARY KEY (CAT_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE image (
  IMG_ID bigint(20) NOT NULL AUTO_INCREMENT,
  THUMBNAIL varchar(200) NOT NULL,
  URL varchar(200) NOT NULL,
  PRODUCT_ID bigint(20) NOT NULL,
  CREATED_DATE datetime NOT NULL,
  UPDATE_DATE datetime NULL,
  INDEX CAT_IDX (PRODUCT_ID),
  CONSTRAINT CATPROD FOREIGN KEY (PRODUCT_ID) REFERENCES product(PRODUCT_ID) ON DELETE CASCADE ON UPDATE CASCADE
  PRIMARY KEY (IMG_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE province (
  PROVINCE_ID bigint(10) NOT NULL AUTO_INCREMENT,
  NAME varchar(45) NOT NULL,
  CREATED_DATE datetime NOT NULL,
  UPDATE_DATE datetime NULL,
  PRIMARY KEY (PROVINCE_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into province values(1, 'Toàn quốc', now(), now());
insert into province values(2, 'Hà Nội', now(), now());
insert into province values(3, 'TP HCM', now(), now());
insert into province values(4, 'An Giang', now(), now());
insert into province values(5, 'Bà Rịa - Vũng Tàu', now(), now());
insert into province values(6, 'Bắc Giang', now(), now());
insert into province values(7, 'Bắc Kạn', now(), now());
insert into province values(8, 'Bạc Liêu', now(), now());
insert into province values(9, 'Bắc Ninh', now(), now());
insert into province values(10, 'Bến Tre', now(), now());
insert into province values(11, 'Bình Định', now(), now());
insert into province values(12, 'Bình Dương', now(), now());
insert into province values(13, 'Bình Phước', now(), now());
insert into province values(14, 'Bình Thuận', now(), now());
insert into province values(15, 'Cà Mau', now(), now());
insert into province values(16, 'Cao Bằng', now(), now());
insert into province values(17, 'Đắk Lắk', now(), now());
insert into province values(18, 'Đắk Nông', now(), now());
insert into province values(19, 'Điện Biên', now(), now());
insert into province values(20, 'Đồng Nai', now(), now());
insert into province values(21, 'Đồng Tháp', now(), now());
insert into province values(22, 'Gia Lai', now(), now());
insert into province values(23, 'Hà Giang', now(), now());
insert into province values(24, 'Hà Nam', now(), now());
insert into province values(25, 'Hà Tĩnh', now(), now());
insert into province values(26, 'Hải Dương', now(), now());
insert into province values(27, 'Hậu Giang', now(), now());
insert into province values(28, 'Hòa Bình', now(), now());
insert into province values(29, 'Hưng Yên', now(), now());
insert into province values(30, 'Khánh Hòa', now(), now());
insert into province values(31, 'Kiên Giang', now(), now());
insert into province values(32, 'Kon Tum', now(), now());
insert into province values(33, 'Lai Châu', now(), now());
insert into province values(34, 'Lâm Đồng', now(), now());
insert into province values(35, 'Lạng Sơn', now(), now());
insert into province values(36, 'Lào Cai', now(), now());
insert into province values(37, 'Long An', now(), now());
insert into province values(38, 'Nam Định', now(), now());
insert into province values(39, 'Nghệ An', now(), now());
insert into province values(40, 'Ninh Bình', now(), now());
insert into province values(41, 'Ninh Thuận', now(), now());
insert into province values(42, 'Phú Thọ', now(), now());
insert into province values(43, 'Quảng Bình', now(), now());
insert into province values(44, 'Quảng Nam', now(), now());
insert into province values(45, 'Quảng Ngãi', now(), now());
insert into province values(46, 'Quảng Ninh', now(), now());
insert into province values(47, 'Quảng Trị', now(), now());
insert into province values(48, 'Sóc Trăng', now(), now());
insert into province values(49, 'Sơn La', now(), now());
insert into province values(50, 'Tây Ninh', now(), now());
insert into province values(51, 'Thái Bình', now(), now());
insert into province values(52, 'Thái Nguyên', now(), now());
insert into province values(53, 'Thanh Hóa', now(), now());
insert into province values(54, 'Thừa Thiên Huế', now(), now());
insert into province values(55, 'Tiền Giang', now(), now());
insert into province values(56, 'Trà Vinh', now(), now());
insert into province values(57, 'Tuyên Quang', now(), now());
insert into province values(58, 'Vĩnh Long', now(), now());
insert into province values(59, 'Vĩnh Phúc', now(), now());
insert into province values(60, 'Yên Bái', now(), now());
insert into province values(61, 'Phú Yên', now(), now());
insert into province values(62, 'Cần Thơ', now(), now());
insert into province values(63, 'Đà Nẵng', now(), now());
insert into province values(64, 'Hải Phòng', now(), now());
