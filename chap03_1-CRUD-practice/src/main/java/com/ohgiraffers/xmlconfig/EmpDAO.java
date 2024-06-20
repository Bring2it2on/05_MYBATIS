package com.ohgiraffers.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpDAO {

    /*
    * DAO 란?(Data Access Object)
    * DB의 데이터에 접근하기 위한 객체를 의미한다.
    * DB에 접근하는 로직을 분리하기 위해 사용함.
    * */

    public List<EmpDTO> selectAllEmployee(SqlSession sqlSession) {

        return sqlSession.selectList("EmployeeMapper.selectAllEmployee");
    }

    public EmpDTO selectEmployeeByCode(SqlSession sqlSession, String empId) {

        return sqlSession.selectOne("EmployeeMapper.selectEmployeeById", empId);
    }

    public EmpDTO selectEmployeeByName(SqlSession sqlSession, String empName) {

        return sqlSession.selectOne("EmployeeMapper.selectEmployeeByName", empName);
    }

    public int insertEmployee(SqlSession sqlSession, EmpDTO emp) {

        return sqlSession.insert("EmployeeMapper.insertEmployee", emp);
    }

    public int UpdateEmployee(SqlSession sqlSession, EmpDTO emp) {

        return sqlSession.update("EmployeeMapper.updateEmployee", emp);
    }

    public int deleteEmployee(SqlSession sqlSession, int code) {

        return sqlSession.delete("EmployeeMapper.deleteEmployee", code);
    }
}
