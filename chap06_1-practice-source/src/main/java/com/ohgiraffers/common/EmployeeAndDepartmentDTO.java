package com.ohgiraffers.common;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeAndDepartmentDTO {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private DeptDTO department;
    private String jobCode;
    private String salLevel;
    private int salary;
    private Date hireDate;
    private Date entDate;
    private String entYN;
}
