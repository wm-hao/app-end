package zhh.ap.valuebean;

public class RespRecord {
    private String appointmentTime;
    private String hospitalName;
    private String userName;
    private String departmentName;
    private String doctorName;
    private String state;
    private String failReason;

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return "RespRecord{" +
                "appointmentTime='" + appointmentTime + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", userName='" + userName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", state='" + state + '\'' +
                ", failReason='" + failReason + '\'' +
                '}';
    }
}
