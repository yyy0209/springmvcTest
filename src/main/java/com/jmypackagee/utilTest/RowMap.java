package com.jmypackagee.utilTest;

import java.sql.ResultSet;

public interface RowMap<T> {
    public T rowMapping(ResultSet rs); //把ResultSet类型对象转换为T类型
}
