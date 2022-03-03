package com.maersk.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "maersk.Bookings”")
public class BookingTbl {
	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
	private UUID id;
	@PrimaryKeyColumn(name = "containerType", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String containerType;
	@PrimaryKeyColumn(name = "containerSize", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
	private int containerSize;
	@PrimaryKeyColumn(name = "origin", ordinal = 3, type = PrimaryKeyType.PARTITIONED)
	private String origin;
	@PrimaryKeyColumn(name = "destination", ordinal = 4, type = PrimaryKeyType.PARTITIONED)
	private String destination;
	@PrimaryKeyColumn(name = "quantity", ordinal = 5, type = PrimaryKeyType.PARTITIONED)
	private int quantity;
	@PrimaryKeyColumn(name = "timestamp", ordinal = 6, type = PrimaryKeyType.PARTITIONED)
	private LocalDateTime timestamp;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
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
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
		
	
}
