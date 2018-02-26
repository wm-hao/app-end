package zhh.ap.util.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.annotation.Resource;

//@PropertySource("classpath:email/email.properties")
public class EmailUtil {

    private transient static Log log = LogFactory.getLog(EmailUtil.class);
    private String fromEmailAddress;
    private MailSender mailSender;

    public boolean sendEmail(String text, String toEmailAddress, String subject) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();//消息构造器
            message.setFrom(fromEmailAddress);//发件人
            message.setTo(toEmailAddress);//收件人
            message.setSubject(subject);//主题
            message.setText(text);//正文
            mailSender.send(message);
            log.info("Email Send Finish | 邮件发送结束");
        }catch (Exception e) {
           log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}

