package com.personal.pojo;

import java.math.BigDecimal;

public class RegistLevel {
    private Integer id;

    private String registcode;

    private String registname;

    private Integer sequenceno;

    private BigDecimal registfee;

    private Integer registquota;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistcode() {
        return registcode;
    }

    public void setRegistcode(String registcode) {
        this.registcode = registcode == null ? null : registcode.trim();
    }

    public String getRegistname() {
        return registname;
    }

    public void setRegistname(String registname) {
        this.registname = registname == null ? null : registname.trim();
    }

    public Integer getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(Integer sequenceno) {
        this.sequenceno = sequenceno;
    }

    public BigDecimal getRegistfee() {
        return registfee;
    }

    public void setRegistfee(BigDecimal registfee) {
        this.registfee = registfee;
    }

    public Integer getRegistquota() {
        return registquota;
    }

    public void setRegistquota(Integer registquota) {
        this.registquota = registquota;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}