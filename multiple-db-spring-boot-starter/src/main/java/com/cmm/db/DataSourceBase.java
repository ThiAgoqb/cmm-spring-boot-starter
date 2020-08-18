package com.cmm.db;


import lombok.Data;

@Data
public class DataSourceBase {
    private String url;
    private String username;
    private String password;
}
