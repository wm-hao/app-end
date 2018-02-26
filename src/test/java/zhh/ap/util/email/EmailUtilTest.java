package zhh.ap.util.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root.xml"})
public class EmailUtilTest {

    @Autowired
    private ApplicationContext ctx;
    @Test
    public void sendEmail() {
        MailSender mailSender = (MailSender) ctx.getBean("mailSender");
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("13218020018@163.com");//发件人
        message.setTo("448826602@qq.com");//收件人
        message.setSubject("来自朱浩浩的邀请");//主题
        message.setText("h请接受");//正文
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }

    @Test
    public void testSendMsg() {
        String text = "恭喜你获得资格！";
        String subject = "修仙门票获取结果";
        EmailUtil emailUtil = (EmailUtil) ctx.getBean("emailUtil");
        emailUtil.sendEmail(text, "448826602@qq.com", subject);
    }
}