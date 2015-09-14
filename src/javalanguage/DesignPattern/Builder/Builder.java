package javalanguage.DesignPattern.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/9/11.
 */
public class Builder {

    public static void main(String[] args){

        Builder1 builder1 = new Builder1();
        builder1.produceMailSender(10);

    }


}


class Builder1{
    private List<Sender> list = new ArrayList<Sender>();
    public void produceMailSender(int count){
        for(int i=0;i<count;i++){
            list.add(new MailSender());
        }
    }
    public void produceSmsSender(int count){
        for(int i=0;i<count;i++){
            list.add(new SmsSender());
        }
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