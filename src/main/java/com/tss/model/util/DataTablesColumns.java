package com.tss.model.util;

public class DataTablesColumns {
    
    private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;
    private String searchValue;
    private Boolean searchRegex;

    public DataTablesColumns() {
    }
    
    public DataTablesColumns(String data, String name, Boolean searchable, Boolean orderable, String searchValue, Boolean searchRegex) {
        this.data = data;
        this.name = name;
        this.searchable = searchable;
        this.orderable = orderable;
        this.searchValue = searchValue;
        this.searchRegex = searchRegex;
    }


    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Boolean return the searchable
     */
    public Boolean isSearchable() {
        return searchable;
    }

    /**
     * @param searchable the searchable to set
     */
    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    /**
     * @return Boolean return the orderable
     */
    public Boolean isOrderable() {
        return orderable;
    }

    /**
     * @param orderable the orderable to set
     */
    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    /**
     * @return String return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return String return the searchRegex
     */
    public Boolean getSearchRegex() {
        return searchRegex;
    }

    /**
     * @param searchRegex the searchRegex to set
     */
    public void setSearchRegex(Boolean searchRegex) {
        this.searchRegex = searchRegex;
    }

    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            ", name='" + getName() + "'" +
            ", searchable='" + isSearchable() + "'" +
            ", orderable='" + isOrderable() + "'" +
            ", searchValue='" + getSearchValue() + "'" +
            ", searchRegex='" + getSearchRegex() + "'" +
            "}";
    }

}
