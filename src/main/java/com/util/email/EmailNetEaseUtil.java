package com.util.email;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class EmailNetEaseUtil {
    public static void main(String[] args) throws Exception {
        sendEmail("attachMail","smtp.163.com","发件人邮箱","发件人邮箱密码","收件人邮箱");
    }
    /**
     *  发送邮件入口
     * @param emailType
     * @param host
     * @param userFrom
     * @param password
     * @param userTo
     * @throws Exception
     */
    public static void sendEmail(String emailType,String host,String userFrom,String password,String userTo) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = null;
        ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(host, userFrom, password);
        //4、创建邮件
        Message message = null;
        //5、发送邮件
        switch (emailType) {
            case "simpleMail":
                message = createSimpleMail(session,userFrom,userTo);
                break;
            case "imageMail":
                message = createImageMail(session,userFrom,userTo);
                break;
            case "attachMail":
                message = createAttachMail(session,userFrom,userTo);
                break;
            case "mixedMail":
                message = createMixedMail(session,userFrom,userTo);
                break;
        }
        ts.sendMessage(message, message.getAllRecipients());

        ts.close();

    }

    /**
     * @param session
     * @return
     * @throws Exception
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     * @Anthor:沐清风
     */
    public static MimeMessage createSimpleMail(Session session,String userFrom,String userTo)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(userFrom));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userTo));
        //邮件的标题
        message.setSubject("施主，我看咱俩有缘！");
        //邮件的文本内容
        message.setContent("<a href='https://www.uc123.com/' value='缘分送到，勿念！'>缘分送到，勿念！</a>", "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

    /**
     * @param session
     * @return
     * @throws Exception
     * @Method: createImageMail
     * @Description: 生成一封邮件正文带图片的邮件
     * @Anthor:孤傲苍狼
     */
    public static MimeMessage createImageMail(Session session,String userFrom,String userTo) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //指明邮件的发件人
        message.setFrom(new InternetAddress(userFrom));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userTo));
        //邮件标题
        message.setSubject("施主，送你一场造化");

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("点击查看<img src='cid:girl.jpg'>的邮件", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\girl.jpg"));
        image.setDataHandler(dh);
        image.setContentID("girl.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        message.setContent(mm);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
    }
    /**
     * @Method: createAttachMail
     * @Description: 创建一封带附件的邮件
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createAttachMail(Session session,String userFrom,String userTo) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //指明邮件的发件人
        message.setFrom(new InternetAddress(userFrom));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userTo));
        //邮件标题
        message.setSubject("施主，我看咱俩有缘！");

        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("缘分送到，勿念！", "text/html;charset=UTF-8");

        //创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\girl.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  //

        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");

        message.setContent(mp);
        message.saveChanges();
        //将创建的Email写入到E盘存储
        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
        //返回生成的邮件
        return message;
    }

    /**
     * @Method: createMixedMail
     * @Description: 生成一封带附件和带图片的邮件
     *
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createMixedMail(Session session,String userFrom,String userTo) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //指明邮件的发件人
        message.setFrom(new InternetAddress(userFrom));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userTo));
        message.setSubject("带附件和带图片的的邮件");

        //正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("送你一场缘分<br/><img src='cid:girl.jpg'>","text/html;charset=UTF-8");

        //图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(new DataHandler(new FileDataSource("src\\girl.jpg")));
        image.setContentID("aaa.jpg");

        //附件1
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\girl.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

        //附件2
        MimeBodyPart attach2 = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("src\\girl.jpg"));
        attach2.setDataHandler(dh2);
        attach2.setFileName(MimeUtility.encodeText(dh2.getName()));

        //描述关系:正文和图片
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(image);
        mp1.setSubType("related");

        //描述关系:正文和附件
        MimeMultipart mp2 = new MimeMultipart();
        mp2.addBodyPart(attach);
        mp2.addBodyPart(attach2);

        //代表正文的bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mp1);
        mp2.addBodyPart(content);
        mp2.setSubType("mixed");

        message.setContent(mp2);
        message.saveChanges();

        message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
        //返回创建好的的邮件
        return message;
    }
}
