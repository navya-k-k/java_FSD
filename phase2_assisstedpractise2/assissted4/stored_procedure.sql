CREATE DEFINER=`root`@`localhost` PROCEDURE `add_product`(IN pname varchar(100), IN pprice decimal(10,2))
BEGIN
INSERT INTO eproduct (name,price) VALUES (pname, pprice);
END