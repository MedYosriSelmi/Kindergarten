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
//System.out.println(bill.getTotalPrice());
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
	public void updateBill(Bill b, int idBill) {
		Bill bill = bills.findById(idBill).get();
		bill.setDateOfBill(b.getDateOfBill());
		bill.setDescription(b.getDescription());
		bill.setTotalPrice(b.getTotalPrice());
		bill.setUser(b.getUser());
		bills.save(bill);		
	}
	@Override
	public void affecteruserToBill( int userId , int billId) {
        User u =users.findById(userId).orElse(null);
		Bill e =bills.findById(billId).orElse(null);
		e.setUser(u);
		bills.save(e);
	}
	@Override
	public void affecterKinderToBill( int kinderId , int billId) {
        Kindergarten k =kinders.findById(kinderId).orElse(null);
		Bill e =bills.findById(billId).orElse(null);
		e.setKindergarten(k);
		bills.save(e);
	}


	@Override
	public void EditBill(Bill b, int idBill ,int KinId , Kindergarten k ,int userid ,User x) {
		Bill bill = bills.findById(idBill).get();
		bill.setDateOfBill(b.getDateOfBill());
		bill.setDescription(b.getDescription());
		bill.setTotalPrice(b.getTotalPrice());
		Kindergarten kin =kinders.findById(KinId).get();
		float t ;
		t= kin.getPricePerChild() * kin.getNemberOfMonth();
		User user =users.findById(userid).get();
		int u ;
		u=user.getList_child().size();
		
		bills.save(bill);		
	}
	
	

	
}
