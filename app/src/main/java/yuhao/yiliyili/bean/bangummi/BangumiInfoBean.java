package yuhao.yiliyili.bean.bangummi;

import java.util.Arrays;

/**
 * Json数据的Bean类
 * Created by Yuhao on 2016/6/13.
 */
public class BangumiInfoBean {

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    private String accept;
    private String backup;
    private String length;
    private String url;

    public BangumiInfoBean() {
    }

    @Override
    public String toString() {
        return "BangumiInfoBean{" +
                "accept='" + accept + '\'' +
                ", backup='" + backup + '\'' +
                ", length='" + length + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
