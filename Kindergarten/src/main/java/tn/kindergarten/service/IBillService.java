package tn.kindergarten.service;


import java.util.List;

import tn.kindergarten.entities.Bill ;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
public interface IBillService {
public int ajouterBill(Bill bill);
public void deleteBillById(int billId);
public List<Bill> getAllBill();
public void updateBill(Bill b, int iBbill);
public void affecteruserToBill( int userId , int billId);
public void affecterKinderToBill( int kinderId , int billId);
public void EditBill(Bill b, int idBill ,int KinId , Kindergarten k ,int userid ,User x);
}
