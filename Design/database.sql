DROP TABLE IF EXISTS `sms`.`stocks` ;
DROP TABLE IF EXISTS `sms`.`user`;

CREATE TABLE IF NOT EXISTS `sms`.`user`
(
    `username`   varchar(255) NOT NULL,
    `user_id`    INT          NOT NULL AUTO_INCREMENT,
    `email`      VARCHAR(45)  NOT NULL,
    `creditcard` INT          NOT NULL,
    `password`   VARCHAR(45)  NOT NULL,
    `money`      float(255,2),
    primary key (user_id)
);

CREATE TABLE IF NOT EXISTS `sms`.`stocks` (
    stock_id    INT            NOT NULL AUTO_INCREMENT,
    user_id     int            NOT NULL,
    stockName   varchar(255)   NOT NULL UNIQUE,
    buyPrice    float(255,2)          NOT NULL,
    amount      int            NOT NULL,
    primary key(stock_id),
    foreign key(user_id) references user(user_id)
);

INSERT INTO sms.user(username, email, creditcard, password, money) VALUE ('admin', 'admin@sms.com', 123456, 'admin123', 37289.98);
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'TSLA', 120.45, 30);
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'AAPl', 10.85, 100);
INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'NIKE', 200, 235);



-- Insert User query
-- INSERT INTO sms.user(username, email, creditcard, password) VALUE ('admin', 'admin@sms.com', 123456, 'admin123');

-- Select user query
-- select * from sms.user where username = `admin`

-- Portfolio query
-- select username, user_id, email, creditcard, password, stock_id, stockName, buyPrice, amount from user inner join stocks using(user_id);
-- select * from stocks where user_id = 1
-- select * from sms.user where username = "admin"

-- add money
-- UPDATE sms.user SET money = money + 100 where username = 'admin'

-- remove money
-- UPDATE sms.user SET money = money - 100 where username = 'admin'

-- add stock to user
-- INSERT INTO sms.stocks(user_id, stockName, buyPrice, amount) VALUE (1, 'NIKE', 200, 235);

-- remove stock from user
-- delete from sms.stocks where stockName = 'TSLA';

-- get stock values
-- select buyPrice * amount from sms.stocks where stockName = 'AAPL';
