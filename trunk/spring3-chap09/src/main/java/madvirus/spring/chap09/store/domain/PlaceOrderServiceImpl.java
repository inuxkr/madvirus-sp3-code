package madvirus.spring.chap09.store.domain;

import madvirus.spring.chap09.store.dao.ItemDao;
import madvirus.spring.chap09.store.dao.PaymentInfoDao;
import madvirus.spring.chap09.store.dao.PurchaseOrderDao;

public class PlaceOrderServiceImpl implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
		this.paymentInfoDao = paymentInformationDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest)
			throws ItemNotFoundException {
		Item item = itemDao.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());

		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.insert(paymentInfo);
		
		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest
				.getAddress(), paymentInfo.getId());
		purchaseOrderDao.insert(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
