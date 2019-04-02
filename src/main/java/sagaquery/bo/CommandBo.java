package sagaquery.bo;

public class CommandBo {
    private Long surrogateid;
    private Long eventid;
    private String servicename;
    private String instanceid;
    private String globaltxid;
    private String localtxid;
    private String parenttxid;
    private String compensationmethod;
    private String payloads;
    private String status;
    private String lastmodified;
    private Long version;

    public CommandBo() {
    }

    public CommandBo(Long surrogateid, Long eventid, String servicename, String instanceid, String globaltxid, String localtxid,
                     String parenttxid, String compensationmethod, String payloads, String status, String lastmodified, Long version) {
        this.surrogateid = surrogateid;
        this.eventid = eventid;
        this.servicename = servicename;
        this.instanceid = instanceid;
        this.globaltxid = globaltxid;
        this.localtxid = localtxid;
        this.parenttxid = parenttxid;
        this.compensationmethod = compensationmethod;
        this.payloads = payloads;
        this.status = status;
        this.lastmodified = lastmodified;
        this.version = version;
    }

    public Long getSurrogateid() {
        return surrogateid;
    }

    public void setSurrogateid(Long surrogateid) {
        this.surrogateid = surrogateid;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
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

    public String getCompensationmethod() {
        return compensationmethod;
    }

    public void setCompensationmethod(String compensationmethod) {
        this.compensationmethod = compensationmethod;
    }

    public String getPayloads() {
        return payloads;
    }

    public void setPayloads(String payloads) {
        this.payloads = payloads;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(String lastmodified) {
        this.lastmodified = lastmodified;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
