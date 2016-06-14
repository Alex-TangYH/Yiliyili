package yuhao.yiliyili.bean.bangummi;

import com.google.gson.JsonObject;

/**
 * VideoInfoBean 视频详情数据
 * Created by Yuhao on 2016/6/15.
 */
public class VideoInfoBean {
    public String getAllow_bp() {
        return allow_bp;
    }

    public void setAllow_bp(String allow_bp) {
        this.allow_bp = allow_bp;
    }

    public String getAllow_download() {
        return allow_download;
    }

    public void setAllow_download(String allow_download) {
        this.allow_download = allow_download;
    }

    public String getAllow_feed() {
        return allow_feed;
    }

    public void setAllow_feed(String allow_feed) {
        this.allow_feed = allow_feed;
    }

    public String getArctype() {
        return arctype;
    }

    public void setArctype(String arctype) {
        this.arctype = arctype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public JsonObject getBangumi() {
        return bangumi;
    }

    public void setBangumi(JsonObject bangumi) {
        this.bangumi = bangumi;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getInstant_server() {
        return instant_server;
    }

    public void setInstant_server(String instant_server) {
        this.instant_server = instant_server;
    }

    public JsonObject getList() {
        return list;
    }

    public void setList(JsonObject list) {
        this.list = list;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getVideo_review() {
        return video_review;
    }

    public void setVideo_review(String video_review) {
        this.video_review = video_review;
    }

    private String allow_bp;
    private String allow_download;
    private String allow_feed;
    private String arctype;
    private String author;
    private JsonObject bangumi;
    private String coins;
    private String created;
    private String created_at;
    private String credit;
    private String description;
    private String face;
    private String favorites;
    private String instant_server;
    private JsonObject list;
    private String mid;
    private String pages;
    private String pic;
    private String play;
    private String review;
    private String spid;
    private String src;
    private String tag;
    private String tid;
    private String title;
    private String typename;
    private String video_review;

    public VideoInfoBean() {
    }

    @Override
    public String toString() {
        return "VideoInfoBean{" +
                "allow_bp='" + allow_bp + '\'' +
                ", allow_download='" + allow_download + '\'' +
                ", allow_feed='" + allow_feed + '\'' +
                ", arctype='" + arctype + '\'' +
                ", author='" + author + '\'' +
                ", bangumi=" + bangumi +
                ", coins='" + coins + '\'' +
                ", created='" + created + '\'' +
                ", created_at='" + created_at + '\'' +
                ", credit='" + credit + '\'' +
                ", description='" + description + '\'' +
                ", face='" + face + '\'' +
                ", favorites='" + favorites + '\'' +
                ", instant_server='" + instant_server + '\'' +
                ", list=" + list +
                ", mid='" + mid + '\'' +
                ", pages='" + pages + '\'' +
                ", pic='" + pic + '\'' +
                ", play='" + play + '\'' +
                ", review='" + review + '\'' +
                ", spid='" + spid + '\'' +
                ", src='" + src + '\'' +
                ", tag='" + tag + '\'' +
                ", tid='" + tid + '\'' +
                ", title='" + title + '\'' +
                ", typename='" + typename + '\'' +
                ", video_review='" + video_review + '\'' +
                '}';
    }
}
