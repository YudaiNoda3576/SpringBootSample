CREATE TABLE users
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT users (id, name) VALUES (1, '野田雄大'), (2, '木村拓也'), (3, '城内麻衣子');
