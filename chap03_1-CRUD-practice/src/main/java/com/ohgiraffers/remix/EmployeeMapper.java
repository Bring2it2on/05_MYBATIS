package com.ohgiraffers.remix;

import java.util.List;

// 데이터 베이스 접근을 하기 때문에 DAO 인터페이스라고 한다.
public interface EmployeeMapper {

    List<EmpDTO> selectAllEmployee();

    EmpDTO selectEmployeeById(String empId);

    EmpDTO selectEmployeeByName(String empName);

    int registEmployee(EmpDTO emp);

    int modifyEmployee(EmpDTO emp);

    int deleteEmployee(int id);
}
