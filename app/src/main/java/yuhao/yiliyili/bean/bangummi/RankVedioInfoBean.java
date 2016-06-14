package yuhao.yiliyili.bean.bangummi;

import java.io.Serializable;

/**
 * 数据持久类，用于分类排行返回的JSON中具体某个视频的信息
 * Created by Yuhao on 2016/6/14.
 */
public class RankVedioInfoBean implements Serializable {
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBadgepay() {
        return badgepay;
    }

    public void setBadgepay(String badgepay) {
        this.badgepay = badgepay;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    private String aid;
    private String author;
    private String badgepay;
    private String coins;
    private String comment;
    private String copyright;
    private String create;
    private String credit;
    private String description;
    private String duration;
    private String favorites;
    private String mid;



    private String pic;
    private String play;
    private String review;
    private String subtitle;
    private String title;
    private String typeid;
    private String typename;
    private String video_review;

    public RankVedioInfoBean() {
    }

    @Override
    public String toString() {
        return "RankVedioInfoBean{" +
                "aid='" + aid + '\'' +
                ", author='" + author + '\'' +
                ", badgepay='" + badgepay + '\'' +
                ", coins='" + coins + '\'' +
                ", comment='" + comment + '\'' +
                ", copyright='" + copyright + '\'' +
                ", create='" + create + '\'' +
                ", credit='" + credit + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", favorites='" + favorites + '\'' +
                ", mid='" + mid + '\'' +
                ", pic='" + pic + '\'' +
                ", play='" + play + '\'' +
                ", review='" + review + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", typeid='" + typeid + '\'' +
                ", typename='" + typename + '\'' +
                ", video_review='" + video_review + '\'' +
                '}';
    }
}
