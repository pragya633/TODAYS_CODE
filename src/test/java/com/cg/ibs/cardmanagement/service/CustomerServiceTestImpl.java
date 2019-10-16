package com.cg.ibs.cardmanagement.service;

//import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.ibs.cardmanagement.bean.CaseIdBean;
import com.cg.ibs.cardmanagement.bean.CreditCardBean;
import com.cg.ibs.cardmanagement.bean.DebitCardBean;
import com.cg.ibs.cardmanagement.dao.BankDao;
import com.cg.ibs.cardmanagement.dao.CardManagementDaoImpl;
import com.cg.ibs.cardmanagement.dao.CustomerDao;
import com.cg.ibs.cardmanagement.exceptionhandling.IBSException;

class CustomerServiceImplTest {

	CustomerService customerService = new CustomerServiceImpl();
	CustomerDao dao = new CardManagementDaoImpl();

	@Test
	void verifyNonExistingDebitCardNumber() {
		BigInteger debitCardNumber = new BigInteger("5456767717123456");
		Assertions.assertThrows(IBSException.class, () -> {
			customerService.verifyDebitCardNumber(debitCardNumber);
		});
	}

	@Test
	void verifyExistingDebitCardNumber() {
		BigInteger debitCardNumber = new BigInteger("5234567891012131");
		try {
			assertEquals(true, customerService.verifyDebitCardNumber(debitCardNumber));
		} catch (IBSException e) {
			fail(e.getMessage());
		}

	}

	@Test
	void verifyNonExistingAccountNumber() {
		BigInteger accountNumber = new BigInteger("5234567891012131");
		Assertions.assertThrows(IBSException.class, () -> {
			customerService.verifyAccountNumber(accountNumber);
		});
	}

	@Test
	void verifyExistngAccountNumber() {
		BigInteger accountNumber = new BigInteger("1234567890");
		try {
			assertEquals(true, customerService.verifyAccountNumber(accountNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}

	}
	
	@Test
	void verifyNonExistingCreditCardNumber() {
		BigInteger creditCardNumber = new BigInteger("523456789101287");
		Assertions.assertThrows(IBSException.class, () -> {
			customerService.verifyCreditCardNumber(creditCardNumber);
		});
	}

	@Test
	void verifyExistngCreditCardNumber() {
		BigInteger creditCardNumber = new BigInteger("5189101213259898");
		try {
			assertEquals(true, customerService.verifyCreditCardNumber(creditCardNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}

	}

	@Test
	void validApplyNewGoldDebitCard() {
		BigInteger accountNumber = new BigInteger("1234567890");
		String newCardType = "Gold";

		try {
			assertEquals("ANDC00034567890", customerService.applyNewDebitCard(accountNumber, newCardType));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}

	}
	@Test
	void validApplyNewGoldCreditCard() {
		String newCardType = "Gold";

			assertEquals("ANCC00049632587", customerService.applyNewCreditCard(newCardType));
		

	}
	@Test
	void invalidApplyNewCreditCard() {
		String newCardType = "Random";
	assertNotNull(customerService.applyNewCreditCard(newCardType));

		
	}

	@Test
	void invalidApplyNewDebitCard() {
		BigInteger accountNumber = new BigInteger("1234567899");
		String newCardType = "Gold";
		try {
			assertNotNull(customerService.applyNewDebitCard(accountNumber, newCardType));

		} catch (IBSException e) {

			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void getNewCardtypeWithValidInput() {
		int cardType = 2;
		try {
			assertEquals("Gold", customerService.getNewCardtype(cardType));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void getNewCardtypeWithInvalidInput() {
		int cardType = 5;
		Assertions.assertThrows(IBSException.class, () -> {
			customerService.getNewCardtype(cardType);
		});

	}

	@Test
	void requestDebitCardLostWithValidInput() {
		BigInteger debitCardNumber = new BigInteger("5234567891012131");
		try {
			assertEquals("RDCL00021012131",
					customerService.requestDebitCardLost(debitCardNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void requestDebitCardLostWithInvalidInput() {
		BigInteger debitCardNumber = new BigInteger("52345678012136");
		try {
			assertNotNull(customerService.requestDebitCardLost(debitCardNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}

	}

	@Test
	void requestCreditCardLostWithValidInput() {
		BigInteger creditCardNumber = new BigInteger("5189101213259898");
		try {
			assertEquals("RCCL00003259898",
					customerService.requestCreditCardLost(creditCardNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void requestCreditCardLostWithInvalidInput() {
		BigInteger creditCardNumber = new BigInteger("52345678012136");
		try {
			assertNotNull(customerService.requestCreditCardLost(creditCardNumber));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void raiseDebitMismatchTicketWithValidInput() {
		String transactionId = "DEB101";
		try {
			assertEquals("RDMT00050DEB101",
					customerService.raiseDebitMismatchTicket(transactionId));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void raiseDebitMismatchTicketWithInvalidInput() {
		String transactionId = "DEB100";
		try {
			assertNotNull(customerService.raiseDebitMismatchTicket(transactionId));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}

	}
	
	@Test
	void raiseCreditMismatchTicketWithValidInput() {
		String transactionId = "CRED101";
		try {
			assertEquals("RCMT00080CRED101",
					customerService.raiseCreditMismatchTicket(transactionId));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}
	}

	@Test
	void raiseCreditMismatchTicketWithInvalidInput() {
		String transactionId = "CRED100";
		try {
			assertNotNull(customerService.raiseCreditMismatchTicket(transactionId));
		} catch (IBSException e) {
			fail("Test failed : " + e.getMessage());
		}}
		
		@Test
		void viewAllDebitCards() {
			List <DebitCardBean> details= dao.viewAllDebitCards();
		
	  		assertNotNull(details);
	    					
		}
		

		@Test
		void viewAllCreditCards() {
			List <CreditCardBean> details= dao.viewAllCreditCards();
		
	  		assertNotNull(details);
	    					
		}
		
		@Test
		void requestDebitCardUpgradeWithValidInput() {
			BigInteger debitCardNumber = new BigInteger("5221562391012233");
			String myChoice="1";
			assertEquals("RDCU00011012233",customerService.requestDebitCardUpgrade(debitCardNumber, myChoice));
			
			
		}
		
		@Test
		void requestDebitCardUpgradeWithInvalidInput() {
			BigInteger debitCardNumber = new BigInteger("5221562391012238");
			String myChoice="1";
			assertEquals("RDCU00011012233",customerService.requestDebitCardUpgrade(debitCardNumber, myChoice));
			
			
		}
		
		
	
	}
//	 @Test
//	    void resetDebitPinInvalid() {
//	    	BigInteger debitCardNumber=new BigInteger("5234567891012131");
//	    	int newPin = 2999;
//	    	customerService.resetDebitPin(debitCardNumber, newPin);
//	    	assertEquals(2999)
//	    	
//	    
//	    
//	    	
//	    }

	 
//	 @Test
//	    void resetDebitPinValid() {
//	    	BigInteger debitCardNumber=new BigInteger("5234567891012131");
//	    	int newPin = 2131;
//	    	customerService.resetDebitPin(debitCardNumber, newPin);
//	    	assertEquals(2131,dao.getDebitCardPin(debitCardNumber));
//	    
//	    	
//	    }\
//	    @Test
//	    void resetCreditPinValid() {
//	    	
//	    	BigInteger creditCardNumber=new BigInteger("5189101213259898");
//	    	int newPin = 9898;
//	    	
//	    	assertEquals(str, customerService.resetCreditPin(creditCardNumber, newPin));
//	    	}
//	    	
//	    }
//
//
