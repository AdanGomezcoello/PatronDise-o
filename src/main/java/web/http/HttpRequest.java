package web.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest extends HttpBase {

    private String host;

    private String path;

    private HttpMethod method;

    private Map<String, String> queryParams;

    public HttpRequest(String host, String path, HttpMethod method) {
        this.host = host;
        this.path = path;
        this.method = method;
        queryParams = new HashMap<>();
    }

    public HttpRequest() {
        this("localhost", "", HttpMethod.GET);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return queryParams;
    }

    public void addQueryParam(String key, String value) {
        queryParams.put(key, value);
    }

    @Override
    public String toString() {
        String result = method.toString() + " /" + path + this.queryParams() + " HTTP/1.1\n";
        result += "Host: //" + host + "\n";
        result += super.toString();
        return result;
    }

    private String queryParams() {
        String query = "";
        String separator = "?";
        for (String key : queryParams.keySet()) {
            query += separator + key + "=" + queryParams.get(key);
            separator = "&";
        }
        return query;
    }

}
