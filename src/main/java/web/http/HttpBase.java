package web.http;

import java.util.HashMap;
import java.util.Map;

public class HttpBase {

    private Map<String, String> headerParams;

    private Map<String, String> cookies;

    private Object body;

    public HttpBase() {
        cookies = new HashMap<>();
        headerParams = new HashMap<>();
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void addCookies(String key, String value) {
        cookies.put(key, value);
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void addHeaderParam(String key, String value) {
        headerParams.put(key, value);
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Headers: headerParams=" + headerParams + ", cookies=" + cookies + ", body=" + body;
    }

}
