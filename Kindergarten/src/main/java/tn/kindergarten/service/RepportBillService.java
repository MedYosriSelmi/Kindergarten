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
        List<Bill> employees = (List<Bill>) repository.findAll();
       
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\bill.pdf");
        }

        return "report generated in path : " + path;
    }
}
