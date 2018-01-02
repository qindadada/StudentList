package com.example.StudentList.db;

import org.litepal.crud.DataSupport;

/**
 * Created by xm on 2017/11/4.
 */

public class stuList extends DataSupport {
    private String sName;
    private String sPhone;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }
}


