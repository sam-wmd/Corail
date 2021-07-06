package com.example.corailbackend.repository;

import java.util.List;

import com.example.corailbackend.entity.materiel.etatmateriel.EtatMateriel;

public interface EtatMaterielRepository extends AbstractEntityRepository<EtatMateriel> {

	@Override
	default <S extends EtatMateriel>  S save(S etat) {
		throw new IllegalAccessError();
	}

	@Override
	default <T extends EtatMateriel> List<T> saveAll(Iterable<T> entities){
		throw new IllegalAccessError();
	}

	@Override
	default <S extends EtatMateriel> S saveAndFlush(S entity) {
		throw new IllegalAccessError();
	}

	@Override
	default <S extends EtatMateriel> List<S> saveAllAndFlush(Iterable<S> entities) {
		throw new IllegalAccessError();
	}

	@Override
	default void delete(EtatMateriel etat) {
		throw new IllegalAccessError();
	}

	@Override
	default void deleteAll() {
		throw new IllegalAccessError();
	}

	@Override
	default void deleteAll(Iterable<? extends EtatMateriel> entities) {
		throw new IllegalAccessError();
	}

	@Override
	default void deleteAllById(Iterable<? extends Integer> ids) {
		throw new IllegalAccessError();
	}

	@Override
	default void deleteAllInBatch(Iterable<EtatMateriel> entities) {
		throw new IllegalAccessError();
	}
}
