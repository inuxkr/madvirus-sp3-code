package madvirus.spring.chap09.store.domain;

import static org.junit.Assert.assertNotNull;
import madvirus.spring.chap09.store.domain.PlaceOrderService;
import madvirus.spring.chap09.store.domain.PurchaseOrderRequest;
import madvirus.spring.chap09.store.domain.PurchaseOrderResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jdbcTxTemplate.xml", "classpath:dataSource.xml"})
@TransactionConfiguration(defaultRollback = false)
public class PlaceOrderServiceJdbcTxTmpImplTest {

	@Autowired
	private PlaceOrderService placeOrderService;

	@Test
	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("����� ���Ǳ� �Ÿ�4��");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		assertNotNull(orderResult);
	}
}
