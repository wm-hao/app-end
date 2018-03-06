package zhh.ap.valuebean;

public class HttpReqResult {
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    private String result;
    private String data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HttpReqResult() {
    }

    public HttpReqResult(String result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
