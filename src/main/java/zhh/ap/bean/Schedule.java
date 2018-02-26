package zhh.ap.bean;

public class Schedule {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.hospital_code
     *
     * @mbggenerated
     */
    private String hospitalCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.department_code
     *
     * @mbggenerated
     */
    private String departmentCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.day
     *
     * @mbggenerated
     */
    private String day;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.isAm
     *
     * @mbggenerated
     */
    private Integer isam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_schedule.doctor_code
     *
     * @mbggenerated
     */
    private String doctorCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.id
     *
     * @return the value of app_schedule.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.id
     *
     * @param id the value for app_schedule.id
     *
     * @mbggenerated
     */
    private void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.hospital_code
     *
     * @return the value of app_schedule.hospital_code
     *
     * @mbggenerated
     */
    public String getHospitalCode() {
        return hospitalCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.hospital_code
     *
     * @param hospitalCode the value for app_schedule.hospital_code
     *
     * @mbggenerated
     */
    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode == null ? null : hospitalCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.department_code
     *
     * @return the value of app_schedule.department_code
     *
     * @mbggenerated
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.department_code
     *
     * @param departmentCode the value for app_schedule.department_code
     *
     * @mbggenerated
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.day
     *
     * @return the value of app_schedule.day
     *
     * @mbggenerated
     */
    public String getDay() {
        return day;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.day
     *
     * @param day the value for app_schedule.day
     *
     * @mbggenerated
     */
    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.isAm
     *
     * @return the value of app_schedule.isAm
     *
     * @mbggenerated
     */
    public Integer getIsam() {
        return isam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.isAm
     *
     * @param isam the value for app_schedule.isAm
     *
     * @mbggenerated
     */
    public void setIsam(Integer isam) {
        this.isam = isam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_schedule.doctor_code
     *
     * @return the value of app_schedule.doctor_code
     *
     * @mbggenerated
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_schedule.doctor_code
     *
     * @param doctorCode the value for app_schedule.doctor_code
     *
     * @mbggenerated
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }
}