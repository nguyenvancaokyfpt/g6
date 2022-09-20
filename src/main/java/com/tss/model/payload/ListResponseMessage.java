package com.tss.model.payload;

public class ListResponseMessage {
    private int code;
    private String message;
    private Object data;
    private int count;
    private int currentPageNo;
    private int totalPages;

    public ListResponseMessage() {
    }

    public ListResponseMessage(int code, String message, Object data, int count, int currentPageNo,
            int totalPages) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
        this.currentPageNo = currentPageNo;
        this.totalPages = totalPages;
    }


    /**
     * @return int return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return Object return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return int return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return int return the currentPageNo
     */
    public int getCurrentPageNo() {
        return currentPageNo;
    }

    /**
     * @param currentPageNo the currentPageNo to set
     */
    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    /**
     * @return int return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
