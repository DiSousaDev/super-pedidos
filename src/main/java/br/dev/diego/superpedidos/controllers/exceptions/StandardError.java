package br.dev.diego.superpedidos.controllers.exceptions;

import java.time.Instant;

public class StandardError {

    private String title;
    private Instant timeStamp;
    private Integer status;
    private String developerMessage;

    public StandardError() {
    }

    public StandardError(String title, Instant timeStamp, Integer status, String developerMessage) {
        this.title = title;
        this.timeStamp = timeStamp;
        this.status = status;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
