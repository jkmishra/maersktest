package com.maersk.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookingRepo extends CassandraRepository<BookingTbl, Long> {

}
