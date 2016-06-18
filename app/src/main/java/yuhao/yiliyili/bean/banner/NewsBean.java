package yuhao.yiliyili.bean.banner;

import java.util.List;

/**
 * Banner数据持久类
 * Created by Yuhao on 2016/5/24.
 */
public class NewsBean {

    private String date;
    private List<StoryBean> stories;
    private List<StoryBean> top_stories;

    public NewsBean(String date, List<StoryBean> stories, List<StoryBean> top_stories) {
        this.date = date;
        this.stories = stories;
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoryBean> getStories() {
        return stories;
    }

    public void setStories(List<StoryBean> stories) {
        this.stories = stories;
    }

    public List<StoryBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<StoryBean> top_stories) {
        this.top_stories = top_stories;
    }
}
