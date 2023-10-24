package dev.hemanth.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.hemanth.movies.entity.Moviedb;
@Repository
public interface MoviedbRepository extends JpaRepository<Moviedb, Integer> {

}
