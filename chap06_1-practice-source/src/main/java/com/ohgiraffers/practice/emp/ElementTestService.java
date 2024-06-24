package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DepartmentAndEmployeeDTO;
import com.ohgiraffers.common.EmpDTO;
import com.ohgiraffers.common.EmployeeAndDepartmentDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void selectResultMapAssociationTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<EmployeeAndDepartmentDTO> empList = mapper.selectResultMapAssociationTest();

        for(EmployeeAndDepartmentDTO emp : empList) {
            System.out.println("직원 아이디 : " + emp.getEmpId() + ", 직원 이름 : " + emp.getEmpName()
                                + ", 부서명 : " + emp.getDepartment().getDeptTitle());
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<DepartmentAndEmployeeDTO> deptList = mapper.selectResultMapCollectionTest();

        for(int i=0; i < deptList.size(); i++) {
            System.out.println("부서명 : " + deptList.get(i).getDeptTitle() + "{");
            List<EmpDTO> empList = deptList.get(i).getEmpList();
            for(EmpDTO emp : empList) {
                System.out.println("사원 아이디 : " + emp.getEmpId() + ", 사원 이름 : " + emp.getEmpName() +
                        ", 연락처 : " + emp.getPhone());
            }
            System.out.println("}");
        }

        sqlSession.close();

    }
}
