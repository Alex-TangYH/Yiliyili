package yuhao.yiliyili.bean;

import java.util.Arrays;

/**
 * Json数据的Bean类
 * Created by Yuhao on 2016/6/13.
 */
public class BangumiInfoBean {
//    {
//    "accept": "mp4,hdmp4",
//            "backup": null,
//            "length": 1475883,
//            "url": "http://cn-sddz2-cu.acgvideo.com/vg7/e/05/8041661-1-hd.mp4?expires=14658264000026ssig=Bfrkzl7KeSKavGzd4RAoiA0026oi=20219324050026appkey=4ebafd7c4951b3660026or=10330717660026rate=0"
//    }

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
