package tn.kindergarten.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.sun.mail.iap.Response;

import tn.kindergarten.entities.Bill;
import tn.kindergarten.repository.BillRepository;
import tn.kindergarten.service.IBillService;
import tn.kindergarten.service.StripeService;
@Controller
public class ChargeController  {
    @Autowired
    StripeService paymentsService;
    @Autowired
	BillRepository bills ;
    @Autowired 
	IBillService bi ;
 
    
    
    
    @PostMapping("/charge/{idBill}")
    
    public String charge( Bill chargeRequest, Model model  ,@PathVariable("idBill")int idBill  )
      throws StripeException {
    	
         
        
        Charge charge = paymentsService.charge(chargeRequest ,idBill );
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
       model.addAttribute("userId",charge.getCustomer());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }

}