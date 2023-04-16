package com.yyyxlzz.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import java.io.IOException;
import java.net.URLEncoder;



/**
 * @description 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {

        CloseableHttpClient httpClient  = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://user.qzone.qq.com/proxy/domain/m.qzone.qq.com/cgi-bin/new/get_msgb?uin=2865301533&hostUin=2865301533&start=0&s=0.5743208730539875&format=jsonp&num=10&inCharset=utf-8&outCharset=utf-8&g_tk=1124245486&g_tk=1124245486");

        get.addHeader("cookie","_qpsvr_localtk=0.8547841273414496; RK=jEKI1i3Suz; ptcz=68de294bf6ccd1c2200f4e2663907478975db314035ed09ecc6d8b3a76d6fc78; pgv_si=s8238196736; pgv_pvi=5708006400; pgv_info=ssid=s9214023430; pgv_pvid=9746592055; rv2=8020287853B5DF8D0E0134EE55DBB5D57A516773A644875B68; property20=DF628F5C3BDC238491778E21AB62848825EBCE0B8316CF01845DED188AA2D6DA82E748B062CC7977; tokenParams=?e_code=505464; lolqqcomrouteLine=index-tool_index-page_index-page_a20210615tftintegration_a20210615tftintegration_a20210615tftintegration_a20210615tftintegration; tvfe_boss_uuid=68e188fc15286d18; o_cookie=2865301533; LW_uid=V1x675N2u3p29107G324n2i034; eas_sid=v176H55233O2z1f7U3d462G1f1; ied_qq=o0346559417; LW_sid=11O6H5a2k6E0R3h541U4N0H1U4; pvpqqcomrouteLine=index_index_index_index; ptui_loginuin=2865301533; uin=o2865301533; skey=@MQkSdRHUV; p_uin=o2865301533; pt4_token=ZHf-XUApGLeCZP42YNmdBhuQzZS5FA8VS6VGwBnmp*w_; p_skey=wMScaiiND2dJKv3VE5lyttKx-No51oZ6eFMEJgzP3xE_; Loading=Yes; qz_screen=1920x1080; QZ_FE_WEBP_SUPPORT=1; __Q_w_s_hat_seed=1; cpu_performance_v8=3; __Q_w_s__QZN_TodoMsgCnt=1; 2865301533_todaycount=14; 2865301533_totalcount=43");
        get.addHeader("Content—Type","application/x-javascript; charset=utf-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println("----");
            System.out.println(res);
            System.out.println("----");
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

        // 获取要回复的评论的id

    }

    /**
     * 回答
     * @throws IOException
     */
    @Test
    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://h5.qzone.qq.com/proxy/domain/m.qzone.qq.com/cgi-bin/new/add_reply?&g_tk=1124245486");
        post.addHeader("cookie", "_qpsvr_localtk=0.8547841273414496; RK=jEKI1i3Suz; ptcz=68de294bf6ccd1c2200f4e2663907478975db314035ed09ecc6d8b3a76d6fc78; pgv_si=s8238196736; pgv_pvi=5708006400; pgv_info=ssid=s9214023430; pgv_pvid=9746592055; rv2=8020287853B5DF8D0E0134EE55DBB5D57A516773A644875B68; property20=DF628F5C3BDC238491778E21AB62848825EBCE0B8316CF01845DED188AA2D6DA82E748B062CC7977; tokenParams=?e_code=505464; lolqqcomrouteLine=index-tool_index-page_index-page_a20210615tftintegration_a20210615tftintegration_a20210615tftintegration_a20210615tftintegration; tvfe_boss_uuid=68e188fc15286d18; o_cookie=2865301533; LW_uid=V1x675N2u3p29107G324n2i034; eas_sid=v176H55233O2z1f7U3d462G1f1; ied_qq=o0346559417; LW_sid=11O6H5a2k6E0R3h541U4N0H1U4; pvpqqcomrouteLine=index_index_index_index; ptui_loginuin=2865301533; uin=o2865301533; skey=@MQkSdRHUV; p_uin=o2865301533; pt4_token=ZHf-XUApGLeCZP42YNmdBhuQzZS5FA8VS6VGwBnmp*w_; p_skey=wMScaiiND2dJKv3VE5lyttKx-No51oZ6eFMEJgzP3xE_; Loading=Yes; QZ_FE_WEBP_SUPPORT=1; __Q_w_s_hat_seed=1; __Q_w_s__QZN_TodoMsgCnt=1; cpu_performance_v8=4");

        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        // 对回复的信息编码
        String urlString = URLEncoder.encode("成功添加", "utf-8");  //输出%E4%BD%A0%E5%A5%BD
        System.out.println(urlString);
//"content="+urlString +

        String paramJson = "hostUin=2865301533&" +
                "msgId=1000050017&" + // 当前评论的id
                "format=fs&" +
                "content="+urlString+"&" + // 要回复的信息
                "uin=2865301533&" +
                "iNotice=1&" +
                "inCharset=utf-8&" +
                "outCharset=utf-8&" +
                "ref=qzone&" +
                "json=1&" +
                "g_tk=1124245486&" + // 1
                "qzreferrer=https%3A%2F%2Fuser.qzone.qq.com%2Fproxy%2Fdomain%2Fqzs.qq.com%2Fqzone%2Fmsgboard%2Fmsgbcanvas.html%23page%3D1";



        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response);
        }


    }

}
