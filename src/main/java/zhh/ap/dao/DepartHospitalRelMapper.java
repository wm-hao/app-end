package zhh.ap.dao;

import java.util.List;
import zhh.ap.bean.DepartHospitalRel;

public interface DepartHospitalRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_department_hospital
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_department_hospital
     *
     * @mbggenerated
     */
    int insert(DepartHospitalRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_department_hospital
     *
     * @mbggenerated
     */
    DepartHospitalRel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_department_hospital
     *
     * @mbggenerated
     */
    List<DepartHospitalRel> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_department_hospital
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DepartHospitalRel record);

    List<DepartHospitalRel> selectByDepartmentCode(String departmentCode);

    List<DepartHospitalRel> selectByHospitalCode(String hospitalCode);
}