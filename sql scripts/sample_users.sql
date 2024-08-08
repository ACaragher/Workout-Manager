INSERT INTO `users`
VALUES
('john', '{bcrypt}$2a$10$rcy7SYGiLNuMX8KehYFYeeAR71bR9eKPg0lcxraW/XV3mjYJGrcEW', 1),
('mary', '{bcrypt}$2a$10$Ip9W1Ot/i2Z8DcC3H9ID.eBfwwBhyy8BpCI.8kheXMru0uvlLTxE.', 1),
('susan', '{bcrypt}$2a$10$AEarblxy7a670AH/BU61k.NbcKbNigEuzIQsyGCW88Twe8azBsawK', 1);

INSERT INTO `authorities`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMINusers');