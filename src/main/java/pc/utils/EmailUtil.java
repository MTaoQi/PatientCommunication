package pc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
  //邮箱验证码（验证身份）2
@Service
public class EmailUtil {
//    配置文件参数读取
    @Value("${spring.mail.username}")
    private String emailUsername;

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(emailUsername);
        mailSender.send(message);
    }
}
