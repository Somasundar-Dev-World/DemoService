package model;

public class HealthResponse {
    public enum Status {
        SUCCESS,
        FAIL,
        PARTIAL_SUCCESS
    }

    private Status status;

    private String response;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
