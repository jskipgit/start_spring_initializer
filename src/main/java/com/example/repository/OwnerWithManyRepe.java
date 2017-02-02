package com.example.repository;

import com.example.data.Owner;
import com.example.data.OwnerWithManyAnimals;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jasonskipper on 2/2/17.
 */
public interface OwnerWithManyRepe extends CrudRepository<OwnerWithManyAnimals, Long> {
}