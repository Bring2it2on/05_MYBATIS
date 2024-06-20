package com.ohgiraffers.xmlconfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmpController {

    /*
    * Controller
    * 뷰와 모델 사이의 전달자 역할
    * 모델에게 명령을 전달해주는 역할로, 모델의 상태를 변경할 수 있다.
    * 뷰에 명령을 보냄으로써 모델의 표시 방법을 바꿀 수 있다.
    *
    * Service 를 알고 있어야 한다.
    * */
    private final EmpService empService;
    private final PrintResult printResult;

    // 생성자 주입
    public EmpController() {
        empService = new EmpService();
        printResult = new PrintResult();
    }

    public void selectAllEmployee() {

        List<EmpDTO> emplist = empService.selectAllEmployee();

        // view로 전달
        if(emplist != null) {
            printResult.printEmployeeList(emplist);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectEmployeeById(Map<String, String> parameter) {

        String empId = parameter.get("empId");

        // service로 보내기
        EmpDTO emp = empService.selectEmployeeById(empId);

        // view로 전달
        if(emp != null) {
            printResult.printEmployee(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectEmployeeByName(Map<String, String> parameter) {

        String empName = parameter.get("empName");

        // service로 보내기
        EmpDTO emp = empService.selectEmployeeByName(empName);

        // view로 전달
        if(emp != null) {
            printResult.printEmployee(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }


    public void registEmployee(Map<String, String> parameter) {

        String empId = parameter.get("empId");
        String empName = parameter.get("empName");
        String empNo = parameter.get("empNo");
        String email = parameter.get("email");
        String phone = parameter.get("phone");
        String deptCode = parameter.get("deptCode");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");
        int salary = Integer.parseInt(parameter.get("salary"));
        java.sql.Date hireDate = getSqlDate(parameter.get("hireDate"));
        java.sql.Date entDate = null;
        if (parameter.get("entYN").equals("Y")) {
            entDate = getSqlDate(parameter.get("entDate"));
        }
        String entYN = parameter.get("entYN");

        EmpDTO emp = new EmpDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setHireDate(hireDate);
        emp.setEntDate(entDate);
        emp.setEntYN(entYN);

        boolean result = empService.registEmployee(emp);

        // view로 전달
        if (result) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

//    public void modifyEmployee(Map<String, String> parameter) {
//
//        int id = Integer.parseInt(parameter.get("id"));
//        String name = parameter.get("name");
//        int price = Integer.parseInt(parameter.get("price"));
//        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
//
//        EmpDTO emp = new EmpDTO();
//        emp.setCode(code);
//        emp.setName(name);
//        emp.setPrice(price);
//        emp.setCategoryCode(categoryCode);
//
//        boolean result = empService.modifyEmployee(emp);
//
//        // view로 전달
//        if(result) {
//            printResult.printSuccessMessage("update");
//        } else {
//            printResult.printErrorMessage("update");
//        }
//    }
//
//    public void deleteEmployee(Map<String, String> parameter) {
//
//        int code = Integer.parseInt(parameter.get("code"));
//
//        boolean result = empService.deleteEmployee(code);
//
//        // view로 전달
//        if(result) {
//            printResult.printSuccessMessage("delete");
//        } else {
//            printResult.printErrorMessage("delete");
//        }
//    }

    private static java.sql.Date getSqlDate(String date) {

        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
        Date tempDate = null;
        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date 객체를 만든다.
            tempDate = df2.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String으로 변환
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transDate = simpleDateFormat.format(tempDate);

        // 반환된 String 값을 java.sql.Date로 변경한다.
        java.sql.Date sqlDate = java.sql.Date.valueOf(transDate);

        return sqlDate;
    }
}
