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

import com.sun.el.parser.ParseException;

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
	
	
	
	
	@PostMapping("/ajout_Bill_To_User/{id_user}/{id_kinder}")
	public String ajout_Bill_To_User(@PathVariable("id_user") int id_user,@PathVariable("id_kinder") int id_kinder,@RequestBody Bill bill) throws ParseException {
		
		return bills.ajout_Bill_To_User(id_user,id_kinder,bill);
	}
	@DeleteMapping("/delete_Bill/{id_kinder}/{id_bill}")
	public String delete_Bill(@PathVariable("id_kinder") int id_kinder,@PathVariable("id_bill") int id_bill)  {
		
		return bills.delete_Bill(id_kinder,id_bill);
	
	}

	@GetMapping(value="/listofbill")
	@ResponseBody
	public List<Bill> getAllBill() {
		return bills.getAllBill();
	}
	/*
	@PutMapping("/updateBill/{idBill}")
  	@ResponseBody
  	public ResponseEntity<String> updateBill(
	  		@RequestBody Bill bill,@PathVariable("idBill")int idBill) {
		bills.updateBill(bill,idBill );
	  	    return new ResponseEntity<String>("Bill updated successfully",HttpStatus.OK);
	  		
	}*/
	@PutMapping("/update_Bill/{kinder_id}/{bill_id}")
	public String update_Bill(@PathVariable("kinder_id") int kinder_id, @PathVariable ("bill_id") int bill_id,@RequestBody Bill  bill) {

		
		return bills.update_Bill( kinder_id  ,bill_id, bill);
	}

	
	@PutMapping("/calculp/{idBill}")
  	@ResponseBody
  	public ResponseEntity<String> calculPrice(
	  		@RequestBody Bill bill,@PathVariable("idBill")int idBill) {
		bills.calculPrice(bill,idBill );
	  	    return new ResponseEntity<String>("Bill is calculated",HttpStatus.OK);
	  		
	}
	

	    @GetMapping("/getAllBillByUser/{iduser}")
	    @ResponseBody
		public List<Bill> getAllBillByUser(@PathVariable("iduser") int usertId) {

			return bills.getAllBillByUser(usertId);
		}
	    @GetMapping("/getAllBillBykinder/{idkinder}")
	    @ResponseBody
		public List<Bill> getAllBillBykinder(@PathVariable("idkinder") int idkinder) {

			return bills.getAllBillBykinder(idkinder);
		}
	    @GetMapping("/getAllBillForUserInKinder/{idkinder}/{iduser}")
	    @ResponseBody
		public List<Bill> getAllBillForUserInKinder(@PathVariable("idkinder") int idkinder ,@PathVariable("iduser") int usertId) {

			return bills.getAllBillForUserInKinder(idkinder,usertId );
		}

	
	    @GetMapping("/NbreChild/{iduser}/{idkinder}")
		 @ResponseBody
		public long getNumberOfChildForUserInKinderJPQL(@PathVariable("iduser")int iduser, @PathVariable("idkinder")int  idkinder) {
			
			return bills.getNumberOfChildForUserInKinderJPQL(iduser , idkinder);
		}
	    
	    

		 @GetMapping("/report/{format}")
		 @ResponseBody
		    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		        return service.exportReport(format);
		    }

		 @GetMapping("/exportReportForKinder/{format}/{idkinder}")
		 @ResponseBody
		    public String exportReportForKinder(@PathVariable String format , @PathVariable("idkinder")int idkinder) throws FileNotFoundException, JRException {
		        return service.exportReportForKinder(format , idkinder);
		    }

		 @GetMapping("/reportForUser/{format}/{iduser}")
		 @ResponseBody
		    public String exportReportForUser(@PathVariable String format , @PathVariable("iduser")int iduser) throws FileNotFoundException, JRException {
		        return service.exportReportForUser(format , iduser);
		    }
		 @GetMapping("/reportForUserInKindergarten/{format}/{iduser}/{idkinder}")
		 @ResponseBody
		    public String exportReportForUserInKinder(@PathVariable String format , @PathVariable("iduser")int iduser , @PathVariable("idkinder")int idkinder) throws FileNotFoundException, JRException {
		        return service.exportReportForUserInKinder(format , iduser,idkinder);
		    }
}
