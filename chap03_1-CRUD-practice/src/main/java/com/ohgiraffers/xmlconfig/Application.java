package com.ohgiraffers.xmlconfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {

    /*
    * 시스템 요구사항
    * 1. 모든 직원 조회
    * 2. 직원 번호로 조회
    * 3. 직원 이름으로 조회
    * 4. 직원 추가
    * 5. 직원 수정
    * 6. 직원 삭제
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpController empController = new EmpController();

        do {
            System.out.println("============= 오지라퍼 직원 관리 시스템 =============");
            System.out.println("1. 직원 전체 조회하기");
            System.out.println("2. 직원 번호로 직원 조회하기");
            System.out.println("3. 직원 이름으로 직원 조회하기");
            System.out.println("4. 신규 직원 추가하기");
            System.out.println("5. 직원 수정하기");
            System.out.println("6. 직원 삭제하기");
            System.out.println("9(0). 프로그램 종료");
            System.out.print("직원 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : empController.selectAllEmployee(); break;
                case 2 : empController.selectEmployeeById(inputEmployeeId()); break;
                case 3 : empController.selectEmployeeByName(inputEmployeeName()); break;
                case 4 : empController.registEmployee(inputEmployee()); break;
//                case 5 : empController.modifyEmployee(inputModifyEmployee()); break;
//                case 6 : empController.deleteEmployee(inputEmployeeId()); break;
                case 9, 0 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputEmployeeName() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직원 이름을 입력하세요 : ");
        String empName = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empName", empName);

        return parameter;
    }


    // 메뉴코드를 입력받는 메서드
    private static Map<String, String> inputEmployeeId() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직원 아이디를 입력하세요 : ");
        String empId = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);

        return parameter;
    }

    private static Map<String, String> inputEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 아이디를 입력하세요 : ");
        String empId = sc.next();
        System.out.print("직원 이름을 입력하세요 : ");
        String empName = sc.next();
        System.out.print("직원 주민번호를 입력하세요 : ");
        String empNo = sc.next();
        System.out.print("직원 이메일을 입력하세요 : ");
        String email = sc.next();
        System.out.print("직원 전화번호를 입력하세요 : ");
        String phone = sc.next();
        System.out.print("직원 부서코드를 입력하세요 : ");
        String deptCode = sc.next();
        System.out.print("직원 직업코드를 입력하세요 : ");
        String jobCode = sc.next();
        System.out.print("직원 월급수준을 입력하세요 : ");
        String salLevel = sc.next();
        System.out.print("직원 월급을 입력하세요 : ");
        String salary = sc.next();

        System.out.print("직원 입사일을 입력하세요(yyyyMMdd) : ");
        String hireDate = sc.next();

        System.out.print("직원 퇴사여부를 입력하세요(Y/N) : ");
        String entYN = sc.next().toUpperCase();

        // 퇴사여부에서 Y일시, 퇴사일 입력하도록
        String entDate = null;
        if (entYN.equals("Y")) {

            System.out.print("퇴사일을 입력하세요(yyyyMMdd) : ");
            entDate = sc.next();

        }

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("empName", empName);
        parameter.put("empNo", empNo);
        parameter.put("email", email);
        parameter.put("phone", phone);
        parameter.put("deptCode", deptCode);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);
        parameter.put("salary", salary);
        parameter.put("hireDate", hireDate);
        parameter.put("entDate", entDate);
        parameter.put("entYN", entYN);

        return parameter;
    }


    private static Map<String, String> inputModifyEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 아이디를 입력하세요 : ");
        String id = sc.next();
        System.out.print("수정할 직원 이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("수정할 직원 가격을 입력하세요 : ");
        String price = sc.next();
        System.out.print("수정할 직원 카테고리 아이디를 입력하세요 : ");
        String categoryId = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryId", categoryId);

        return parameter;

    }
}
