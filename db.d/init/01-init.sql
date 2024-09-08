CREATE
    DATABASE IF NOT EXISTS db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;



CREATE TABLE tb_mcdd_series
(
    id   INT          NOT NULL AUTO_INCREMENT COMMENT '系列 id',
    name VARCHAR(255) NOT NULL COMMENT '系列名称',
    PRIMARY KEY (id)
);

CREATE TABLE tb_mcdd
(
    id        INT          NOT NULL AUTO_INCREMENT COMMENT '抹茶旦旦 id',
    series_id INT          NOT NULL COMMENT '系列 id',
    name      VARCHAR(255) NOT NULL COMMENT '名称',
    img_rul    VARCHAR(255) NOT NULL COMMENT '图片地址',
    PRIMARY KEY (id),
    FOREIGN KEY (series_id) REFERENCES tb_mcdd_series (id) ON DELETE CASCADE
);

CREATE TABLE tb_mcdd_comments
(
    id      INT  NOT NULL AUTO_INCREMENT COMMENT 'id',
    mcdd_id INT  NOT NULL COMMENT '抹茶旦旦 id',
    content TEXT NOT NULL COMMENT '评论',
    PRIMARY KEY (id),
    FOREIGN KEY (mcdd_id) REFERENCES tb_mcdd (id) ON DELETE CASCADE
);




