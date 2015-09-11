package javalanguage.DesignPattern.factoryPattern;

/**
 * Created by hy on 2015/9/10.
 */
public class FactoryMethod {
    public static void main(String[] args){

        Sender sender = new SendMailFactory().produce();
        sender.Send();
    }

}
class SendMailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}

class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
interface Provider{
    public Sender produce();
}