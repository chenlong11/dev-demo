package cn.ksource.domain.org;

import java.util.Date;

public class SysOrg {
    private Long id;

    private Long lv1Id;

    private String lv1Name;

    private Long lv2Id;

    private String lv2Name;

    private Long lv3Id;

    private String lv3Name;

    private String orgName;

    private String orgCode;

    private Byte lv;

    private Long pid;

    private String orgPath;

    private Short sn;

    private Date createDate;

    private Date createTime;

    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLv1Id() {
        return lv1Id;
    }

    public void setLv1Id(Long lv1Id) {
        this.lv1Id = lv1Id;
    }

    public String getLv1Name() {
        return lv1Name;
    }

    public void setLv1Name(String lv1Name) {
        this.lv1Name = lv1Name == null ? null : lv1Name.trim();
    }

    public Long getLv2Id() {
        return lv2Id;
    }

    public void setLv2Id(Long lv2Id) {
        this.lv2Id = lv2Id;
    }

    public String getLv2Name() {
        return lv2Name;
    }

    public void setLv2Name(String lv2Name) {
        this.lv2Name = lv2Name == null ? null : lv2Name.trim();
    }

    public Long getLv3Id() {
        return lv3Id;
    }

    public void setLv3Id(Long lv3Id) {
        this.lv3Id = lv3Id;
    }

    public String getLv3Name() {
        return lv3Name;
    }

    public void setLv3Name(String lv3Name) {
        this.lv3Name = lv3Name == null ? null : lv3Name.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Byte getLv() {
        return lv;
    }

    public void setLv(Byte lv) {
        this.lv = lv;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    public Short getSn() {
        return sn;
    }

    public void setSn(Short sn) {
        this.sn = sn;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}