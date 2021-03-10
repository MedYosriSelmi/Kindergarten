package tn.kindergarten.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import tn.kindergarten.entities.Bill;
import tn.kindergarten.repository.BillRepository;
import tn.kindergarten.service.IBillService;
import tn.kindergarten.service.RepportBillService;

@RestController
public class BillRestControllerImpl  {
	@Autowired 
	IBillService bills ;
	@Autowired
	RepportBillService  service ;
	@Autowired
	BillRepository repository ;
	
	@PostMapping("/addBill")
	@ResponseBody
	public int ajouterBill(@RequestBody Bill bill) {
		bills.ajouterBill (bill);
		return bill.getId();
	}
	@DeleteMapping("/deleteBillById/{ent-id}")
	public void deleteBillById(@PathVariable("ent-id") int ide) {
		bills.deleteBillById(ide);		
	}
	@GetMapping(value="/listofbill")
	@ResponseBody
	public List<Bill> getAllBill() {
		return bills.getAllBill();
	}
	
	@PutMapping("/updateBill/{idBill}")
  	@ResponseBody
  	public ResponseEntity<String> updateBill(
	  		@RequestBody Bill bill,@PathVariable("idBill")int idBill) {
		bills.updateBill(bill,idBill);
	  	    return new ResponseEntity<String>("Bill updated successfully",HttpStatus.OK);
	  		
	}
	@PutMapping(value ="/affecteruserToBill/{idapp}/{iduser}")
	@ResponseBody
	public void affecteruserToBill(@PathVariable("idapp")int appId,@PathVariable("iduser") int medId) {
		bills.affecteruserToBill(appId, medId);
	}
	@PutMapping(value ="/affecterKinderToBill/{idapp}/{iduser}")
	@ResponseBody
	public void affecterKinderToBill(@PathVariable("idapp")int appId,@PathVariable("iduser") int medId) {
		bills.affecterKinderToBill(appId, medId);
	}
	 
	
	 @GetMapping("/report/{format}")
	 @ResponseBody
	    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	        return service.exportReport(format);
	    }
	
	

}
