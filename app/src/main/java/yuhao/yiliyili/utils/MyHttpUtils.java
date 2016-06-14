package yuhao.yiliyili.utils;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


import java.lang.reflect.Type;

import yuhao.yiliyili.bean.BangumiInfoBean;
import yuhao.yiliyili.bean.RankInfoBean;
import yuhao.yiliyili.bean.RankVedioInfoBean;
import yuhao.yiliyili.callbacktosetui.SetBanguimiUI;

/**
 * 网络请求工具类
 * Created by Yuhao on 2016/6/13.
 */
public class MyHttpUtils {
    private static String TAG = "MyHttpUtils";
    int count2 = 1;
    int page2 = 1;

    private SetBanguimiUI.SetHotBanguimiUI setHotBanguimiUI;


    public MyHttpUtils(SetBanguimiUI.SetHotBanguimiUI HotBanguimiUI) {
        this.setHotBanguimiUI = HotBanguimiUI;
    }


    /**
     * 获取mp4/flv视频源地址
     * 请求方式: GET
     * 示例:GET http://bilibili-service.daoapp.io/video/3580782?quality=2
     * quailty  [int]  清晰度(1~2，根据视频有不同)
     * type  [int]  0:flv,1:hdmp4,2:mp4
     * @return Video source address
     */
    public boolean getBangumi (String aid){

        HttpUtils httpUtils = new HttpUtils();
//        String url = "http://bilibili-service.daoapp.io/video/8041661?quality=2";
        String url = "http://bilibili-service.daoapp.io/video/";
        aid = "8041661";
        String quality = "2";
        //TODO 整理删除注释
//        post方法
//        httpUtils.send(HttpRequest.HttpMethod.POST,
//                url,
//                params, new RequestCallBack<String>() {
//                    @Override
//                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                        Gson gson = new Gson();
//                        Type type = new TypeToken<BangumiInfoBean>() {
//                        }.getType();
//                        BangumiInfoBean jsonBean = gson.fromJson(responseInfo.toString(),BangumiInfoBean.class);
//                        jsonBean.toString();
//                    }
//
//                    @Override
//                    public void onFailure(HttpException error, String msg) {
//
//                    }
//                });

        httpUtils.send(HttpRequest.HttpMethod.GET,
                url+aid+"?quality="+quality,
//                url,
                new RequestCallBack<String>(){

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String test = responseInfo.result;
                        Log.e("result",test);
                        Type type = new TypeToken<BangumiInfoBean>() {
                        }.getType();
                        Gson gson = new GsonBuilder().create();
                        BangumiInfoBean bangumiInfoBean = gson.fromJson(test,BangumiInfoBean.class);

                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                    }
                });
        return true;
    }


    /**
     * 获取分类下的排行信息
     * 请求方式: GET
     * 示例:GET http://bilibili-service.daoapp.io/sort/13?order=new&page=2&count=3
     * Sort 分类号  '1' => '动画','3' => '音乐','4' => '游戏','5' => '娱乐','11' => '电视剧'，
     *              '13' => '番剧','23' => '电影','36' => '科技','119' => '鬼畜','129' => '舞蹈',
     * page 页码; count 分页容量; order排序方式(new,hot);默认值为1，20，hot.使用空字符即可使用默认值
     * @return VideoInfomationList
     */
    public boolean getRankOfSort (String sortId,String order, int count, int page){

        HttpUtils httpUtils = new HttpUtils();

        count2 = count;
        page2 = page;
        String url = "http://bilibili-service.daoapp.io/sort/";
        httpUtils.send(HttpRequest.HttpMethod.GET,
//                url + sortId + "?order=" + order + "count=?" + count + "page=?" + page,
                url + sortId + "?count=" + count2 +"&page=" + page2,
//                url + sortId + "?count=" + count,
                new RequestCallBack<Object>() {
                    @Override
                    public void onSuccess(ResponseInfo<Object> responseInfo) {
                        String test = (String) responseInfo.result;
                        Log.e("result",test);

                        Gson gson = new GsonBuilder().create();
                        RankInfoBean rankInfoBean = new RankInfoBean();
                        rankInfoBean = gson.fromJson(test,RankInfoBean.class);
//                        Log.e("=====jsonBean====",rankInfoBean.toString());
//                        Log.e("getList",rankInfoBean.getList().toString());
                        String rvib = rankInfoBean.getList().toString().replace("{\"0\":","").replace(",\"num\":\""+rankInfoBean.getResults()+"\"}","");
                        Log.e("rvib",rvib);
                        RankVedioInfoBean rankVedioInfoBean= gson.fromJson(rvib,RankVedioInfoBean.class);
                        Log.e("rvib",rankVedioInfoBean.toString());
                        setHotBanguimiUI.doing(rankVedioInfoBean);
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {

                    }
                });

        return true;
    }
}
