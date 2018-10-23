package cn.ksource.domain.attachment;

import java.util.Date;

public class SysAttachment {
    private Long id;

    private Long businessId;

    private String attType;

    private String attName;

    private String attPath;

    private String attSize;

    private String attExt;

    private Short sn;

    private Long createId;

    private Date createDate;

    private Date createTime;

    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType == null ? null : attType.trim();
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName == null ? null : attName.trim();
    }

    public String getAttPath() {
        return attPath;
    }

    public void setAttPath(String attPath) {
        this.attPath = attPath == null ? null : attPath.trim();
    }

    public String getAttSize() {
        return attSize;
    }

    public void setAttSize(String attSize) {
        this.attSize = attSize == null ? null : attSize.trim();
    }

    public String getAttExt() {
        return attExt;
    }

    public void setAttExt(String attExt) {
        this.attExt = attExt == null ? null : attExt.trim();
    }

    public Short getSn() {
        return sn;
    }

    public void setSn(Short sn) {
        this.sn = sn;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
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