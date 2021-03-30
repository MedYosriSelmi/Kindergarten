package tn.kindergarten.service;
import java.util.HashMap;

import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import tn.kindergarten.entities.Bill;
import tn.kindergarten.repository.BillRepository;
@Service
public class StripeService {
    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    @Autowired
	BillRepository bills ;
    
    public Charge charge(Bill chargeRequest ,int idBill   ) 
      throws AuthenticationException, InvalidRequestException,
        APIConnectionException, CardException, APIException {
    	 String id = null;
        Map<String, Object> chargeParams = new HashMap<>();
         Bill bill = bills.findById(idBill).get();
    
        chargeParams.put("amount", bill.getTotalPrice());
        chargeParams.put("date", bill.getDateOfBill());
        chargeParams.put("description", bill.getDescription());
        chargeParams.put("Kindergarten Name ", bill.getKindergarten().getName());
        chargeParams.put("User Name ", bill.getUser().getFirstName()+" " + bill.getUser().getLastName());
        chargeParams.put("customer",bill.getUser().getId());
        
         return Charge.create(chargeParams );
   }
   
    
}