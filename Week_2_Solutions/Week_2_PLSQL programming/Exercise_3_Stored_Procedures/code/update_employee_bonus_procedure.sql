DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percent DECIMAL(5,2) -- e.g. 5.00 for 5%
)
BEGIN
    -- Update salaries by applying the bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;
END;
//

DELIMITER ;

CALL UpdateEmployeeBonus('IT', 10.00);