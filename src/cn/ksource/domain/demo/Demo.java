package cn.ksource.domain.demo;

public class Demo {
    private String id;

    private String aString;

    private Integer aInteger;

    private Double aDouble;

    private Long aLong;

    private Integer createDate;

    private Integer createTime;

    private Short statu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString == null ? null : aString.trim();
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public void setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Short getStatu() {
        return statu;
    }

    public void setStatu(Short statu) {
        this.statu = statu;
    }
}