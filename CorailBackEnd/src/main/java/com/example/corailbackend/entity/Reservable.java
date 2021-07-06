package com.example.corailbackend.entity;

import com.example.corailbackend.entity.session.Session;
import com.example.corailbackend.exception.CannotReserveException;

public interface Reservable {

	void reserver(Session session) throws CannotReserveException;

}
