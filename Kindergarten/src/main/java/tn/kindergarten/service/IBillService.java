package tn.kindergarten.service;


import java.util.List;

import tn.kindergarten.entities.Bill ;


public interface IBillService {
public int ajouterBill(Bill bill);
public void deleteBillById(int billId);
public List<Bill> getAllBill();
public void updateBill(Bill b, int iBbill  );
public long getNumberOfChildForUserInKinderJPQL(int iduser , int idkinder);
public void affecteruserAndKinderToBill( int userId , int billId, int kinderId);
public void calculPrice(Bill b ,int  idBill );
public List<Bill> getAllBillByUser(int usertId);
public List<Bill> getAllBillBykinder(int kinderId);
public List<Bill> getAllBillForUserInKinder(int kinderId ,int userId);



}
