package sagaquery.entity;

import javax.persistence.*;


@Entity
@Table(name = "command", schema = "public", catalog = "saga")
public class Command {
    private Long surrogateid;
    private Long eventid;
    private String servicename;
    private String instanceid;
    private String globaltxid;
    private String localtxid;
    private String parenttxid;
    private String compensationmethod;
    private byte[] payloads;
    private String status;
    private String lastmodified;
    private Long version;


    @Id
    @Column(name = "surrogateid")
    public Long getSurrogateid() {
        return surrogateid;
    }

    public void setSurrogateid(Long surrogateid) {
        this.surrogateid = surrogateid;
    }

    @Basic
    @Column(name = "servicename")
    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @Basic
    @Column(name = "instanceid")
    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }


    @Basic
    @Column(name = "globaltxid")
    public String getGlobaltxid() {
        return globaltxid;
    }

    public void setGlobaltxid(String globaltxid) {
        this.globaltxid = globaltxid;
    }

    @Basic
    @Column(name = "localtxid")
    public String getLocaltxid() {
        return localtxid;
    }

    public void setLocaltxid(String localtxid) {
        this.localtxid = localtxid;
    }

    @Basic
    @Column(name = "parenttxid")
    public String getParenttxid() {
        return parenttxid;
    }

    public void setParenttxid(String parenttxid) {
        this.parenttxid = parenttxid;
    }


    @Basic
    @Column(name = "compensationmethod")
    public String getCompensationmethod() {
        return compensationmethod;
    }

    public void setCompensationmethod(String compensationmethod) {
        this.compensationmethod = compensationmethod;
    }

    @Basic
    @Column(name = "eventid")
    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "lastmodified")
    public String getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(String lastmodified) {
        this.lastmodified = lastmodified;
    }

    @Basic
    @Column(name = "version")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Basic
    @Column(name = "payloads")
    public byte[] getPayloads() {
        return payloads;
    }

    public void setPayloads(byte[] payloads) {
        this.payloads = payloads;
    }


}
