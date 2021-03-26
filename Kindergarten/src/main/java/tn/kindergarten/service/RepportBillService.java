package tn.kindergarten.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tn.kindergarten.entities.Bill;
import tn.kindergarten.repository.BillRepository;

@Service
public class RepportBillService {
	@Autowired
	BillRepository repository ;
	public String exportReport(String reportFormat ) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\souhaib\\Documents\\workspace-sts-3.8.4.RELEASE\\Kindergarten";
        List<Bill> bill = (List<Bill>) repository.findAll();
        for (Bill b : bill){
        	
        	b.setKindername(b.getKindergarten().getName());
        	b.setUsnm(b.getUser().getFirstName() + " "+ b.getUser().getLastName());
        }
        
       
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bill);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\bill.pdf");
        }

        return "report generated in path : " + path;
    }
	public String exportReportForKinder(String reportFormat  , int kinderid) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\souhaib\\Documents\\workspace-sts-3.8.4.RELEASE\\Kindergarten";
        List<Bill> bill = (List<Bill>) repository.getAllBillBykinder(kinderid);
        for (Bill b : bill){
        	
        	b.setKindername(b.getKindergarten().getName());
        	b.setUsnm(b.getUser().getFirstName() + " "+ b.getUser().getLastName());
        }
        
       
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bill);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\bill of Kindergarten.pdf");
        }

        return "report generated in path : " + path;
    }
	
	
	public String exportReportForUser(String reportFormat  ,int iduser ) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\souhaib\\Documents\\workspace-sts-3.8.4.RELEASE\\Kindergarten";
        
       
        List<Bill> bill = (List<Bill>) repository.getAllBillByUser(iduser);
        for (Bill b : bill){
        	
        	b.setKindername(b.getKindergarten().getName());
        	b.setUsnm(b.getUser().getFirstName() + " "+ b.getUser().getLastName());
        }
        
       
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bill);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\bill For User.pdf");
        }

        return "report generated in path : " + path;
    }

	public String exportReportForUserInKinder(String reportFormat  ,int iduser , int idkinder ) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\souhaib\\Documents\\workspace-sts-3.8.4.RELEASE\\Kindergarten";
        
       
        List<Bill> bill = (List<Bill>) repository.getAllBillForUserInKinder(iduser, idkinder);
        for (Bill b : bill){
        	
        	b.setKindername(b.getKindergarten().getName());
        	b.setUsnm(b.getUser().getFirstName() + " "+ b.getUser().getLastName());
        }
        
       
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bill);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Bill For User In Kindergarten.pdf");
        }

        return "report generated in path : " + path;
    }
}
