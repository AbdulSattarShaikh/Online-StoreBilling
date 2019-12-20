package com.intelliSwift.billing.service;

import java.io.IOException;
import java.util.List;

import com.intelliSwift.billing.exceptions.BadRequestException;
import com.intelliSwift.billing.model.BillingDto;

public interface BillingService {

	String generateBill(List<BillingDto> billingDto) throws BadRequestException, IOException;

}
