package yuhao.yiliyili.bean.bangummi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Json数据的Bean类
 * Created by Yuhao on 2016/6/13.
 */
public class BangumiInfoBean {

    public String getAccept_format() {
        return accept_format;
    }

    public void setAccept_format(String accept_format) {
        this.accept_format = accept_format;
    }

    public JsonArray getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(JsonArray accept_quality) {
        this.accept_quality = accept_quality;
    }

    public JsonArray getDurl() {
        return durl;
    }

    public void setDurl(JsonArray durl) {
        this.durl = durl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimelength() {
        return timelength;
    }

    public void setTimelength(String timelength) {
        this.timelength = timelength;
    }

    private String format;
    private String timelength;
    private String accept_format;
    private JsonArray accept_quality;
    private JsonArray durl;

    public BangumiInfoBean() {
    }

    @Override
    public String toString() {
        return "BangumiInfoBean{" +
                "accept_format='" + accept_format + '\'' +
                ", format='" + format + '\'' +
                ", timelength='" + timelength + '\'' +
                ", accept_quality=" + accept_quality +
                ", durl=" + durl +
                '}';
    }
}
