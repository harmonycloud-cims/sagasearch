package com.harmonycloud.sagaquery.bo;

import java.sql.Timestamp;

public class TxeventBo {
    private Long surrogateid;
    private String servicename;
    private String instanceid;
    private Timestamp creationtime;
    private String globaltxid;
    private String localtxid;
    private String parenttxid;
    private String type;
    private String compensationmethod;
    private Timestamp expirytime;

    private String payloads;

    public TxeventBo() {
    }

    public TxeventBo(Long surrogateid, String servicename, String instanceid, Timestamp creationtime, String globaltxid,
                     String localtxid, String parenttxid, String type, String compensationmethod, Timestamp expirytime,
                     String payloads) {
        this.surrogateid = surrogateid;
        this.servicename = servicename;
        this.instanceid = instanceid;
        this.creationtime = creationtime;
        this.globaltxid = globaltxid;
        this.localtxid = localtxid;
        this.parenttxid = parenttxid;
        this.type = type;
        this.compensationmethod = compensationmethod;
        this.expirytime = expirytime;
        this.payloads = payloads;
    }

    public Long getSurrogateid() {
        return surrogateid;
    }

    public void setSurrogateid(Long surrogateid) {
        this.surrogateid = surrogateid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }

    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }

    public String getGlobaltxid() {
        return globaltxid;
    }

    public void setGlobaltxid(String globaltxid) {
        this.globaltxid = globaltxid;
    }

    public String getLocaltxid() {
        return localtxid;
    }

    public void setLocaltxid(String localtxid) {
        this.localtxid = localtxid;
    }

    public String getParenttxid() {
        return parenttxid;
    }

    public void setParenttxid(String parenttxid) {
        this.parenttxid = parenttxid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompensationmethod() {
        return compensationmethod;
    }

    public void setCompensationmethod(String compensationmethod) {
        this.compensationmethod = compensationmethod;
    }

    public Timestamp getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(Timestamp expirytime) {
        this.expirytime = expirytime;
    }

    public String getPayloads() {
        return payloads;
    }

    public void setPayloads(String payloads) {
        this.payloads = payloads;
    }
}
