package sagaquery.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "txevent", schema = "public", catalog = "saga")
public class TxeventEntity {
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
    private String retrymethod;
    private Integer retries;
    private byte[] payloads;

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
    @Column(name = "creationtime")
    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "expirytime")
    public Timestamp getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(Timestamp expirytime) {
        this.expirytime = expirytime;
    }

    @Basic
    @Column(name = "retrymethod")
    public String getRetrymethod() {
        return retrymethod;
    }

    public void setRetrymethod(String retrymethod) {
        this.retrymethod = retrymethod;
    }

    @Basic
    @Column(name = "retries")
    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    @Basic
    @Column(name = "payloads")
    public byte[] getPayloads() {
        return payloads;
    }

    public void setPayloads(byte[] payloads) {
        this.payloads = payloads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxeventEntity that = (TxeventEntity) o;
        return surrogateid == that.surrogateid &&
                retries == that.retries &&
                Objects.equals(servicename, that.servicename) &&
                Objects.equals(instanceid, that.instanceid) &&
                Objects.equals(creationtime, that.creationtime) &&
                Objects.equals(globaltxid, that.globaltxid) &&
                Objects.equals(localtxid, that.localtxid) &&
                Objects.equals(parenttxid, that.parenttxid) &&
                Objects.equals(type, that.type) &&
                Objects.equals(compensationmethod, that.compensationmethod) &&
                Objects.equals(expirytime, that.expirytime) &&
                Objects.equals(retrymethod, that.retrymethod) &&
                Arrays.equals(payloads, that.payloads);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(surrogateid, servicename, instanceid, creationtime, globaltxid, localtxid, parenttxid, type, compensationmethod, expirytime, retrymethod, retries);
        result = 31 * result + Arrays.hashCode(payloads);
        return result;
    }
}
