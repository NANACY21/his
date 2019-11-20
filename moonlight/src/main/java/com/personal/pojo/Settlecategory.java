package com.personal.pojo;

public class Settlecategory {
    private Integer id;

    private String settlecode;

    private String settlename;

    private Integer sequenceno;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSettlecode() {
        return settlecode;
    }

    public void setSettlecode(String settlecode) {
        this.settlecode = settlecode == null ? null : settlecode.trim();
    }

    public String getSettlename() {
        return settlename;
    }

    public void setSettlename(String settlename) {
        this.settlename = settlename == null ? null : settlename.trim();
    }

    public Integer getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(Integer sequenceno) {
        this.sequenceno = sequenceno;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}