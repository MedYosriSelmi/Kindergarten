package tn.kindergarten.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Bill;

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.BillRepository;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	BillRepository bills ;
	@Autowired
	UserRepository users ;
	@Autowired
	KindergartenRepository kinders ;
	
	
	

	@Override
	public int ajouterBill(Bill bill) {

		bills.save(bill);
		return bill.getId();
	}

	@Override
	public void deleteBillById(int billId) {
		 Bill b  =bills.findById(billId).orElse(null);
		 bills.delete(b);
		
	}
	@Override
	public List<Bill> getAllBill() {
	return (List<Bill>) bills.findAll();
	}

	@Override
	public void updateBill(Bill b, int idBill ) {
		Bill bill = bills.findById(idBill).get();
		bill.setDateOfBill(b.getDateOfBill());
		bill.setDescription(b.getDescription());
		
		
	
	/*//	int c = bills.findById(idBill).get().getKindergarten().getList_child().size();
		//int ca = bills.findById(idBill).get().getKindergarten().getUser().get(idBill).getList_child().size();
		
		
		int k = bills.findById(idBill).get().getKindergarten().getId();
		int u = bills.findById(idBill).get().getUser().getId();
		long  a = bills.getNumberOfChildForUserInKinderJPQL(u,k);
		float t=bills.findById(idBill).get().getKindergarten().getPricePerChild();
		
		bill.setTotalPrice(a*t);
	*/
		
		bills.save(bill);		
	}
	@Override
	public void affecteruserAndKinderToBill( int billId , int userId , int kinderId) {
        User u =users.findById(userId).orElse(null);
        Kindergarten k =kinders.findById(kinderId).orElse(null);
		Bill e =bills.findById(billId).orElse(null);
		e.setUser(u);
		e.setKindergarten(k);
		bills.save(e);
	}


	
	@Override
	public List<Bill> getAllBillByUser(int usertId) {
		return bills.getAllBillByUser(usertId);
	}
	@Override
	public List<Bill> getAllBillBykinder(int kinderId) {
		return bills.getAllBillBykinder(kinderId)	;
	}
	@Override
	public List<Bill> getAllBillForUserInKinder(int kinderId, int userId) {
		return bills.getAllBillForUserInKinder(kinderId, userId);
	}


	@Override
	public void calculPrice(Bill b ,int idBill  ) {
		Bill bill = bills.findById(idBill).get();
		
		int k = bills.findById(idBill).get().getKindergarten().getId();
		int u = bills.findById(idBill).get().getUser().getId();
		long  a = bills.getNumberOfChildForUserInKinderJPQL(u, k);
		float t=bills.findById(idBill).get().getKindergarten().getPricePerChild();
		
		
			bill.setTotalPrice(a*t);
			bills.save(bill);	
			}
		
 
	@Override
	public long getNumberOfChildForUserInKinderJPQL(int iduser , int idkinder) {
		return bills.getNumberOfChildForUserInKinderJPQL( iduser , idkinder);
	}

	




	

	
}
