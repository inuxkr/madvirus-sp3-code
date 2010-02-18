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
@ContextConfiguration({"classpath:annotTx.xml", "classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = false)
public class PlaceOrderServiceAnnotTxImplTest {

	@Autowired
	private PlaceOrderService placeOrderService;

	@Test
	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("서울시 관악구 신림4동");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		assertNotNull(orderResult);
	}
}
