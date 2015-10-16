package web.http;

public class HttpResponse extends HttpBase {

    private HttpStatus status;

    public HttpResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HTTP/1.1 " + status.getCode() + " " + status.toString() + "\n" + super.toString();
    }

}
