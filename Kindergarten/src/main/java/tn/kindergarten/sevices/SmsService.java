package tn.kindergarten.sevices;



import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.kindergarten.entities.Sms;


@Component
public class SmsService {
	private final String ACCOUNT_SID ="AC17a797ab00790b12582521f39e5f97c7";

    private final String AUTH_TOKEN = "a075ee3a49c9f261e6af6b451d9b9619";

    private final String FROM_NUMBER = "+12062037418";

    public void send(Sms sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}
