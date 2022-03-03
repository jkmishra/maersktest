package com.maersk.dto;

import javax.validation.constraints.Size;

public class Booking {

	private ContainerType containerType;
	private int containerSize;
	@Size(min = 5, max = 20, message = "origin must be between 5 and 20 characters")
	private String origin;
	@Size(min = 5, max = 20, message = "destination must be between 5 and 20 characters")
	private String destination;
	@Size(min = 1, max = 100, message = "quantity must be between 1 and 100")
	private int quantity;

	public ContainerType getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
