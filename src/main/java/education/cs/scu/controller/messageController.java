//package education.cs.scu.controller;
//
//import com.sun.javafx.tools.ant.Info;
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//import education.cs.scu.entity.UserSms;
//import education.cs.scu.util.RandomUtil;
//
//import java.util.Date;
//
///**
// * Created by maicius on 2017/4/30.
//
// */
//public class messageController {
//    public Info requestSmsCode(String phone) {
//    //这个只是我项目中的标识，忽略
//        Info in = new Info();
//    //阿里大鱼URL
//        String url = "http://gw.api.taobao.com/router/rest";
//    //我自己随机生成了六位数验证码，自己去实现
//        String code = RandomUtil.createRandomVcode();
//    //以下才是重点  三个参数，一个url阿里大鱼的服务地址，其他两个去阿里大鱼后端查看自己的相应的参数
//        TaobaoClient client = new DefaultTaobaoClient(url, "23334143",
//                "23gyfruy38hf83yh7y8u98j9u9j9i9");
//        // String json="{\"code\":\"1234\",\"product\":\"某某电子商务验证\"}";
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        req.setExtend("1");
//        //必须填写normal
//        req.setSmsType("normal");
//        //你应用的名字
//        req.setSmsFreeSignName("XXXX");
//        //电话号码
//        req.setRecNum(phone);phone
//        //模板
//        req.setSmsTemplateCode("SMS_8926569");
//        //模板中的参数，按照实际情况去
//        req.setSmsParamString("{msg:'" + code + "'}");
//
//        try {
//            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//            // 这里是我设置的一个保存验证码 机制。按照实际需求，自行设计
//            UserSms userSms = new UserSms();
//            userSms.setPhone(phone);
//            userSms.setCode(code);
//            userSms.setTime(new Date());
//            sms.addSms(userSms);
//            in.setStatus("发送成功");
//        } catch (ApiException e) {
//            // TODO Auto-generated catch block
//            // e.printStackTrace();
//            in.setStatus("发送失败");
//        }
//
//        return in;
//}
