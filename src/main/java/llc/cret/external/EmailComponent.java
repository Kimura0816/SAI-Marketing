package llc.cret.external;

import llc.cret.constants.EmailConst;
import llc.cret.constants.SystemConst;
import llc.cret.repository.SystemConfigtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Email送信コンポーネント.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailComponent {
    private final SystemConfigtRepository systemConfigtRepository;

    private Map<String, String> headers = new HashMap<String, String>(){
        private static final long serialVersionUID = 1L;
        {
            put("Content-Transfer-Encoding", EmailConst.ENCODING);
        }
    };

    public void send(String to, String subject, String content) {
        // システム定義の取得
        Map<String, String> sysCong = systemConfigtRepository.getMap();

        Email email = new SimpleEmail();
        try {
            email.setHostName(sysCong.get(SystemConst.MAIL_HOST));
            email.setSmtpPort(Integer.parseInt(sysCong.get(SystemConst.MAIL_PORT)));
            email.setCharset(EmailConst.CHARSET_UTF8);
            email.setHeaders(headers);
            email.setAuthenticator(new DefaultAuthenticator(sysCong.get(SystemConst.MAIL_USER), sysCong.get(SystemConst.MAIL_PASS)));
            email.setStartTLSEnabled(Boolean.parseBoolean(sysCong.get(SystemConst.MAIL_STARTTLS)));
            email.setFrom(sysCong.get(SystemConst.MAIL_FROM));
            email.addTo(to);
            email.setSubject(subject);
            email.setMsg(content);
            email.setDebug(Boolean.parseBoolean(sysCong.get(SystemConst.MAIL_DEBUG)));
            email.send();
        } catch (EmailException e) {
            log.error(e.getMessage(),e);
        }
    }

}
