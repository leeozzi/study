package com.inflearn.core.order;

public interface OrderService {

    // 주문을 넣으면 주문 결과를 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);


}
