package yuhao.yiliyili.bean.bangummi;

/**
 * 视频信息List
 * Created by Yuhao on 2016/6/15.
 */
public class ListOfVideoInfoBean {
    public ListOfVideoInfoBean() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getHas_alias() {
        return has_alias;
    }

    public void setHas_alias(String has_alias) {
        this.has_alias = has_alias;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    private String cid;
    private String has_alias;
    private String page;
    private String part;
    private String type;
    private String vid;

    @Override
    public String toString() {
        return "ListOfVideoInfoBean{" +
                "cid='" + cid + '\'' +
                ", has_alias='" + has_alias + '\'' +
                ", page='" + page + '\'' +
                ", part='" + part + '\'' +
                ", type='" + type + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }
}
