package com.ohgiraffers.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.remix.Template.getSqlSession;

public class EmpService {

    private EmployeeMapper employeeMapper;

    public List<EmpDTO> selectAllEmployee() {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmpDTO> empList = employeeMapper.selectAllEmployee();

        sqlSession.close();

        return empList;

    }

    public EmpDTO selectEmployeeById(String empId) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmpDTO emp = employeeMapper.selectEmployeeById(empId);

        sqlSession.close();

        return emp;
    }

    public EmpDTO selectEmployeeByName(String empName) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmpDTO emp = employeeMapper.selectEmployeeByName(empName);

        sqlSession.close();

        return emp;
    }

    public boolean registEmployee(EmpDTO emp) {

        // 세션 열기
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.registEmployee(emp);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyEmployee(EmpDTO emp) {

        // 세션 열기
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.modifyEmployee(emp);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteEmployee(int id) {

        // 세션 열기
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.deleteEmployee(id);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
