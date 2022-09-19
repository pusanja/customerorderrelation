package com.orthofx.CustomerOrderRelation.Dto;

import java.util.List;
import com.orthofx.CustomerOrderRelation.model.Order;

public class OrderListDto {
	private List<Order> orderList;
	  public List<Order> getorderList(){
		  return orderList;
	  }
	  public void setorderList(List<Order> set) {
		  this.orderList = set;
	  }
	

}
