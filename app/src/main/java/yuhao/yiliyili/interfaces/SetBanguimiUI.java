package yuhao.yiliyili.interfaces;

import yuhao.yiliyili.bean.bangummi.RankVedioInfoBean;

/**
 * Bangumi（番剧）类所需数据的接口
 * Created by Yuhao on 2016/6/14.
 */
public class SetBanguimiUI {
    public interface SetHotBanguimiUI{
        public void doing(RankVedioInfoBean rankVedioInfoBean);
    };

    public interface SetVideoUI{
        public void doing(String url);
    };

    public interface GetVideoInfo{
        public void doing(String cid);
    };
}