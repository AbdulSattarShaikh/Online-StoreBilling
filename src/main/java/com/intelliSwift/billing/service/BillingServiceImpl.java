package com.intelliSwift.billing.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliSwift.billing.exceptions.BadRequestException;
import com.intelliSwift.billing.model.BillingDto;
import com.intelliSwift.billing.model.BillingInfo;
import com.intelliSwift.billing.model.Product;
import com.intelliSwift.billing.repositories.ProductRepository;


@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	ProductRepository productRepository;
	
	

	@SuppressWarnings("unused")
	@Override
	public String generateBill(List<BillingDto> billingDto) throws BadRequestException, IOException {		
		
		BillingInfo bill = new BillingInfo(); 
		
		billingDto.forEach(i-> {			
			Product dbProduct = productRepository.findByproductCode(i.getProductCode());						
		
			bill.setPrice(i.getProductPrice());
			bill.setQuantity(i.getQuantity());
			bill.setName(dbProduct.getName());
			bill.setId(dbProduct.getId());			
		
			if(dbProduct != null) {
					
				if(dbProduct.getCategory().equalsIgnoreCase("A")) {				
					bill.setTax(i.getProductPrice()*i.getQuantity()*0.10);				
				}else if (dbProduct.getCategory().equalsIgnoreCase("B") ) {				
					bill.setTax(i.getProductPrice()*0.20);				
				}else if (dbProduct.getCategory().equalsIgnoreCase("C") ) {				
					bill.setTax(i.getProductPrice());
				}				
			
			bill.setFinalAmount(i.getQuantity()*i.getProductPrice()+bill.getTax());
		
// Bill Printing Start
			
			try {
				printBill(dbProduct.getProductCode().toString(), bill.getName(), bill.getTax().toString(), 
						bill.getPrice().toString(), bill.getFinalAmount().toString());
			} catch (IOException e) {			
				e.printStackTrace();
			} 
			
// Bill Printing Ends
			}else throw new BadRequestException("Product not found");
		});		
		
		return "Bill Generated Successfully";
	}
	
	
	
	

	public static String printBill(String productCode, String name, String tax, String price, String amount) throws IOException {

		String data = "product Code : "+productCode+" Product Name : " + name +" price : " +price+ ", service-tax : " + tax
				+  " Amount Payable : " + amount;

		try {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			String formattedDate = df.format(c.getTime());

			File file = new File("C:\\Users\\candidate\\Desktop\\Online_Bills\\Bill on " +formattedDate+ ".txt"); 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data + "\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
