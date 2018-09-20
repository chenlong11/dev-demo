package cn.ksource.domain.demo;

public class Demo {
    private String id;

    private String demoString;

    private Integer demoInt;

    private Double demoDouble;

    private Long demoLong;

    private Integer createDate;

    private Integer createTime;

    private Short state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDemoString() {
        return demoString;
    }

    public void setDemoString(String demoString) {
        this.demoString = demoString == null ? null : demoString.trim();
    }

    public Integer getDemoInt() {
        return demoInt;
    }

    public void setDemoInt(Integer demoInt) {
        this.demoInt = demoInt;
    }

    public Double getDemoDouble() {
        return demoDouble;
    }

    public void setDemoDouble(Double demoDouble) {
        this.demoDouble = demoDouble;
    }

    public Long getDemoLong() {
        return demoLong;
    }

    public void setDemoLong(Long demoLong) {
        this.demoLong = demoLong;
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

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}