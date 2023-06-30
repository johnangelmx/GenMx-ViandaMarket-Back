CREATE
    database vianda_market_db;
USE
    vianda_market_db;

CREATE TABLE vianda_market_db.usuarios
(
    id_usuarios BIGINT       NOT NULL AUTO_INCREMENT,
    domicilio   VARCHAR(250) NOT NULL,
    nombres     VARCHAR(50)  NOT NULL,
    apellidos   VARCHAR(50)  NOT NULL,
    correo      VARCHAR(45)  NOT NULL,
    contrasena  VARCHAR(60)  NOT NULL,
    status      BOOLEAN      NOT NULL,
    rol         VARCHAR(15)  NOT NULL,
    PRIMARY KEY (id_usuarios)
);

CREATE TABLE vianda_market_db.cortes
(
    idcortes            BIGINT       NOT NULL AUTO_INCREMENT,
    nombre              VARCHAR(45)  NOT NULL,
    precio              FLOAT        NOT NULL,
    descripcion_corte   VARCHAR(500) NOT NULL,
    disponibilidad      TINYINT      NULL,
    cantidad_disponible FLOAT        NULL,
    idcalidades         BIGINT       NOT NULL,
    idgramos            BIGINT,
    imagen              VARCHAR(500),
    PRIMARY KEY (idcortes),
    KEY (idcalidades)

);

CREATE TABLE vianda_market_db.complementos
(
    idcomplementos          BIGINT       NOT NULL AUTO_INCREMENT,
    nombre                  VARCHAR(45)  NOT NULL,
    disponibilidad          TINYINT      NOT NULL,
    cantidad_disponible     DOUBLE       NOT NULL,
    descripcion_complemento VARCHAR(500) NOT NULL,
    precio                  FLOAT        NOT NULL,
    PRIMARY KEY (idcomplementos)
);

CREATE TABLE vianda_market_db.calidades
(
    idcalidades       BIGINT       NOT NULL AUTO_INCREMENT,
    marca             VARCHAR(45)  NOT NULL,
    pais              VARCHAR(45)  NOT NULL,
    descripcion_marca VARCHAR(500) NOT NULL,
    calidad           VARCHAR(45)  NOT NULL,
    PRIMARY KEY (idcalidades)
);

CREATE TABLE vianda_market_db.gramos
(
    idgramos       BIGINT NOT NULL auto_increment,
    cantidad       INT    NOT NULL,
    idcortes       BIGINT,
    idcomplementos BIGINT,
    PRIMARY KEY (idgramos),
    KEY (idcortes),
    KEY (idcomplementos)
);

CREATE TABLE vianda_market_db.pedidos
(
    idpedido       BIGINT       NOT NULL auto_increment,
    nombre         VARCHAR(500) NOT NULL,
    precio         BIGINT         NOT NULL,
    gramaje        INT          NOT NULL,
    cantidad       INT          NOT NULL,
    estatus        BOOL         NOT NULL,
    fecha_guardado DATETIME     NOT NULL,
    id_usuarios    BIGINT       NOT NULL,
    PRIMARY KEY (idpedido),
    KEY (id_usuarios)
);