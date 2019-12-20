package com.intelliSwift.billing.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelliSwift.billing.exceptions.BadRequestException;
import com.intelliSwift.billing.model.BillingDto;
import com.intelliSwift.billing.service.BillingService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/billing")
@Api
public class BillingController {

	@Autowired
	private BillingService billingService;

	@PostMapping("/generate")
	public ResponseEntity<String> generateBill(@RequestBody List<BillingDto> billingDto)
			throws BadRequestException, IOException {
		return new ResponseEntity<>(billingService.generateBill(billingDto), HttpStatus.OK);
	}

}
