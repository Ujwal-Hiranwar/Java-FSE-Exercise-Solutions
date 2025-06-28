DELIMITER //

-- This procedure applies a 1% interest discount to loans for customers over 60 years old.
CREATE PROCEDURE ApplySeniorLoanDiscount()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id INT;
    DECLARE v_dob DATE;
    DECLARE v_age INT;

    
    DECLARE cur CURSOR FOR
        SELECT CustomerID, DOB FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_customer_id, v_dob;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SET v_age = TIMESTAMPDIFF(YEAR, v_dob, CURDATE());

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;

CALL ApplySeniorLoanDiscount();