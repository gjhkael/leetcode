package javalanguage.DesignPattern.factoryPattern;

/**
 * Created by hy on 2015/9/10.
 */
public class SampleFactory {
    public static void main(String[] args){
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("sms");
        sender.Send();
    }
}

interface Sender{
    public void Send();
}

class MailSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is mail sender!");
    }
}

class SmsSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is sms sender");
    }
}

class SendFactory{
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请正确输入类型");
            return null;
        }
    }
}