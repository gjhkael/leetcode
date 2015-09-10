package javalanguage.DesignPattern.factoryPattern;

/**
 * Created by hy on 2015/9/10.
 */
public class SampleFactory {



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

}