package com.personal.utils;

import java.util.List;
/**
 *
 * @author Administrator
 * 分页类
 * @param <T>
 */
public class PageBean<T> {

    private int pageSize;//每页显示的条数
    private int offset;//偏移page * pageSize page从0开始
    private int count;//总条数
    private List<T> contents;//分页数据
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<T> getContents() {
        return contents;
    }
    public void setContents(List<T> contents) {
        this.contents = contents;
    }



    /*
    int count = deptService.getDeptCount();
    PageBean<Department> pageBean = new PageBean<>();
    pageBean.setPageSize(pageSize);
    pageBean.setOffset(page * pageSize);
    List<Department> depts = deptService.listdeptpages(pageBean);
    pageBean.setCount(count);
    pageBean.setContents(depts);
    return pageBean;*/
}
