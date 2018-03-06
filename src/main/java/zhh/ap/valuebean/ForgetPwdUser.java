package zhh.ap.valuebean;

public class ForgetPwdUser {
    private String phoneNumber;
    private String password;
    private String email;
    private String validateCode;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "ForgetPwdUser{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }

    public ForgetPwdUser() {
    }
}
