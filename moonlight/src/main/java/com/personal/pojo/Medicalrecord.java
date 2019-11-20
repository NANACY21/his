package com.personal.pojo;

public class Medicalrecord {
    private Integer id;

    private String casenumber;

    private Integer registid;

    private String readme;

    private String present;

    private String presenttreat;

    private String history;

    private String allergy;

    private String physique;

    private String proposal;

    private String careful;

    private String checkresult;

    private String diagnosis;

    private String handling;

    private Integer casestate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme == null ? null : readme.trim();
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present == null ? null : present.trim();
    }

    public String getPresenttreat() {
        return presenttreat;
    }

    public void setPresenttreat(String presenttreat) {
        this.presenttreat = presenttreat == null ? null : presenttreat.trim();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy == null ? null : allergy.trim();
    }

    public String getPhysique() {
        return physique;
    }

    public void setPhysique(String physique) {
        this.physique = physique == null ? null : physique.trim();
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal == null ? null : proposal.trim();
    }

    public String getCareful() {
        return careful;
    }

    public void setCareful(String careful) {
        this.careful = careful == null ? null : careful.trim();
    }

    public String getCheckresult() {
        return checkresult;
    }

    public void setCheckresult(String checkresult) {
        this.checkresult = checkresult == null ? null : checkresult.trim();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling == null ? null : handling.trim();
    }

    public Integer getCasestate() {
        return casestate;
    }

    public void setCasestate(Integer casestate) {
        this.casestate = casestate;
    }
}