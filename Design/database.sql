DROP TABLE IF EXISTS `sms`.`stocks` ;
DROP TABLE IF EXISTS `sms`.`user`;

CREATE TABLE IF NOT EXISTS `sms`.`user`
(
    `username`   varchar(255) NOT NULL,
    `user_id`    INT          NOT NULL AUTO_INCREMENT,
    `email`      VARCHAR(45)  NOT NULL,
    `creditcard` INT          NOT NULL,
    `password`   VARCHAR(45)  NOT NULL,
    primary key (user_id)
);

CREATE TABLE IF NOT EXISTS `sms`.`stocks` (
    stock_id    INT            NOT NULL AUTO_INCREMENT,
    user_id     int            NOT NULL,
    stockName   varchar(255)   NOT NULL UNIQUE,
    buyPrice    float          NOT NULL,
    amount      int            NOT NULL,
    primary key(stock_id),
    foreign key(user_id) references user(user_id)
);

INSERT INTO sms.user(username, email, creditcard, password) VALUE ('admin', 'admin@sms.com', 123456, 'admin123');
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'TSLA', 120.45, 30);
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'AAPl', 10.85, 100);
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'NIKE', 200, 235);
