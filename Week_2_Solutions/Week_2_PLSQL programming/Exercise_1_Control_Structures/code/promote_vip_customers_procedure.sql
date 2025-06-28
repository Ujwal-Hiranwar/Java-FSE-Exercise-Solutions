ALTER TABLE Customers ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;

DELIMITER //

CREATE PROCEDURE PromoteVIPCustomers()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id INT;
    DECLARE v_balance DECIMAL(10,2);

    DECLARE cur CURSOR FOR
        SELECT CustomerID, Balance FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_customer_id, v_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;

-- calling the procedure to promote customers
CALL PromoteVIPCustomers();
