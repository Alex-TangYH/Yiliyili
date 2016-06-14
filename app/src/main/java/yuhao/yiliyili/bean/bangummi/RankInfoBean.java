package yuhao.yiliyili.bean.bangummi;

import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.List;
import java.util.Objects;

/**
 *  数据持久类，用于获取分类排行方法返回的JSON
 * Created by Yuhao on 2016/6/14.
 */
public class RankInfoBean {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JsonObject getList() {
        return list;
    }

    public void setList(JsonObject list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    private int code;
//    private JSONArray list;
    private JsonObject list;
    private String name;
    private String number;
    private String pages;
    private String results;

    public RankInfoBean() {
    }

    @Override
    public String toString() {
        return "RankInfoBean{" +
                "code=" + code +
                ", list=" + list +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", pages=" + pages +
                ", results=" + results +
                '}';
    }
}
