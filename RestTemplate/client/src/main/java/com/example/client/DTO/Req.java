package com.example.client.DTO;

public class Req<T> { // 바디의 내용이 바뀔것이기 때문에 변수로 받음

    private Header header;
    private T body; // 내용이 바뀜

    public static class Header{
        private String responseCode;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "responseCode='" + responseCode + '\'' +
                    '}';
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Req{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}


